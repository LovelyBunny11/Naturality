package com._LovelyBunny.Naturality.client.renderer;

import com._LovelyBunny.Naturality.Naturality;
import com._LovelyBunny.Naturality.entity.NaturalityBoat;
import com._LovelyBunny.Naturality.entity.NaturalityChestBoat;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class NaturalityBoatRenderer extends BoatRenderer
{
    private final Map<NaturalityBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public NaturalityBoatRenderer(EntityRendererProvider.Context context, boolean hasChest)
    {
        super(context, false);
        this.boatResources = Stream.of(NaturalityBoat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) -> {
            return Pair.of(new ResourceLocation(Naturality.MODID, getTextureLocation(model, hasChest)), createBoatModel(context, model, hasChest));
        }));
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat)
    {
        if (boat instanceof NaturalityChestBoat)
            return this.boatResources.get(((NaturalityChestBoat)boat).getNaturalityType());
        else
            return this.boatResources.get(((NaturalityBoat)boat).getNaturalityType());
    }

    private static String getTextureLocation(NaturalityBoat.Type model, boolean hasChest)
    {
        return hasChest ? "textures/entity/chest_boat/" + model.getName() + ".png" : "textures/entity/boat/" + model.getName() + ".png";
    }

    private static ModelLayerLocation createLocation(String name, String layer)
    {
        return new ModelLayerLocation(new ResourceLocation(Naturality.MODID, name), layer);
    }

    public static ModelLayerLocation createBoatModelName(NaturalityBoat.Type model)
    {
        return createLocation("boat/" + model.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(NaturalityBoat.Type model)
    {
        return createLocation("chest_boat/" + model.getName(), "main");
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, NaturalityBoat.Type model, boolean hasChest)
    {
        ModelLayerLocation modellayerlocation = hasChest ? createChestBoatModelName(model) : createBoatModelName(model);
        ModelPart baked = context.bakeLayer(modellayerlocation);
        return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
    }
}