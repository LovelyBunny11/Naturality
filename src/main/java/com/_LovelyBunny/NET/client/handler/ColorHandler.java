package com._LovelyBunny.NET.client.handler;


import com._LovelyBunny.NET.NET;
import com._LovelyBunny.NET.block.NETBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = NET.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandler
{
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event)
    {
        event.getItemColors().register((stack, tintIndex) -> {
                    BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return event.getBlockColors().getColor(state, null, null, tintIndex); },
                NETBlocks.MAPLE_LEAVES.get(), NETBlocks.LINDEN_LEAVES.get(), NETBlocks.LINDEN_LEAVES.get());
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
    {
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                NETBlocks.MAPLE_LEAVES.get(), NETBlocks.LINDEN_LEAVES.get(), NETBlocks.LINDEN_LEAVES.get());
            event.getBlockColors().register((state, world, pos, tintIndex) ->
    world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
        NETBlocks.CLOVER.get(), NETBlocks.RARE_CLOVER.get());
    }
}