package com.moepus.fushigi.compact.Maid.Tasks.Wine;

import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidCheckRateTask;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitEntities;
import com.github.tartaricacid.touhoulittlemaid.util.ItemsUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.satisfy.vinery.core.item.GrapeItem;
import net.satisfy.vinery.core.registry.ObjectRegistry;

import static com.moepus.fushigi.compact.Maid.Tasks.Wine.GrapeUtils.*;

public class GrapeProcessTask extends MaidCheckRateTask {
    private float speed;

    public GrapeProcessTask(float speed) {
        super(ImmutableMap.of(InitEntities.TARGET_POS.get(), MemoryStatus.VALUE_PRESENT));
        this.speed = speed;
        this.setMaxCheckRate(1);
    }

    public void fillGrape(BlockState blockState, Level world, BlockPos pos, ItemStack grape) {
        int stage = blockState.getValue(STAGE);
        int storage = blockState.getValue(STORAGE) + 1;
        grape.shrink(1);
        blockState = blockState.setValue(GRAPEVINE_TYPE, ((GrapeItem) grape.getItem()).getType()).setValue(STORAGE, Math.min(storage, 6));
        if (stage==0)
            blockState = blockState.setValue(STAGE, 1);
        else if (storage==3 || storage==6 || storage==9)
            blockState = blockState.setValue(STAGE, Math.min(stage + 1, 3));

        world.setBlock(pos, blockState, Block.UPDATE_ALL);
        world.playSound(null, pos, SoundEvents.CORAL_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    protected void start(ServerLevel worldIn, EntityMaid maid, long gameTimeIn) {
        maid.getBrain().getMemory(InitEntities.TARGET_POS.get()).ifPresent(targetPos -> {
            BlockPos blockPos = targetPos.currentBlockPosition();
            BlockState blockState = worldIn.getBlockState(blockPos);
            if (!blockState.is(ObjectRegistry.GRAPEVINE_POT.get()) || !blockState.hasProperty(STAGE)) {
                return;
            }
            this.setMaxCheckRate(1);
            if (!maid.isWithinRestriction(blockPos)) return;

            int stage = blockState.getValue(STAGE);

            CombinedInvWrapper availableInv = maid.getAvailableInv(false);

            if (stage < 3) {
                // 放入与pot内grapeType相同的grape或随意一种grape
                Item grape = getGrapeType(blockState);
                ItemStack grapeStack = ItemsUtil.getStack(availableInv, stack -> grape==null ? stack.getItem() instanceof GrapeItem:stack.is(grape));
                if (!grapeStack.isEmpty()) {
                    fillGrape(blockState, worldIn, blockPos, grapeStack);
                    maid.swing(InteractionHand.MAIN_HAND);
                    setNextCheckTickCount(12);
                }
            } else if (stage >= 3) {
                // 在pot上跳跃，直到stage==6或stage<3
                if (blockPos.distToCenterSqr(maid.position()) <= 0.6f) {

                    maid.setDeltaMovement((blockPos.getX() + 0.5f - maid.position().x) * 0.2f,
                            0.3, (blockPos.getZ() + 0.5f - maid.position().z) * 0.2f);
                    if (stage==6 || blockState.getValue(STAGE) < 3) {
                        finishTask(maid);
                    }
                    setNextCheckTickCount(20);
                }
            }
        });
    }

    private void finishTask(EntityMaid maid) {
        maid.getBrain().eraseMemory(InitEntities.TARGET_POS.get());
        maid.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        maid.getBrain().eraseMemory(MemoryModuleType.LOOK_TARGET);
        this.setMaxCheckRate(40);
    }
}
