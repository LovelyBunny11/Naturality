package com._LovelyBunny.NET.worldgen.biome;

import com._LovelyBunny.NET.NET;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;

public class NETBiomes {
    public static final ResourceKey<Biome> MAPLE_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NET.MODID, "maple_forest"));
    public static final ResourceKey<Biome> DECIDUOUS_WOODLAND = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NET.MODID, "deciduous_woodland"));
    public static final ResourceKey<Biome> AUTUMNAL_DECIDUOUS_WOODLAND = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NET.MODID, "autumnal_deciduous_woodland"));
    public static final ResourceKey<Biome> BARRENS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NET.MODID, "barrens"));
}
