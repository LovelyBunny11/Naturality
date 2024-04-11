package com._LovelyBunny.Naturality.client.handler;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.block.entity.NaturalityBlockEntities;
import com._LovelyBunny.Naturality.block.entity.NaturalityHangingSignBlockEntity;
import com._LovelyBunny.Naturality.block.entity.NaturalitySignBlockEntity;
import com._LovelyBunny.Naturality.client.renderer.ButterflyRenderer;
import com._LovelyBunny.Naturality.client.renderer.MothRenderer;
import com._LovelyBunny.Naturality.client.renderer.NaturalityBoatRenderer;
import com._LovelyBunny.Naturality.entity.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Naturality.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRendererHandler {

    public static final ModelLayerLocation MOTH_LAYER = new ModelLayerLocation(
            new ResourceLocation(Naturality.MODID, "moth_layer"), "moth");

    public static final ModelLayerLocation BUTTERFLY_LAYER = new ModelLayerLocation(
            new ResourceLocation(Naturality.MODID, "butterfly_layer"), "butterfly");

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MOTH_LAYER, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(BUTTERFLY_LAYER, ButterflyModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {

        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();

        for (NaturalityBoat.Type type : NaturalityBoat.Type.values())
        {
            ForgeHooksClient.registerLayerDefinition(NaturalityBoatRenderer.createBoatModelName(type), () -> boatLayerDefinition);
            ForgeHooksClient.registerLayerDefinition(NaturalityBoatRenderer.createChestBoatModelName(type), () -> chestBoatLayerDefinition);
        }

        event.registerBlockEntityRenderer((BlockEntityType<NaturalitySignBlockEntity>) NaturalityBlockEntities.SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<NaturalityHangingSignBlockEntity>) NaturalityBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerEntityRenderer((EntityType<NaturalityBoat>) NaturalityEntityTypes.BOAT.get(), context -> new NaturalityBoatRenderer(context, false));
        event.registerEntityRenderer((EntityType<NaturalityChestBoat>) NaturalityEntityTypes.CHEST_BOAT.get(), context -> new NaturalityBoatRenderer(context, true));
        event.registerEntityRenderer((EntityType<Moth>) NaturalityEntityTypes.MOTH.get(), MothRenderer::new);
        event.registerEntityRenderer((EntityType<Butterfly>) NaturalityEntityTypes.BUTTERFLY.get(), ButterflyRenderer::new);
    }
}