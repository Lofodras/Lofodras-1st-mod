package com.lofodras.firstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.Map;

public class FertilizerWandItem extends Item {

    private static final Map<Block, Block> FERTILIZER_WAND_MAP =
            Map.of(
                    Blocks.SAND, Blocks.DIRT,
                    Blocks.GRAVEL, Blocks.DIRT,
                    Blocks.DIRT, Blocks.GRASS_BLOCK
            );
    public FertilizerWandItem(Settings settings) {
        super(settings);
    }
}
