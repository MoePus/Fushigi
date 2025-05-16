package com.moepus.fushigi.compact.Vinery;

import com.moepus.fushigi.FSGFluids;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;

import java.util.Map;

public class GrapeTypeFluids {
    public static Map<String, FluidEntry<VirtualFluid>> fluids = Map.of(
            "none", FSGFluids.RED_GRAPEJUICE,
            "red", FSGFluids.RED_GRAPEJUICE,
            "white", FSGFluids.WHITE_GRAPEJUICE,
            "savanna_red", FSGFluids.SAVANNA_RED_GRAPEJUICE,
            "savanna_white", FSGFluids.SAVANNA_WHITE_GRAPEJUICE,
            "taiga_red", FSGFluids.TAIGA_RED_GRAPEJUICE,
            "taiga_white", FSGFluids.TAIGA_WHITE_GRAPEJUICE,
            "jungle_red", FSGFluids.JUNGLE_RED_GRAPEJUICE,
            "jungle_white", FSGFluids.JUNGLE_WHITE_GRAPEJUICE
    );
}
