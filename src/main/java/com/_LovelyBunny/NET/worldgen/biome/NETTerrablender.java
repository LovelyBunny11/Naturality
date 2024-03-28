package com._LovelyBunny.NET.worldgen.biome;

import com._LovelyBunny.NET.NET;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class NETTerrablender {
    public static void registerBiomes() {
        Regions.register(new NETOverworldRegion(new ResourceLocation(NET.MODID, "overworld"), 3));
        Regions.register(new NETOverworldRegion1(new ResourceLocation(NET.MODID, "overworld1"), 2));
    }
}
