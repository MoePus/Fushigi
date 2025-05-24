package com.moepus.fushigi.compact.Create.datagen;

import com.moepus.fushigi.*;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.PackOutput;
import net.satisfy.vinery.core.registry.ObjectRegistry;

import java.util.function.UnaryOperator;

public class WineBottlingRecipeGen extends FSGRecipeGen {
    GeneratedRecipe
            RED_GRAPEJUICE = create("red_grapejuice", b -> b.require(FSGFluids.RED_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.RED_GRAPEJUICE.get())),
            WHITE_GRAPEJUICE = create("white_grapejuice", b -> b.require(FSGFluids.WHITE_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.WHITE_GRAPEJUICE.get())),
            RED_TAIGA_GRAPEJUICE = create("red_taiga_grapejuice", b -> b.require(FSGFluids.RED_TAIGA_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.RED_TAIGA_GRAPEJUICE.get())),
            WHITE_TAIGA_GRAPEJUICE = create("white_taiga_grapejuice", b -> b.require(FSGFluids.WHITE_TAIGA_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.WHITE_TAIGA_GRAPEJUICE.get())),
            RED_JUNGLE_GRAPEJUICE = create("red_jungle_grapejuice", b -> b.require(FSGFluids.RED_JUNGLE_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.RED_JUNGLE_GRAPEJUICE.get())),
            WHITE_JUNGLE_GRAPEJUICE = create("white_jungle_grapejuice", b -> b.require(FSGFluids.WHITE_JUNGLE_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.WHITE_JUNGLE_GRAPEJUICE.get())),
            RED_SAVANNA_GRAPEJUICE = create("red_savanna_grapejuice", b -> b.require(FSGFluids.RED_SAVANNA_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.RED_SAVANNA_GRAPEJUICE.get())),
            WHITE_SAVANNA_GRAPEJUICE = create("white_savanna_grapejuice", b -> b.require(FSGFluids.WHITE_SAVANNA_GRAPEJUICE.get(), 250)
            .output(ObjectRegistry.WHITE_SAVANNA_GRAPEJUICE.get()))
                    ;

    public WineBottlingRecipeGen(PackOutput generator) {
        super(generator);
    }

    <T extends ProcessingRecipe<?>> CreateRecipeProvider.GeneratedRecipe create(String name, UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return this.create(Fushigi.rl(name), transform);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return FSGRecipeTypes.WINE_BOTTLING;
    }
}
