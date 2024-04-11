package com._LovelyBunny.Naturality.block;

import com._LovelyBunny.Naturality.block.entity.NaturalityHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NaturalityWallHangingSignBlock extends WallHangingSignBlock {
    public NaturalityWallHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NaturalityHangingSignBlockEntity(pPos, pState);
    }
}
