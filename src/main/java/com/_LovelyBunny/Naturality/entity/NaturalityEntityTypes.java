package com._LovelyBunny.Naturality.entity;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturalityEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Naturality.MODID);

    public static final RegistryObject<EntityType<NaturalityBoat>> BOAT =
            ENTITY_TYPES.register("boat", () -> EntityType.Builder.<NaturalityBoat>of(NaturalityBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("boat"));
    public static final RegistryObject<EntityType<NaturalityChestBoat>> CHEST_BOAT =
            ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.<NaturalityChestBoat>of(NaturalityChestBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("chest_boat"));
    public static final RegistryObject<EntityType<Moth>> MOTH =
            ENTITY_TYPES.register("moth", () -> EntityType.Builder.<Moth>of(Moth::new, MobCategory.AMBIENT)
                    .sized(0.7F, 0.6F).build("moth"));

    public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY =
            ENTITY_TYPES.register("butterfly", () -> EntityType.Builder.<Butterfly>of(Butterfly::new, MobCategory.AMBIENT)
                    .sized(0.7F, 0.6F).build("butterfly"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
