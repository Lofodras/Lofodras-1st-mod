package com.lofodras.firstmod.item;

import com.lofodras.firstmod.Lofodras1stMod;
import com.lofodras.firstmod.block.ModBlocks;
import com.lofodras.firstmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup LOFODRAS_1AT_MOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Lofodras1stMod.MOD_ID, "lofodras_1st_mod"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.lofodras_1st_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.RUBY_DEEPSLATE_ORE);
                        entries.add(ModBlocks.RUBY_CHANGER_BLOCK);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.STRAWBERRY);
                        entries.add(ModItems.RUBY_POWDER);
                    }).build());

    public static void registerItemGroups() {
        Lofodras1stMod.LOGGER.info("Registering Item Groups for " + Lofodras1stMod.MOD_ID);
    }
}
