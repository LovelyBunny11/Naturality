package com._LovelyBunny.Naturality.entity;

import com._LovelyBunny.Naturality.sound.NaturalitySoundEvents;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Bird extends Animal implements FlyingAnimal {
    private static final EntityDataAccessor<Integer> DATA_VARIANT_ID;
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    private float flapping = 1.0F;
    private float nextFlap = 1.0F;
    private boolean partyBird;
    @Nullable
    private BlockPos jukebox;

    public Bird(EntityType<? extends Bird> p_29362_, Level p_29363_) {
        super(p_29362_, p_29363_);
        this.moveControl = new FlyingMoveControl(this, 10, false);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29389_, DifficultyInstance p_29390_, MobSpawnType p_29391_, @Nullable SpawnGroupData p_29392_, @Nullable CompoundTag p_29393_) {
        this.setVariant((Bird.Variant) Util.getRandom(Bird.Variant.values(), p_29389_.getRandom()));
        if (p_29392_ == null) {
            p_29392_ = new AgeableMob.AgeableMobGroupData(false);
        }

        return super.finalizeSpawn(p_29389_, p_29390_, p_29391_, (SpawnGroupData)p_29392_, p_29393_);
    }

    public boolean isBaby() {
        return false;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new BirdWanderGoal(this, 1.0));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0, 3.0F, 7.0F));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0).add(Attributes.FLYING_SPEED, 0.4000000059604645).add(Attributes.MOVEMENT_SPEED, 0.20000000298023224);
    }

    protected PathNavigation createNavigation(Level p_29417_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    protected float getStandingEyeHeight(Pose p_29411_, EntityDimensions p_29412_) {
        return p_29412_.height * 0.6F;
    }

    public void aiStep() {
        super.aiStep();
        this.calculateFlapping();
    }

    public void setRecordPlayingNearby(BlockPos p_29395_, boolean p_29396_) {
        this.jukebox = p_29395_;
        this.partyBird = p_29396_;
    }

    public boolean isPartyBird() {
        return this.partyBird;
    }

    private void calculateFlapping() {
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed += (float)(!this.onGround() && !this.isPassenger() ? 4 : -1) * 0.3F;
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping *= 0.9F;
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0) {
            this.setDeltaMovement(vec3.multiply(1.0, 0.6, 1.0));
        }

        this.flap += this.flapping * 2.0F;
    }

    public boolean isFood(ItemStack p_29446_) {
        return false;
    }

    protected void checkFallDamage(double p_29370_, boolean p_29371_, BlockState p_29372_, BlockPos p_29373_) {
    }

    public boolean canMate(Animal p_29381_) {
        return false;
    }

    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel p_148993_, AgeableMob p_148994_) {
        return null;
    }

    public boolean doHurtTarget(Entity p_29365_) {
        return p_29365_.hurt(this.damageSources().mobAttack(this), 3.0F);
    }

    @Nullable
    public SoundEvent getAmbientSound() {
        return getAmbient(this.level(), this.level().random);
    }

    public static SoundEvent getAmbient(Level p_218239_, RandomSource p_218240_) {
            return NaturalitySoundEvents.BIRD_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_29437_) {
        return NaturalitySoundEvents.BIRD_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return NaturalitySoundEvents.BIRD_DEATH.get();
    }
    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    protected void onFlap() {
        this.playSound(NaturalitySoundEvents.BIRD_FLY.get(), 0.15F, 1.0F);
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }

    public float getVoicePitch() {
        return getPitch(this.random);
    }

    public static float getPitch(RandomSource p_218237_) {
        return (p_218237_.nextFloat() - p_218237_.nextFloat()) * 0.2F + 1.0F;
    }

    public SoundSource getSoundSource() {
        return SoundSource.NEUTRAL;
    }

    public boolean isPushable() {
        return true;
    }

    protected void doPush(Entity p_29367_) {
        if (!(p_29367_ instanceof Player)) {
            super.doPush(p_29367_);
        }

    }

    public Bird.Variant getVariant() {
        return Bird.Variant.byId((Integer)this.entityData.get(DATA_VARIANT_ID));
    }

    public void setVariant(Bird.Variant p_262613_) {
        this.entityData.set(DATA_VARIANT_ID, p_262613_.id);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
    }

    public void addAdditionalSaveData(CompoundTag p_29422_) {
        super.addAdditionalSaveData(p_29422_);
        p_29422_.putInt("Variant", this.getVariant().id);
    }

    public void readAdditionalSaveData(CompoundTag p_29402_) {
        super.readAdditionalSaveData(p_29402_);
        this.setVariant(Bird.Variant.byId(p_29402_.getInt("Variant")));
    }

    public boolean isFlying() {
        return !this.onGround();
    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0, (double)(0.5F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }

    static {
        DATA_VARIANT_ID = SynchedEntityData.defineId(Bird.class, EntityDataSerializers.INT);
    }

    public static enum Variant implements StringRepresentable {
        NIGHTINGALE(0, "nightingale");

        public static final Codec<Bird.Variant> CODEC = StringRepresentable.fromEnum(Bird.Variant::values);
        private static final IntFunction<Bird.Variant> BY_ID = ByIdMap.continuous(Bird.Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.CLAMP);
        final int id;
        private final String name;

        private Variant(int p_262571_, String p_262693_) {
            this.id = p_262571_;
            this.name = p_262693_;
        }

        public int getId() {
            return this.id;
        }

        public static Bird.Variant byId(int p_262643_) {
            return (Bird.Variant)BY_ID.apply(p_262643_);
        }

        public String getSerializedName() {
            return this.name;
        }
    }

    static class BirdWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public BirdWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @Nullable
        protected Vec3 getPosition() {
            Vec3 vec3 = null;
            if (this.mob.isInWater()) {
                vec3 = LandRandomPos.getPos(this.mob, 15, 15);
            }

            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3 = this.getTreePos();
            }

            return vec3 == null ? super.getPosition() : vec3;
        }

        @Nullable
        private Vec3 getTreePos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();
            Iterator var4 = BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 3.0), Mth.floor(this.mob.getY() - 6.0), Mth.floor(this.mob.getZ() - 3.0), Mth.floor(this.mob.getX() + 3.0), Mth.floor(this.mob.getY() + 6.0), Mth.floor(this.mob.getZ() + 3.0)).iterator();

            BlockPos blockpos1;
            boolean flag;
            do {
                do {
                    if (!var4.hasNext()) {
                        return null;
                    }

                    blockpos1 = (BlockPos)var4.next();
                } while(blockpos.equals(blockpos1));

                BlockState blockstate = this.mob.level().getBlockState(blockpos$mutableblockpos1.setWithOffset(blockpos1, Direction.DOWN));
                flag = blockstate.getBlock() instanceof LeavesBlock || blockstate.is(BlockTags.LOGS);
            } while(!flag || !this.mob.level().isEmptyBlock(blockpos1) || !this.mob.level().isEmptyBlock(blockpos$mutableblockpos.setWithOffset(blockpos1, Direction.UP)));

            return Vec3.atBottomCenterOf(blockpos1);
        }
    }
}

