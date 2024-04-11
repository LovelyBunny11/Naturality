package com._LovelyBunny.Naturality.block;

import com._LovelyBunny.Naturality.block.entity.NaturalitySignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NaturalityStandingSignBlock extends StandingSignBlock {
    public NaturalityStandingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NaturalitySignBlockEntity(pPos, pState);
    }
}
