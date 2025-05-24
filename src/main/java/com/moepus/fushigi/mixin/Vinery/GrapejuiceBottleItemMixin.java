package com.moepus.fushigi.mixin.Vinery;

import com.moepus.fushigi.Fushigi;
import com.moepus.fushigi.compact.Vinery.Blocks.IWrappedBottle;
import com.moepus.fushigi.util.ItemUtil;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.satisfy.vinery.core.item.GrapejuiceBottleItem;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GrapejuiceBottleItem.class)
public abstract class GrapejuiceBottleItemMixin extends Item implements IWrappedBottle {
    public GrapejuiceBottleItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext useOnContext) {
        ItemStack bottle = useOnContext.getItemInHand();
        Item bottleItem = bottle.getItem();
        Item FSGBottleItem = ItemUtil.GetItem(Fushigi.rl(ItemUtil.GetId(bottleItem).getPath()));
        Block targetBlock = ((BlockItem) FSGBottleItem).getBlock();
        return this.useOn(useOnContext, targetBlock);
    }
}
