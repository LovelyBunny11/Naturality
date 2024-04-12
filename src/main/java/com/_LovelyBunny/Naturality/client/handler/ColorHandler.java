package com._LovelyBunny.Naturality.client.handler;


import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Naturality.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandler {
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event)
    {
        event.getItemColors().register((stack, tintIndex) -> {
                    BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return event.getBlockColors().getColor(state, null, null, tintIndex); },
                NaturalityBlocks.MAPLE_LEAVES.get(), NaturalityBlocks.LINDEN_LEAVES.get(), NaturalityBlocks.BEECH_LEAVES.get(), NaturalityBlocks.LARCH_LEAVES.get(), NaturalityBlocks.JASMINE_LEAVES.get(), NaturalityBlocks.FLOWERING_JASMINE_LEAVES.get());
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
    {
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                NaturalityBlocks.MAPLE_LEAVES.get(), NaturalityBlocks.LINDEN_LEAVES.get(), NaturalityBlocks.BEECH_LEAVES.get(), NaturalityBlocks.LARCH_LEAVES.get(), NaturalityBlocks.JASMINE_LEAVES.get(), NaturalityBlocks.FLOWERING_JASMINE_LEAVES.get());
            event.getBlockColors().register((state, world, pos, tintIndex) ->
    world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(), NaturalityBlocks.CLOVER.get(), NaturalityBlocks.RARE_CLOVER.get());
    }
}