package com._LovelyBunny.NET.entity;

import com._LovelyBunny.NET.item.NETItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class NETChestBoat extends ChestBoat {
    
    public NETChestBoat(EntityType<? extends NETChestBoat> type, Level level)
        {
            super(type, level);
            this.blocksBuilding = true;
        }

    public NETChestBoat(Level level, double x, double y, double z)
        {
            this((EntityType<NETChestBoat>)NETEntities.CHEST_BOAT.get(), level);
            this.setPos(x, y, z);
            this.xo = x;
            this.yo = y;
            this.zo = z;
        }

        @Override
        public Packet<ClientGamePacketListener> getAddEntityPacket()
        {
            return new ClientboundAddEntityPacket(this);
        }

        @Override
        protected void addAdditionalSaveData(CompoundTag nbt) {
            super.readAdditionalSaveData(nbt);
            this.readChestVehicleSaveData(nbt);
            nbt.putString("Type", this.getNETVariant().getSerializedName());
        }

        @Override
        protected void readAdditionalSaveData(CompoundTag nbt) {
            super.readAdditionalSaveData(nbt);
            this.readChestVehicleSaveData(nbt);
            if (nbt.contains("Type", 8)) {
                this.setNETVariant(NETBoat.Type.byName(nbt.getString("Type")));
            }
        }

        @Override
        protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos)
        {
            this.lastYd = this.getDeltaMovement().y;
            if (!this.isPassenger())
            {
                if (onGround)
                {
                    if (this.fallDistance > 3.0F)
                    {
                        if (this.status != Status.ON_LAND)
                        {
                            this.resetFallDistance();
                            return;
                        }

                        this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());
                        if (!this.level().isClientSide && !this.isRemoved())
                        {
                            this.kill();
                            if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS))
                            {
                                for (int i = 0; i < 3; ++i)
                                {
                                    this.spawnAtLocation(this.getNETType().getPlanks());
                                }

                                for (int j = 0; j < 2; ++j)
                                {
                                    this.spawnAtLocation(Items.STICK);
                                }
                            }
                        }
                    }

                    this.resetFallDistance();
                }
                else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D)
                {
                    this.fallDistance -= (float)y;
                }
            }
        }

        @Override
        public Item getDropItem()
        {
            switch (NETBoat.Type.byId(this.entityData.get(DATA_ID_TYPE)))
            {
                case MAPLE:
                    return NETItems.MAPLE_CHEST_BOAT.get();
                case LINDEN:
                    return NETItems.LINDEN_CHEST_BOAT.get();
                case DRACAENA:
                    return NETItems.DRACAENA_CHEST_BOAT.get();
                case BEECH:
                    return NETItems.BEECH_CHEST_BOAT.get();
                case LARCH:
                    return NETItems.LARCH_CHEST_BOAT.get();
            }
            return Items.OAK_CHEST_BOAT;
        }

        public void setType(NETBoat.Type type)
        {
            this.entityData.set(DATA_ID_TYPE, type.ordinal());
        }

        public NETBoat.Type getNETType()
        {
            return NETBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
        }

    public NETBoat.Type getNETVariant() {
        return NETBoat.Type.byId((Integer)this.entityData.get(DATA_ID_TYPE));
    }
    public void setNETVariant(NETBoat.Type p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }
}