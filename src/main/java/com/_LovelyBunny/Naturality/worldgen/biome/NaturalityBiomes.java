package com._LovelyBunny.Naturality.worldgen.biome;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import static com._LovelyBunny.Naturality.Naturality.MODID;

public class NaturalityBiomes {


    public static void registerBiomes(){
        Regions.register(new NaturalityColdOverworldRegion(new ResourceLocation(MODID, "overworld_cold"), 3));
        Regions.register(new NaturalityNeutralOverworldRegion(new ResourceLocation(MODID, "overworld_neutral"), 5));
        Regions.register(new NaturalityWarmOverworldRegion(new ResourceLocation(MODID, "overworld_warm"), 4));
        Regions.register(new NaturalityHotOverworldRegion(new ResourceLocation(MODID, "overworld_hot"), 3));
    }
    public static final ResourceKey<Biome> MAPLE_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "maple_forest"));
    public static final ResourceKey<Biome> DECIDUOUS_WOODLAND = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "deciduous_woodland"));
    public static final ResourceKey<Biome> AUTUMNAL_DECIDUOUS_WOODLAND = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "autumnal_deciduous_woodland"));
    public static final ResourceKey<Biome> LUSH_DESERT = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "lush_desert"));
    public static final ResourceKey<Biome> BUTTERFLY_VALLEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(MODID, "butterfly_valley"));
}
