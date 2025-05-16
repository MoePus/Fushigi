package com.moepus.fushigi.compact.Maid.Tasks.Wine;

import com.github.tartaricacid.touhoulittlemaid.api.task.IFarmTask;
import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidFarmMoveTask;
import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidFarmPlantTask;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.google.common.collect.Lists;
import com.moepus.fushigi.FSGTags;
import com.moepus.fushigi.Fushigi;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.satisfy.vinery.core.block.GrapeBush;
import net.satisfy.vinery.core.block.LatticeBlock;
import net.satisfy.vinery.core.registry.ObjectRegistry;

import java.util.List;

public class WineTask implements IFarmTask {
    private final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Fushigi.MODID, "wine_task");
    private final static ItemStack ICON = ObjectRegistry.RED_GRAPE.get().getDefaultInstance();
    private final static IntegerProperty BushAgeProp = BlockStateProperties.AGE_3;
    private final static IntegerProperty LatticeAgeProp = BlockStateProperties.AGE_4;

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public ItemStack getIcon() {
        return ICON;
    }

    @Override
    public boolean isSeed(ItemStack itemStack) {
        return itemStack.is(FSGTags.GRAPE_SEED_TAG);
    }

    @Override
    public boolean canHarvest(EntityMaid entityMaid, BlockPos blockPos, BlockState blockState) {
        if (blockState.getBlock() instanceof GrapeBush) {
            if (blockState.hasProperty(BushAgeProp)) {
                return blockState.getValue(BushAgeProp)==3;
            }
        }
        if (blockState.getBlock() instanceof LatticeBlock) {
            if (blockState.hasProperty(LatticeAgeProp)) {
                return blockState.getValue(LatticeAgeProp) >= 3;
            }
        }

        return false;
    }

    @Override
    public void harvest(EntityMaid entityMaid, BlockPos blockPos, BlockState blockState) {
        Level level = entityMaid.level;
        Block block = blockState.getBlock();
        if (block instanceof GrapeBush grapeBush) {
            if (!blockState.hasProperty(BushAgeProp)) {
                return;
            }
            BlockState newState = blockState.setValue(BushAgeProp, 1);
            level.setBlock(blockPos, newState, Block.UPDATE_ALL);
            int popCount = level.random.nextInt(1, 3);
            Block.popResource(level, blockPos, new ItemStack(grapeBush.getGrapeType().getItem(), popCount));
            level.playSound((Player) null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        } else if (block instanceof LatticeBlock latticeBlock) {
            if (!blockState.hasProperty(LatticeAgeProp)) {
                return;
            }
            Direction direction = Direction.getNearest(
                    entityMaid.getX() - (blockPos.getX() + 0.5),
                    entityMaid.getY() - (blockPos.getY() + 1.0),
                    entityMaid.getZ() - (blockPos.getZ() + 0.5)
            );

            latticeBlock.dropGrapes(level, blockState, blockPos, direction);
            BlockState newState = blockState.setValue(LatticeAgeProp, 1);
            level.setBlock(blockPos, newState, Block.UPDATE_ALL);
        }
        return;
    }

    @Override
    public boolean canPlant(EntityMaid entityMaid, BlockPos blockPos, BlockState blockState, ItemStack itemStack) {
        return false;
    }

    @Override
    public ItemStack plant(EntityMaid entityMaid, BlockPos blockPos, BlockState blockState, ItemStack itemStack) {
        return null;
    }

    @Override
    public double getCloseEnoughDist() {
        return 2.0D;
    }

    @Override
    public List<Pair<Integer, BehaviorControl<? super EntityMaid>>> createBrainTasks(EntityMaid maid) {
        return Lists.newArrayList(
                Pair.of(5, new MaidGrapeFarmMoveTask(this, 0.6F)),
                Pair.of(6, new MaidFarmPlantTask(this)),
                Pair.of(7, new GrapePotFindTask(0.6f)),
                Pair.of(8, new GrapeProcessTask(0.6f))
        );
    }
}
