package com._LovelyBunny.Naturality.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class NaturalityHotOverworldRegion extends Region {
    public NaturalityHotOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
            {
                VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
                // BARRENS
                new ParameterUtils.ParameterPointListBuilder()
                        .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.WARM, ParameterUtils.Temperature.HOT))
                        .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.ARID, ParameterUtils.Humidity.DRY))
                        .continentalness(ParameterUtils.Continentalness.INLAND)
                        .weirdness(ParameterUtils.Weirdness.PEAK_NORMAL)
                        .erosion(ParameterUtils.Erosion.FULL_RANGE)
                        .build().forEach(point -> builder.add(point, NaturalityBiomes.LUSH_DESERT));

                builder.build().forEach(mapper);
            }
}

