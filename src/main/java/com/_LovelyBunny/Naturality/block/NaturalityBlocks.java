package com._LovelyBunny.Naturality.block;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.block.entity.NaturalityWoodTypes;
import com._LovelyBunny.Naturality.worldgen.tree.*;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NaturalityBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Naturality.MODID);

    public static final RegistryObject<Block> SANDY_SOIL = registerBlock("sandy_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT).sound(SoundType.ROOTED_DIRT)));
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LINDEN_LOG = registerBlock("linden_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DRACAENA_LOG = registerBlock("dracaena_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LOG).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LINDEN_WOOD = registerBlock("linden_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DRACAENA_WOOD = registerBlock("dracaena_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_WOOD).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LINDEN_LOG = registerBlock("stripped_linden_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_DRACAENA_LOG = registerBlock("stripped_dracaena_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LOG).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LINDEN_WOOD = registerBlock("stripped_linden_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_DRACAENA_WOOD = registerBlock("stripped_dracaena_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_WOOD).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_PLANKS = registerBlock("linden_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_PLANKS = registerBlock("dracaena_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).sound(SoundType.CHERRY_WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new StairBlock(() -> NaturalityBlocks.MAPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_STAIRS = registerBlock("linden_stairs",
            () -> new StairBlock(() -> NaturalityBlocks.LINDEN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_STAIRS = registerBlock("dracaena_stairs",
            () -> new StairBlock(() -> NaturalityBlocks.DRACAENA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CHERRY_STAIRS).sound(SoundType.CHERRY_WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_SLAB = registerBlock("linden_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_SLAB = registerBlock("dracaena_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_SLAB).sound(SoundType.CHERRY_WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_FENCE = registerBlock("linden_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_FENCE = registerBlock("dracaena_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_FENCE).sound(SoundType.CHERRY_WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_FENCE_GATE = registerBlock("linden_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_FENCE_GATE = registerBlock("dracaena_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_FENCE_GATE).sound(SoundType.CHERRY_WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_DOOR = registerBlock("linden_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_DOOR = registerBlock("dracaena_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_DOOR).sound(SoundType.CHERRY_WOOD).noOcclusion(), BlockSetType.CHERRY){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.BIRCH){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_TRAPDOOR = registerBlock("linden_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_TRAPDOOR = registerBlock("dracaena_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR).sound(SoundType.CHERRY_WOOD).noOcclusion(), BlockSetType.CHERRY){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD),
                    BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_PRESSURE_PLATE = registerBlock("linden_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD),
                    BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_PRESSURE_PLATE = registerBlock("dracaena_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.CHERRY_PRESSURE_PLATE).sound(SoundType.CHERRY_WOOD),
                    BlockSetType.CHERRY){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> LINDEN_BUTTON = registerBlock("linden_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> DRACAENA_BUTTON = registerBlock("dracaena_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_BUTTON).sound(SoundType.CHERRY_WOOD),
                    BlockSetType.CHERRY, 10, true));
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LINDEN_LEAVES = registerBlock("linden_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DRACAENA_LEAVES = registerBlock("dracaena_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LEAVES).sound(SoundType.CHERRY_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LINDEN_SAPLING = registerBlock("linden_sapling",
            () -> new SaplingBlock(new LindenTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DRACAENA_SAPLING = registerBlock("dracaena_sapling",
            () -> new SaplingBlock(new DracaenaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.CHERRY_SAPLING).sound(SoundType.CHERRY_SAPLING)));
    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign",
            () -> new NaturalityStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NaturalityWoodTypes.MAPLE));
    public static final RegistryObject<Block> LINDEN_SIGN = BLOCKS.register("linden_sign",
            () -> new NaturalityStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NaturalityWoodTypes.LINDEN));
    public static final RegistryObject<Block> DRACAENA_SIGN = BLOCKS.register("dracaena_sign",
            () -> new NaturalityStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_SIGN), NaturalityWoodTypes.DRACAENA));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign",
            () -> new NaturalityWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NaturalityWoodTypes.MAPLE));
    public static final RegistryObject<Block> LINDEN_WALL_SIGN = BLOCKS.register("linden_wall_sign",
            () -> new NaturalityWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NaturalityWoodTypes.LINDEN));
    public static final RegistryObject<Block> DRACAENA_WALL_SIGN = BLOCKS.register("dracaena_wall_sign",
            () -> new NaturalityWallSignBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_WALL_SIGN), NaturalityWoodTypes.DRACAENA));
    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = BLOCKS.register("maple_hanging_sign",
            () -> new NaturalityHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NaturalityWoodTypes.MAPLE));
    public static final RegistryObject<Block> LINDEN_HANGING_SIGN = BLOCKS.register("linden_hanging_sign",
            () -> new NaturalityHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NaturalityWoodTypes.LINDEN));
    public static final RegistryObject<Block> DRACAENA_HANGING_SIGN = BLOCKS.register("dracaena_hanging_sign",
            () -> new NaturalityHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_HANGING_SIGN).sound(SoundType.CHERRY_WOOD_HANGING_SIGN), NaturalityWoodTypes.DRACAENA));
    public static final RegistryObject<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("maple_wall_hanging_sign",
            () -> new NaturalityWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NaturalityWoodTypes.MAPLE));
    public static final RegistryObject<Block> LINDEN_WALL_HANGING_SIGN = BLOCKS.register("linden_wall_hanging_sign",
            () -> new NaturalityWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NaturalityWoodTypes.LINDEN));
    public static final RegistryObject<Block> DRACAENA_WALL_HANGING_SIGN = BLOCKS.register("dracaena_wall_hanging_sign",
            () -> new NaturalityWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_WALL_HANGING_SIGN), NaturalityWoodTypes.DRACAENA));
    public static final RegistryObject<Block> BEECH_LOG = registerBlock("beech_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BEECH_WOOD = registerBlock("beech_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_BEECH_LOG = registerBlock("stripped_beech_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_BEECH_WOOD = registerBlock("stripped_beech_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BEECH_PLANKS = registerBlock("beech_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_STAIRS = registerBlock("beech_stairs",
            () -> new StairBlock(() -> NaturalityBlocks.BEECH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_SLAB = registerBlock("beech_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_FENCE = registerBlock("beech_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_FENCE_GATE = registerBlock("beech_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_DOOR = registerBlock("beech_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_TRAPDOOR = registerBlock("beech_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.BIRCH){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_PRESSURE_PLATE = registerBlock("beech_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_BUTTON = registerBlock("beech_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> BEECH_LEAVES = registerBlock("beech_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> BEECH_SAPLING = registerBlock("beech_sapling",
            () -> new SaplingBlock(new BeechTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BEECH_SIGN = BLOCKS.register("beech_sign",
            () -> new NaturalityStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NaturalityWoodTypes.BEECH));
    public static final RegistryObject<Block> BEECH_WALL_SIGN = BLOCKS.register("beech_wall_sign",
            () -> new NaturalityWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NaturalityWoodTypes.BEECH));
    public static final RegistryObject<Block> BEECH_HANGING_SIGN = BLOCKS.register("beech_hanging_sign",
            () -> new NaturalityHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NaturalityWoodTypes.BEECH));
    public static final RegistryObject<Block> BEECH_WALL_HANGING_SIGN = BLOCKS.register("beech_wall_hanging_sign",
            () -> new NaturalityWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NaturalityWoodTypes.BEECH));

    public static final RegistryObject<Block> LARCH_LOG = registerBlock("larch_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LARCH_WOOD = registerBlock("larch_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LARCH_LOG = registerBlock("stripped_larch_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LARCH_WOOD = registerBlock("stripped_larch_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LARCH_PLANKS = registerBlock("larch_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_STAIRS = registerBlock("larch_stairs",
            () -> new StairBlock(() -> NaturalityBlocks.LARCH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_SLAB = registerBlock("larch_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_FENCE = registerBlock("larch_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_FENCE_GATE = registerBlock("larch_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_DOOR = registerBlock("larch_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_TRAPDOOR = registerBlock("larch_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.BIRCH){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_PRESSURE_PLATE = registerBlock("larch_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_BUTTON = registerBlock("larch_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> LARCH_LEAVES = registerBlock("larch_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> LARCH_SAPLING = registerBlock("larch_sapling",
            () -> new SaplingBlock(new LarchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LARCH_SIGN = BLOCKS.register("larch_sign",
            () -> new NaturalityStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NaturalityWoodTypes.LARCH));
    public static final RegistryObject<Block> LARCH_WALL_SIGN = BLOCKS.register("larch_wall_sign",
            () -> new NaturalityWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NaturalityWoodTypes.LARCH));
    public static final RegistryObject<Block> LARCH_HANGING_SIGN = BLOCKS.register("larch_hanging_sign",
            () -> new NaturalityHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NaturalityWoodTypes.LARCH));
    public static final RegistryObject<Block> LARCH_WALL_HANGING_SIGN = BLOCKS.register("larch_wall_hanging_sign",
            () -> new NaturalityWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NaturalityWoodTypes.LARCH));
    public static final RegistryObject<Block> JACARANDA_LOG = registerBlock("jacaranda_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JACARANDA_WOOD = registerBlock("jacaranda_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_JACARANDA_LOG = registerBlock("stripped_jacaranda_log",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_JACARANDA_WOOD = registerBlock("stripped_jacaranda_wood",
            () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JACARANDA_PLANKS = registerBlock("jacaranda_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_STAIRS = registerBlock("jacaranda_stairs",
            () -> new StairBlock(() -> NaturalityBlocks.JACARANDA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_SLAB = registerBlock("jacaranda_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_FENCE = registerBlock("jacaranda_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_FENCE_GATE = registerBlock("jacaranda_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_DOOR = registerBlock("jacaranda_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_TRAPDOOR = registerBlock("jacaranda_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.BIRCH){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_PRESSURE_PLATE = registerBlock("jacaranda_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_BUTTON = registerBlock("jacaranda_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> JACARANDA_LEAVES = registerBlock("jacaranda_leaves",
            () -> new JacarandaLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> JACARANDA_SAPLING = registerBlock("jacaranda_sapling",
            () -> new SaplingBlock(new JacarandaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> JACARANDA_SIGN = BLOCKS.register("jacaranda_sign",
            () -> new NaturalityStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), NaturalityWoodTypes.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_WALL_SIGN = BLOCKS.register("jacaranda_wall_sign",
            () -> new NaturalityWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), NaturalityWoodTypes.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_HANGING_SIGN = BLOCKS.register("jacaranda_hanging_sign",
            () -> new NaturalityHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), NaturalityWoodTypes.JACARANDA));
    public static final RegistryObject<Block> JACARANDA_WALL_HANGING_SIGN = BLOCKS.register("jacaranda_wall_hanging_sign",
            () -> new NaturalityWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), NaturalityWoodTypes.JACARANDA));
    public static final RegistryObject<Block> CLOVER = BLOCKS.register("clover",
        () -> new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)));
    public static final RegistryObject<Block> RARE_CLOVER = BLOCKS.register("rare_clover",
            () -> new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)));
    public static final RegistryObject<Block> JACARANDA_CARPET = BLOCKS.register("jacaranda_carpet",
            () -> new JacarandaCarpetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)));
    public static final RegistryObject<Block> ALOE = BLOCKS.register("aloe",
            () -> new AloeBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)));
    public static final RegistryObject<Block> DRAGON_FRUIT = BLOCKS.register("dragon_fruit",
            () -> new DragonFruitBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DRAGON_FRUIT_PLANT = BLOCKS.register("dragon_fruit_plant",
            () -> new DragonFruitPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WISTERIA = BLOCKS.register("wisteria",
            () -> new WisteriaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WISTERIA_PLANT = BLOCKS.register("wisteria_plant",
            () -> new WisteriaPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> JASMINE_LEAVES = registerBlock("jasmine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> FLOWERING_JASMINE_LEAVES = registerBlock("flowering_jasmine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.GRASS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MILKWEED = registerBlock("milkweed",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.PEONY).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> VIOLET = registerBlock("violet",
            () -> new FlowerBlock(() -> MobEffects.DIG_SPEED, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BLUEBELL = registerBlock("bluebell",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> AZURE_BLUET = registerBlock("azure_bluet",
            () -> new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).sound(SoundType.PINK_PETALS)));
    public static final RegistryObject<Block> FORGET_ME_NOT = registerBlock("forget_me_not",
            () -> new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).sound(SoundType.PINK_PETALS)));
    public static final RegistryObject<Block> OYSTER_MUSHROOMS = registerBlock("oyster_mushrooms",
            () -> new OysterMushroomsBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> POTTED_VIOLET = BLOCKS.register("potted_violet",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.VIOLET,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> POTTED_BLUEBELL = BLOCKS.register("potted_bluebell",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.BLUEBELL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> POTTED_ALOE = BLOCKS.register("potted_aloe",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.ALOE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.MAPLE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> POTTED_LINDEN_SAPLING = BLOCKS.register("potted_linden_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.LINDEN_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> POTTED_DRACAENA_SAPLING = BLOCKS.register("potted_dracaena_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.DRACAENA_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> POTTED_BEECH_SAPLING = BLOCKS.register("potted_beech_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.BEECH_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> POTTED_LARCH_SAPLING = BLOCKS.register("potted_larch_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.LARCH_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> POTTED_JACARANDA_SAPLING = BLOCKS.register("potted_jacaranda_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), NaturalityBlocks.JACARANDA_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
