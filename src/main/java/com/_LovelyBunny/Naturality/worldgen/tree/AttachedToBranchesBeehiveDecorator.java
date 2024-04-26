package com._LovelyBunny.Naturality.worldgen.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AttachedToBranchesBeehiveDecorator extends TreeDecorator {
    public static final Codec<AttachedToBranchesBeehiveDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(AttachedToBranchesBeehiveDecorator::new, (p_69971_) -> {
        return p_69971_.probability;
    }).codec();
    private static final Direction WORLDGEN_FACING;
    private static final Direction[] SPAWN_DIRECTIONS;
    private final float probability;
    public AttachedToBranchesBeehiveDecorator(float p_69958_) {
        this.probability = p_69958_;
    }

    protected TreeDecoratorType<?> type() {
        return NaturalityTreeDecorators.ATTACHED_TO_BRANCHES_BEEHIVE_DECORATOR.get();
    }

    public void place(TreeDecorator.Context context) {
        RandomSource randomSource = context.random();
        Random random = new Random();
        int range = 3 - 2 + 1;
        int hiveHeight =  random.nextInt(range) + 2;
        if (!(randomSource.nextFloat() >= this.probability)) {
            List<BlockPos> leaves = context.leaves();
            List<BlockPos> logs = context.logs();
            int hiveLogAttachment =  !leaves.isEmpty() ? Math.max(((BlockPos)leaves.get(4)).getY() - hiveHeight, ((BlockPos)logs.get(0)).getY() + 1)  : Math.min(((BlockPos)logs.get(0)).getY() + 3 + randomSource.nextInt(3), ((BlockPos)logs.get(logs.size() - 1)).getY());
            List<BlockPos> logList = (List) logs.stream().filter((p_202300_) ->
                    p_202300_.getY() == hiveLogAttachment).flatMap((p_202305_) -> {
                Stream var10000 = Stream.of(SPAWN_DIRECTIONS);
                Objects.requireNonNull(p_202305_);
                return var10000.map(direction -> p_202305_.relative(Direction.Plane.HORIZONTAL.getRandomDirection(randomSource)));
            }).collect(Collectors.toList());
            if (!logList.isEmpty()) {
                Collections.shuffle(logList);
                Optional<BlockPos> hivePos = logList.stream().filter((p_226022_) -> context.level().isStateAtPosition(p_226022_.above(), (p_70304_) -> p_70304_.is(BlockTags.LOGS)) && context.isAir(p_226022_) && context.isAir(p_226022_.relative(WORLDGEN_FACING))).findFirst();
                if (!hivePos.isEmpty()) {
                    context.setBlock(hivePos.get(), Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, WORLDGEN_FACING));
                    context.level().getBlockEntity(hivePos.get(), BlockEntityType.BEEHIVE).ifPresent((p_259007_) -> {
                        int i = 2 + randomSource.nextInt(2);

                        for (int x = 0; x < i; ++x) {
                            CompoundTag tag = new CompoundTag();
                            tag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(EntityType.BEE).toString());
                            p_259007_.storeBee(tag, randomSource.nextInt(599), false);
                        }
                    });
                }
            }
        }
    }

    static {
        WORLDGEN_FACING = Direction.SOUTH;
        SPAWN_DIRECTIONS = Direction.Plane.HORIZONTAL.stream().filter((p_202307_) -> p_202307_ != WORLDGEN_FACING.getOpposite()).toArray(Direction[]::new);
    }
}