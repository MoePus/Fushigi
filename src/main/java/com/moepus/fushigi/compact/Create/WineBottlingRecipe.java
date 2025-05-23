package com.moepus.fushigi.compact.Create;

import com.moepus.fushigi.FSGRecipeTypes;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class WineBottlingRecipe extends ProcessingRecipe<RecipeWrapper> {
    public WineBottlingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(FSGRecipeTypes.WINE_BOTTLING, params);
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 1;
    }

    @Override
    protected int getMaxFluidInputCount() {
        return 1;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        return ingredients.get(0)
                .test(inv.getItem(0));
    }

    public FluidIngredient getRequiredFluid() {
        if (fluidIngredients.isEmpty())
            throw new IllegalStateException("Filling Recipe: " + id.toString() + " has no fluid ingredient!");
        return fluidIngredients.get(0);
    }
}
