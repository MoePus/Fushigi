package com.moepus.fushigi.compact.Maid;

import com.github.tartaricacid.touhoulittlemaid.entity.task.TaskManager;
import com.moepus.fushigi.compact.Maid.Tasks.Wine.WineTask;

public final class MaidTaskManager {
    public static void init(TaskManager manager) {
        manager.add(new WineTask());
    }
}
