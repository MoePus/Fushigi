package com.moepus.fushigi;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FSGTags {
    public final static TagKey<Item> GRAPE_SEED_TAG = ItemTags.create(new ResourceLocation("vinery", "grape_seeds"));
    public final static TagKey<Item> GRAPE_TAG = ItemTags.create(new ResourceLocation("vinery", "grapes"));
    public final static TagKey<Block> GRAPE_BUSH_TAG = BlockTags.create(new ResourceLocation("vinery", "grape_bushes"));
}
