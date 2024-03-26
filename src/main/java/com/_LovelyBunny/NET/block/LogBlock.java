package com._LovelyBunny.NET.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class LogBlock extends RotatedPillarBlock{
    public LogBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(NETBlocks.MAPLE_LOG.get())) {
                return NETBlocks.STRIPPED_MAPLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(NETBlocks.LINDEN_LOG.get())) {
                return NETBlocks.STRIPPED_LINDEN_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(NETBlocks.DRACAENA_LOG.get())) {
                return NETBlocks.STRIPPED_DRACAENA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.BEECH_LOG.get())) {
                return NETBlocks.STRIPPED_BEECH_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.LARCH_LOG.get())) {
                return NETBlocks.STRIPPED_LARCH_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.MAPLE_WOOD.get())) {
                return NETBlocks.STRIPPED_MAPLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.LINDEN_WOOD.get())) {
                return NETBlocks.STRIPPED_LINDEN_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.DRACAENA_WOOD.get())) {
                return NETBlocks.STRIPPED_DRACAENA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.BEECH_WOOD.get())) {
                return NETBlocks.STRIPPED_BEECH_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(NETBlocks.LARCH_WOOD.get())) {
                return NETBlocks.STRIPPED_LARCH_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
