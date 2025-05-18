package com.moepus.fushigi.compact.Vinery.Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;

public interface IWrappedBottle {
    public default InteractionResult useOn(UseOnContext useOnContext, Block block) {
        Player player = useOnContext.getPlayer();
        if (player!=null && !useOnContext.getPlayer().isShiftKeyDown()) return InteractionResult.PASS;
        return this.place(new BlockPlaceContext(useOnContext), block);
    }

    public default InteractionResult place(BlockPlaceContext blockPlaceContext, Block block) {
        if (!block.isEnabled(blockPlaceContext.getLevel().enabledFeatures())) {
            return InteractionResult.FAIL;
        } else if (!blockPlaceContext.canPlace()) {
            return InteractionResult.FAIL;
        } else {
            BlockState blockState = this.getPlacementState(blockPlaceContext, block);
            if (blockState==null) {
                return InteractionResult.FAIL;
            } else if (!this.placeBlock(blockPlaceContext, blockState)) {
                return InteractionResult.FAIL;
            } else {
                BlockPos blockPos = blockPlaceContext.getClickedPos();
                Level level = blockPlaceContext.getLevel();
                Player player = blockPlaceContext.getPlayer();
                ItemStack itemStack = blockPlaceContext.getItemInHand();
                BlockState blockState2 = level.getBlockState(blockPos);

                SoundType soundType = blockState2.getSoundType();
                level.playSound(player, blockPos, this.getPlaceSound(blockState2), SoundSource.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
                level.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(player, blockState2));
                if (player==null || !player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
    }

    default boolean placeBlock(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        return blockPlaceContext.getLevel().setBlock(blockPlaceContext.getClickedPos(), blockState, 11);
    }

    default BlockState getPlacementState(BlockPlaceContext blockPlaceContext, Block block) {
        BlockState blockState = block.getStateForPlacement(blockPlaceContext);
        return blockState != null && this.canPlace(blockPlaceContext, blockState) ? blockState : null;
    }

    default boolean canPlace(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        Player player = blockPlaceContext.getPlayer();
        CollisionContext collisionContext = player == null ? CollisionContext.empty() : CollisionContext.of(player);
        return (blockState.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) && blockPlaceContext.getLevel().isUnobstructed(blockState, blockPlaceContext.getClickedPos(), collisionContext);
    }

    default SoundEvent getPlaceSound(BlockState blockState) {
        return blockState.getSoundType().getPlaceSound();
    }
}
