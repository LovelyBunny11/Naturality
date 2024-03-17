package com._LovelyBunny.NET.item;

import com._LovelyBunny.NET.NET;
import com._LovelyBunny.NET.block.NETBlocks;
import com._LovelyBunny.NET.entity.NETBoat;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class NETItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NET.MODID);

    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log",
            () -> new BlockItem(NETBlocks.MAPLE_LOG.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood",
            () -> new BlockItem(NETBlocks.MAPLE_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log",
            () -> new BlockItem(NETBlocks.STRIPPED_MAPLE_LOG.get(), new Item.Properties()));

    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood",
            () -> new BlockItem(NETBlocks.STRIPPED_MAPLE_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_PLANKS = ITEMS.register("maple_planks",
            () -> new BlockItem(NETBlocks.MAPLE_PLANKS.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_STAIRS = ITEMS.register("maple_stairs",
            () -> new BlockItem(NETBlocks.MAPLE_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_SLAB = ITEMS.register("maple_slab",
            () -> new BlockItem(NETBlocks.MAPLE_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_FENCE = ITEMS.register("maple_fence",
            () -> new BlockItem(NETBlocks.MAPLE_FENCE.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_FENCE_GATE = ITEMS.register("maple_fence_gate",
            () -> new BlockItem(NETBlocks.MAPLE_FENCE_GATE.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_DOOR = ITEMS.register("maple_door",
            () -> new BlockItem(NETBlocks.MAPLE_DOOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_TRAPDOOR = ITEMS.register("maple_trapdoor",
            () -> new BlockItem(NETBlocks.MAPLE_TRAPDOOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = ITEMS.register("maple_pressure_plate",
            () -> new BlockItem(NETBlocks.MAPLE_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_BUTTON = ITEMS.register("maple_button",
            () -> new BlockItem(NETBlocks.MAPLE_BUTTON.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_LEAVES = ITEMS.register("maple_leaves",
            () -> new BlockItem(NETBlocks.MAPLE_LEAVES.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_SAPLING = ITEMS.register("maple_sapling",
            () -> new BlockItem(NETBlocks.MAPLE_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NETBlocks.MAPLE_SIGN.get(), NETBlocks.MAPLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(NETBlocks.MAPLE_HANGING_SIGN.get(), NETBlocks.MAPLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new NETBoatItem(false, NETBoat.ModelType.MAPLE,new Item.Properties()));

    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new NETBoatItem(true, NETBoat.ModelType.MAPLE,new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
