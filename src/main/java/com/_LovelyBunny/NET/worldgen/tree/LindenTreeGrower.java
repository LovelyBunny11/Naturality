package com._LovelyBunny.NET.worldgen.tree;

import com._LovelyBunny.NET.worldgen.NETConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class LindenTreeGrower extends AbstractTreeGrower {

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return NETConfiguredFeatures.LINDEN;
    }
}
