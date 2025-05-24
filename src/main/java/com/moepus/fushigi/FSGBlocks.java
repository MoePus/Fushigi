package com.moepus.fushigi;

import com.moepus.fushigi.compact.Vinery.Blocks.SimpleWineBottleBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Blocks;
import net.satisfy.vinery.core.registry.ObjectRegistry;

import static com.moepus.fushigi.Fushigi.REGISTRATE;

public class FSGBlocks {

    public static final BlockEntry<SimpleWineBottleBlock> WINE_BOTTLE = REGISTRATE.block("wine_bottle", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.WINE_BOTTLE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Wine Bottle")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_GRAPEJUICE = REGISTRATE.block("red_grapejuice",  (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.RED_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Red Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_GRAPEJUICE = REGISTRATE.block("white_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.WHITE_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("White Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_SAVANNA_GRAPEJUICE = REGISTRATE.block("red_savanna_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.RED_SAVANNA_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Red Savanna Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_SAVANNA_GRAPEJUICE = REGISTRATE.block("white_savanna_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.WHITE_SAVANNA_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("White Savanna Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_TAIGA_GRAPEJUICE = REGISTRATE.block("red_taiga_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.RED_TAIGA_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Red Taiga Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_TAIGA_GRAPEJUICE = REGISTRATE.block("white_taiga_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.WHITE_TAIGA_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("White Taiga Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_JUNGLE_GRAPEJUICE = REGISTRATE.block("red_jungle_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.RED_JUNGLE_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Red Jungle Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_JUNGLE_GRAPEJUICE = REGISTRATE.block("white_jungle_grapejuice", (p) ->
                    new SimpleWineBottleBlock(ObjectRegistry.WHITE_JUNGLE_GRAPEJUICE, p)
            )
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("White Jungle Grape Juice")
            .blockstate((c, p) -> {
            })
            .item()
            .model((c, p) -> {
            })
            .build()
            .register();

    public static void register() {
    }
}
