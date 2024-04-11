package com._LovelyBunny.Naturality.worldgen.biome;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class NaturalityBiomes {
    public static final ResourceKey<Biome> MAPLE_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Naturality.MODID, "maple_forest"));
    public static final ResourceKey<Biome> DECIDUOUS_WOODLAND = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Naturality.MODID, "deciduous_woodland"));
    public static final ResourceKey<Biome> AUTUMNAL_DECIDUOUS_WOODLAND = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Naturality.MODID, "autumnal_deciduous_woodland"));
    public static final ResourceKey<Biome> LUSH_DESERT = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Naturality.MODID, "lush_desert"));
    public static final ResourceKey<Biome> BUTTERFLY_VALLEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Naturality.MODID, "butterfly_valley"));
}
