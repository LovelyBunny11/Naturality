package com._LovelyBunny.NET.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class NETOverworldRegion extends Region {
    public NETOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, NETBiomes.MAPLE_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FLOWER_FOREST, NETBiomes.DECIDUOUS_WOODLAND);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, NETBiomes.AUTUMNAL_DECIDUOUS_WOODLAND);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SPARSE_JUNGLE, NETBiomes.LUSH_DESERT);
        });
    }
}
