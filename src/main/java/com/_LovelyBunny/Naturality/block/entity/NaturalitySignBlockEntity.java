package com._LovelyBunny.Naturality.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NaturalitySignBlockEntity extends SignBlockEntity {

    public NaturalitySignBlockEntity(BlockPos p_250603_, BlockState p_251674_) {
        super(NaturalityBlockEntities.SIGN.get(),  p_250603_, p_251674_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return NaturalityBlockEntities.SIGN.get();
    }
}
