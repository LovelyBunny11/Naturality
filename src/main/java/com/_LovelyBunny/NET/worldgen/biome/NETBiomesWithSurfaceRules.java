package com._LovelyBunny.NET.worldgen.biome;

import com._LovelyBunny.NET.NET;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class NETBiomesWithSurfaceRules {
    public static final ResourceKey<Biome> LUSH_DESERT = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(NET.MODID, "lush_desert"));
}
