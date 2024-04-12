package com._LovelyBunny.Naturality.worldgen;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
public class NaturalityPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MAPLE = registerKey("maple");
    public static final ResourceKey<PlacedFeature> LINDEN = registerKey("linden");
    public static final ResourceKey<PlacedFeature> DRACAENA = registerKey("dracaena");
    public static final ResourceKey<PlacedFeature> BEECH = registerKey("beech");
    public static final ResourceKey<PlacedFeature> LARCH = registerKey("larch");
    public static final ResourceKey<PlacedFeature> JACARANDA = registerKey("jacaranda");
    public static final ResourceKey<PlacedFeature> ALOE = registerKey("aloe");
    public static final ResourceKey<PlacedFeature> PATCH_DENSE_GRASS = registerKey("patch_dense_grass");
    public static final ResourceKey<PlacedFeature> DRAGON_FRUIT = registerKey("dragon_fruit");
    public static final ResourceKey<PlacedFeature> WISTERIA = registerKey("wisteria");
    public static final ResourceKey<PlacedFeature> FLOWER_MAPLE = registerKey("flower_maple");
    public static final ResourceKey<PlacedFeature> TREES_MAPLE_FOREST = registerKey("trees_maple_forest");
    public static final ResourceKey<PlacedFeature> TREES_DECIDUOUS = registerKey("trees_deciduous");
    public static final ResourceKey<PlacedFeature> TREES_CLIFFS = registerKey("trees_cliffs");
    public static final ResourceKey<PlacedFeature> DECIDUOUS_BUSH = registerKey("deciduous_bush");

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Naturality.MODID, name));
    }
}