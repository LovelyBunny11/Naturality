package com._LovelyBunny.Naturality.worldgen.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FallenTrunkPlacer extends TrunkPlacer {
    public static final Codec<FallenTrunkPlacer> CODEC = RecordCodecBuilder.create(fallenTrunkPlacerInstance ->
            trunkPlacerParts(fallenTrunkPlacerInstance).apply(fallenTrunkPlacerInstance, FallenTrunkPlacer::new));

    public FallenTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return NaturalityTrunkPlacers.FALLEN_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int height, BlockPos pPos, TreeConfiguration pConfig) {

        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);

        Random random = new Random();

        int branchLenghtRange = 8 - 6 + 1;
        int branchLenght = random.nextInt(branchLenghtRange) + 6;

        if (validTreePos(pLevel, pPos)) {
            if (pLevel.isStateAtPosition(pPos.north(), BlockBehaviour.BlockStateBase::canBeReplaced)) {
                if (pLevel.isStateAtPosition(pPos.south(), BlockBehaviour.BlockStateBase::canBeReplaced)) {
                    if (pLevel.isStateAtPosition(pPos.west(), BlockBehaviour.BlockStateBase::canBeReplaced)) {
                        if (pLevel.isStateAtPosition(pPos.east(), BlockBehaviour.BlockStateBase::canBeReplaced)) {
                            setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);

                            for (int i = 0; i < height; i++) {
                                placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

                                if (pLevel.isStateAtPosition(pPos.below().relative(direction, 2).relative(direction, 3).relative(direction, 4).relative(direction, 5).relative(direction, 6).relative(direction, branchLenght), (p_70304_) -> p_70304_.is(BlockTags.DIRT))) {
                                    if (pLevel.isStateAtPosition(pPos.below().relative(direction, 2).relative(direction, branchLenght), (p_70304_) -> !p_70304_.is(BlockTags.LOGS) && p_70304_.canBeReplaced())) {
                                        for (int x = 2; x < branchLenght; x++) {
                                            pBlockSetter.accept(pPos.above(0).relative(direction, x), ((BlockState)
                                                    Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, direction.getAxis()))));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}