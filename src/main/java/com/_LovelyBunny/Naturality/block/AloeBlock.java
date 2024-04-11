package com._LovelyBunny.Naturality.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AloeBlock extends BushBlock {
    private static final VoxelShape SHAPE;
    public AloeBlock(Properties p_49795_) {
        super(p_49795_);
    }
    public VoxelShape getShape(BlockState p_57336_, BlockGetter p_57337_, BlockPos p_57338_, CollisionContext p_57339_) {
        return SHAPE;
    }
    static {
        SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    }

    public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity p_57273_) {
        if (p_57273_ instanceof LivingEntity) {
            p_57273_.makeStuckInBlock(p_57270_, new Vec3(0.800000011920929, 0.75, 0.800000011920929)); {
                double d0 = Math.abs(p_57273_.getX() - p_57273_.xOld);
                double d1 = Math.abs(p_57273_.getZ() - p_57273_.zOld);
                if (d0 >= 0.003000000026077032 || d1 >= 0.003000000026077032) {
                    p_57273_.hurt(p_57271_.damageSources().sweetBerryBush(), 1.0F);
                }
            }
        }
    }
}
