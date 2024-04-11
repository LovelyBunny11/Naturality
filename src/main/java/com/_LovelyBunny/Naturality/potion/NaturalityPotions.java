package com._LovelyBunny.Naturality.potion;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturalityPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, Naturality.MODID);

    public static final RegistryObject<Potion> LONG_LUCK = POTIONS.register("long_luck",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 9600)));
    public static final RegistryObject<Potion> STRONG_LUCK = POTIONS.register("strong_luck",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 1800, 1)));
    public static final RegistryObject<Potion> UNLUCK = POTIONS.register("unluck",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000)));
    public static final RegistryObject<Potion> LONG_UNLUCK = POTIONS.register("long_unluck",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 9600)));
    public static final RegistryObject<Potion> STRONG_UNLUCK = POTIONS.register("strong_unluck",
            () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 1800, 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
