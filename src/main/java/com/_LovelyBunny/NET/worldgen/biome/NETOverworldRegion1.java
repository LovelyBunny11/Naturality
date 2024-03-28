package com._LovelyBunny.NET.worldgen.biome;

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

public class NETOverworldRegion1 extends Region {
    public NETOverworldRegion1(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
            {
                VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
                // BARRENS
                new ParameterUtils.ParameterPointListBuilder()
                        .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.HOT, ParameterUtils.Temperature.HOT))
                        .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.DRY))
                        .continentalness(ParameterUtils.Continentalness.MID_INLAND)
                        .weirdness(ParameterUtils.Weirdness.VALLEY)
                        .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_2)
                        .build().forEach(point -> builder.add(point, NETBiomes.BARRENS));
                // WOODED_BARRENS
                new ParameterUtils.ParameterPointListBuilder()
                        .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.HOT, ParameterUtils.Temperature.HOT))
                        .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.DRY))
                        .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                        .weirdness(ParameterUtils.Weirdness.VALLEY)
                        .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_2)
                        .build().forEach(point -> builder.add(point, NETBiomes.WOODED_BARRENS));

                builder.build().forEach(mapper::accept);
            };
}

