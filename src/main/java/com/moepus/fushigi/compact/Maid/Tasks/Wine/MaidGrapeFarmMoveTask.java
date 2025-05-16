package com.moepus.fushigi.compact.Maid.Tasks.Wine;

import com.github.tartaricacid.touhoulittlemaid.api.task.IFarmTask;
import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidFarmMoveTask;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.MaidPathFindingBFS;
import net.minecraft.core.BlockPos;

public class MaidGrapeFarmMoveTask extends MaidFarmMoveTask {
    public MaidGrapeFarmMoveTask(IFarmTask task, float movementSpeed) {
        super(task, movementSpeed);
    }

    @Override
    protected boolean checkPathReach(EntityMaid maid, MaidPathFindingBFS pathFinding, BlockPos pos) {
        if (pathFinding.canPathReach(pos)) {
            return true;
        }
        BlockPos blockPos = pos.below();
        if (maid.level().getBlockState(blockPos).isSolid())
            return false;
        return pathFinding.canPathReach(blockPos);
    }
}
