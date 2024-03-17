package com._LovelyBunny.NET.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NETHangingSignBlockEntity extends SignBlockEntity {
    public NETHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(NETBlockEntities.NET_HANGING_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return NETBlockEntities.NET_HANGING_SIGN.get();
    }
}
