package com._LovelyBunny.NET.worldgen.biome;

import com._LovelyBunny.NET.block.NETBlocks;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class NETSurfaceRuleData1 {
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource SANDY_SOIL = makeStateRule(NETBlocks.SANDY_SOIL.get());
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static SurfaceRules.RuleSource makeStateRule(Block p_194811_) {
        return SurfaceRules.state(p_194811_.defaultBlockState());
    }
    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource $$5 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource $$6 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource $$7 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(NETBiomesWithSurfaceRules.LUSH_DESERT),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SANDY_SOIL)),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE), SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SANDY_SOIL),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE),

        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface));
    }
    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}