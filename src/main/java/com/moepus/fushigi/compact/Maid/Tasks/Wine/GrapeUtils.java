package com.moepus.fushigi.compact.Maid.Tasks.Wine;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.satisfy.vinery.core.util.GrapeProperty;
import net.satisfy.vinery.core.util.GrapeType;

import javax.annotation.Nullable;

public class GrapeUtils {
    public final static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 6);
    public final static IntegerProperty STORAGE = IntegerProperty.create("storage", 0, 6);
    public final static GrapeProperty GRAPEVINE_TYPE = GrapeProperty.create("type");
    public static @Nullable Item getGrapeType(BlockState blockState) {
        int stage = blockState.getValue(STAGE);
        GrapeType grapeType = blockState.getValue(GRAPEVINE_TYPE);
        Item grape = grapeType.getFruit() == Items.AIR || stage == 0 ? null : grapeType.getFruit();
        return grape;
    }

}
