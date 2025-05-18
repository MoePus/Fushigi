package com.moepus.fushigi;

import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;

import static com.moepus.fushigi.Fushigi.REGISTRATE;

public class FSGFluids {
    public static final FluidEntry<VirtualFluid> RED_GRAPEJUICE =
            REGISTRATE.virtualFluid("red_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> WHITE_GRAPEJUICE =
            REGISTRATE.virtualFluid("white_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("White Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> RED_SAVANNA_GRAPEJUICE =
            REGISTRATE.virtualFluid("red_savanna_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Savanna Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> WHITE_SAVANNA_GRAPEJUICE =
            REGISTRATE.virtualFluid("white_savanna_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("Savanna White Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> RED_TAIGA_GRAPEJUICE =
            REGISTRATE.virtualFluid("red_taiga_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Taiga Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> WHITE_TAIGA_GRAPEJUICE =
            REGISTRATE.virtualFluid("white_taiga_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("Taiga White Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> RED_JUNGLE_GRAPEJUICE =
            REGISTRATE.virtualFluid("red_jungle_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Jungle Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> WHITE_JUNGLE_GRAPEJUICE =
            REGISTRATE.virtualFluid("white_jungle_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("Jungle White Grape Juice")
                    .register();

    public static void register() {
    }
}
