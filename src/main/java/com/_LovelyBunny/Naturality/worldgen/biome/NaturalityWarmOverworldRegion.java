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

public class NaturalityWarmOverworldRegion extends Region {
    public NaturalityWarmOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
            {
                VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
                // BLOOMING CLIFFS
                new ParameterUtils.ParameterPointListBuilder()
                        .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.WARM, ParameterUtils.Temperature.WARM))
                        .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.NEUTRAL))
                        .continentalness(ParameterUtils.Continentalness.NEAR_INLAND)
                        .weirdness(ParameterUtils.Weirdness.PEAK_NORMAL)
                        .erosion(ParameterUtils.Erosion.FULL_RANGE)
                        .build().forEach(point -> builder.add(point, NaturalityBiomes.BUTTERFLY_VALLEY));

                builder.build().forEach(mapper);
            }
}

