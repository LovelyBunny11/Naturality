package com._LovelyBunny.NET.worldgen;

import com._LovelyBunny.NET.NET;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

public class NETConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE = registerKey("maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LINDEN = registerKey("linden");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRACAENA = registerKey("dracaena");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEECH = registerKey("beech");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH = registerKey("larch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COARSE_DIRT_PATCH = registerKey("coarse_dirt_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALOE = registerKey("aloe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_BUSH = registerKey("deciduous_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_MAPLE = registerKey("flower_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MAPLE_FOREST = registerKey("trees_maple_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_DECIDUOUS = registerKey("trees_deciduous");
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(NET.MODID, name));
    }
}