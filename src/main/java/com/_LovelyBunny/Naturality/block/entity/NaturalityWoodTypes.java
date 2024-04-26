package com._LovelyBunny.Naturality.block.entity;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NaturalityWoodTypes {
    public static final WoodType MAPLE = WoodType.register(new WoodType(Naturality.MODID + ":maple", BlockSetType.OAK));
    public static final WoodType LINDEN = WoodType.register(new WoodType(Naturality.MODID + ":linden", BlockSetType.OAK));
    public static final WoodType DRACAENA = WoodType.register(new WoodType(Naturality.MODID + ":dracaena", BlockSetType.CHERRY));
    public static final WoodType BEECH = WoodType.register(new WoodType(Naturality.MODID + ":beech", BlockSetType.OAK));
    public static final WoodType LARCH = WoodType.register(new WoodType(Naturality.MODID + ":larch", BlockSetType.OAK));
    public static final WoodType JACARANDA = WoodType.register(new WoodType(Naturality.MODID + ":jacaranda", BlockSetType.OAK));
    public static final WoodType ADENIUM = WoodType.register(new WoodType(Naturality.MODID + ":adenium", BlockSetType.CRIMSON));
}