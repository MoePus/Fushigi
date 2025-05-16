package com.moepus.fushigi.mixin.Vinery;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.vinery.core.block.GrapevinePotBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GrapevinePotBlock.class, remap = false)
public abstract class GrapevinePotBlockMixin {
    @Redirect(
            method = "fallOn",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"
            ),
            remap = true
    )
    private boolean redirectSetBlock(Level world, BlockPos pos, BlockState state, int flags) {
        if (world.random.nextFloat() < 0.3) {
            world.setBlock(pos, state, flags);
        }
        return false;
    }
}
