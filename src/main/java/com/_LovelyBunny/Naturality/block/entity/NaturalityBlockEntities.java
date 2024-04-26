package com._LovelyBunny.Naturality.block.entity;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NaturalityBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Naturality.MODID);

    public static final RegistryObject<BlockEntityType<NaturalitySignBlockEntity>> SIGN =
            BLOCK_ENTITIES.register("sign", () ->
                    BlockEntityType.Builder.of(NaturalitySignBlockEntity::new,
                            NaturalityBlocks.MAPLE_SIGN.get(), NaturalityBlocks.MAPLE_WALL_SIGN.get(),
                            NaturalityBlocks.LINDEN_SIGN.get(), NaturalityBlocks.LINDEN_WALL_SIGN.get(),
                            NaturalityBlocks.DRACAENA_SIGN.get(), NaturalityBlocks.DRACAENA_WALL_SIGN.get(),
                            NaturalityBlocks.BEECH_SIGN.get(), NaturalityBlocks.BEECH_WALL_SIGN.get(),
                            NaturalityBlocks.LARCH_SIGN.get(), NaturalityBlocks.LARCH_WALL_SIGN.get(),
                            NaturalityBlocks.JACARANDA_SIGN.get(), NaturalityBlocks.JACARANDA_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<NaturalityHangingSignBlockEntity>> HANGING_SIGN =
            BLOCK_ENTITIES.register("hanging_sign", () ->
                    BlockEntityType.Builder.of(NaturalityHangingSignBlockEntity::new,
                            NaturalityBlocks.MAPLE_HANGING_SIGN.get(), NaturalityBlocks.MAPLE_WALL_HANGING_SIGN.get(),
                            NaturalityBlocks.LINDEN_HANGING_SIGN.get(), NaturalityBlocks.LINDEN_WALL_HANGING_SIGN.get(),
                            NaturalityBlocks.DRACAENA_HANGING_SIGN.get(), NaturalityBlocks.DRACAENA_WALL_HANGING_SIGN.get(),
                            NaturalityBlocks.BEECH_HANGING_SIGN.get(), NaturalityBlocks.BEECH_WALL_HANGING_SIGN.get(),
                            NaturalityBlocks.LARCH_HANGING_SIGN.get(), NaturalityBlocks.LARCH_WALL_HANGING_SIGN.get(),
                            NaturalityBlocks.JACARANDA_HANGING_SIGN.get(), NaturalityBlocks.JACARANDA_WALL_HANGING_SIGN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
