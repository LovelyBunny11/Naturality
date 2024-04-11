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

public class NaturalityColdOverworldRegion extends Region {
    public NaturalityColdOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
            {
                VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
                // AUTUMNAL DECIDUOUS WOODLAND
                new ParameterUtils.ParameterPointListBuilder()
                        .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.COOL))
                        .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.HUMID, ParameterUtils.Humidity.HUMID))
                        .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                        .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_2)
                        .weirdness(ParameterUtils.Weirdness.VALLEY)
                        .build().forEach(point -> builder.add(point, NaturalityBiomes.AUTUMNAL_DECIDUOUS_WOODLAND));

                builder.build().forEach(mapper);
            }
}

