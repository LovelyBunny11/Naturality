package com._LovelyBunny.NET.worldgen.tree;

import com._LovelyBunny.NET.NET;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NETTrunkPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, NET.MODID);

    public static final RegistryObject<TrunkPlacerType<DracaenaTrunkPlacer>> DRACAENA_TRUNK_PLACER =
            TRUNK_PLACER.register("dracaena_trunk_placer", () -> new TrunkPlacerType<>(DracaenaTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
