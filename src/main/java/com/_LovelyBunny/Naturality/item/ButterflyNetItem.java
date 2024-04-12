package com._LovelyBunny.Naturality.item;

import com._LovelyBunny.Naturality.entity.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class ButterflyNetItem extends Item {
    public ButterflyNetItem(Properties properties) {
        super(properties);
    }

    public InteractionResult interactLivingEntity(ItemStack p_41085_, Player p_41086_, LivingEntity p_41087_, InteractionHand p_41088_) {
        if (p_41087_ instanceof Butterfly $$4) {
            if ($$4.isAlive()) {
                $$4.level().playSound(p_41086_, $$4, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!p_41086_.level().isClientSide) {
                    $$4.discard();
                    ItemEntity itementity = $$4.spawnAtLocation((ItemLike) $$4.getDropItem(), 1);
                }

                return InteractionResult.sidedSuccess(p_41086_.level().isClientSide);
            }
        }
        if (p_41087_ instanceof Moth $$4) {
            if ($$4.isAlive()) {
                $$4.level().playSound(p_41086_, $$4, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!p_41086_.level().isClientSide) {
                    $$4.discard();
                    ItemEntity itementity = $$4.spawnAtLocation((ItemLike) $$4.getDropItem(), 1);
                }

                return InteractionResult.sidedSuccess(p_41086_.level().isClientSide);
            }
        }
        if (p_41087_ instanceof Bee $$4) {
            if ($$4.isAlive()) {
                $$4.level().playSound(p_41086_, $$4, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!p_41086_.level().isClientSide) {
                    if (!p_41086_.isCreative()) {
                        $$4.setTarget(p_41086_);
                    }
                }
                return InteractionResult.sidedSuccess(p_41086_.level().isClientSide);
            }
        }
        if (p_41087_ instanceof Spider $$4) {
            if ($$4.isAlive()) {
                $$4.level().playSound(p_41086_, $$4, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!p_41086_.level().isClientSide) {
                    if (!p_41086_.isCreative()) {
                        $$4.setTarget(p_41086_);
                    }
                }
                return InteractionResult.sidedSuccess(p_41086_.level().isClientSide);
            }
        }
        return InteractionResult.PASS;
    }
}