package com._LovelyBunny.NET.block.entity;

import com._LovelyBunny.NET.NET;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NETWoodTypes {
    public static final WoodType MAPLE = WoodType.register(new WoodType(NET.MODID + ":maple", BlockSetType.OAK));
    public static final WoodType LINDEN = WoodType.register(new WoodType(NET.MODID + ":linden", BlockSetType.OAK));
    public static final WoodType DRACAENA = WoodType.register(new WoodType(NET.MODID + ":dracaena", BlockSetType.CHERRY));
    public static final WoodType BEECH = WoodType.register(new WoodType(NET.MODID + ":beech", BlockSetType.OAK));
    public static final WoodType LARCH = WoodType.register(new WoodType(NET.MODID + ":larch", BlockSetType.OAK));
}