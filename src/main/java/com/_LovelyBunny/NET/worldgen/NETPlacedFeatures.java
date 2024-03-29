package com._LovelyBunny.NET.worldgen;

import com._LovelyBunny.NET.NET;
import com._LovelyBunny.NET.block.NETBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class NETPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MAPLE = registerKey("maple");
    public static final ResourceKey<PlacedFeature> LINDEN = registerKey("linden");
    public static final ResourceKey<PlacedFeature> DRACAENA = registerKey("dracaena");
    public static final ResourceKey<PlacedFeature> BEECH = registerKey("beech");
    public static final ResourceKey<PlacedFeature> LARCH = registerKey("larch");
    public static final ResourceKey<PlacedFeature> ALOE = registerKey("aloe");
    public static final ResourceKey<PlacedFeature> DRAGON_FRUIT = registerKey("dragon_fruit");
    public static final ResourceKey<PlacedFeature> FLOWER_MAPLE = registerKey("flower_maple");
    public static final ResourceKey<PlacedFeature> TREES_MAPLE_FOREST = registerKey("trees_maple_forest");
    public static final ResourceKey<PlacedFeature> TREES_DECIDUOUS = registerKey("trees_deciduous");
    public static final ResourceKey<PlacedFeature> DECIDUOUS_BUSH = registerKey("deciduous_bush");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NET.MODID, name));
    }
}