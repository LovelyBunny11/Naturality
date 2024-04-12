package com._LovelyBunny.Naturality.worldgen.biome;

import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class NaturalitySurfaceRuleData {
    //VANILLA
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    //Naturality
    private static final SurfaceRules.RuleSource SANDY_SOIL = makeStateRule(NaturalityBlocks.SANDY_SOIL.get());

    private static SurfaceRules.RuleSource makeStateRule(Block p_194811_) {
        return SurfaceRules.state(p_194811_.defaultBlockState());
    }

    public static SurfaceRules.RuleSource overworld() {
        return overworldLike();
    }
    public static SurfaceRules.RuleSource overworldLike() {
        SurfaceRules.ConditionSource $$1 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818, 0.1818);
        SurfaceRules.ConditionSource $$2 = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource $$3 = SurfaceRules.sequence(SurfaceRules.ifTrue($$2, SANDY_SOIL), SAND);
        SurfaceRules.RuleSource $$4 = SurfaceRules.sequence(SurfaceRules.ifTrue($$2, COARSE_DIRT), SAND);
        SurfaceRules.RuleSource $$5 = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, $$4)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, DIRT)),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, STONE)),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                        SurfaceRules.ifTrue($$1, STONE)),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, $$3),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, $$3),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE));
        SurfaceRules.RuleSource $$6 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.RuleSource $$7 = SurfaceRules.sequence(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(NaturalityBiomes.LUSH_DESERT), $$5), SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, $$6)));
        return SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), $$7);
    }
}