package com._LovelyBunny.NET.worldgen.biome;

import com._LovelyBunny.NET.block.NETBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class NETSurfaceRuleData {

    private static final SurfaceRules.RuleSource SANDY_SOIL = makeStateRule(NETBlocks.SANDY_SOIL.get());
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static SurfaceRules.RuleSource makeStateRule(Block p_194811_) {
        return SurfaceRules.state(p_194811_.defaultBlockState());
    }
    public static SurfaceRules.RuleSource makeRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(NETBiomes.BARRENS),
                        SurfaceRules.ifTrue(surfaceNoiseAbove(3.1D), SANDY_SOIL)),
                SurfaceRules.ifTrue(surfaceNoiseAbove(1D), COARSE_DIRT));
    }
    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}