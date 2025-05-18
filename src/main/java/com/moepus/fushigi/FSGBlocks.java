package com.moepus.fushigi;

import com.moepus.fushigi.compact.Vinery.Blocks.SimpleWineBottleBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;

import static com.moepus.fushigi.Fushigi.REGISTRATE;
public class FSGBlocks {

    public static final BlockEntry<SimpleWineBottleBlock> WINE_BOTTLE = REGISTRATE.block("wine_bottle", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Wine Bottle")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_GRAPEJUICE = REGISTRATE.block("red_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("Red Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_GRAPEJUICE = REGISTRATE.block("white_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .lang("White Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_SAVANNA_GRAPEJUICE = REGISTRATE.block("red_savanna_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Red Savanna Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_SAVANNA_GRAPEJUICE = REGISTRATE.block("white_savanna_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("White Savanna Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_TAIGA_GRAPEJUICE = REGISTRATE.block("red_taiga_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Red Taiga Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_TAIGA_GRAPEJUICE = REGISTRATE.block("white_taiga_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("White Taiga Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> RED_JUNGLE_GRAPEJUICE = REGISTRATE.block("red_jungle_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Red Jungle Grape Juice")
            .simpleItem()
            .register();

    public static final BlockEntry<SimpleWineBottleBlock> WHITE_JUNGLE_GRAPEJUICE = REGISTRATE.block("white_jungle_grapejuice", SimpleWineBottleBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.instabreak())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("White Jungle Grape Juice")
            .simpleItem()
            .register();

    public static void register() {
    }
}
