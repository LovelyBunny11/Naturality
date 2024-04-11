package com._LovelyBunny.Naturality.worldgen.biome;

import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class NaturalitySurfaceRuleData {
    //VANILLA
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    //Naturality
    private static final SurfaceRules.RuleSource SANDY_SOIL = makeStateRule(NaturalityBlocks.SANDY_SOIL.get());

    public NaturalitySurfaceRuleData() {
    }

    private static SurfaceRules.RuleSource makeStateRule(Block p_194811_) {
        return SurfaceRules.state(p_194811_.defaultBlockState());
    }

    public static SurfaceRules.RuleSource overworld() {
        return overworldLike();
    }

    public static SurfaceRules.RuleSource overworldLike() {
        SurfaceRules.ConditionSource $$1 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454, 0.909);
        SurfaceRules.ConditionSource $$2 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.2454, 0.709);
        SurfaceRules.RuleSource $$3 = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, COARSE_DIRT)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, DIRT)),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, STONE)),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                        SurfaceRules.ifTrue(
                                $$1, STONE)),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SANDY_SOIL),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SANDY_SOIL),
                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE));
        SurfaceRules.RuleSource $$4 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.RuleSource $$5 = SurfaceRules.sequence(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(NaturalityBiomes.LUSH_DESERT), $$3), SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, $$4)));
        SurfaceRules.RuleSource $$6 = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), $$5);
        return $$6;
    }
}