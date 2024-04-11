package com._LovelyBunny.Naturality.block;

import com._LovelyBunny.Naturality.block.entity.NaturalityHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NaturalityHangingSignBlock extends CeilingHangingSignBlock {
    public NaturalityHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NaturalityHangingSignBlockEntity(pPos, pState);
    }
}
