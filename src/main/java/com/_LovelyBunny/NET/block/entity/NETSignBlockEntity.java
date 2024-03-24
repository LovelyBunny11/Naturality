package com._LovelyBunny.NET.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NETSignBlockEntity extends SignBlockEntity {

    public NETSignBlockEntity(BlockPos p_250603_, BlockState p_251674_) {
        super(NETBlockEntities.SIGN.get(),  p_250603_, p_251674_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return NETBlockEntities.SIGN.get();
    }
}
