package com.lofodras.firstmod.item;

import com.lofodras.firstmod.Lofodras1stMod;
import com.lofodras.firstmod.item.custom.ChiselItem;
import com.lofodras.firstmod.item.custom.DashItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item DASH_ITEM = registerItem("dash_item", new DashItem(new Item.Settings().maxCount(1)));

    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.lofodras_1at_mod.strawberry_tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item RUBY_POWDER = registerItem("ruby_powder", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Lofodras1stMod.MOD_ID, name), item);
    }

    public static void registerModItems () {
        Lofodras1stMod.LOGGER.info("Register Mod Items for " + Lofodras1stMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
            entries.add(RAW_RUBY);
        });
    }
}
