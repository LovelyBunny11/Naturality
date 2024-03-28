package com._LovelyBunny.NET.worldgen.biome;

import com._LovelyBunny.NET.block.NETBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class NETSurfaceRuleData {
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static SurfaceRules.RuleSource makeStateRule(Block p_194811_) {
        return SurfaceRules.state(p_194811_.defaultBlockState());
    }
    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(NETBiomes.BARRENS),
                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5), STONE)),
                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5), COARSE_DIRT),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(NETBiomes.WOODED_BARRENS),
                        SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5), STONE)),
                        SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5), COARSE_DIRT),

        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        ));
    }
    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}