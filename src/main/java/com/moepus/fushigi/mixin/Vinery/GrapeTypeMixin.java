package com.moepus.fushigi.mixin.Vinery;

import com.moepus.fushigi.compact.Vinery.GrapeTypeFluidInterface;
import com.moepus.fushigi.compact.Vinery.GrapeTypeFluids;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.world.level.material.Fluid;
import net.satisfy.vinery.core.util.GrapeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(value = GrapeType.class, remap = false)
public abstract class GrapeTypeMixin implements GrapeTypeFluidInterface {
    @Unique
    private FluidEntry<VirtualFluid> fluid;

    @Inject(method = "<init>(Ljava/lang/String;Ljava/util/function/Supplier;Ljava/util/function/Supplier;Ljava/util/function/Supplier;Z)V", at = @At("RETURN"))
    void onInit(String id, Supplier fruit, Supplier seeds, Supplier bottle, boolean lattice, CallbackInfo ci) {
        fluid = GrapeTypeFluids.fluids.get(id);
        if (fluid == null) {
            throw new IllegalArgumentException("Fluid not found for GrapeType: " + id);
        }
    }

    @Override
    public Fluid getFluid() {
        return fluid.get();
    }
}
