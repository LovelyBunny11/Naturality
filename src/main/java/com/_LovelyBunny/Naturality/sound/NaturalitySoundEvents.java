package com._LovelyBunny.Naturality.sound;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturalitySoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Naturality.MODID);

    public static final RegistryObject<SoundEvent> MOTH_AMBIENT = registerSoundEvents("moth_ambient");
    public static final RegistryObject<SoundEvent> MOTH_HURT = registerSoundEvents("moth_hurt");
    public static final RegistryObject<SoundEvent> MOTH_DEATH = registerSoundEvents("moth_death");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Naturality.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}