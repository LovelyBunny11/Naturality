package com._LovelyBunny.Naturality;

import com._LovelyBunny.Naturality.block.NaturalityBlocks;
import com._LovelyBunny.Naturality.block.entity.NaturalityBlockEntities;
import com._LovelyBunny.Naturality.block.entity.NaturalityWoodTypes;
import com._LovelyBunny.Naturality.entity.NaturalityEntityTypes;
import com._LovelyBunny.Naturality.item.NaturalityCreativeTabs;
import com._LovelyBunny.Naturality.item.NaturalityItems;
import com._LovelyBunny.Naturality.particle.NaturalityParticleTypes;
import com._LovelyBunny.Naturality.potion.NaturalityPotions;
import com._LovelyBunny.Naturality.sound.NaturalitySoundEvents;
import com._LovelyBunny.Naturality.util.NaturalityBrewingRecipe;
import com._LovelyBunny.Naturality.worldgen.biome.*;
import com._LovelyBunny.Naturality.worldgen.tree.NaturalityTreeDecorators;
import com._LovelyBunny.Naturality.worldgen.tree.NaturalityTrunkPlacers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

@Mod(Naturality.MODID)
public class Naturality {
    public static final String MODID = "naturality";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Naturality()
    { 
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        NaturalityCreativeTabs.register(modEventBus);
        NaturalityItems.register(modEventBus);
        NaturalityBlocks.register(modEventBus);
        NaturalityBlockEntities.register(modEventBus);
        NaturalityEntityTypes.register(modEventBus);
        NaturalityTrunkPlacers.register(modEventBus);
        NaturalityTreeDecorators.register(modEventBus);
        NaturalityParticleTypes.register(modEventBus);
        NaturalitySoundEvents.register(modEventBus);
        NaturalityPotions.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            NaturalityBiomes.registerBiomes();

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, NaturalitySurfaceRuleData.overworld());

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.VIOLET.getId(), NaturalityBlocks.POTTED_VIOLET);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.BLUEBELL.getId(), NaturalityBlocks.POTTED_BLUEBELL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.ALOE.getId(), NaturalityBlocks.POTTED_ALOE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.MAPLE_SAPLING.getId(), NaturalityBlocks.POTTED_MAPLE_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.LINDEN_SAPLING.getId(), NaturalityBlocks.POTTED_LINDEN_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.DRACAENA_SAPLING.getId(), NaturalityBlocks.POTTED_DRACAENA_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.BEECH_SAPLING.getId(), NaturalityBlocks.POTTED_BEECH_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.LARCH_SAPLING.getId(), NaturalityBlocks.POTTED_LARCH_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(NaturalityBlocks.JACARANDA_SAPLING.getId(), NaturalityBlocks.POTTED_JACARANDA_SAPLING);
            });
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LEAPING,
                NaturalityItems.FOUR_LEAF_CLOVER.get(), Potions.LUCK));
        BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LUCK,
                Items.REDSTONE, NaturalityPotions.LONG_LUCK.get()));
        BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LUCK,
                Items.GLOWSTONE_DUST, NaturalityPotions.STRONG_LUCK.get()));
        BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LUCK,
                Items.FERMENTED_SPIDER_EYE, NaturalityPotions.UNLUCK.get()));
        BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(NaturalityPotions.UNLUCK.get(),
                Items.REDSTONE, NaturalityPotions.LONG_UNLUCK.get()));
        BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(NaturalityPotions.UNLUCK.get(),
                Items.GLOWSTONE_DUST, NaturalityPotions.STRONG_UNLUCK.get()));
    }
    @Mod.EventBusSubscriber(modid = Naturality.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(NaturalityWoodTypes.MAPLE);
            Sheets.addWoodType(NaturalityWoodTypes.LINDEN);
            Sheets.addWoodType(NaturalityWoodTypes.DRACAENA);
            Sheets.addWoodType(NaturalityWoodTypes.BEECH);
            Sheets.addWoodType(NaturalityWoodTypes.LARCH);
            Sheets.addWoodType(NaturalityWoodTypes.JACARANDA);

            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.MAPLE_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.LINDEN_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.DRACAENA_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.JACARANDA_DOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.MAPLE_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.LINDEN_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.DRACAENA_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.JACARANDA_TRAPDOOR.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.MAPLE_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.LINDEN_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.DRACAENA_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.BEECH_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.LARCH_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.JACARANDA_SAPLING.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.CLOVER.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.RARE_CLOVER.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.FORGET_ME_NOT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.ALOE.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.DRAGON_FRUIT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.DRAGON_FRUIT_PLANT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.JACARANDA_CARPET.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.WISTERIA.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.WISTERIA_PLANT.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.JASMINE_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.MILKWEED.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.VIOLET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_VIOLET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_ALOE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_MAPLE_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_LINDEN_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_DRACAENA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_BEECH_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_LARCH_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_JACARANDA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.AZURE_BLUET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.BLUEBELL.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.POTTED_BLUEBELL.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NaturalityBlocks.OYSTER_MUSHROOMS.get(), RenderType.cutout());

            BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LEAPING,
                    NaturalityItems.FOUR_LEAF_CLOVER.get(), Potions.LUCK));
            BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LUCK,
                    Items.REDSTONE, NaturalityPotions.LONG_LUCK.get()));
            BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LUCK,
                    Items.GLOWSTONE_DUST, NaturalityPotions.STRONG_LUCK.get()));
            BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(Potions.LUCK,
                    Items.FERMENTED_SPIDER_EYE, NaturalityPotions.UNLUCK.get()));
            BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(NaturalityPotions.UNLUCK.get(),
                    Items.REDSTONE, NaturalityPotions.LONG_UNLUCK.get()));
            BrewingRecipeRegistry.addRecipe(new NaturalityBrewingRecipe(NaturalityPotions.UNLUCK.get(),
                    Items.GLOWSTONE_DUST, NaturalityPotions.STRONG_UNLUCK.get()));
        }
    }
}
