package com._LovelyBunny.NET.worldgen.tree;

import com._LovelyBunny.NET.worldgen.NETConfiguredFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.grower.AzaleaTreeGrower;
import net.minecraft.world.level.block.grower.BirchTreeGrower;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class MapleTreeGrower extends AbstractTreeGrower {
    public MapleTreeGrower() {
    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_255997_, boolean p_255923_) {
        return NETConfiguredFeatures.MAPLE;
    }
}
