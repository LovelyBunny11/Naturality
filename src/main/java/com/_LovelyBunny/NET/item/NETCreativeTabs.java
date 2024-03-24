package com._LovelyBunny.NET.item;

import com._LovelyBunny.NET.NET;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NETCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NET.MODID);

    public static final RegistryObject<CreativeModeTab> NET_TAB = CREATIVE_MODE_TABS.register("net_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NETItems.MAPLE_SAPLING.get()))
                    .title(Component.translatable("creativetab.net_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(NETItems.SANDY_SOIL.get());
                        pOutput.accept(NETItems.MAPLE_LOG.get());
                        pOutput.accept(NETItems.LINDEN_LOG.get());
                        pOutput.accept(NETItems.DRACAENA_LOG.get());
                        pOutput.accept(NETItems.BEECH_LOG.get());
                        pOutput.accept(NETItems.MAPLE_WOOD.get());
                        pOutput.accept(NETItems.LINDEN_WOOD.get());
                        pOutput.accept(NETItems.DRACAENA_WOOD.get());
                        pOutput.accept(NETItems.BEECH_WOOD.get());
                        pOutput.accept(NETItems.STRIPPED_MAPLE_LOG.get());
                        pOutput.accept(NETItems.STRIPPED_LINDEN_LOG.get());
                        pOutput.accept(NETItems.STRIPPED_DRACAENA_LOG.get());
                        pOutput.accept(NETItems.STRIPPED_BEECH_LOG.get());
                        pOutput.accept(NETItems.STRIPPED_MAPLE_WOOD.get());
                        pOutput.accept(NETItems.STRIPPED_LINDEN_WOOD.get());
                        pOutput.accept(NETItems.STRIPPED_DRACAENA_WOOD.get());
                        pOutput.accept(NETItems.STRIPPED_BEECH_WOOD.get());
                        pOutput.accept(NETItems.MAPLE_PLANKS.get());
                        pOutput.accept(NETItems.LINDEN_PLANKS.get());
                        pOutput.accept(NETItems.DRACAENA_PLANKS.get());
                        pOutput.accept(NETItems.BEECH_PLANKS.get());
                        pOutput.accept(NETItems.MAPLE_STAIRS.get());
                        pOutput.accept(NETItems.LINDEN_STAIRS.get());
                        pOutput.accept(NETItems.DRACAENA_STAIRS.get());
                        pOutput.accept(NETItems.BEECH_STAIRS.get());
                        pOutput.accept(NETItems.MAPLE_SLAB.get());
                        pOutput.accept(NETItems.LINDEN_SLAB.get());
                        pOutput.accept(NETItems.DRACAENA_SLAB.get());
                        pOutput.accept(NETItems.BEECH_SLAB.get());
                        pOutput.accept(NETItems.MAPLE_FENCE.get());
                        pOutput.accept(NETItems.LINDEN_FENCE.get());
                        pOutput.accept(NETItems.BEECH_FENCE.get());
                        pOutput.accept(NETItems.MAPLE_FENCE_GATE.get());
                        pOutput.accept(NETItems.LINDEN_FENCE_GATE.get());
                        pOutput.accept(NETItems.DRACAENA_FENCE_GATE.get());
                        pOutput.accept(NETItems.BEECH_FENCE_GATE.get());
                        pOutput.accept(NETItems.MAPLE_DOOR.get());
                        pOutput.accept(NETItems.LINDEN_DOOR.get());
                        pOutput.accept(NETItems.DRACAENA_DOOR.get());
                        pOutput.accept(NETItems.BEECH_DOOR.get());
                        pOutput.accept(NETItems.MAPLE_TRAPDOOR.get());
                        pOutput.accept(NETItems.LINDEN_TRAPDOOR.get());
                        pOutput.accept(NETItems.DRACAENA_TRAPDOOR.get());
                        pOutput.accept(NETItems.BEECH_TRAPDOOR.get());
                        pOutput.accept(NETItems.MAPLE_PRESSURE_PLATE.get());
                        pOutput.accept(NETItems.LINDEN_PRESSURE_PLATE.get());
                        pOutput.accept(NETItems.DRACAENA_PRESSURE_PLATE.get());
                        pOutput.accept(NETItems.BEECH_PRESSURE_PLATE.get());
                        pOutput.accept(NETItems.MAPLE_BUTTON.get());
                        pOutput.accept(NETItems.LINDEN_BUTTON.get());
                        pOutput.accept(NETItems.DRACAENA_BUTTON.get());
                        pOutput.accept(NETItems.BEECH_BUTTON.get());
                        pOutput.accept(NETItems.MAPLE_LEAVES.get());
                        pOutput.accept(NETItems.LINDEN_LEAVES.get());
                        pOutput.accept(NETItems.DRACAENA_LEAVES.get());
                        pOutput.accept(NETItems.BEECH_LEAVES.get());
                        pOutput.accept(NETItems.MAPLE_SAPLING.get());
                        pOutput.accept(NETItems.LINDEN_SAPLING.get());
                        pOutput.accept(NETItems.DRACAENA_SAPLING.get());
                        pOutput.accept(NETItems.BEECH_SAPLING.get());
                        pOutput.accept(NETItems.CLOVER.get());
                        pOutput.accept(NETItems.FOUR_LEAF_CLOVER.get());
                        pOutput.accept(NETItems.MAPLE_SIGN.get());
                        pOutput.accept(NETItems.LINDEN_SIGN.get());
                        pOutput.accept(NETItems.DRACAENA_SIGN.get());
                        pOutput.accept(NETItems.BEECH_SIGN.get());
                        pOutput.accept(NETItems.MAPLE_HANGING_SIGN.get());
                        pOutput.accept(NETItems.LINDEN_HANGING_SIGN.get());
                        pOutput.accept(NETItems.DRACAENA_HANGING_SIGN.get());
                        pOutput.accept(NETItems.BEECH_HANGING_SIGN.get());
                        pOutput.accept(NETItems.MAPLE_BOAT.get());
                        pOutput.accept(NETItems.LINDEN_BOAT.get());
                        pOutput.accept(NETItems.DRACAENA_BOAT.get());
                        pOutput.accept(NETItems.BEECH_BOAT.get());
                        pOutput.accept(NETItems.MAPLE_CHEST_BOAT.get());
                        pOutput.accept(NETItems.LINDEN_CHEST_BOAT.get());
                        pOutput.accept(NETItems.DRACAENA_CHEST_BOAT.get());
                        pOutput.accept(NETItems.BEECH_CHEST_BOAT.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
