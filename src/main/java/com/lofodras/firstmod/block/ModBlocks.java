package com.lofodras.firstmod.block;

import com.lofodras.firstmod.Lofodras1stMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block RUBY_DEEPSLATE_ORE = registerBlock("ruby_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Lofodras1stMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Lofodras1stMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        Lofodras1stMod.LOGGER.info("Registering Mod Blocks for " + Lofodras1stMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
            entries.add(ModBlocks.RAW_RUBY_BLOCK);
        });
    }
}
