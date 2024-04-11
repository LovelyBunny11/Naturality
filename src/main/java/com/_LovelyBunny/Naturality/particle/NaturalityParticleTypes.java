package com._LovelyBunny.Naturality.particle;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class NaturalityParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Naturality.MODID);
    public static final RegistryObject<SimpleParticleType> JACARANDA_LEAVES = PARTICLES.register("jacaranda_leaves", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> WISTERIA_LEAVES = PARTICLES.register("wisteria_leaves", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MAPLE_SEEDS = PARTICLES.register("maple_seeds", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LUNA_MOTH_DUST = PARTICLES.register("luna_moth_dust", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> ROSY_MAPLE_MOTH_DUST = PARTICLES.register("rosy_maple_moth_dust", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> DEATH_HEAD_MOTH_DUST = PARTICLES.register("death_head_moth_dust", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
