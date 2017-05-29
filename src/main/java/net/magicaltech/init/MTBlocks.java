package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.block.BlockBase;
import net.magicaltech.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTBlocks {
	
	public static Block hStone;
	
	public static void init() {
		hStone = new BlockBase("hardened_stone", 5.0F, 20.0F, "pickaxe", 1, MTCreativeTabs.blocks);
	}
	
	public static void register() {
		registerBlock(hStone);
	}

	public static void registerRenders() {
		registerRender(hStone);
	}
	
	public static void registerBlock (Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + block.getUnlocalizedName().substring(5));
	}
}
