package com._LovelyBunny.Naturality.block;

import com._LovelyBunny.Naturality.item.NaturalityItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class DragonFruitPlantBlock extends GrowingPlantBodyBlock implements BonemealableBlock, DragonFruit {
    public DragonFruitPlantBlock(BlockBehaviour.Properties p_152959_) {
        super(p_152959_, Direction.DOWN, SHAPE, false);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(BERRIES, false)));
    }
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_220928_) {
        return 1;
    }
    protected boolean canGrowInto(BlockState p_152998_) {
        return p_152998_.isAir();
    }


    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock)NaturalityBlocks.DRAGON_FRUIT.get();
    }

    protected BlockState updateBodyAfterConvertedFromHead(BlockState p_152987_, BlockState p_152988_) {
        return (BlockState)p_152988_.setValue(BERRIES, (Boolean)p_152987_.getValue(BERRIES));
    }

    public ItemStack getCloneItemStack(BlockGetter p_152966_, BlockPos p_152967_, BlockState p_152968_) {
        return new ItemStack(NaturalityItems.DRAGON_FRUIT.get());
    }

    public InteractionResult use(BlockState p_152980_, Level p_152981_, BlockPos p_152982_, Player p_152983_, InteractionHand p_152984_, BlockHitResult p_152985_) {
        return DragonFruit.use(p_152983_, p_152980_, p_152981_, p_152982_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_152993_) {
        super.createBlockStateDefinition(p_152993_);
        p_152993_.add(new Property[]{BERRIES});
    }

    public boolean isValidBonemealTarget(LevelReader p_256026_, BlockPos p_152971_, BlockState p_152972_, boolean p_152973_) {
        return !(Boolean)p_152972_.getValue(BERRIES);
    }

    public boolean isBonemealSuccess(Level p_220930_, RandomSource p_220931_, BlockPos p_220932_, BlockState p_220933_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_220923_, RandomSource p_220924_, BlockPos p_220925_, BlockState p_220926_) {
        p_220923_.setBlock(p_220925_, (BlockState)p_220926_.setValue(BERRIES, true), 2);
    }
    public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity p_57273_) {
        if (p_57273_ instanceof LivingEntity) {
            p_57273_.makeStuckInBlock(p_57270_, new Vec3(0.800000011920929, 0.75, 0.800000011920929));
            {
                double d0 = Math.abs(p_57273_.getX() - p_57273_.xOld);
                double d1 = Math.abs(p_57273_.getZ() - p_57273_.zOld);
                if (d0 >= 0.003000000026077032 || d1 >= 0.003000000026077032) {
                    p_57273_.hurt(p_57271_.damageSources().cactus(), 1.0F);
                }
            }
        }
    }
}

