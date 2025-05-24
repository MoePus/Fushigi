package com.moepus.fushigi.compact.JEI;

import com.moepus.fushigi.FSGBlocks;
import com.moepus.fushigi.compact.Create.WineBottlingRecipe;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedSpout;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

public class WineBottlingCategory extends CreateRecipeCategory<WineBottlingRecipe> {
    private final AnimatedSpoutCustomTarget spout = new AnimatedSpoutCustomTarget(FSGBlocks.WINE_BOTTLE.get().defaultBlockState());

    public WineBottlingCategory(Info<WineBottlingRecipe> info) {
        super(info);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WineBottlingRecipe recipe, IFocusGroup iFocusGroup) {
        addFluidSlot(builder, 27, 32, recipe.getRequiredFluid());

        ProcessingOutput output = recipe.getRollableResults().get(0);
        builder
                .addSlot(RecipeIngredientRole.OUTPUT, 132, 51)
                .setBackground(getRenderedSlot(output), -1, -1)
                .addItemStack(output.getStack())
                .addRichTooltipCallback(addStochasticTooltip(output));
    }

    @Override
    public void draw(WineBottlingRecipe recipe, @NotNull IRecipeSlotsView iRecipeSlotsView, @NotNull GuiGraphics graphics, double mouseX, double mouseY) {
        AllGuiTextures.JEI_SHADOW.render(graphics, 62, 57);
        AllGuiTextures.JEI_DOWN_ARROW.render(graphics, 126, 29);
        spout.withFluids(recipe.getRequiredFluid()
                        .getMatchingFluidStacks())
                .draw(graphics, getBackground().getWidth() / 2 - 13, 22);
    }
}
