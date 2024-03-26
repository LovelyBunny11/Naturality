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
    public static final RegistryObject<Item> SANDY_SOIL = ITEMS.register("sandy_soil",
            () -> new BlockItem(NETBlocks.SANDY_SOIL.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log",
            () -> new BlockItem(NETBlocks.MAPLE_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_LOG = ITEMS.register("linden_log",
            () -> new BlockItem(NETBlocks.LINDEN_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_LOG = ITEMS.register("dracaena_log",
            () -> new BlockItem(NETBlocks.DRACAENA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_BRANCHES = ITEMS.register("dracaena_branches",
            () -> new BlockItem(NETBlocks.DRACAENA_BRANCHES.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood",
            () -> new BlockItem(NETBlocks.MAPLE_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_WOOD = ITEMS.register("linden_wood",
            () -> new BlockItem(NETBlocks.LINDEN_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_WOOD = ITEMS.register("dracaena_wood",
            () -> new BlockItem(NETBlocks.DRACAENA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log",
            () -> new BlockItem(NETBlocks.STRIPPED_MAPLE_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LINDEN_LOG = ITEMS.register("stripped_linden_log",
            () -> new BlockItem(NETBlocks.STRIPPED_LINDEN_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_DRACAENA_LOG = ITEMS.register("stripped_dracaena_log",
            () -> new BlockItem(NETBlocks.STRIPPED_DRACAENA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood",
            () -> new BlockItem(NETBlocks.STRIPPED_MAPLE_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LINDEN_WOOD = ITEMS.register("stripped_linden_wood",
            () -> new BlockItem(NETBlocks.STRIPPED_LINDEN_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_DRACAENA_WOOD = ITEMS.register("stripped_dracaena_wood",
            () -> new BlockItem(NETBlocks.STRIPPED_DRACAENA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_PLANKS = ITEMS.register("maple_planks",
            () -> new BlockItem(NETBlocks.MAPLE_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_PLANKS = ITEMS.register("linden_planks",
            () -> new BlockItem(NETBlocks.LINDEN_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_PLANKS = ITEMS.register("dracaena_planks",
            () -> new BlockItem(NETBlocks.DRACAENA_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_STAIRS = ITEMS.register("maple_stairs",
            () -> new BlockItem(NETBlocks.MAPLE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_STAIRS = ITEMS.register("linden_stairs",
            () -> new BlockItem(NETBlocks.LINDEN_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_STAIRS = ITEMS.register("dracaena_stairs",
            () -> new BlockItem(NETBlocks.DRACAENA_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_SLAB = ITEMS.register("maple_slab",
            () -> new BlockItem(NETBlocks.MAPLE_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_SLAB = ITEMS.register("linden_slab",
            () -> new BlockItem(NETBlocks.LINDEN_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_SLAB = ITEMS.register("dracaena_slab",
            () -> new BlockItem(NETBlocks.DRACAENA_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_FENCE = ITEMS.register("maple_fence",
            () -> new BlockItem(NETBlocks.MAPLE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_FENCE = ITEMS.register("linden_fence",
            () -> new BlockItem(NETBlocks.LINDEN_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_FENCE = ITEMS.register("dracaena_fence",
            () -> new BlockItem(NETBlocks.DRACAENA_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_FENCE_GATE = ITEMS.register("maple_fence_gate",
            () -> new BlockItem(NETBlocks.MAPLE_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_FENCE_GATE = ITEMS.register("linden_fence_gate",
            () -> new BlockItem(NETBlocks.LINDEN_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_FENCE_GATE = ITEMS.register("dracaena_fence_gate",
            () -> new BlockItem(NETBlocks.DRACAENA_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_DOOR = ITEMS.register("maple_door",
            () -> new BlockItem(NETBlocks.MAPLE_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_DOOR = ITEMS.register("linden_door",
            () -> new BlockItem(NETBlocks.LINDEN_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_DOOR = ITEMS.register("dracaena_door",
            () -> new BlockItem(NETBlocks.DRACAENA_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_TRAPDOOR = ITEMS.register("maple_trapdoor",
            () -> new BlockItem(NETBlocks.MAPLE_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_TRAPDOOR = ITEMS.register("linden_trapdoor",
            () -> new BlockItem(NETBlocks.LINDEN_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_TRAPDOOR = ITEMS.register("dracaena_trapdoor",
            () -> new BlockItem(NETBlocks.DRACAENA_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = ITEMS.register("maple_pressure_plate",
            () -> new BlockItem(NETBlocks.MAPLE_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_PRESSURE_PLATE = ITEMS.register("linden_pressure_plate",
            () -> new BlockItem(NETBlocks.LINDEN_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_PRESSURE_PLATE = ITEMS.register("dracaena_pressure_plate",
            () -> new BlockItem(NETBlocks.DRACAENA_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_BUTTON = ITEMS.register("maple_button",
            () -> new BlockItem(NETBlocks.MAPLE_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_BUTTON = ITEMS.register("linden_button",
            () -> new BlockItem(NETBlocks.LINDEN_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_BUTTON = ITEMS.register("dracaena_button",
            () -> new BlockItem(NETBlocks.DRACAENA_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_LEAVES = ITEMS.register("maple_leaves",
            () -> new BlockItem(NETBlocks.MAPLE_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_LEAVES = ITEMS.register("linden_leaves",
            () -> new BlockItem(NETBlocks.LINDEN_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_LEAVES = ITEMS.register("dracaena_leaves",
            () -> new BlockItem(NETBlocks.DRACAENA_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_SAPLING = ITEMS.register("maple_sapling",
            () -> new BlockItem(NETBlocks.MAPLE_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_SAPLING = ITEMS.register("linden_sapling",
            () -> new BlockItem(NETBlocks.LINDEN_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_SAPLING = ITEMS.register("dracaena_sapling",
            () -> new BlockItem(NETBlocks.DRACAENA_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NETBlocks.MAPLE_SIGN.get(), NETBlocks.MAPLE_WALL_SIGN.get()));
    public static final RegistryObject<Item> LINDEN_SIGN = ITEMS.register("linden_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NETBlocks.LINDEN_SIGN.get(), NETBlocks.LINDEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> DRACAENA_SIGN = ITEMS.register("dracaena_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NETBlocks.DRACAENA_SIGN.get(), NETBlocks.DRACAENA_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(NETBlocks.MAPLE_HANGING_SIGN.get(), NETBlocks.MAPLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LINDEN_HANGING_SIGN = ITEMS.register("linden_hanging_sign",
            () -> new HangingSignItem(NETBlocks.LINDEN_HANGING_SIGN.get(), NETBlocks.LINDEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> DRACAENA_HANGING_SIGN = ITEMS.register("dracaena_hanging_sign",
            () -> new HangingSignItem(NETBlocks.DRACAENA_HANGING_SIGN.get(), NETBlocks.DRACAENA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new NETBoatItem(false, NETBoat.Type.MAPLE,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LINDEN_BOAT = ITEMS.register("linden_boat",
            () -> new NETBoatItem(false, NETBoat.Type.LINDEN,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DRACAENA_BOAT = ITEMS.register("dracaena_boat",
            () -> new NETBoatItem(false, NETBoat.Type.DRACAENA,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new NETBoatItem(true, NETBoat.Type.MAPLE,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LINDEN_CHEST_BOAT = ITEMS.register("linden_chest_boat",
            () -> new NETBoatItem(true, NETBoat.Type.LINDEN,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DRACAENA_CHEST_BOAT = ITEMS.register("dracaena_chest_boat",
            () -> new NETBoatItem(true, NETBoat.Type.DRACAENA,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BEECH_LOG = ITEMS.register("beech_log",
            () -> new BlockItem(NETBlocks.BEECH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_WOOD = ITEMS.register("beech_wood",
            () -> new BlockItem(NETBlocks.BEECH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_BEECH_LOG = ITEMS.register("stripped_beech_log",
            () -> new BlockItem(NETBlocks.STRIPPED_BEECH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_BEECH_WOOD = ITEMS.register("stripped_beech_wood",
            () -> new BlockItem(NETBlocks.STRIPPED_BEECH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_PLANKS = ITEMS.register("beech_planks",
            () -> new BlockItem(NETBlocks.BEECH_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_STAIRS = ITEMS.register("beech_stairs",
            () -> new BlockItem(NETBlocks.BEECH_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_SLAB = ITEMS.register("beech_slab",
            () -> new BlockItem(NETBlocks.BEECH_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_FENCE = ITEMS.register("beech_fence",
            () -> new BlockItem(NETBlocks.BEECH_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_FENCE_GATE = ITEMS.register("beech_fence_gate",
            () -> new BlockItem(NETBlocks.BEECH_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_DOOR = ITEMS.register("beech_door",
            () -> new BlockItem(NETBlocks.BEECH_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_TRAPDOOR = ITEMS.register("beech_trapdoor",
            () -> new BlockItem(NETBlocks.BEECH_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_PRESSURE_PLATE = ITEMS.register("beech_pressure_plate",
            () -> new BlockItem(NETBlocks.BEECH_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_BUTTON = ITEMS.register("beech_button",
            () -> new BlockItem(NETBlocks.BEECH_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_LEAVES = ITEMS.register("beech_leaves",
            () -> new BlockItem(NETBlocks.BEECH_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_SAPLING = ITEMS.register("beech_sapling",
            () -> new BlockItem(NETBlocks.BEECH_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_SIGN = ITEMS.register("beech_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NETBlocks.BEECH_SIGN.get(), NETBlocks.BEECH_WALL_SIGN.get()));
    public static final RegistryObject<Item> BEECH_HANGING_SIGN = ITEMS.register("beech_hanging_sign",
            () -> new HangingSignItem(NETBlocks.BEECH_HANGING_SIGN.get(), NETBlocks.BEECH_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BEECH_BOAT = ITEMS.register("beech_boat",
            () -> new NETBoatItem(false, NETBoat.Type.BEECH,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BEECH_CHEST_BOAT = ITEMS.register("beech_chest_boat",
            () -> new NETBoatItem(true, NETBoat.Type.BEECH,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LARCH_LOG = ITEMS.register("larch_log",
            () -> new BlockItem(NETBlocks.LARCH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_WOOD = ITEMS.register("larch_wood",
            () -> new BlockItem(NETBlocks.LARCH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LARCH_LOG = ITEMS.register("stripped_larch_log",
            () -> new BlockItem(NETBlocks.STRIPPED_LARCH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LARCH_WOOD = ITEMS.register("stripped_larch_wood",
            () -> new BlockItem(NETBlocks.STRIPPED_LARCH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_PLANKS = ITEMS.register("larch_planks",
            () -> new BlockItem(NETBlocks.LARCH_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_STAIRS = ITEMS.register("larch_stairs",
            () -> new BlockItem(NETBlocks.LARCH_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_SLAB = ITEMS.register("larch_slab",
            () -> new BlockItem(NETBlocks.LARCH_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_FENCE = ITEMS.register("larch_fence",
            () -> new BlockItem(NETBlocks.LARCH_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_FENCE_GATE = ITEMS.register("larch_fence_gate",
            () -> new BlockItem(NETBlocks.LARCH_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_DOOR = ITEMS.register("larch_door",
            () -> new BlockItem(NETBlocks.LARCH_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_TRAPDOOR = ITEMS.register("larch_trapdoor",
            () -> new BlockItem(NETBlocks.LARCH_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_PRESSURE_PLATE = ITEMS.register("larch_pressure_plate",
            () -> new BlockItem(NETBlocks.LARCH_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_BUTTON = ITEMS.register("larch_button",
            () -> new BlockItem(NETBlocks.LARCH_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_LEAVES = ITEMS.register("larch_leaves",
            () -> new BlockItem(NETBlocks.LARCH_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_SAPLING = ITEMS.register("larch_sapling",
            () -> new BlockItem(NETBlocks.LARCH_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_SIGN = ITEMS.register("larch_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NETBlocks.LARCH_SIGN.get(), NETBlocks.LARCH_WALL_SIGN.get()));
    public static final RegistryObject<Item> LARCH_HANGING_SIGN = ITEMS.register("larch_hanging_sign",
            () -> new HangingSignItem(NETBlocks.LARCH_HANGING_SIGN.get(), NETBlocks.LARCH_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LARCH_BOAT = ITEMS.register("larch_boat",
            () -> new NETBoatItem(false, NETBoat.Type.LARCH,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LARCH_CHEST_BOAT = ITEMS.register("larch_chest_boat",
            () -> new NETBoatItem(true, NETBoat.Type.LARCH,new Item.Properties().stacksTo(1)));
public static final RegistryObject<Item> CLOVER = ITEMS.register("clover",
        () -> new BlockItem(NETBlocks.CLOVER.get(),new Item.Properties()));
    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
