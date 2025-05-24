package com.moepus.fushigi;

import com.moepus.fushigi.compact.Create.datagen.WineBottlingRecipeGen;
import com.simibubi.create.Create;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.data.recipe.*;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.platform.CatnipServices;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class FSGRecipeGen extends CreateRecipeProvider {
    protected static final List<FSGRecipeGen> GENERATORS = new ArrayList<>();

    public static void registerAll(DataGenerator gen, PackOutput output) {
        GENERATORS.add(new WineBottlingRecipeGen(output));

        gen.addProvider(true, new DataProvider() {

            @Override
            public String getName() {
                return "Fushigi's Processing Recipes";
            }

            @Override
            public CompletableFuture<?> run(CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(dc))
                        .toArray(CompletableFuture[]::new));
            }
        });
    }

    public FSGRecipeGen(PackOutput generator) {
        super(generator);
    }

    /**
     * Create a processing recipe with a single itemstack ingredient, using its id
     * as the name of the recipe
     */
    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(String namespace,
                                                                     Supplier<ItemLike> singleIngredient, UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        GeneratedRecipe generatedRecipe = c -> {
            ItemLike itemLike = singleIngredient.get();
            transform
                    .apply(new ProcessingRecipeBuilder<>(serializer.getFactory(),
                            ResourceLocation.fromNamespaceAndPath(namespace,
                                    CatnipServices.REGISTRIES.getKeyOrThrow(itemLike.asItem())
                                    .getPath())).withItemIngredients(Ingredient.of(itemLike)))
                    .build(c);
        };
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    /**
     * Create a processing recipe with a single itemstack ingredient, using its id
     * as the name of the recipe
     */
    <T extends ProcessingRecipe<?>> GeneratedRecipe create(Supplier<ItemLike> singleIngredient,
                                                           UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return create(Create.ID, singleIngredient, transform);
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe createWithDeferredId(Supplier<ResourceLocation> name,
                                                                                   UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(), name.get()))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    /**
     * Create a new processing recipe, with recipe definitions provided by the
     * function
     */
    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(ResourceLocation name,
                                                                     UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return createWithDeferredId(() -> name, transform);
    }

    /**
     * Create a new processing recipe, with recipe definitions provided by the
     * function
     */
    <T extends ProcessingRecipe<?>> GeneratedRecipe create(String name,
                                                           UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return create(Create.asResource(name), transform);
    }

    protected abstract IRecipeTypeInfo getRecipeType();

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }

    protected Supplier<ResourceLocation> idWithSuffix(Supplier<ItemLike> item, String suffix) {
        return () -> {
            ResourceLocation registryName = CatnipServices.REGISTRIES.getKeyOrThrow(item.get()
                    .asItem());
            return Create.asResource(registryName.getPath() + suffix);
        };
    }
}