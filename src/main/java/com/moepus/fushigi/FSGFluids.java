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

    public static final FluidEntry<VirtualFluid> SAVANNA_RED_GRAPEJUICE =
            REGISTRATE.virtualFluid("savanna_red_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Savanna Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> SAVANNA_WHITE_GRAPEJUICE =
            REGISTRATE.virtualFluid("savanna_white_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("Savanna White Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> TAIGA_RED_GRAPEJUICE =
            REGISTRATE.virtualFluid("taiga_red_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Taiga Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> TAIGA_WHITE_GRAPEJUICE =
            REGISTRATE.virtualFluid("taiga_white_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("Taiga White Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> JUNGLE_RED_GRAPEJUICE =
            REGISTRATE.virtualFluid("jungle_red_grapejuice",
                            Fushigi.rl("fluid/red_grapejuice_still"), Fushigi.rl("fluid/red_grapejuice_flow"))
                    .lang("Jungle Red Grape Juice")
                    .register();

    public static final FluidEntry<VirtualFluid> JUNGLE_WHITE_GRAPEJUICE =
            REGISTRATE.virtualFluid("jungle_white_grapejuice",
                            Fushigi.rl("fluid/white_grapejuice_still"), Fushigi.rl("fluid/white_grapejuice_flow"))
                    .lang("Jungle White Grape Juice")
                    .register();

    public static void register() {
    }
}
