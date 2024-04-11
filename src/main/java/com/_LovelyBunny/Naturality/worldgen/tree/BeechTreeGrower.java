package com._LovelyBunny.Naturality.worldgen.tree;

import com._LovelyBunny.Naturality.worldgen.NaturalityConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BeechTreeGrower extends AbstractTreeGrower {

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return NaturalityConfiguredFeatures.BEECH;
    }
}
