package com.moepus.fushigi;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fushigi.MODID);
    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = TAB_REGISTER.register("fsg_creative_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.fsg_creative_tab"))
                    .icon(FSGBlocks.WINE_BOTTLE::asStack)
                    .displayItems((pParameters, output) -> {
                        output.accept(FSGBlocks.WINE_BOTTLE.get());
                        output.accept(FSGBlocks.RED_GRAPEJUICE.get());
                        output.accept(FSGBlocks.WHITE_GRAPEJUICE.get());
                        output.accept(FSGBlocks.RED_SAVANNA_GRAPEJUICE.get());
                        output.accept(FSGBlocks.WHITE_SAVANNA_GRAPEJUICE.get());
                        output.accept(FSGBlocks.RED_TAIGA_GRAPEJUICE.get());
                        output.accept(FSGBlocks.WHITE_TAIGA_GRAPEJUICE.get());
                        output.accept(FSGBlocks.RED_JUNGLE_GRAPEJUICE.get());
                        output.accept(FSGBlocks.WHITE_JUNGLE_GRAPEJUICE.get());
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        TAB_REGISTER.register(modEventBus);
    }
}
