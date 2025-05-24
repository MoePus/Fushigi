package com.moepus.fushigi.compact.JEI;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Axis;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.fluid.FluidRenderer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.gui.UIRenderHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class AnimatedSpoutCustomTarget extends AnimatedKinetics {
    private List<FluidStack> fluids;
    private BlockState depotState;

    public AnimatedSpoutCustomTarget(BlockState depotState) {
        this.depotState = depotState;
    }

    public AnimatedSpoutCustomTarget withFluids(List<FluidStack> fluids) {
        this.fluids = fluids;
        return this;
    }

    public void draw(GuiGraphics graphics, int xOffset, int yOffset) {
        PoseStack matrixStack = graphics.pose();
        matrixStack.pushPose();
        matrixStack.translate((float) xOffset, (float) yOffset, 100.0F);
        matrixStack.mulPose(Axis.XP.rotationDegrees(-15.5F));
        matrixStack.mulPose(Axis.YP.rotationDegrees(22.5F));
        int scale = 20;
        this.blockElement(AllBlocks.SPOUT.getDefaultState()).scale((double) scale).render(graphics);
        float cycle = (AnimationTickHolder.getRenderTime() - (float) (this.offset * 8)) % 30.0F;
        float squeeze = cycle < 20.0F ? Mth.sin((float) ((double) (cycle / 20.0F) * Math.PI)):0.0F;
        squeeze *= 20.0F;
        matrixStack.pushPose();
        this.blockElement(AllPartialModels.SPOUT_TOP).scale((double) scale).render(graphics);
        matrixStack.translate(0.0F, -3.0F * squeeze / 32.0F, 0.0F);
        this.blockElement(AllPartialModels.SPOUT_MIDDLE).scale((double) scale).render(graphics);
        matrixStack.translate(0.0F, -3.0F * squeeze / 32.0F, 0.0F);
        this.blockElement(AllPartialModels.SPOUT_BOTTOM).scale((double) scale).render(graphics);
        matrixStack.translate(0.0F, -3.0F * squeeze / 32.0F, 0.0F);
        matrixStack.popPose();
        this.blockElement(depotState).atLocal((double) 0.0F, (double) 2.0F, (double) 0.0F).scale((double) scale).render(graphics);
        AnimatedKinetics.DEFAULT_LIGHTING.applyLighting();
        MultiBufferSource.BufferSource buffer = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
        matrixStack.pushPose();
        UIRenderHelper.flipForGuiRender(matrixStack);
        matrixStack.scale(16.0F, 16.0F, 16.0F);
        float from = 0.1875F;
        float to = 1.0625F;
        FluidStack fluidStack = (FluidStack) this.fluids.get(0);
        FluidRenderer.renderFluidBox(fluidStack.getFluid(), (long) fluidStack.getAmount(), from, from, from, to, to, to, buffer, matrixStack, 15728880, false, true, fluidStack.getTag());
        matrixStack.popPose();
        float width = 0.0078125F * squeeze;
        matrixStack.translate((float) scale / 2.0F, (float) scale * 1.5F, (float) scale / 2.0F);
        UIRenderHelper.flipForGuiRender(matrixStack);
        matrixStack.scale(16.0F, 16.0F, 16.0F);
        matrixStack.translate(-0.5F, 0.0F, -0.5F);
        from = -width / 2.0F + 0.5F;
        to = width / 2.0F + 0.5F;
        FluidRenderer.renderFluidBox(fluidStack.getFluid(), (long) fluidStack.getAmount(), from, 0.0F, from, to, 2.0F, to, buffer, matrixStack, 15728880, false, true, fluidStack.getTag());
        buffer.endBatch();
        Lighting.setupFor3DItems();
        matrixStack.popPose();
    }
}
