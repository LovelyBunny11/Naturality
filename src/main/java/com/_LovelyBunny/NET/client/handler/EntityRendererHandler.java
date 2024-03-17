package com._LovelyBunny.NET.client.handler;

import com._LovelyBunny.NET.NET;
import com._LovelyBunny.NET.block.entity.NETBlockEntities;
import com._LovelyBunny.NET.block.entity.NETHangingSignBlockEntity;
import com._LovelyBunny.NET.block.entity.NETSignBlockEntity;
import com._LovelyBunny.NET.client.renderer.NETBoatRenderer;
import com._LovelyBunny.NET.entity.NETBoat;
import com._LovelyBunny.NET.entity.NETChestBoat;
import com._LovelyBunny.NET.entity.NETEntities;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NET.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRendererHandler {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {

        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();

        for (NETBoat.ModelType type : NETBoat.ModelType.values())
        {
            ForgeHooksClient.registerLayerDefinition(NETBoatRenderer.createBoatModelName(type), () -> boatLayerDefinition);
            ForgeHooksClient.registerLayerDefinition(NETBoatRenderer.createChestBoatModelName(type), () -> chestBoatLayerDefinition);
        }

        event.registerBlockEntityRenderer((BlockEntityType<NETSignBlockEntity>) NETBlockEntities.NET_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer((BlockEntityType<NETHangingSignBlockEntity>) NETBlockEntities.NET_HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerEntityRenderer((EntityType<NETBoat>) NETEntities.NET_BOAT.get(), context -> new NETBoatRenderer(context, false));
        event.registerEntityRenderer((EntityType<NETChestBoat>) NETEntities.NET_CHEST_BOAT.get(), context -> new NETBoatRenderer(context, true));
    }
}