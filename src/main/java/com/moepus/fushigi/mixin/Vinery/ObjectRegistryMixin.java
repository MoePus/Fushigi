package com.moepus.fushigi.mixin.Vinery;

import com.moepus.fushigi.compact.Vinery.Blocks.WineBottleItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.satisfy.vinery.core.registry.ObjectRegistry;
import net.satisfy.vinery.core.util.GeneralUtil;
import net.satisfy.vinery.core.util.VineryIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.Supplier;

import static net.satisfy.vinery.core.registry.ObjectRegistry.ITEMS;
import static net.satisfy.vinery.core.registry.ObjectRegistry.ITEM_REGISTRAR;

@Mixin(value = ObjectRegistry.class, remap = false)
public abstract class ObjectRegistryMixin {
    /**
     * @author MoePus
     * @reason Replace the itemsupplier with a custom one
     */
    @Overwrite
    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        switch (path) {
            case "wine_bottle" -> {
                return fushigi$registerItem(new VineryIdentifier(path),
                        () -> (T) new WineBottleItem(new Item.Properties()));
            }
        }
        return fushigi$registerItem(new VineryIdentifier(path), itemSupplier);
    }

    @Unique
    private static <T extends Item> RegistrySupplier<T> fushigi$registerItem(ResourceLocation path, Supplier<T> itemSupplier) {
        return GeneralUtil.registerItem(ITEMS, ITEM_REGISTRAR, path, itemSupplier);
    }
}
