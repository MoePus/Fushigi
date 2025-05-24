package com.moepus.fushigi.compact.Create;

import com.moepus.fushigi.FSGBlocks;
import com.moepus.fushigi.FSGFluids;
import com.moepus.fushigi.FSGRecipeTypes;
import com.moepus.fushigi.compact.Vinery.Blocks.SimpleWineBottleBlock;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.api.registry.SimpleRegistry;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.fluids.transfer.GenericItemFilling;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import java.util.List;
import java.util.Optional;

public enum WineBottlingBehaviour implements BlockSpoutingBehaviour {
    INSTANCE;

    private WineBottlingRecipe getRecipe(Level level, FluidStack availableFluid) {
        for (Recipe<?> recipe : level.getRecipeManager()
                .getAllRecipesFor(FSGRecipeTypes.WINE_BOTTLING.getType())) {
            WineBottlingRecipe bottlingRecipe = (WineBottlingRecipe) recipe;
            FluidIngredient requiredFluid = bottlingRecipe.getRequiredFluid();
            if (requiredFluid.test(availableFluid))
                return bottlingRecipe;
        }
        return null;
    }

    @Override
    public int fillBlock(Level level, BlockPos pos, SpoutBlockEntity spout, FluidStack availableFluid, boolean simulate) {
        Fluid fluid = availableFluid.getFluid();
        if (fluid == null)
            return 0;

        WineBottlingRecipe recipe = getRecipe(level, availableFluid);
        if (recipe == null)
            return 0;

        FluidIngredient requiredFluid = recipe.getRequiredFluid();
        if (availableFluid.getAmount() < requiredFluid.getRequiredAmount())
            return 0;

        if (!simulate) {
            if (!level.getBlockState(pos).is(FSGBlocks.WINE_BOTTLE.get()))
                return 0;

            List<ItemStack> results = recipe.rollResults();
            if (results.isEmpty())
                return 0;
            ItemStack result = results.get(0);
            Block targetBlock = SimpleWineBottleBlock.getItem2BlockMap().get(result.getItem());
            if (targetBlock == null)
                return 0;
            level.setBlockAndUpdate(pos, targetBlock.defaultBlockState());
        }

        return requiredFluid.getRequiredAmount();
    }
}
