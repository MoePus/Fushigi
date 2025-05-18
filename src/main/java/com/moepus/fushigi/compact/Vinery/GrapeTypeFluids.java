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
            "savanna_red", FSGFluids.RED_SAVANNA_GRAPEJUICE,
            "savanna_white", FSGFluids.WHITE_SAVANNA_GRAPEJUICE,
            "taiga_red", FSGFluids.RED_TAIGA_GRAPEJUICE,
            "taiga_white", FSGFluids.WHITE_TAIGA_GRAPEJUICE,
            "jungle_red", FSGFluids.RED_JUNGLE_GRAPEJUICE,
            "jungle_white", FSGFluids.WHITE_JUNGLE_GRAPEJUICE
    );
}
