package com._LovelyBunny.NET;

import com._LovelyBunny.NET.block.NETBlocks;
import com._LovelyBunny.NET.block.entity.NETBlockEntities;
import com._LovelyBunny.NET.block.entity.NETWoodTypes;
import com._LovelyBunny.NET.entity.NETEntities;
import com._LovelyBunny.NET.item.NETCreativeTabs;
import com._LovelyBunny.NET.item.NETItems;
import com._LovelyBunny.NET.worldgen.biome.NETOverworldRegion;
import com._LovelyBunny.NET.worldgen.biome.NETOverworldRegion1;
import com._LovelyBunny.NET.worldgen.biome.NETSurfaceRuleData;
import com._LovelyBunny.NET.worldgen.biome.NETSurfaceRuleData1;
import com._LovelyBunny.NET.worldgen.tree.NETTrunkPlacers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NET.MODID)
public class NET
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "notenoughtrees";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public NET()
    { 
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        NETCreativeTabs.register(modEventBus);
        NETItems.register(modEventBus);
        NETBlocks.register(modEventBus);
        NETBlockEntities.register(modEventBus);
        NETEntities.register(modEventBus);
        NETTrunkPlacers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(NETWoodTypes.MAPLE);
            Sheets.addWoodType(NETWoodTypes.LINDEN);
            Sheets.addWoodType(NETWoodTypes.DRACAENA);
            Sheets.addWoodType(NETWoodTypes.BEECH);
            Sheets.addWoodType(NETWoodTypes.LARCH);
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.DRACAENA_BRANCHES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.MAPLE_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.LINDEN_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.DRACAENA_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.MAPLE_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.LINDEN_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.DRACAENA_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.MAPLE_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.LINDEN_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.DRACAENA_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.BEECH_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.LARCH_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.CLOVER.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.RARE_CLOVER.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.ALOE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.DRAGON_FRUIT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NETBlocks.DRAGON_FRUIT_PLANT.get(), RenderType.cutoutMipped());

            event.enqueueWork(() -> {
                Regions.register(new NETOverworldRegion(new ResourceLocation(MODID, "overworld"), 3));
                Regions.register(new NETOverworldRegion1(new ResourceLocation(MODID, "overworld1"), 2));
            });
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, NETSurfaceRuleData.makeRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, NETSurfaceRuleData1.makeRules());
        }
    }
}
