package com.moepus.fushigi;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fushigi.MODID)
public class Fushigi {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "fushigi";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Fushigi() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FSGFluids.register();
        FSGBlocks.register();
        CreativeTab.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
        REGISTRATE.registerEventListeners(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FSGBehaviours.register();
        });
    }

    public static ResourceLocation rl(String path){
        return new ResourceLocation(MODID, path);
    }

    public static Component lang(String path, Object... args) {
        return Component.translatable(MODID+"."+path, args);
    }
}

