package com._LovelyBunny.Naturality.item;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import com._LovelyBunny.Naturality.entity.Butterfly;
import com._LovelyBunny.Naturality.entity.Moth;
import com._LovelyBunny.Naturality.entity.NaturalityBoat;
import com._LovelyBunny.Naturality.entity.NaturalityEntityTypes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class NaturalityItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Naturality.MODID);
    public static final RegistryObject<Item> SANDY_SOIL = ITEMS.register("sandy_soil",
            () -> new BlockItem(NaturalityBlocks.SANDY_SOIL.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log",
            () -> new BlockItem(NaturalityBlocks.MAPLE_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_LOG = ITEMS.register("linden_log",
            () -> new BlockItem(NaturalityBlocks.LINDEN_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_LOG = ITEMS.register("dracaena_log",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_BRANCHES = ITEMS.register("dracaena_branches",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_BRANCHES.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood",
            () -> new BlockItem(NaturalityBlocks.MAPLE_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_WOOD = ITEMS.register("linden_wood",
            () -> new BlockItem(NaturalityBlocks.LINDEN_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_WOOD = ITEMS.register("dracaena_wood",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_MAPLE_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LINDEN_LOG = ITEMS.register("stripped_linden_log",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_LINDEN_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_DRACAENA_LOG = ITEMS.register("stripped_dracaena_log",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_DRACAENA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_MAPLE_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LINDEN_WOOD = ITEMS.register("stripped_linden_wood",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_LINDEN_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_DRACAENA_WOOD = ITEMS.register("stripped_dracaena_wood",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_DRACAENA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_PLANKS = ITEMS.register("maple_planks",
            () -> new BlockItem(NaturalityBlocks.MAPLE_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_PLANKS = ITEMS.register("linden_planks",
            () -> new BlockItem(NaturalityBlocks.LINDEN_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_PLANKS = ITEMS.register("dracaena_planks",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_STAIRS = ITEMS.register("maple_stairs",
            () -> new BlockItem(NaturalityBlocks.MAPLE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_STAIRS = ITEMS.register("linden_stairs",
            () -> new BlockItem(NaturalityBlocks.LINDEN_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_STAIRS = ITEMS.register("dracaena_stairs",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_SLAB = ITEMS.register("maple_slab",
            () -> new BlockItem(NaturalityBlocks.MAPLE_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_SLAB = ITEMS.register("linden_slab",
            () -> new BlockItem(NaturalityBlocks.LINDEN_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_SLAB = ITEMS.register("dracaena_slab",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_FENCE = ITEMS.register("maple_fence",
            () -> new BlockItem(NaturalityBlocks.MAPLE_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_FENCE = ITEMS.register("linden_fence",
            () -> new BlockItem(NaturalityBlocks.LINDEN_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_FENCE = ITEMS.register("dracaena_fence",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_FENCE_GATE = ITEMS.register("maple_fence_gate",
            () -> new BlockItem(NaturalityBlocks.MAPLE_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_FENCE_GATE = ITEMS.register("linden_fence_gate",
            () -> new BlockItem(NaturalityBlocks.LINDEN_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_FENCE_GATE = ITEMS.register("dracaena_fence_gate",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_DOOR = ITEMS.register("maple_door",
            () -> new BlockItem(NaturalityBlocks.MAPLE_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_DOOR = ITEMS.register("linden_door",
            () -> new BlockItem(NaturalityBlocks.LINDEN_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_DOOR = ITEMS.register("dracaena_door",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_TRAPDOOR = ITEMS.register("maple_trapdoor",
            () -> new BlockItem(NaturalityBlocks.MAPLE_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_TRAPDOOR = ITEMS.register("linden_trapdoor",
            () -> new BlockItem(NaturalityBlocks.LINDEN_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_TRAPDOOR = ITEMS.register("dracaena_trapdoor",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = ITEMS.register("maple_pressure_plate",
            () -> new BlockItem(NaturalityBlocks.MAPLE_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_PRESSURE_PLATE = ITEMS.register("linden_pressure_plate",
            () -> new BlockItem(NaturalityBlocks.LINDEN_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_PRESSURE_PLATE = ITEMS.register("dracaena_pressure_plate",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_BUTTON = ITEMS.register("maple_button",
            () -> new BlockItem(NaturalityBlocks.MAPLE_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_BUTTON = ITEMS.register("linden_button",
            () -> new BlockItem(NaturalityBlocks.LINDEN_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_BUTTON = ITEMS.register("dracaena_button",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_LEAVES = ITEMS.register("maple_leaves",
            () -> new BlockItem(NaturalityBlocks.MAPLE_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_LEAVES = ITEMS.register("linden_leaves",
            () -> new BlockItem(NaturalityBlocks.LINDEN_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_LEAVES = ITEMS.register("dracaena_leaves",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_SAPLING = ITEMS.register("maple_sapling",
            () -> new BlockItem(NaturalityBlocks.MAPLE_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> LINDEN_SAPLING = ITEMS.register("linden_sapling",
            () -> new BlockItem(NaturalityBlocks.LINDEN_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRACAENA_SAPLING = ITEMS.register("dracaena_sapling",
            () -> new BlockItem(NaturalityBlocks.DRACAENA_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register("maple_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NaturalityBlocks.MAPLE_SIGN.get(), NaturalityBlocks.MAPLE_WALL_SIGN.get()));
    public static final RegistryObject<Item> LINDEN_SIGN = ITEMS.register("linden_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NaturalityBlocks.LINDEN_SIGN.get(), NaturalityBlocks.LINDEN_WALL_SIGN.get()));
    public static final RegistryObject<Item> DRACAENA_SIGN = ITEMS.register("dracaena_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NaturalityBlocks.DRACAENA_SIGN.get(), NaturalityBlocks.DRACAENA_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAPLE_HANGING_SIGN = ITEMS.register("maple_hanging_sign",
            () -> new HangingSignItem(NaturalityBlocks.MAPLE_HANGING_SIGN.get(), NaturalityBlocks.MAPLE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LINDEN_HANGING_SIGN = ITEMS.register("linden_hanging_sign",
            () -> new HangingSignItem(NaturalityBlocks.LINDEN_HANGING_SIGN.get(), NaturalityBlocks.LINDEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> DRACAENA_HANGING_SIGN = ITEMS.register("dracaena_hanging_sign",
            () -> new HangingSignItem(NaturalityBlocks.DRACAENA_HANGING_SIGN.get(), NaturalityBlocks.DRACAENA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat",
            () -> new NaturalityBoatItem(false, NaturalityBoat.Type.MAPLE,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LINDEN_BOAT = ITEMS.register("linden_boat",
            () -> new NaturalityBoatItem(false, NaturalityBoat.Type.LINDEN,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DRACAENA_BOAT = ITEMS.register("dracaena_boat",
            () -> new NaturalityBoatItem(false, NaturalityBoat.Type.DRACAENA,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAPLE_CHEST_BOAT = ITEMS.register("maple_chest_boat",
            () -> new NaturalityBoatItem(true, NaturalityBoat.Type.MAPLE,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LINDEN_CHEST_BOAT = ITEMS.register("linden_chest_boat",
            () -> new NaturalityBoatItem(true, NaturalityBoat.Type.LINDEN,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DRACAENA_CHEST_BOAT = ITEMS.register("dracaena_chest_boat",
            () -> new NaturalityBoatItem(true, NaturalityBoat.Type.DRACAENA,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BEECH_LOG = ITEMS.register("beech_log",
            () -> new BlockItem(NaturalityBlocks.BEECH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_WOOD = ITEMS.register("beech_wood",
            () -> new BlockItem(NaturalityBlocks.BEECH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_BEECH_LOG = ITEMS.register("stripped_beech_log",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_BEECH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_BEECH_WOOD = ITEMS.register("stripped_beech_wood",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_BEECH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_PLANKS = ITEMS.register("beech_planks",
            () -> new BlockItem(NaturalityBlocks.BEECH_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_STAIRS = ITEMS.register("beech_stairs",
            () -> new BlockItem(NaturalityBlocks.BEECH_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_SLAB = ITEMS.register("beech_slab",
            () -> new BlockItem(NaturalityBlocks.BEECH_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_FENCE = ITEMS.register("beech_fence",
            () -> new BlockItem(NaturalityBlocks.BEECH_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_FENCE_GATE = ITEMS.register("beech_fence_gate",
            () -> new BlockItem(NaturalityBlocks.BEECH_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_DOOR = ITEMS.register("beech_door",
            () -> new BlockItem(NaturalityBlocks.BEECH_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_TRAPDOOR = ITEMS.register("beech_trapdoor",
            () -> new BlockItem(NaturalityBlocks.BEECH_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_PRESSURE_PLATE = ITEMS.register("beech_pressure_plate",
            () -> new BlockItem(NaturalityBlocks.BEECH_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_BUTTON = ITEMS.register("beech_button",
            () -> new BlockItem(NaturalityBlocks.BEECH_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_LEAVES = ITEMS.register("beech_leaves",
            () -> new BlockItem(NaturalityBlocks.BEECH_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_SAPLING = ITEMS.register("beech_sapling",
            () -> new BlockItem(NaturalityBlocks.BEECH_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEECH_SIGN = ITEMS.register("beech_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NaturalityBlocks.BEECH_SIGN.get(), NaturalityBlocks.BEECH_WALL_SIGN.get()));
    public static final RegistryObject<Item> BEECH_HANGING_SIGN = ITEMS.register("beech_hanging_sign",
            () -> new HangingSignItem(NaturalityBlocks.BEECH_HANGING_SIGN.get(), NaturalityBlocks.BEECH_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BEECH_BOAT = ITEMS.register("beech_boat",
            () -> new NaturalityBoatItem(false, NaturalityBoat.Type.BEECH,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BEECH_CHEST_BOAT = ITEMS.register("beech_chest_boat",
            () -> new NaturalityBoatItem(true, NaturalityBoat.Type.BEECH,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LARCH_LOG = ITEMS.register("larch_log",
            () -> new BlockItem(NaturalityBlocks.LARCH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_WOOD = ITEMS.register("larch_wood",
            () -> new BlockItem(NaturalityBlocks.LARCH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LARCH_LOG = ITEMS.register("stripped_larch_log",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_LARCH_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_LARCH_WOOD = ITEMS.register("stripped_larch_wood",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_LARCH_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_PLANKS = ITEMS.register("larch_planks",
            () -> new BlockItem(NaturalityBlocks.LARCH_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_STAIRS = ITEMS.register("larch_stairs",
            () -> new BlockItem(NaturalityBlocks.LARCH_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_SLAB = ITEMS.register("larch_slab",
            () -> new BlockItem(NaturalityBlocks.LARCH_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_FENCE = ITEMS.register("larch_fence",
            () -> new BlockItem(NaturalityBlocks.LARCH_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_FENCE_GATE = ITEMS.register("larch_fence_gate",
            () -> new BlockItem(NaturalityBlocks.LARCH_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_DOOR = ITEMS.register("larch_door",
            () -> new BlockItem(NaturalityBlocks.LARCH_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_TRAPDOOR = ITEMS.register("larch_trapdoor",
            () -> new BlockItem(NaturalityBlocks.LARCH_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_PRESSURE_PLATE = ITEMS.register("larch_pressure_plate",
            () -> new BlockItem(NaturalityBlocks.LARCH_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_BUTTON = ITEMS.register("larch_button",
            () -> new BlockItem(NaturalityBlocks.LARCH_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_LEAVES = ITEMS.register("larch_leaves",
            () -> new BlockItem(NaturalityBlocks.LARCH_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_SAPLING = ITEMS.register("larch_sapling",
            () -> new BlockItem(NaturalityBlocks.LARCH_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> LARCH_SIGN = ITEMS.register("larch_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NaturalityBlocks.LARCH_SIGN.get(), NaturalityBlocks.LARCH_WALL_SIGN.get()));
    public static final RegistryObject<Item> LARCH_HANGING_SIGN = ITEMS.register("larch_hanging_sign",
            () -> new HangingSignItem(NaturalityBlocks.LARCH_HANGING_SIGN.get(), NaturalityBlocks.LARCH_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LARCH_BOAT = ITEMS.register("larch_boat",
            () -> new NaturalityBoatItem(false, NaturalityBoat.Type.LARCH,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LARCH_CHEST_BOAT = ITEMS.register("larch_chest_boat",
            () -> new NaturalityBoatItem(true, NaturalityBoat.Type.LARCH,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JACARANDA_LOG = ITEMS.register("jacaranda_log",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_WOOD = ITEMS.register("jacaranda_wood",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_JACARANDA_LOG = ITEMS.register("stripped_jacaranda_log",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_JACARANDA_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_JACARANDA_WOOD = ITEMS.register("stripped_jacaranda_wood",
            () -> new BlockItem(NaturalityBlocks.STRIPPED_JACARANDA_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_PLANKS = ITEMS.register("jacaranda_planks",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_STAIRS = ITEMS.register("jacaranda_stairs",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_SLAB = ITEMS.register("jacaranda_slab",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_FENCE = ITEMS.register("jacaranda_fence",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_FENCE_GATE = ITEMS.register("jacaranda_fence_gate",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_DOOR = ITEMS.register("jacaranda_door",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_TRAPDOOR = ITEMS.register("jacaranda_trapdoor",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_PRESSURE_PLATE = ITEMS.register("jacaranda_pressure_plate",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_BUTTON = ITEMS.register("jacaranda_button",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_LEAVES = ITEMS.register("jacaranda_leaves",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_SAPLING = ITEMS.register("jacaranda_sapling",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> JACARANDA_SIGN = ITEMS.register("jacaranda_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), NaturalityBlocks.JACARANDA_SIGN.get(), NaturalityBlocks.JACARANDA_WALL_SIGN.get()));
    public static final RegistryObject<Item> JACARANDA_HANGING_SIGN = ITEMS.register("jacaranda_hanging_sign",
            () -> new HangingSignItem(NaturalityBlocks.JACARANDA_HANGING_SIGN.get(), NaturalityBlocks.JACARANDA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> JACARANDA_BOAT = ITEMS.register("jacaranda_boat",
            () -> new NaturalityBoatItem(false, NaturalityBoat.Type.JACARANDA,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> JACARANDA_CHEST_BOAT = ITEMS.register("jacaranda_chest_boat",
            () -> new NaturalityBoatItem(true, NaturalityBoat.Type.JACARANDA,new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CLOVER = ITEMS.register("clover",
            () -> new BlockItem(NaturalityBlocks.CLOVER.get(),new Item.Properties()));
    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> JACARANDA_CARPET = ITEMS.register("jacaranda_carpet",
            () -> new BlockItem(NaturalityBlocks.JACARANDA_CARPET.get(),new Item.Properties()));
    public static final RegistryObject<Item> ALOE = ITEMS.register("aloe",
            () -> new BlockItem(NaturalityBlocks.ALOE.get(),new Item.Properties()));
    public static final RegistryObject<Item> DENSE_GRASS = ITEMS.register("dense_grass",
            () -> new BlockItem(NaturalityBlocks.DENSE_GRASS.get(),new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_FRUIT = ITEMS.register("dragon_fruit",
            () -> new BlockItem(NaturalityBlocks.DRAGON_FRUIT.get(),new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    public static final RegistryObject<Item> WISTERIA = ITEMS.register("wisteria",
            () -> new BlockItem(NaturalityBlocks.WISTERIA.get(),new Item.Properties()));

    public static final RegistryObject<Item> JASMINE_LEAVES = ITEMS.register("jasmine_leaves",
            () -> new BlockItem(NaturalityBlocks.JASMINE_LEAVES.get(),new Item.Properties()));
    public static final RegistryObject<Item> FLOWERING_JASMINE_LEAVES = ITEMS.register("flowering_jasmine_leaves",
            () -> new BlockItem(NaturalityBlocks.FLOWERING_JASMINE_LEAVES.get(),new Item.Properties()));
    public static final RegistryObject<Item> MILKWEED = ITEMS.register("milkweed",
            () -> new BlockItem(NaturalityBlocks.MILKWEED.get(),new Item.Properties()));
    public static final RegistryObject<Item> VIOLET = ITEMS.register("violet",
            () -> new BlockItem(NaturalityBlocks.VIOLET.get(),new Item.Properties()));
//    public static final RegistryObject<Item> PEAT_MOSS = ITEMS.register("peat_moss",
//            () -> new BlockItem(NaturalityBlocks.PEAT_MOSS.get(),new Item.Properties()));
    public static final RegistryObject<Item> BUTTERFLY_SPAWN_EGG = ITEMS.register("butterfly_spawn_egg",
            () -> new ForgeSpawnEggItem(NaturalityEntityTypes.BUTTERFLY, 0xf08a16,0x241300, new Item.Properties()));
    public static final RegistryObject<Item> MOTH_SPAWN_EGG = ITEMS.register("moth_spawn_egg",
            () -> new ForgeSpawnEggItem(NaturalityEntityTypes.MOTH, 0xAAC689, 0x634D57, new Item.Properties()));
    public static final RegistryObject<Item> BUTTERFLY_NET = ITEMS.register("butterfly_net",
            () -> new ButterflyNetItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MONARCH_BUTTERFLY = ITEMS.register("monarch_butterfly",
            () -> new ButterflyItem(Butterfly.Variant.MONARCH, new Item.Properties()));
    public static final RegistryObject<Item> MORPHO_BUTTERFLY = ITEMS.register("morpho_butterfly",
            () -> new ButterflyItem(Butterfly.Variant.MORPHO, new Item.Properties()));
    public static final RegistryObject<Item> RED_ADMIRAL_BUTTERFLY = ITEMS.register("red_admiral_butterfly",
            () -> new ButterflyItem(Butterfly.Variant.RED_ADMIRAL, new Item.Properties()));
    public static final RegistryObject<Item> LUNA_MOTH = ITEMS.register("luna_moth",
            () -> new MothItem(Moth.Variant.LUNA, new Item.Properties()));
    public static final RegistryObject<Item> ROSY_MAPLE_MOTH = ITEMS.register("rosy_maple_moth",
            () -> new MothItem(Moth.Variant.ROSY_MAPLE, new Item.Properties()));
    public static final RegistryObject<Item> DEATH_HEAD_HAWK_MOTH = ITEMS.register("death_head_hawk_moth",
            () -> new MothItem(Moth.Variant.DEATH_HEAD_HAWK, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
