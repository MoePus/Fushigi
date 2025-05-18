package com.moepus.fushigi;

import com.moepus.fushigi.compact.Create.WineBottlingBehaviour;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;

public class FSGBehaviours {
    public static void register() {
        BlockSpoutingBehaviour.BY_BLOCK.register(FSGBlocks.WINE_BOTTLE.get(), WineBottlingBehaviour.INSTANCE);
    }
}
