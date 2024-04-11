package com._LovelyBunny.Naturality.entity;

import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import com._LovelyBunny.Naturality.item.NaturalityItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;

public class NaturalityBoat extends Boat {
    public NaturalityBoat(EntityType<? extends NaturalityBoat> type, Level level)
    {
        super(type, level);
        this.blocksBuilding = true;
    }

    public NaturalityBoat(Level level, double x, double y, double z)
    {
        this((EntityType<NaturalityBoat>) NaturalityEntityTypes.BOAT.get(), level);
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
        nbt.putString("Type", this.getNaturalityVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag nbt) {
        if (nbt.contains("Type", 8)) {
            this.setNaturalityVariant(NaturalityBoat.Type.byName(nbt.getString("Type")));
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
                    if (this.status != Boat.Status.ON_LAND)
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
                                this.spawnAtLocation(this.getNaturalityType().getPlanks());
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
        switch (Type.byId(this.entityData.get(DATA_ID_TYPE)))
        {
            case MAPLE:
                return NaturalityItems.MAPLE_BOAT.get();
            case LINDEN:
                return NaturalityItems.LINDEN_BOAT.get();
            case DRACAENA:
                return NaturalityItems.DRACAENA_BOAT.get();
            case BEECH:
                return NaturalityItems.BEECH_BOAT.get();
            case LARCH:
                return NaturalityItems.LARCH_BOAT.get();
            case JACARANDA:
                return NaturalityItems.JACARANDA_BOAT.get();
        }
        return Items.OAK_BOAT;
    }

    public void setType(Type type)
    {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public NaturalityBoat.Type getNaturalityType()
    {
        return NaturalityBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public void setNaturalityVariant(Type p_38333_) {
        this.entityData.set(DATA_ID_TYPE, p_38333_.ordinal());
    }

    public Type getNaturalityVariant() {
        return Type.byId((Integer)this.entityData.get(DATA_ID_TYPE));
    }

    public enum Type {
        MAPLE("maple", NaturalityBlocks.MAPLE_PLANKS.get()),
        LINDEN("linden", NaturalityBlocks.LINDEN_PLANKS.get()),
        DRACAENA("dracaena", NaturalityBlocks.DRACAENA_PLANKS.get()),
        BEECH("beech", NaturalityBlocks.BEECH_PLANKS.get()),
        LARCH("larch", NaturalityBlocks.LARCH_PLANKS.get()),
        JACARANDA("jacaranda", NaturalityBlocks.JACARANDA_PLANKS.get());

        private final String name;
        private final Block planks;

        Type(String name, Block planks)
        {
            this.name = name;
            this.planks = planks;
        }

        public String getName()
        {
            return this.name;
        }
        public String getSerializedName() {
            return this.name;
        }
        public Block getPlanks()
        {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int id)
        {
            Type[] type = values();
            return type[id < 0 || id >= type.length ? 0 : id];
        }

        public static Type byName(String aName)
        {
            Type[] type = values();
            return Arrays.stream(type).filter(t -> t.getName().equals(aName)).findFirst().orElse(type[0]);
        }
    }
}
