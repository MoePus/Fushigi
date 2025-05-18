package com.moepus.fushigi.compact.Vinery.Blocks;

import com.moepus.fushigi.FSGBlocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class WineBottleItem extends Item implements IWrappedBottle {
    public WineBottleItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        return this.useOn(useOnContext, FSGBlocks.WINE_BOTTLE.get());
    }
}
