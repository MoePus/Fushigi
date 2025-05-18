package com.moepus.fushigi.compact.Create;

import com.moepus.fushigi.FSGBlocks;
import com.moepus.fushigi.FSGFluids;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.api.registry.SimpleRegistry;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;

public enum WineBottlingBehaviour implements BlockSpoutingBehaviour {
    INSTANCE;
    public static final SimpleRegistry<FluidType, BlockEntry<?>> WINE_INFO = Util.make(() -> {
        SimpleRegistry<FluidType, BlockEntry<?>> registry = SimpleRegistry.create();
        registry.register(FSGFluids.RED_GRAPEJUICE.get().getFluidType(), FSGBlocks.RED_GRAPEJUICE);
        registry.register(FSGFluids.WHITE_GRAPEJUICE.get().getFluidType(), FSGBlocks.WHITE_GRAPEJUICE);
        registry.register(FSGFluids.RED_TAIGA_GRAPEJUICE.get().getFluidType(), FSGBlocks.RED_TAIGA_GRAPEJUICE);
        registry.register(FSGFluids.WHITE_TAIGA_GRAPEJUICE.get().getFluidType(), FSGBlocks.WHITE_TAIGA_GRAPEJUICE);
        registry.register(FSGFluids.RED_JUNGLE_GRAPEJUICE.get().getFluidType(), FSGBlocks.RED_JUNGLE_GRAPEJUICE);
        registry.register(FSGFluids.WHITE_JUNGLE_GRAPEJUICE.get().getFluidType(), FSGBlocks.WHITE_JUNGLE_GRAPEJUICE);
        registry.register(FSGFluids.RED_SAVANNA_GRAPEJUICE.get().getFluidType(), FSGBlocks.RED_SAVANNA_GRAPEJUICE);
        registry.register(FSGFluids.WHITE_SAVANNA_GRAPEJUICE.get().getFluidType(), FSGBlocks.WHITE_SAVANNA_GRAPEJUICE);
        return registry;
    });
    private static final int amount = 250;

    @Override
    public int fillBlock(Level level, BlockPos pos, SpoutBlockEntity spout, FluidStack availableFluid, boolean simulate) {
        if (availableFluid.getAmount() < amount)
            return 0;

        Fluid fluid = availableFluid.getFluid();
        if (fluid==null)
            return 0;

        BlockEntry<?> targetBlock = WINE_INFO.get(fluid.getFluidType());
        if (targetBlock==null)
            return 0;

        if (!simulate) {
            level.setBlockAndUpdate(pos, targetBlock.get().defaultBlockState());
        }

        return amount;
    }
}
