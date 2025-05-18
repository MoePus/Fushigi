package com.moepus.fushigi.compact.Vinery.Blocks;

import com.moepus.fushigi.FSGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.vinery.core.registry.ObjectRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SimpleWineBottleBlock extends Block {
    private static final VoxelShape SHAPE = Shapes.box(0.125, 0, 0.125, 0.875, 0.875, 0.875);

    public SimpleWineBottleBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @NotNull BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (direction==Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos)) {
            levelAccessor.destroyBlock(blockPos, true);
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    static public final Supplier<Map<Block, Item>> Block2ItemSupplier = () -> Map.of(
            FSGBlocks.WINE_BOTTLE.get(), ObjectRegistry.WINE_BOTTLE.get(),
            FSGBlocks.RED_GRAPEJUICE.get(), ObjectRegistry.RED_GRAPEJUICE.get(),
            FSGBlocks.WHITE_GRAPEJUICE.get(), ObjectRegistry.WHITE_GRAPEJUICE.get(),
            FSGBlocks.RED_TAIGA_GRAPEJUICE.get(), ObjectRegistry.RED_TAIGA_GRAPEJUICE.get(),
            FSGBlocks.WHITE_TAIGA_GRAPEJUICE.get(), ObjectRegistry.WHITE_TAIGA_GRAPEJUICE.get(),
            FSGBlocks.RED_JUNGLE_GRAPEJUICE.get(), ObjectRegistry.RED_JUNGLE_GRAPEJUICE.get(),
            FSGBlocks.WHITE_JUNGLE_GRAPEJUICE.get(), ObjectRegistry.WHITE_JUNGLE_GRAPEJUICE.get(),
            FSGBlocks.RED_SAVANNA_GRAPEJUICE.get(), ObjectRegistry.RED_SAVANNA_GRAPEJUICE.get(),
            FSGBlocks.WHITE_SAVANNA_GRAPEJUICE.get(), ObjectRegistry.WHITE_SAVANNA_GRAPEJUICE.get()
    );
    static private Map<Item, Block> item2BlockMap = null;

    static public Map<Block, Item> getBlock2ItemMap() {
        return Block2ItemSupplier.get();
    }

    static public Map<Item, Block> getItem2BlockMap() {
        if (item2BlockMap==null) {
            item2BlockMap = Block2ItemSupplier.get().entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        }
        return item2BlockMap;
    }

    @Override
    public Item asItem() {
        return getBlock2ItemMap().get(this);
    }
}
