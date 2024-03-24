package com._LovelyBunny.NET.client.renderer;

import com._LovelyBunny.NET.NET;
import com._LovelyBunny.NET.entity.NETBoat;
import com._LovelyBunny.NET.entity.NETChestBoat;
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

public class NETBoatRenderer extends BoatRenderer
{
    private final Map<NETBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public NETBoatRenderer(EntityRendererProvider.Context context, boolean hasChest)
    {
        super(context, false);
        this.boatResources = Stream.of(NETBoat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) -> {
            return Pair.of(new ResourceLocation(NET.MODID, getTextureLocation(model, hasChest)), createBoatModel(context, model, hasChest));
        }));
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat)
    {
        if (boat instanceof NETChestBoat)
            return this.boatResources.get(((NETChestBoat)boat).getNETType());
        else
            return this.boatResources.get(((NETBoat)boat).getNETType());
    }

    private static String getTextureLocation(NETBoat.Type model, boolean hasChest)
    {
        return hasChest ? "textures/entity/chest_boat/" + model.getName() + ".png" : "textures/entity/boat/" + model.getName() + ".png";
    }

    private static ModelLayerLocation createLocation(String name, String layer)
    {
        return new ModelLayerLocation(new ResourceLocation(NET.MODID, name), layer);
    }

    public static ModelLayerLocation createBoatModelName(NETBoat.Type model)
    {
        return createLocation("boat/" + model.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(NETBoat.Type model)
    {
        return createLocation("chest_boat/" + model.getName(), "main");
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, NETBoat.Type model, boolean hasChest)
    {
        ModelLayerLocation modellayerlocation = hasChest ? createChestBoatModelName(model) : createBoatModelName(model);
        ModelPart baked = context.bakeLayer(modellayerlocation);
        return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
    }
}