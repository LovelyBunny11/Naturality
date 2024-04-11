package com._LovelyBunny.Naturality.entity;

import com._LovelyBunny.Naturality.item.NaturalityItems;
import com._LovelyBunny.Naturality.particle.NaturalityParticleTypes;
import com._LovelyBunny.Naturality.tag.NaturalityTags;
import com.google.errorprone.annotations.Var;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.allay.AllayAi;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Predicate;

import static com._LovelyBunny.Naturality.entity.Moth.Variant.*;

public class Moth extends Animal implements FlyingAnimal {
    int remainingCooldownBeforeLocatingNewFlower;
    @Nullable
    BlockPos savedFlowerPos;

    int ticksWithoutNectar;
    boolean isFlowerValid(BlockPos p_27897_) {
        return this.level().isLoaded(p_27897_) && this.level().getBlockState(p_27897_).is(BlockTags.FLOWERS);
    }
    public boolean hasSavedFlowerPos() {
        return this.savedFlowerPos != null;
    }
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID;
    public Moth(EntityType<? extends Moth> p_21368_, Level p_21369_) {
        super(p_21368_, p_21369_);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new LookControl(this);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
    }
    public Moth(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
        this(NaturalityEntityTypes.MOTH.get(), p_38293_);
        this.setPos(p_38294_, p_38295_, p_38296_);
        this.xo = p_38294_;
        this.yo = p_38295_;
        this.zo = p_38296_;
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WanderGoal());
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.2D, Ingredient.of(ItemTags.FLOWERS), false));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Player.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Spider.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(3, new AvoidEntityGoal(this, CaveSpider.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new MothPollinateGoal());
        this.goalSelector.addGoal(5, new GoToKnownFlowerGoal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, 0);
    }

    public void addAdditionalSaveData(CompoundTag p_29697_) {
        super.addAdditionalSaveData(p_29697_);
        p_29697_.putInt("Type", this.getVariant().id);
    }

    public void readAdditionalSaveData(CompoundTag p_29684_) {
        super.readAdditionalSaveData(p_29684_);
        this.setVariant(byId(p_29684_.getInt("Type")));
    }
    static {
        DATA_TYPE_ID = SynchedEntityData.defineId(Moth.class, EntityDataSerializers.INT);
    }

    public static enum Variant implements StringRepresentable {

        ROSY_MAPLE(0, "rosy_maple"),
        LUNA(1, "luna"),
        DEATH_HEAD_HAWK(2, "death_head_hawk");

        private static final IntFunction<Moth.Variant> BY_ID = ByIdMap.sparse(Moth.Variant::id, values(), LUNA);
        public static final Codec<Moth.Variant> CODEC = StringRepresentable.fromEnum(Moth.Variant::values);
        final int id;
        private final String name;

        private Variant(int p_262657_, String p_262679_) {
            this.id = p_262657_;
            this.name = p_262679_;
        }

        public String getSerializedName() {
            return this.name;
        }

        public int id() {
            return this.id;
        }

        public static Moth.Variant byId(int p_262665_) {
            return (Moth.Variant) BY_ID.apply(p_262665_);
        }
    }
    public Item getDropItem() {
        Item item;
        switch (this.getVariant()) {
            case LUNA:
                item = NaturalityItems.LUNA_MOTH.get();
                break;
            case ROSY_MAPLE:
                item = NaturalityItems.ROSY_MAPLE_MOTH.get();
                break;
            case DEATH_HEAD_HAWK:
                item = NaturalityItems.DEATH_HEAD_HAWK_MOTH.get();
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        return item;
    }
    public static boolean checkSpawnRules(EntityType<Moth> p_218256_, ServerLevelAccessor p_218257_, MobSpawnType p_218258_, BlockPos p_218259_, RandomSource p_218260_) {
        BlockState blockstate = p_218257_.getBlockState(p_218259_.below());
        return (blockstate.is(BlockTags.LEAVES) || blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(BlockTags.LOGS) || blockstate.is(Blocks.AIR)) && isDarkEnoughToSpawn(p_218257_, p_218259_, p_218260_);
    }

    @javax.annotation.Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        Moth.Variant Moth$variant = getRandomMothVariant(p_29678_, this.blockPosition());
        if (p_29681_ instanceof Moth.MothGroupData) {
            Moth$variant = ((Moth.MothGroupData) p_29681_).variant;
        } else {
            p_29681_ = new Moth.MothGroupData(Moth$variant);
        }

        this.setVariant(Moth$variant);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, (SpawnGroupData) p_29681_, p_29682_);
    }

    private static Moth.Variant getRandomMothVariant(LevelAccessor p_262699_, BlockPos p_262700_) {
        Holder<Biome> holder = p_262699_.getBiome(p_262700_);
        int i = p_262699_.getRandom().nextInt(100);
        if (isHalloween()) {
            return DEATH_HEAD_HAWK;
        } if (holder.is(NaturalityTags.SPAWNS_ROSY_MAPLE_MOTHS)) {
            return ROSY_MAPLE;
        } else if (holder.is(NaturalityTags.SPAWNS_LUNA_MOTHS)) {
            return LUNA;
        } else if (holder.is(NaturalityTags.SPAWNS_DEATH_HEAD_HAWK_MOTHS)) {
            return DEATH_HEAD_HAWK;
        } else {
            return LUNA;
        }
    }
    private static boolean isHalloween() {
        LocalDate $$0 = LocalDate.now();
        int $$1 = $$0.get(ChronoField.DAY_OF_MONTH);
        int $$2 = $$0.get(ChronoField.MONTH_OF_YEAR);
        return $$2 == 10 && $$1 >= 20 || $$2 == 11 && $$1 <= 3;
    }
    protected static boolean isDarkEnoughToSpawn(ServerLevelAccessor p_219010_, BlockPos p_219011_, RandomSource p_219012_) {
        if (p_219010_.getBrightness(LightLayer.SKY, p_219011_) > p_219012_.nextInt(32)) {
            return false;
        } else {
            DimensionType dimensiontype = p_219010_.dimensionType();
            int i = dimensiontype.monsterSpawnBlockLightLimit();
            if (i < 15 && p_219010_.getBrightness(LightLayer.BLOCK, p_219011_) > i) {
                return false;
            } else {
                int j = p_219010_.getLevel().isThundering() ? p_219010_.getMaxLocalRawBrightness(p_219011_, 10) : p_219010_.getMaxLocalRawBrightness(p_219011_);
                return j <= dimensiontype.monsterSpawnLightTest().sample(p_219012_);
            }
        }
    }

    public void setVariant(Moth.Variant p_262578_) {
        this.entityData.set(DATA_TYPE_ID, p_262578_.id);
    }

    public Moth.Variant getVariant() {
        return byId((Integer) this.entityData.get(DATA_TYPE_ID));
    }

    @javax.annotation.Nullable
    public Moth getBreedOffspring(ServerLevel p_149035_, AgeableMob p_149036_) {
        Moth Moth = (Moth) NaturalityEntityTypes.MOTH.get().create(p_149035_);
        if (Moth != null) {
            Moth.Variant moth$variant = getRandomMothVariant(p_149035_, this.blockPosition());
            if (this.random.nextInt(20) != 0) {
                label22:
                {
                    if (p_149036_ instanceof Moth) {
                        Moth moth1 = (Moth) p_149036_;
                        if (this.random.nextBoolean()) {
                            moth$variant = moth1.getVariant();
                            break label22;
                        }
                    }

                    moth$variant = this.getVariant();
                }
            }

            Moth.setVariant(moth$variant);
        }

        return Moth;
    }
    public static class MothGroupData extends AgeableMob.AgeableMobGroupData {
        public final Moth.Variant variant;

        public MothGroupData(Moth.Variant p_262662_) {
            super(1.0F);
            this.variant = p_262662_;
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.FLYING_SPEED, 0.355353)
                .add(Attributes.MAX_HEALTH, 6);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        FlyingPathNavigation flyingpathnavigator = new FlyingPathNavigation(this, worldIn) {
            public boolean isStableDestination(BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }
        };
        flyingpathnavigator.setCanOpenDoors(false);
        flyingpathnavigator.setCanFloat(false);
        flyingpathnavigator.setCanPassDoors(false);
        return flyingpathnavigator;
    }

    public void travel(Vec3 p_218382_) {
        if (this.isControlledByLocalInstance()) {
            if (this.isInWater()) {
                this.moveRelative(0.02F, p_218382_);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.800000011920929));
            } else if (this.isInLava()) {
                this.moveRelative(0.02F, p_218382_);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5));
            } else {
                    this.moveRelative(this.getSpeed(), p_218382_);
                    this.move(MoverType.SELF, this.getDeltaMovement());
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.365353));
            }
        }
        this.calculateEntityAnimation(false);
    }

    public boolean isFlying() {
        return true;
    }

    public boolean isFlapping() {
        return !this.onGround();
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.FLOWERS);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
        BlockPos blockPos = BlockPos.containing(Moth.this.getX(), Moth.this.getBoundingBox().maxY, Moth.this.getZ());
        if (isFlapping()) {
            switch (Variant.byId(this.entityData.get(DATA_TYPE_ID))) {
                case LUNA:
                    this.level().addParticle(NaturalityParticleTypes.LUNA_MOTH_DUST.get(),
                            blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.15d, 0.15d, 0.15d);
            }
            switch (Variant.byId(this.entityData.get(DATA_TYPE_ID))) {
                case ROSY_MAPLE:
                    this.level().addParticle(NaturalityParticleTypes.ROSY_MAPLE_MOTH_DUST.get(),
                            blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.15d, 0.15d, 0.15d);
            }
            switch (Variant.byId(this.entityData.get(DATA_TYPE_ID))) {
                case DEATH_HEAD_HAWK:
                    this.level().addParticle(NaturalityParticleTypes.DEATH_HEAD_MOTH_DUST.get(),
                            blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.15d, 0.15d, 0.15d);
            }
        }
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            if (!Moth.this.isSleeping()) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        }
    }
    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (!this.onGround()) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }
    protected void checkFallDamage(double p_27419_, boolean p_27420_, BlockState p_27421_, BlockPos p_27422_) {
    }

    protected void playStepSound(BlockPos p_218364_, BlockState p_218365_) {
    }
    public boolean canPollinate() {
        switch (this.getVariant()) {
            case DEATH_HEAD_HAWK:
                return true;
        }
        return false;
    }
    public boolean removeWhenFarAway(double p_218384_) {
        return false;
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0, (double) (0.5F * this.getEyeHeight()), (double) (this.getBbWidth() * 0.2F));
    }

    private int underWaterTicks;

    protected void customServerAiStep() {
        if (this.isInWaterOrBubble()) {
            ++this.underWaterTicks;
        } else {
            this.underWaterTicks = 0;
        }

        if (this.underWaterTicks > 20) {
            this.hurt(this.damageSources().drown(), 1.0F);
        }
    }

    protected void onFlap() {
        this.playSound(SoundEvents.PARROT_FLY, 0.15F, 1.0F);
    }
    void pathfindRandomlyTowards(BlockPos p_27881_) {
        Vec3 vec3 = Vec3.atBottomCenterOf(p_27881_);
        int i = 0;
        BlockPos blockpos = this.blockPosition();
        int j = (int)vec3.y - blockpos.getY();
        if (j > 2) {
            i = 4;
        } else if (j < -2) {
            i = -4;
        }

        int k = 6;
        int l = 8;
        int i1 = blockpos.distManhattan(p_27881_);
        if (i1 < 15) {
            k = i1 / 2;
            l = i1 / 2;
        }

        Vec3 vec31 = AirRandomPos.getPosTowards(this, k, l, i, vec3, 0.3141592741012573);
        if (vec31 != null) {
            this.navigation.setMaxVisitedNodesMultiplier(0.5F);
            this.navigation.moveTo(vec31.x, vec31.y, vec31.z, 1.0);
        }

    }

    @Deprecated
    protected void jumpInLiquid(TagKey<Fluid> p_204061_) {
        this.jumpInLiquidInternal();
    }

    private void jumpInLiquidInternal() {
        this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.01, 0.0));
    }

    public void jumpInFluid(FluidType type) {
        this.jumpInLiquidInternal();
    }
    boolean closerThan(BlockPos p_27817_, int p_27818_) {
        return p_27817_.closerThan(this.blockPosition(), (double)p_27818_);
    }

    class MothPollinateGoal extends Goal {
        private static final int MIN_POLLINATION_TICKS = 400;
        private static final int MIN_FIND_FLOWER_RETRY_COOLDOWN = 20;
        private static final int MAX_FIND_FLOWER_RETRY_COOLDOWN = 60;
        private final Predicate<BlockState> VALID_POLLINATION_BLOCKS = (p_28074_) -> {
            if (p_28074_.hasProperty(BlockStateProperties.WATERLOGGED) && (Boolean) p_28074_.getValue(BlockStateProperties.WATERLOGGED)) {
                return false;
            } else if (p_28074_.is(BlockTags.FLOWERS)) {
                if (p_28074_.is(Blocks.SUNFLOWER)) {
                    return p_28074_.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        };
        private static final double ARRIVAL_THRESHOLD = 0.1;
        private static final int POSITION_CHANGE_CHANCE = 25;
        private static final float SPEED_MODIFIER = 0.35F;
        private static final float HOVER_HEIGHT_WITHIN_FLOWER = 0.6F;
        private static final float HOVER_POS_OFFSET = 0.33333334F;
        private int successfulPollinatingTicks;
        private int lastSoundPlayedTick;
        private boolean pollinating;
        @Nullable
        private Vec3 hoverPos;
        private int pollinatingTicks;
        private static final int MAX_POLLINATING_TICKS = 600;

        MothPollinateGoal() {
            super();
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (!canPollinate()) {
                return false;
            }
            if (Moth.this.remainingCooldownBeforeLocatingNewFlower > 0) {
                return false;
            } else if (Moth.this.level().isRaining()) {
                return false;
            } else {
                Optional<BlockPos> optional = this.findNearbyFlower();
                if (optional.isPresent()) {
                    Moth.this.savedFlowerPos = (BlockPos) optional.get();
                    Moth.this.navigation.moveTo((double) Moth.this.savedFlowerPos.getX() + 0.5, (double) Moth.this.savedFlowerPos.getY() + 0.5, (double) Moth.this.savedFlowerPos.getZ() + 0.5, 1.2000000476837158);
                    return true;
                } else {
                    Moth.this.remainingCooldownBeforeLocatingNewFlower = Mth.nextInt(Moth.this.random, 20, 60);
                    return false;
                }
            }
        }

        public boolean canContinueToUse() {
            if (!this.pollinating) {
                return false;
            } else if (!Moth.this.hasSavedFlowerPos()) {
                return false;
            } else if (Moth.this.level().isRaining()) {
                return false;
            } else if (this.hasPollinatedLongEnough()) {
                return Moth.this.random.nextFloat() < 0.2F;
            } else if (Moth.this.tickCount % 20 == 0 && !Moth.this.isFlowerValid(Moth.this.savedFlowerPos)) {
                Moth.this.savedFlowerPos = null;
                return false;
            } else {
                return true;
            }
        }

        private boolean hasPollinatedLongEnough() {
            return this.successfulPollinatingTicks > 400;
        }

        boolean isPollinating() {
            return this.pollinating;
        }

        void stopPollinating() {
            this.pollinating = false;
        }

        public void start() {
            this.successfulPollinatingTicks = 0;
            this.pollinatingTicks = 0;
            this.lastSoundPlayedTick = 0;
            this.pollinating = true;
        }

        public void stop() {
            if (this.hasPollinatedLongEnough()) {
            }

            this.pollinating = false;
            Moth.this.navigation.stop();
            Moth.this.remainingCooldownBeforeLocatingNewFlower = 200;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            ++this.pollinatingTicks;
            if (this.pollinatingTicks > 600) {
                Moth.this.savedFlowerPos = null;
            } else {
                Vec3 vec3 = Vec3.atBottomCenterOf(Moth.this.savedFlowerPos).add(0.0, 0.6000000238418579, 0.0);
                if (vec3.distanceTo(Moth.this.position()) > 1.0) {
                    this.hoverPos = vec3;
                    this.setWantedPos();
                } else {
                    if (this.hoverPos == null) {
                        this.hoverPos = vec3;
                    }

                    boolean flag = Moth.this.position().distanceTo(this.hoverPos) <= 0.1;
                    boolean flag1 = true;
                    if (!flag && this.pollinatingTicks > 600) {
                        Moth.this.savedFlowerPos = null;
                    } else {
                        if (flag) {
                            boolean flag2 = Moth.this.random.nextInt(25) == 0;
                            if (flag2) {
                                this.hoverPos = new Vec3(vec3.x() + (double) this.getOffset(), vec3.y(), vec3.z() + (double) this.getOffset());
                                Moth.this.navigation.stop();
                            } else {
                                flag1 = false;
                            }

                            Moth.this.getLookControl().setLookAt(vec3.x(), vec3.y(), vec3.z());
                        }

                        if (flag1) {
                            this.setWantedPos();
                        }

                        ++this.successfulPollinatingTicks;
                        if (Moth.this.random.nextFloat() < 0.05F && this.successfulPollinatingTicks > this.lastSoundPlayedTick + 60) {
                            this.lastSoundPlayedTick = this.successfulPollinatingTicks;
                            Moth.this.playSound(SoundEvents.BEE_POLLINATE, 1.0F, 1.0F);
                        }
                    }
                }
            }

        }

        private void setWantedPos() {
            Moth.this.getMoveControl().setWantedPosition(this.hoverPos.x(), this.hoverPos.y(), this.hoverPos.z(), 0.3499999940395355);
        }

        private float getOffset() {
            return (Moth.this.random.nextFloat() * 2.0F - 1.0F) * 0.33333334F;
        }

        private Optional<BlockPos> findNearbyFlower() {
            return this.findNearestBlock(this.VALID_POLLINATION_BLOCKS, 5.0);
        }

        private Optional<BlockPos> findNearestBlock(Predicate<BlockState> p_28076_, double p_28077_) {
            BlockPos blockpos = Moth.this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (int i = 0; (double) i <= p_28077_; i = i > 0 ? -i : 1 - i) {
                for (int j = 0; (double) j < p_28077_; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            blockpos$mutableblockpos.setWithOffset(blockpos, k, i - 1, l);
                            if (blockpos.closerThan(blockpos$mutableblockpos, p_28077_) && p_28076_.test(Moth.this.level().getBlockState(blockpos$mutableblockpos))) {
                                return Optional.of(blockpos$mutableblockpos);
                            }
                        }
                    }
                }
            }

            return Optional.empty();
        }
    }
    public class GoToKnownFlowerGoal extends Goal {
        private static final int MAX_TRAVELLING_TICKS = 600;
        int travellingTicks;

        GoToKnownFlowerGoal() {
            super();
            this.travellingTicks = Moth.this.level().random.nextInt(10);
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (!canPollinate()) {
                return false;
            } else {
                return Moth.this.savedFlowerPos != null && !Moth.this.hasRestriction() && this.wantsToGoToKnownFlower() && Moth.this.isFlowerValid(Moth.this.savedFlowerPos) && !Moth.this.closerThan(Moth.this.savedFlowerPos, 2);
            }
        }

        public boolean canContinueToUse() {
            return this.canUse();
        }

        public void start() {
            this.travellingTicks = 0;
            super.start();
        }

        public void stop() {
            this.travellingTicks = 0;
            Moth.this.navigation.stop();
            Moth.this.navigation.resetMaxVisitedNodesMultiplier();
        }

        public void tick() {
            if (Moth.this.savedFlowerPos != null) {
                ++this.travellingTicks;
                if (this.travellingTicks > this.adjustedTickDelay(600)) {
                    Moth.this.savedFlowerPos = null;
                } else if (!Moth.this.navigation.isInProgress()) {
                    if (Moth.this.isTooFarAway(Moth.this.savedFlowerPos)) {
                        Moth.this.savedFlowerPos = null;
                    } else {
                        Moth.this.pathfindRandomlyTowards(Moth.this.savedFlowerPos);
                    }
                }
            }

        }

        private boolean wantsToGoToKnownFlower() {
            return Moth.this.ticksWithoutNectar > 2400;
        }
    }
    boolean isTooFarAway(BlockPos p_27890_) {
        return !this.closerThan(p_27890_, 32);
    }
    class WanderGoal extends Goal {
        WanderGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }
        public boolean canUse() {
            return Moth.this.navigation.isDone() && Moth.this.random.nextInt(3) == 0;
        }
        public boolean canContinueToUse() {
            return Moth.this.navigation.isInProgress();
        }
        public void start() {
            Vec3 vector3d = this.getRandomLocation();
            if (vector3d != null) {
                Moth.this.navigation.moveTo(Moth.this.navigation.createPath(this.fromVec3(vector3d), 1), 1.0D);
            }

        }

        @Nullable
        private Vec3 getRandomLocation() {
            Vec3   vec3 = Moth.this.getViewVector(0.0F);
            int i = 8;
            Vec3 vec32 = HoverRandomPos.getPos(Moth.this, 8, 7, vec3.x, vec3.z, Mth.HALF_PI, 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(Moth.this, 8, 4, -2, vec3.x, vec3.z, (double)Mth.HALF_PI);
        }
        public static final BlockPos fromCoords(double x, double y, double z){
            return new BlockPos((int) x, (int) y, (int) z);
        }

        public static final BlockPos fromVec3(Vec3 vec3){
            return fromCoords(vec3.x, vec3.y, vec3.z);
        }
    }
}

