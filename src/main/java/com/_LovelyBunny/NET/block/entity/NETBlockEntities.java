package com._LovelyBunny.NET.block.entity;

import com._LovelyBunny.NET.NET;
import com._LovelyBunny.NET.block.NETBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NETBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NET.MODID);

    public static final RegistryObject<BlockEntityType<NETSignBlockEntity>> SIGN =
            BLOCK_ENTITIES.register("sign", () ->
                    BlockEntityType.Builder.of(NETSignBlockEntity::new,
                            NETBlocks.MAPLE_SIGN.get(), NETBlocks.MAPLE_WALL_SIGN.get(), NETBlocks.LINDEN_SIGN.get(), NETBlocks.LINDEN_WALL_SIGN.get(), NETBlocks.DRACAENA_SIGN.get(), NETBlocks.DRACAENA_WALL_SIGN.get(), NETBlocks.BEECH_SIGN.get(), NETBlocks.BEECH_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<NETHangingSignBlockEntity>> HANGING_SIGN =
            BLOCK_ENTITIES.register("hanging_sign", () ->
                    BlockEntityType.Builder.of(NETHangingSignBlockEntity::new,
                            NETBlocks.MAPLE_HANGING_SIGN.get(), NETBlocks.MAPLE_WALL_HANGING_SIGN.get(), NETBlocks.LINDEN_HANGING_SIGN.get(), NETBlocks.LINDEN_WALL_HANGING_SIGN.get(), NETBlocks.DRACAENA_HANGING_SIGN.get(), NETBlocks.DRACAENA_WALL_HANGING_SIGN.get(), NETBlocks.BEECH_HANGING_SIGN.get(), NETBlocks.BEECH_WALL_HANGING_SIGN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
