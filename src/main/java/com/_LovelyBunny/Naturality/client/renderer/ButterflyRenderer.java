package com._LovelyBunny.Naturality.client.renderer;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.client.handler.ButterflyModel;
import com._LovelyBunny.Naturality.client.handler.EntityRendererHandler;
import com._LovelyBunny.Naturality.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ButterflyRenderer extends MobRenderer<Butterfly, ButterflyModel<Butterfly>> {
    private static final ResourceLocation MONARCH_LOCATION = new ResourceLocation(Naturality.MODID,"textures/entity/butterfly/monarch.png");
    private static final ResourceLocation MORPHO_LOCATION = new ResourceLocation(Naturality.MODID,"textures/entity/butterfly/blue_morpho.png");
    private static final ResourceLocation RED_ADMIRAL_LOCATION = new ResourceLocation(Naturality.MODID,"textures/entity/butterfly/red_admiral.png");
    public ButterflyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ButterflyModel<>(pContext.bakeLayer(EntityRendererHandler.BUTTERFLY_LAYER)), 0.3f);
    }
    public ResourceLocation getTextureLocation(Butterfly p_115803_) {
        String $$1 = ChatFormatting.stripFormatting(p_115803_.getName().getString());
            ResourceLocation variation;
            switch (p_115803_.getVariant()) {
                case MONARCH:
                    variation = MONARCH_LOCATION;
                    break;
                case MORPHO:
                    variation = MORPHO_LOCATION;
                    break;
                case RED_ADMIRAL:
                    variation = RED_ADMIRAL_LOCATION;
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return variation;
        }

    @Override
    public void render(Butterfly pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
