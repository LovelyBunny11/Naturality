package com._LovelyBunny.Naturality.client;

import com._LovelyBunny.Naturality.particle.MothDustParticle;
import com._LovelyBunny.Naturality.particle.NaturalityParticleTypes;
import com._LovelyBunny.Naturality.particle.WindBlowingParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com._LovelyBunny.Naturality.Naturality.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NaturalityClient {
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
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