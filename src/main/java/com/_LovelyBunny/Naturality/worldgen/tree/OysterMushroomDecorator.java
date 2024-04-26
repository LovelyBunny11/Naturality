package com._LovelyBunny.Naturality.worldgen.tree;

import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import com._LovelyBunny.Naturality.block.OysterMushroomsBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.*;

public class OysterMushroomDecorator extends TreeDecorator {
    public static final Codec<OysterMushroomDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(OysterMushroomDecorator::new, (p_69971_) -> p_69971_.probability).codec();
    private final float probability;
    public OysterMushroomDecorator(float p_69958_) {
        this.probability = p_69958_;
    }

    protected TreeDecoratorType<?> type() {
        return NaturalityTreeDecorators.OYSTER_MUSHROOM_DECORATOR.get();
    }

    public void place(Context context) {
        Random random = new Random();
        int mushroomAmountRange = 4 - 1 + 1;
        int mushroomAmount =  random.nextInt(mushroomAmountRange) + 1;
        RandomSource randomSource = context.random();
        context.logs().forEach((p_226075_) -> {
            BlockPos pos;
            if (!(randomSource.nextFloat() >= this.probability)) {
                pos = p_226075_.west();
                if (context.isAir(pos)) {
                    context.setBlock(pos, NaturalityBlocks.OYSTER_MUSHROOMS.get().defaultBlockState().setValue(OysterMushroomsBlock.FACING, Direction.WEST).setValue(OysterMushroomsBlock.AMOUNT, mushroomAmount));
                }
            }
            if (!(randomSource.nextFloat() >= this.probability)) {
                pos = p_226075_.east();
                if (context.isAir(pos)) {
                    context.setBlock(pos, NaturalityBlocks.OYSTER_MUSHROOMS.get().defaultBlockState().setValue(OysterMushroomsBlock.FACING, Direction.EAST).setValue(OysterMushroomsBlock.AMOUNT, mushroomAmount));
                }
            }
            if (!(randomSource.nextFloat() >= this.probability)) {
                pos = p_226075_.north();
                if (context.isAir(pos)) {
                    context.setBlock(pos, NaturalityBlocks.OYSTER_MUSHROOMS.get().defaultBlockState().setValue(OysterMushroomsBlock.FACING, Direction.NORTH).setValue(OysterMushroomsBlock.AMOUNT, mushroomAmount));
                }
            }
            if (!(randomSource.nextFloat() >= this.probability)) {
                pos = p_226075_.south();
                if (context.isAir(pos)) {
                    context.setBlock(pos, NaturalityBlocks.OYSTER_MUSHROOMS.get().defaultBlockState().setValue(OysterMushroomsBlock.FACING, Direction.SOUTH).setValue(OysterMushroomsBlock.AMOUNT, mushroomAmount));
                }
            }
        });
    }
}