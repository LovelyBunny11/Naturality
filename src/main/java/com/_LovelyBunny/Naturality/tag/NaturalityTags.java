package com._LovelyBunny.Naturality.tag;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class NaturalityTags {

    public static final TagKey<Block> BUTTERFLIES_AND_MOTHS_SPAWNABLE_ON = blockTag("butterflies_and_moths_spawnable_on");
    public static final TagKey<Biome> SPAWNS_MORPHO_BUTTERFLIES = biomeTag("spawns_morpho_butterflies");
    public static final TagKey<Biome> SPAWNS_MONARCH_BUTTERFLIES = biomeTag("spawns_monarch_butterflies");
    public static final TagKey<Biome> SPAWNS_ADMIRAL_BUTTERFLIES = biomeTag("spawns_admiral_butterflies");
    public static final TagKey<Biome> SPAWNS_MONARCH_AND_MORPHO_BUTTERFLIES = biomeTag("spawns_monarch_and_morpho_butterflies");
    public static final TagKey<Biome> SPAWNS_ROSY_MAPLE_MOTHS = biomeTag("spawns_rosy_maple_moth");
    public static final TagKey<Biome> SPAWNS_LUNA_MOTHS = biomeTag("spawns_luna_moth");
    public static final TagKey<Biome> SPAWNS_DEATH_HEAD_HAWK_MOTHS = biomeTag("spawns_death_head_hawk_moth");
    private static TagKey<Biome> biomeTag(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(Naturality.MODID, name));
    }
    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Naturality.MODID, name));
    }
}
