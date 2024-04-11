package com._LovelyBunny.Naturality.event;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.entity.Butterfly;
import com._LovelyBunny.Naturality.entity.NaturalityEntityTypes;
import com._LovelyBunny.Naturality.entity.Moth;
import com._LovelyBunny.Naturality.particle.MothDustParticle;
import com._LovelyBunny.Naturality.particle.WindBlowingParticle;
import com._LovelyBunny.Naturality.particle.NaturalityParticleTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
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
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(NaturalityParticleTypes.JACARANDA_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new WindBlowingParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });
        event.registerSpriteSet(NaturalityParticleTypes.WISTERIA_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new WindBlowingParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });
        event.registerSpriteSet(NaturalityParticleTypes.MAPLE_SEEDS.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new WindBlowingParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });
        event.registerSpriteSet(NaturalityParticleTypes.LUNA_MOTH_DUST.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_172332_, p_277222_, p_277223_, p_277224_) -> {
                return new MothDustParticle(p_277218_, p_277219_, p_277220_, p_172332_, p_277215_);
            };
        });
        event.registerSpriteSet(NaturalityParticleTypes.ROSY_MAPLE_MOTH_DUST.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_172332_, p_277222_, p_277223_, p_277224_) -> {
                return new MothDustParticle(p_277218_, p_277219_, p_277220_, p_172332_, p_277215_);
            };
        });
        event.registerSpriteSet(NaturalityParticleTypes.DEATH_HEAD_MOTH_DUST.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_172332_, p_277222_, p_277223_, p_277224_) -> {
                return new MothDustParticle(p_277218_, p_277219_, p_277220_, p_172332_, p_277215_);
            };
        });
    }
}
