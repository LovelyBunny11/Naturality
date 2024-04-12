package com._LovelyBunny.Naturality.event;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.entity.Butterfly;
import com._LovelyBunny.Naturality.entity.NaturalityEntityTypes;
import com._LovelyBunny.Naturality.entity.Moth;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Naturality.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NaturalityEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(NaturalityEntityTypes.MOTH.get(), Moth.createAttributes().build());
        event.put(NaturalityEntityTypes.BUTTERFLY.get(), Butterfly.createAttributes().build());
    }
    @SubscribeEvent
    public static void initializeAttributes(EntityAttributeCreationEvent event) {
        SpawnPlacements.register(NaturalityEntityTypes.BUTTERFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Butterfly::checkSpawnRules);
        SpawnPlacements.register(NaturalityEntityTypes.MOTH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Moth::checkSpawnRules);
    }
}
