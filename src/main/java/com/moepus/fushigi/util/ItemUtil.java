package com.moepus.fushigi.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ItemUtil {
    public static ResourceLocation GetId(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }

    public static Item GetItem(ResourceLocation id) {
        return BuiltInRegistries.ITEM.get(id);
    }
}
