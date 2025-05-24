package com.moepus.fushigi;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

public class FSGDataGen {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        if (event.includeServer()) {
            FSGRecipeGen.registerAll(generator, output);
        }
    }
}
