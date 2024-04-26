package com._LovelyBunny.Naturality.worldgen.tree;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NaturalityTrunkPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Naturality.MODID);

    public static final RegistryObject<TrunkPlacerType<CrossTrunkPlacer>> CROSS_TRUNK_PLACER =
            TRUNK_PLACER.register("cross_trunk_placer", () -> new TrunkPlacerType<>(CrossTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<BirchTrunkPlacer>> BIRCH_TRUNK_PLACER =
            TRUNK_PLACER.register("birch_trunk_placer", () -> new TrunkPlacerType<>(BirchTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<FallenTrunkPlacer>> FALLEN_TRUNK_PLACER =
            TRUNK_PLACER.register("fallen_trunk_placer", () -> new TrunkPlacerType<>(FallenTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
