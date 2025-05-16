package com.moepus.fushigi.mixin.Create;

import com.moepus.fushigi.FSGFluids;
import com.moepus.fushigi.compact.Vinery.GrapeTypeFluidInterface;
import com.simibubi.create.content.fluids.pipes.VanillaFluidTargets;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.fluids.FluidStack;
import net.satisfy.vinery.core.registry.ObjectRegistry;
import net.satisfy.vinery.core.util.GrapeProperty;
import net.satisfy.vinery.core.util.GrapeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = VanillaFluidTargets.class, remap = false)
public abstract class VanillaFluidTargetsMixin {
    @Unique
    private final static IntegerProperty fushigi$STAGE = IntegerProperty.create("stage", 0, 6);
    @Unique
    private final static IntegerProperty fushigi$STORAGE = IntegerProperty.create("storage", 0, 6);
    @Unique
    private final static GrapeProperty fushigi$GRAPEVINE_TYPE = GrapeProperty.create("type");

    @Inject(method = "canProvideFluidWithoutCapability", at = @At("HEAD"), cancellable = true)
    private static void extraCanProvideFluidWithoutCapability(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(ObjectRegistry.GRAPEVINE_POT.get())) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "drainBlock", at = @At("HEAD"), cancellable = true)
    private static void extraDrainBlock(Level level, BlockPos pos, BlockState state, boolean simulate, CallbackInfoReturnable<FluidStack> cir) {
        if (state.is(ObjectRegistry.GRAPEVINE_POT.get())) {
            if (state.getValue(fushigi$STAGE)!=6) return;
            int storage = state.getValue(fushigi$STORAGE) / 3;
            if (storage <= 0) return;
            GrapeType grapeType = state.getValue(fushigi$GRAPEVINE_TYPE);
            if (!simulate) {
                level.setBlock(pos, ObjectRegistry.GRAPEVINE_POT.get().defaultBlockState(), 3);
            }

            cir.setReturnValue(new FluidStack(((GrapeTypeFluidInterface) grapeType).getFluid(), 250 * storage));
        }
    }
}
