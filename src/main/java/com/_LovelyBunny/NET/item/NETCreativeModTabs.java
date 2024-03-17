package com._LovelyBunny.NET.item;

import com._LovelyBunny.NET.NET;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NETCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NET.MODID);

    public static final RegistryObject<CreativeModeTab> NET_TAB = CREATIVE_MODE_TABS.register("net_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NETItems.MAPLE_SAPLING.get()))
                    .title(Component.translatable("creativetab.net_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(NETItems.MAPLE_LOG.get());
                        pOutput.accept(NETItems.MAPLE_WOOD.get());
                        pOutput.accept(NETItems.STRIPPED_MAPLE_LOG.get());
                        pOutput.accept(NETItems.STRIPPED_MAPLE_WOOD.get());
                        pOutput.accept(NETItems.MAPLE_PLANKS.get());
                        pOutput.accept(NETItems.MAPLE_STAIRS.get());
                        pOutput.accept(NETItems.MAPLE_SLAB.get());
                        pOutput.accept(NETItems.MAPLE_FENCE.get());
                        pOutput.accept(NETItems.MAPLE_FENCE_GATE.get());
                        pOutput.accept(NETItems.MAPLE_DOOR.get());
                        pOutput.accept(NETItems.MAPLE_TRAPDOOR.get());
                        pOutput.accept(NETItems.MAPLE_PRESSURE_PLATE.get());
                        pOutput.accept(NETItems.MAPLE_BUTTON.get());
                        pOutput.accept(NETItems.MAPLE_LEAVES.get());
                        pOutput.accept(NETItems.MAPLE_SAPLING.get());
                        pOutput.accept(NETItems.MAPLE_SIGN.get());
                        pOutput.accept(NETItems.MAPLE_HANGING_SIGN.get());
                        pOutput.accept(NETItems.MAPLE_BOAT.get());
                        pOutput.accept(NETItems.MAPLE_CHEST_BOAT.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
