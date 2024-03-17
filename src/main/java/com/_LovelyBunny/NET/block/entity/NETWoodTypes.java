package com._LovelyBunny.NET.block.entity;

import com._LovelyBunny.NET.NET;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class NETWoodTypes {
    public static final WoodType MAPLE = WoodType.register(new WoodType(NET.MODID + ":maple", BlockSetType.OAK));
}