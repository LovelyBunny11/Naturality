package com._LovelyBunny.Naturality.worldgen.tree;

import com._LovelyBunny.Naturality.Naturality;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NaturalityTreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, Naturality.MODID);
    public static final RegistryObject<TreeDecoratorType<AttachedToBranchesBeehiveDecorator>> ATTACHED_TO_BRANCHES_BEEHIVE_DECORATOR =
            TREE_DECORATORS.register("attached_to_branches_beehive", () -> new TreeDecoratorType(AttachedToBranchesBeehiveDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<BranchMossDecorator>> BRANCH_MOSS_DECORATOR =
            TREE_DECORATORS.register("branch_moss", () -> new TreeDecoratorType(BranchMossDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<NearBranchMossDecorator>> NEAR_BRANCH_MOSS_DECORATOR =
            TREE_DECORATORS.register("near_branch_moss", () -> new TreeDecoratorType(NearBranchMossDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<OysterMushroomDecorator>> OYSTER_MUSHROOM_DECORATOR =
            TREE_DECORATORS.register("oyster_mushroom", () -> new TreeDecoratorType(OysterMushroomDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}
