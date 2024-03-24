package com._LovelyBunny.NET.entity;

import com._LovelyBunny.NET.NET;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NETEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NET.MODID);


    public static final RegistryObject<EntityType<NETBoat>> BOAT =
            ENTITY_TYPES.register("boat", () -> EntityType.Builder.<NETBoat>of(NETBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("boat"));
    public static final RegistryObject<EntityType<NETChestBoat>> CHEST_BOAT =
            ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.<NETChestBoat>of(NETChestBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("chest_boat"));
    public static final RegistryObject<EntityType<RosyMapleMoth>> ROSY_MAPLE_MOTH =
            ENTITY_TYPES.register("rosy_maple_moth", () -> EntityType.Builder.<RosyMapleMoth>of(RosyMapleMoth::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("rosy_maple_moth"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
