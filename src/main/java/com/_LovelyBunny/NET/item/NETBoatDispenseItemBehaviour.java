package com._LovelyBunny.NET.item;

import com._LovelyBunny.NET.entity.NETBoat;
import com._LovelyBunny.NET.entity.NETChestBoat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class NETBoatDispenseItemBehaviour extends DefaultDispenseItemBehavior
{
    private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();
    private final NETBoat.Type type;
    private final boolean hasChest;

    public NETBoatDispenseItemBehaviour(boolean hasChest, NETBoat.Type type)
    {
        this.type = type;
        this.hasChest = hasChest;
    }

    @Override
    public ItemStack execute(BlockSource source, ItemStack stack)
    {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        Level level = source.getLevel();
        double d0 = source.x() + (double) ((float) direction.getStepX() * 1.125F);
        double d1 = source.y() + (double) ((float) direction.getStepY() * 1.125F);
        double d2 = source.z() + (double) ((float) direction.getStepZ() * 1.125F);
        BlockPos blockpos = source.getPos().relative(direction);
        double d3;
        if (level.getFluidState(blockpos).is(FluidTags.WATER))
        {
            d3 = 1.0D;
        }
        else
        {
            if (!level.getBlockState(blockpos).isAir() || !level.getFluidState(blockpos.below()).is(FluidTags.WATER))
            {
                return this.defaultDispenseItemBehavior.dispense(source, stack);
            }

            d3 = 0.0D;
        }

        Boat boat;

        if (this.hasChest)
        {
            boat = new NETChestBoat(level, d0, d1 + d3, d2);
            ((NETChestBoat)boat).setType(this.type);

        }
        else
        {
            boat = new NETBoat(level, d0, d1 + d3, d2);
            ((NETBoat)boat).setType(this.type);
        }

        boat.setYRot(direction.toYRot());
        level.addFreshEntity(boat);

        stack.shrink(1);
        return stack;
    }

    @Override
    protected void playSound(BlockSource p_123373_)
    {
        p_123373_.getLevel().levelEvent(1000, p_123373_.getPos(), 0);
    }
}