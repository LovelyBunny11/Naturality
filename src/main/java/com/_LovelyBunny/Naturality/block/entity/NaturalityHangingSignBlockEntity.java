package com._LovelyBunny.Naturality.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NaturalityHangingSignBlockEntity extends HangingSignBlockEntity {


    public NaturalityHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return NaturalityBlockEntities.HANGING_SIGN.get();
    }
}
