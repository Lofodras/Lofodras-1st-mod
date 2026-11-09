package com.lofodras.firstmod;

import com.lofodras.firstmod.block.ModBlocks;
import com.lofodras.firstmod.item.ModItemGroups;
import com.lofodras.firstmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lofodras1stMod implements ModInitializer {
	public static final String MOD_ID = "lofodras_1st_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
