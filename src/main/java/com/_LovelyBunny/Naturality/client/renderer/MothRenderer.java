package com._LovelyBunny.Naturality.client.renderer;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.client.handler.EntityRendererHandler;
import com._LovelyBunny.Naturality.client.handler.MothModel;
import com._LovelyBunny.Naturality.entity.Moth;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MothRenderer extends MobRenderer<Moth, MothModel<Moth>> {
    private static final ResourceLocation ROSY_MAPLE_LOCATION = new ResourceLocation(Naturality.MODID, "textures/entity/moth/rosy_maple.png");
    private static final ResourceLocation LUNA_LOCATION = new ResourceLocation(Naturality.MODID, "textures/entity/moth/luna.png");
    private static final ResourceLocation DEATH_HEAD_LOCATION = new ResourceLocation(Naturality.MODID, "textures/entity/moth/death_head_hawk.png");

    public MothRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MothModel<>(pContext.bakeLayer(EntityRendererHandler.MOTH_LAYER)), 0.3f);
    }

    public ResourceLocation getTextureLocation(Moth p_115803_) {
        String $$1 = ChatFormatting.stripFormatting(p_115803_.getName().getString());
        ResourceLocation variation;
        switch (p_115803_.getVariant()) {
            case ROSY_MAPLE:
                variation = ROSY_MAPLE_LOCATION;
                break;
            case LUNA:
                variation = LUNA_LOCATION;
                break;
            case DEATH_HEAD_HAWK:
                variation = DEATH_HEAD_LOCATION;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        return variation;
    }

    @Override
    public void render(Moth pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        Minecraft $$10 = Minecraft.getInstance();
        boolean $$11 = $$10.shouldEntityAppearGlowing(pEntity) && pEntity.isInvisible();
        if (!pEntity.isInvisible() || $$11) {
            VertexConsumer $$13;
            if ($$11) {
                $$13 = pBuffer.getBuffer(RenderType.outline(this.getTextureLocation(pEntity)));
            } else {
                $$13 = pBuffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(pEntity)));
            }
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }
}
