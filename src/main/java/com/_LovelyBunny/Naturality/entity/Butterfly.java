package com._LovelyBunny.Naturality.entity;

import com._LovelyBunny.Naturality.item.NaturalityItems;
import com._LovelyBunny.Naturality.sound.NaturalitySoundEvents;
import com._LovelyBunny.Naturality.tag.NaturalityTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Butterfly extends Animal implements FlyingAnimal {
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

    public static final EntityDataAccessor<Integer> DATA_TYPE_ID;
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;
    private static final int FLAG_RESTING = 1;
    private static final TargetingConditions BUTTERFLY_RESTING_TARGETING;
    @Nullable
    private BlockPos targetPosition;

    public Butterfly(EntityType<? extends Butterfly> p_21368_, Level p_21369_) {
        super(p_21368_, p_21369_);
        this.moveControl = new ButterflyMoveControl(this, 20, true);
        this.lookControl = new ButterflyLookControl();
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
    }
    public Butterfly(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
        this(NaturalityEntityTypes.BUTTERFLY.get(), p_38293_);
        this.setPos(p_38294_, p_38295_, p_38296_);
        this.xo = p_38294_;
        this.yo = p_38295_;
        this.zo = p_38296_;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WanderGoal());
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.of(ItemTags.FLOWERS), false));
        this.goalSelector.addGoal(4, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new AvoidEntityGoal(this, Player.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(7, new ButterflySleepGoal());
        this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Spider.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(9, new AvoidEntityGoal(this, CaveSpider.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(10, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(12, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(13, new ButterflyPollinateGoal());
        this.goalSelector.addGoal(14, new GoToKnownFlowerGoal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    public void addAdditionalSaveData(CompoundTag p_29697_) {
        super.addAdditionalSaveData(p_29697_);
        p_29697_.putInt("Type", this.getVariant().id);
        this.entityData.set(DATA_FLAGS_ID, p_29697_.getByte("Flags"));
    }

    public void readAdditionalSaveData(CompoundTag p_29684_) {
        super.readAdditionalSaveData(p_29684_);
        this.setVariant(Butterfly.Variant.byId(p_29684_.getInt("Type")));
        p_29684_.putByte("Flags", (Byte)this.entityData.get(DATA_FLAGS_ID));
    }

    static {
        DATA_TYPE_ID = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.INT);
        DATA_FLAGS_ID = SynchedEntityData.defineId(Fox.class, EntityDataSerializers.BYTE);
        BUTTERFLY_RESTING_TARGETING = TargetingConditions.forNonCombat().range(4.0);
    }
    public boolean isResting() {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setResting(boolean p_27457_) {
        byte $$1 = (Byte)this.entityData.get(DATA_FLAGS_ID);
        if (p_27457_) {
            this.entityData.set(DATA_FLAGS_ID, (byte)($$1 | 1));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)($$1 & -2));
        }

    }

    public static enum Variant implements StringRepresentable {

        MONARCH(0, "monarch"),
        MORPHO(1, "morpho"),
        RED_ADMIRAL(2, "red_admiral");

        private static final IntFunction<Butterfly.Variant> BY_ID = ByIdMap.sparse(Butterfly.Variant::id, values(), MONARCH);
        public static final Codec<Butterfly.Variant> CODEC = StringRepresentable.fromEnum(Butterfly.Variant::values);
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
        public static Butterfly.Variant byId(int p_262665_) {
            return (Butterfly.Variant) BY_ID.apply(p_262665_);
        }
    }
    public Butterfly.Variant getVariant() {
        return Butterfly.Variant.byId((Integer)this.entityData.get(DATA_TYPE_ID));
    }

    public Item getDropItem() {
            Item item;
            switch (this.getVariant()) {
                case MONARCH:
                    item = NaturalityItems.MONARCH_BUTTERFLY.get();
                    break;
                case MORPHO:
                    item = NaturalityItems.MORPHO_BUTTERFLY.get();
                    break;
                case RED_ADMIRAL:
                    item = NaturalityItems.RED_ADMIRAL_BUTTERFLY.get();
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return item;
    }
    public static boolean checkSpawnRules(EntityType<Butterfly> p_218256_, ServerLevelAccessor p_218257_, MobSpawnType p_218258_, BlockPos p_218259_, RandomSource p_218260_) {
        BlockState blockstate = p_218257_.getBlockState(p_218259_.below());
        return (blockstate.is(BlockTags.LEAVES) || blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(BlockTags.LOGS) || blockstate.is(Blocks.AIR)) && isBrightEnoughToSpawn(p_218257_, p_218259_);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @javax.annotation.Nullable SpawnGroupData p_29681_, @javax.annotation.Nullable CompoundTag p_29682_) {
        Butterfly.Variant Butterfly$variant = getRandomButterflyVariant(p_29678_, this.blockPosition());
        if (p_29681_ instanceof Butterfly.ButterflyGroupData) {
            Butterfly$variant = ((Butterfly.ButterflyGroupData) p_29681_).variant;
        } else {
            p_29681_ = new Butterfly.ButterflyGroupData(Butterfly$variant);
        }

        this.setVariant(Butterfly$variant);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, (SpawnGroupData) p_29681_, p_29682_);
    }

    private static Butterfly.Variant getRandomButterflyVariant(LevelAccessor p_262699_, BlockPos p_262700_) {
        Holder<Biome> holder = p_262699_.getBiome(p_262700_);
        int i = p_262699_.getRandom().nextInt(100);
        if (holder.is(NaturalityTags.SPAWNS_MORPHO_BUTTERFLIES)) {
            return Variant.MORPHO;
        } else if (holder.is(NaturalityTags.SPAWNS_MONARCH_BUTTERFLIES)) {
            return Variant.MONARCH;
        } else if (holder.is(NaturalityTags.SPAWNS_MONARCH_AND_MORPHO_BUTTERFLIES)) {
            return i < 50 ? Variant.MONARCH : Variant.MORPHO;
        } else if (holder.is(NaturalityTags.SPAWNS_ADMIRAL_BUTTERFLIES)) {
            return Variant.RED_ADMIRAL;
        } else {
            return Variant.MONARCH;
            }
        }
    public void setVariant(Butterfly.Variant p_262578_) {
        this.entityData.set(DATA_TYPE_ID, p_262578_.id);
    }

    @javax.annotation.Nullable
    public Butterfly getBreedOffspring(ServerLevel p_149035_, AgeableMob p_149036_) {
        Butterfly butterfly = (Butterfly) NaturalityEntityTypes.BUTTERFLY.get().create(p_149035_);
        if (butterfly != null) {
            Butterfly.Variant butterfly$variant = getRandomButterflyVariant(p_149035_, this.blockPosition());
            if (this.random.nextInt(20) != 0) {
                label22:
                {
                    if (p_149036_ instanceof Butterfly) {
                        Butterfly butterfly1 = (Butterfly) p_149036_;
                        if (this.random.nextBoolean()) {
                            butterfly$variant = butterfly1.getVariant();
                            break label22;
                        }
                    }

                    butterfly$variant = this.getVariant();
                }
            }

            butterfly.setVariant(butterfly$variant);
        }

        return butterfly;
    }

    public static class ButterflyGroupData extends AgeableMob.AgeableMobGroupData {
        public final Butterfly.Variant variant;

        public ButterflyGroupData(Butterfly.Variant p_262662_) {
            super(1.0F);
            this.variant = p_262662_;
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.FLYING_SPEED, 0.355353)
                .add(Attributes.MAX_HEALTH, 5);
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
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
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

    public boolean removeWhenFarAway(double p_218384_) {
        return false;
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    boolean isTooFarAway(BlockPos p_27890_) {
        return !this.closerThan(p_27890_, 32);
    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0, (double) (0.5F * this.getEyeHeight()), (double) (this.getBbWidth() * 0.2F));
    }

    protected void onFlap() {
        this.playSound(SoundEvents.PARROT_FLY, 0.15F, 1.0F);
    }
    void pathfindRandomlyTowards(BlockPos p_27881_) {
        Vec3 vec3 = Vec3.atBottomCenterOf(p_27881_);
        int i = 0;
        BlockPos blockpos = this.blockPosition();
        int j = (int) vec3.y - blockpos.getY();
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
        return p_27817_.closerThan(this.blockPosition(), (double) p_27818_);
    }
    private void setFlag(int p_28533_, boolean p_28534_) {
        if (p_28534_) {
            this.entityData.set(DATA_FLAGS_ID, (byte)((Byte)this.entityData.get(DATA_FLAGS_ID) | p_28533_));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)((Byte)this.entityData.get(DATA_FLAGS_ID) & ~p_28533_));
        }

    }
    private boolean getFlag(int p_28609_) {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & p_28609_) != 0;
    }
    public boolean isSleeping() {
        return this.getFlag(32);
    }
    void setSleeping(boolean p_28627_) {
        this.setFlag(32, p_28627_);
    }
    void clearStates() {
        this.setSleeping(false);
    }
    protected boolean isOnLeaves() {
        BlockPos blockpos = BlockPos.containing(Butterfly.this.getX(), Butterfly.this.getBoundingBox().maxY, Butterfly.this.getZ());
        BlockState blockstate = this.level().getBlockState(blockpos.below());
        return (blockstate.is(BlockTags.LEAVES) || blockstate.is(BlockTags.LOGS));
    }
    class ButterflySleepGoal extends Goal {
        private static final int WAIT_TIME_BEFORE_SLEEP = reducedTickDelay(140);
        private int countdown;

        public ButterflySleepGoal() {
            super();
            this.countdown = Butterfly.this.random.nextInt(WAIT_TIME_BEFORE_SLEEP);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public boolean canUse() {
            if (Butterfly.this.xxa == 0.0F && Butterfly.this.yya == 0.0F && Butterfly.this.zza == 0.0F) {
                return this.canSleep() || Butterfly.this.isSleeping();
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return this.canSleep();
        }

        private boolean canSleep() {
            if (this.countdown > 0) {
                --this.countdown;
                return false;
            } else {
                return Butterfly.this.level().isNight() && isOnLeaves() && !Butterfly.this.isInPowderSnow;
            }
        }

        public void stop() {
            this.countdown = Butterfly.this.random.nextInt(WAIT_TIME_BEFORE_SLEEP);
            Butterfly.this.clearStates();
        }

        public void start() {
            Butterfly.this.setJumping(false);
            Butterfly.this.setSleeping(true);
            Butterfly.this.getNavigation().stop();
            Butterfly.this.getMoveControl().setWantedPosition(Butterfly.this.getX(), Butterfly.this.getY(), Butterfly.this.getZ(), 0.0);
        }
    }
    public class ButterflyLookControl extends LookControl {
        public ButterflyLookControl() {
            super(Butterfly.this);
        }

        public void tick() {
            if (!Butterfly.this.isSleeping()) {
                super.tick();
            }

        }
    }

    class ButterflyMoveControl extends FlyingMoveControl {


        public ButterflyMoveControl(Mob p_24893_, int p_24894_, boolean p_24895_) {
            super(p_24893_, p_24894_, p_24895_);
        }

        public void tick() {
            if (!Butterfly.this.isSleeping()) {
                super.tick();
            }

        }
    }
    class ButterflyPollinateGoal extends Goal {
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

        ButterflyPollinateGoal() {
            super();
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (Butterfly.this.remainingCooldownBeforeLocatingNewFlower > 0) {
                return false;
            } else if (Butterfly.this.level().isRaining()) {
                return false;
            } else {
                Optional<BlockPos> optional = this.findNearbyFlower();
                if (optional.isPresent()) {
                    Butterfly.this.savedFlowerPos = (BlockPos) optional.get();
                    Butterfly.this.navigation.moveTo((double) Butterfly.this.savedFlowerPos.getX() + 0.5, (double) Butterfly.this.savedFlowerPos.getY() + 0.5, (double) Butterfly.this.savedFlowerPos.getZ() + 0.5, 1.2000000476837158);
                    return true;
                } else {
                    Butterfly.this.remainingCooldownBeforeLocatingNewFlower = Mth.nextInt(Butterfly.this.random, 20, 60);
                    return false;
                }
            }
        }

        public boolean canContinueToUse() {
            if (!this.pollinating) {
                return false;
            } else if (!Butterfly.this.hasSavedFlowerPos()) {
                return false;
            } else if (Butterfly.this.level().isRaining()) {
                return false;
            } else if (this.hasPollinatedLongEnough()) {
                return Butterfly.this.random.nextFloat() < 0.2F;
            } else if (Butterfly.this.tickCount % 20 == 0 && !Butterfly.this.isFlowerValid(Butterfly.this.savedFlowerPos)) {
                Butterfly.this.savedFlowerPos = null;
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
            Butterfly.this.navigation.stop();
            Butterfly.this.remainingCooldownBeforeLocatingNewFlower = 200;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            ++this.pollinatingTicks;
            if (this.pollinatingTicks > 600) {
                Butterfly.this.savedFlowerPos = null;
            } else {
                Vec3 vec3 = Vec3.atBottomCenterOf(Butterfly.this.savedFlowerPos).add(0.0, 0.6000000238418579, 0.0);
                if (vec3.distanceTo(Butterfly.this.position()) > 1.0) {
                    this.hoverPos = vec3;
                    this.setWantedPos();
                } else {
                    if (this.hoverPos == null) {
                        this.hoverPos = vec3;
                    }

                    boolean flag = Butterfly.this.position().distanceTo(this.hoverPos) <= 0.1;
                    boolean flag1 = true;
                    if (!flag && this.pollinatingTicks > 600) {
                        Butterfly.this.savedFlowerPos = null;
                    } else {
                        if (flag) {
                            boolean flag2 = Butterfly.this.random.nextInt(25) == 0;
                            if (flag2) {
                                this.hoverPos = new Vec3(vec3.x() + (double) this.getOffset(), vec3.y(), vec3.z() + (double) this.getOffset());
                                Butterfly.this.navigation.stop();
                            } else {
                                flag1 = false;
                            }

                            Butterfly.this.getLookControl().setLookAt(vec3.x(), vec3.y(), vec3.z());
                        }

                        if (flag1) {
                            this.setWantedPos();
                        }

                        ++this.successfulPollinatingTicks;
                        if (Butterfly.this.random.nextFloat() < 0.05F && this.successfulPollinatingTicks > this.lastSoundPlayedTick + 60) {
                            this.lastSoundPlayedTick = this.successfulPollinatingTicks;
                            Butterfly.this.playSound(SoundEvents.BEE_POLLINATE, 1.0F, 1.0F);
                        }
                    }
                }
            }

        }

        private void setWantedPos() {
            Butterfly.this.getMoveControl().setWantedPosition(this.hoverPos.x(), this.hoverPos.y(), this.hoverPos.z(), 0.3499999940395355);
        }

        private float getOffset() {
            return (Butterfly.this.random.nextFloat() * 2.0F - 1.0F) * 0.33333334F;
        }

        private Optional<BlockPos> findNearbyFlower() {
            return this.findNearestBlock(this.VALID_POLLINATION_BLOCKS, 5.0);
        }

        private Optional<BlockPos> findNearestBlock(Predicate<BlockState> p_28076_, double p_28077_) {
            BlockPos blockpos = Butterfly.this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (int i = 0; (double) i <= p_28077_; i = i > 0 ? -i : 1 - i) {
                for (int j = 0; (double) j < p_28077_; ++j) {
                    for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                        for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                            blockpos$mutableblockpos.setWithOffset(blockpos, k, i - 1, l);
                            if (blockpos.closerThan(blockpos$mutableblockpos, p_28077_) && p_28076_.test(Butterfly.this.level().getBlockState(blockpos$mutableblockpos))) {
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
            this.travellingTicks = Butterfly.this.level().random.nextInt(10);
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return Butterfly.this.savedFlowerPos != null && !Butterfly.this.hasRestriction() && this.wantsToGoToKnownFlower() && Butterfly.this.isFlowerValid(Butterfly.this.savedFlowerPos) && !Butterfly.this.closerThan(Butterfly.this.savedFlowerPos, 2);
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
            Butterfly.this.navigation.stop();
            Butterfly.this.navigation.resetMaxVisitedNodesMultiplier();
        }

        public void tick() {
            if (Butterfly.this.savedFlowerPos != null) {
                ++this.travellingTicks;
                if (this.travellingTicks > this.adjustedTickDelay(600)) {
                    Butterfly.this.savedFlowerPos = null;
                } else if (!Butterfly.this.navigation.isInProgress()) {
                    if (Butterfly.this.isTooFarAway(Butterfly.this.savedFlowerPos)) {
                        Butterfly.this.savedFlowerPos = null;
                    } else {
                        Butterfly.this.pathfindRandomlyTowards(Butterfly.this.savedFlowerPos);
                    }
                }
            }

        }

        private boolean wantsToGoToKnownFlower() {
            return Butterfly.this.ticksWithoutNectar > 2400;
        }
    }

    class WanderGoal extends Goal {
        WanderGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return Butterfly.this.navigation.isDone() && Butterfly.this.random.nextInt(3) == 0;
        }

        public boolean canContinueToUse() {
            return Butterfly.this.navigation.isInProgress();
        }

        public void start() {
            Vec3 vector3d = Butterfly.this.getRandomLocation();
                if (vector3d != null) {
                    Butterfly.this.navigation.moveTo(Butterfly.this.navigation.createPath(Butterfly.this.fromVec3(vector3d), 1), 1.0D);
            }
        }
    }
    @Nullable
    private Vec3 getRandomLocation() {
        Vec3 vec3 = Butterfly.this.getViewVector(0.0F);
        int i = 8;
        Vec3 vec32 = HoverRandomPos.getPos(Butterfly.this, 8, 7, vec3.x, vec3.z, Mth.HALF_PI, 3, 1);
        return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(Butterfly.this, 8, 4, -2, vec3.x, vec3.z, (double)Mth.HALF_PI);
    }
    public static final BlockPos fromCoords(double x, double y, double z){
        return new BlockPos((int) x, (int) y, (int) z);
    }

    public static final BlockPos fromVec3(Vec3 vec3) {
        return fromCoords(vec3.x, vec3.y, vec3.z);
    }
}