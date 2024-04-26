package com._LovelyBunny.Naturality.worldgen.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class NearBranchMossDecorator extends TreeDecorator {
    public static final Codec<NearBranchMossDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(NearBranchMossDecorator::new, (p_69971_) -> p_69971_.probability).codec();
    private final float probability;
    public NearBranchMossDecorator(float p_69958_) {
        this.probability = p_69958_;
    }

    protected TreeDecoratorType<?> type() {
        return NaturalityTreeDecorators.NEAR_BRANCH_MOSS_DECORATOR.get();
    }

    public void place(Context context) {
        RandomSource random = context.random();
        context.logs().forEach((p_226075_) -> {
            BlockPos pos;
            if (!(random.nextFloat() >= this.probability)) {
                pos = p_226075_.west();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.MOSS_CARPET.defaultBlockState());
                }
            }
            if (!(random.nextFloat() >= this.probability)) {
                pos = p_226075_.east();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.MOSS_CARPET.defaultBlockState());
                }
            }
            if (!(random.nextFloat() >= this.probability)) {
                pos = p_226075_.north();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.MOSS_CARPET.defaultBlockState());
                }
            }
            if (!(random.nextFloat() >= this.probability)) {
                pos = p_226075_.south();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.MOSS_CARPET.defaultBlockState());
                }
            }
        });
    }
}