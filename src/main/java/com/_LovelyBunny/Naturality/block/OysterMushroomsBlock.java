package com._LovelyBunny.Naturality.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OysterMushroomsBlock extends Block implements BonemealableBlock {
    public static final int MIN_FLOWERS = 1;
    public static final int MAX_FLOWERS = 4;
    public static final DirectionProperty FACING;
    public static final IntegerProperty AMOUNT;

    protected final VoxelShape northAabb;
    protected final VoxelShape southAabb;
    protected final VoxelShape eastAabb;
    protected final VoxelShape westAabb;

    public OysterMushroomsBlock(BlockBehaviour.Properties p_273335_) {
        super(p_273335_);
        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(AMOUNT, 1));
        eastAabb = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        westAabb = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        southAabb = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        northAabb = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
    }

    public VoxelShape getShape(BlockState p_152021_, BlockGetter p_152022_, BlockPos p_152023_, CollisionContext p_152024_) {
        Direction $$4 = (Direction)p_152021_.getValue(FACING);
        switch ($$4) {
            case NORTH:
                return this.northAabb;
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            default:
                return this.northAabb;
        }
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos.relative((Direction)state.getValue(FACING).getOpposite()));
        return blockstate.is(BlockTags.LOGS);
    }

    public BlockState updateShape(BlockState p_51771_, Direction p_51772_, BlockState p_51773_, LevelAccessor p_51774_, BlockPos p_51775_, BlockPos p_51776_) {
        return p_51772_ == p_51771_.getValue(FACING) && !p_51771_.canSurvive(p_51774_, p_51775_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51771_, p_51772_, p_51773_, p_51774_, p_51775_, p_51776_);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_51750_) {
        LevelReader levelreader = p_51750_.getLevel();
        BlockPos blockpos = p_51750_.getClickedPos();
        BlockState state = p_51750_.getLevel().getBlockState(p_51750_.getClickedPos());
        if (state.is(this)) {
            return state.setValue(AMOUNT, Math.min(4, state.getValue(AMOUNT) + 1));
        } else if (state.canSurvive(levelreader, blockpos)) {
            return this.defaultBlockState().setValue(FACING, p_51750_.getHorizontalDirection().getOpposite());
        }
        return null;
    }

    public BlockState rotate(BlockState p_273485_, Rotation p_273021_) {
        return (BlockState) p_273485_.setValue(FACING, p_273021_.rotate((Direction) p_273485_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_272961_, Mirror p_273278_) {
        return p_272961_.rotate(p_273278_.getRotation((Direction) p_272961_.getValue(FACING)));
    }

    public boolean canBeReplaced(BlockState p_272922_, BlockPlaceContext p_273534_) {
        return !p_273534_.isSecondaryUseActive() && p_273534_.getItemInHand().is(this.asItem()) && (Integer) p_272922_.getValue(AMOUNT) < 4 ? true : super.canBeReplaced(p_272922_, p_273534_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_272634_) {
        p_272634_.add(new Property[]{FACING, AMOUNT});
    }

    public boolean isValidBonemealTarget(LevelReader p_272968_, BlockPos p_273762_, BlockState p_273662_, boolean p_273778_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_272604_, RandomSource p_273609_, BlockPos p_272988_, BlockState p_273231_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_273476_, RandomSource p_273093_, BlockPos p_272601_, BlockState p_272683_) {
        int $$4 = (Integer) p_272683_.getValue(AMOUNT);
        if ($$4 < 4) {
            p_273476_.setBlock(p_272601_, (BlockState) p_272683_.setValue(AMOUNT, $$4 + 1), 2);
        } else {
            popResource(p_273476_, p_272601_, new ItemStack(this));
        }
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        AMOUNT = BlockStateProperties.FLOWER_AMOUNT;
    }
}
