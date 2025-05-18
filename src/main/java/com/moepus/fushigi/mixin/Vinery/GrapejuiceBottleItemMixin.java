package com.moepus.fushigi.mixin.Vinery;

import com.moepus.fushigi.FSGBlocks;
import com.moepus.fushigi.compact.Vinery.Blocks.IWrappedBottle;
import com.moepus.fushigi.compact.Vinery.Blocks.SimpleWineBottleBlock;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.satisfy.vinery.core.item.GrapejuiceBottleItem;
import net.satisfy.vinery.core.registry.ObjectRegistry;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;
import java.util.function.Supplier;

@Mixin(GrapejuiceBottleItem.class)
public abstract class GrapejuiceBottleItemMixin extends Item implements IWrappedBottle {
    public GrapejuiceBottleItemMixin(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext useOnContext) {
        ItemStack bottle = useOnContext.getItemInHand();
        Block targetBlock = SimpleWineBottleBlock.getItem2BlockMap().get(bottle.getItem());
        if (targetBlock==null) {
            return InteractionResult.PASS;
        }
        return this.useOn(useOnContext, targetBlock);
    }
}
