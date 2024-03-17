package com._LovelyBunny.NET.block;

import com._LovelyBunny.NET.block.entity.NETHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NETHangingSignBlock extends CeilingHangingSignBlock {
    public NETHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NETHangingSignBlockEntity(pPos, pState);
    }
}
