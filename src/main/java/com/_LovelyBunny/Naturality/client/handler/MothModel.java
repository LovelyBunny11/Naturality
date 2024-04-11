package com._LovelyBunny.Naturality.client.handler;

import com._LovelyBunny.Naturality.entity.Moth;
import com._LovelyBunny.Naturality.entity.animations.NaturalityAnimationDefinitions;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class MothModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Lepidoptera;
	private final ModelPart head;
	private final ModelPart body;

	public MothModel(ModelPart root) {
		this.Lepidoptera = root.getChild("Lepidoptera");
		this.head = Lepidoptera.getChild("Head");
		this.body = Lepidoptera.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Butterfly = partdefinition.addOrReplaceChild("Lepidoptera", CubeListBuilder.create(), PartPose.offset(0.0F, 23.05F, 0.0F));

		PartDefinition Body = Butterfly.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0F));

		PartDefinition Head = Butterfly.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 1.0F));

		PartDefinition LeftWing = Head.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offset(-1.5F, 0.0F, -1.5F));

		PartDefinition LeftUpperWing = LeftWing.addOrReplaceChild("LeftUpperWing", CubeListBuilder.create(), PartPose.offset(0.0152F, 0.0F, -0.0264F));

		PartDefinition cube_r1 = LeftUpperWing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 24).addBox(-10.0F, 0.075F, 0.0F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-10.0F, 0.0F, 0.0F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0152F, -0.05F, 0.0264F, 0.0F, -1.5708F, 0.0F));

		PartDefinition LeftBottomWing = LeftWing.addOrReplaceChild("LeftBottomWing", CubeListBuilder.create().texOffs(0, 12).addBox(-11.0152F, 0.05F, 0.0264F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(11, 36).addBox(-11.0152F, 0.1F, 0.0264F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0152F, 0.0F, -0.0264F));

		PartDefinition RightWing = Head.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offset(1.5F, 0.0F, -1.5F));

		PartDefinition RightUpperWing = RightWing.addOrReplaceChild("RightUpperWing", CubeListBuilder.create(), PartPose.offset(0.0247F, 0.0F, 0.0929F));

		PartDefinition cube_r2 = RightUpperWing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 36).addBox(-1.0F, 0.1F, 0.0F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(22, 12).addBox(-1.0F, 0.0F, 0.0F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0247F, -0.05F, -0.0929F, 0.0F, 1.5708F, 0.0F));

		PartDefinition RightBottomWing = RightWing.addOrReplaceChild("RightBottomWing", CubeListBuilder.create().texOffs(0, 0).addBox(-0.0247F, 0.05F, 0.0071F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(11, 24).addBox(-0.0247F, 0.1F, 0.0071F, 11.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0247F, 0.0F, -0.0071F));

		PartDefinition Antennaes = Head.addOrReplaceChild("Antennaes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, -3.0F));

		PartDefinition cube_r3 = Antennaes.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -4.0F, -0.3F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.5F, -0.3587F, -1.0075F, 0.4173F));

		PartDefinition cube_r4 = Antennaes.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, -0.3F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.5F, -0.3587F, 1.0075F, -0.4173F));

		PartDefinition RightLegs = Butterfly.addOrReplaceChild("RightLegs", CubeListBuilder.create().texOffs(8, 5).addBox(0.0F, -0.3F, -2.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 7).addBox(0.0F, -0.3F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(0.5F, -0.9F, 2.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition LeftLegs = Butterfly.addOrReplaceChild("LeftLegs", CubeListBuilder.create().texOffs(0, 5).addBox(-0.1F, -0.3F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 5).addBox(-0.1F, -0.3F, -2.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.6F, -1.0F, 2.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float NaturalityHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(NaturalityAnimationDefinitions.LEPIDOPTERA_FLIGHT, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((Moth) entity).idleAnimationState, NaturalityAnimationDefinitions.LEPIDOPTERA_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Lepidoptera.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Lepidoptera;
	}
}