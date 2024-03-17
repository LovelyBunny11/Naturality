package com._LovelyBunny.NET.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NETSignBlockEntity extends SignBlockEntity {
    public NETSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(NETBlockEntities.NET_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return NETBlockEntities.NET_SIGN.get();
    }
}
