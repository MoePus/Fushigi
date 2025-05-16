package com.moepus.fushigi;

import com.github.tartaricacid.touhoulittlemaid.api.ILittleMaid;
import com.github.tartaricacid.touhoulittlemaid.api.LittleMaidExtension;
import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.ExtraMaidBrainManager;
import com.github.tartaricacid.touhoulittlemaid.entity.task.TaskManager;
import com.moepus.fushigi.compact.Maid.MaidBrain;
import com.moepus.fushigi.compact.Maid.MaidTaskManager;

@LittleMaidExtension
public final class MaidPlugin implements ILittleMaid {
    @Override
    public void addMaidTask(TaskManager manager) {
        MaidTaskManager.init(manager);
    }
    @Override
    public void addExtraMaidBrain(ExtraMaidBrainManager manager) {
        manager.addExtraMaidBrain(new MaidBrain());
    }
}
