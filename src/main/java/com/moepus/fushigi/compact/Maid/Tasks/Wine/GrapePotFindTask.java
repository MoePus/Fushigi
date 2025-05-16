package com.moepus.fushigi.compact.Maid.Tasks.Wine;

import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidMoveToBlockTask;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.util.ItemsUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.satisfy.vinery.core.item.GrapeItem;
import net.satisfy.vinery.core.registry.ObjectRegistry;
import static com.moepus.fushigi.compact.Maid.Tasks.Wine.GrapeUtils.*;

public class GrapePotFindTask extends MaidMoveToBlockTask {
    public GrapePotFindTask(float movementSpeed) {
        super(movementSpeed);
    }

    @Override
    protected boolean shouldMoveTo(ServerLevel serverLevel, EntityMaid entityMaid, BlockPos blockPos) {
        BlockState blockState = serverLevel.getBlockState(blockPos);
        if (!blockState.is(ObjectRegistry.GRAPEVINE_POT.get())) return false;

        int stage = blockState.getValue(STAGE);
        int storage = blockState.getValue(STORAGE);

        if (stage < 3) {
            Item grape = getGrapeType(blockState);
            CombinedInvWrapper availableInv = entityMaid.getAvailableInv(true);
            return ItemsUtil.isStackIn(availableInv, stack -> stack.getCount() >= 8 - storage && (grape == null ? stack.getItem() instanceof GrapeItem : stack.is(grape)));
        } else if (stage < 6 && storage == 6) {
            return true;
        }
        return false;
    }

    @Override
    protected void start(ServerLevel worldIn, EntityMaid entityIn, long gameTimeIn) {
        this.searchForDestination(worldIn, entityIn);
    }

}
