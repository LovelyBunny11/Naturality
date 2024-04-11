package com._LovelyBunny.Naturality.worldgen;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FossilFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

import static net.minecraft.util.random.SimpleWeightedRandomList.*;

public class NaturalityConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAT_MOSS_VEGETATION = FeatureUtils.createKey("peat_moss_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAT_MOSS_PATCH = FeatureUtils.createKey("peat_moss_patch_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE = registerKey("maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LINDEN = registerKey("linden");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRACAENA = registerKey("dracaena");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEECH = registerKey("beech");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH = registerKey("larch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA = registerKey("jacaranda");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DENSE_GRASS = registerKey("patch_dense_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALOE = registerKey("aloe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRAGON_FRUIT = registerKey("dragon_fruit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WISTERIA = registerKey("wisteria");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_BUSH = registerKey("deciduous_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_MAPLE = registerKey("flower_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MAPLE_FOREST = registerKey("trees_maple_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_DECIDUOUS = registerKey("trees_deciduous");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CLIFFS = registerKey("trees_cliffs");
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Naturality.MODID, name));
    }
}