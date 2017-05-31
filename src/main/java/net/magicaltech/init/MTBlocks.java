package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.block.BlockBase;
import net.magicaltech.block.crop.BlockCropTransition;
import net.magicaltech.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTBlocks {
	
//	Normal Blocks
	public static Block hStone;
	
//	Machines
	public static Block cGen;
	public static Block grinder;
	
//	Crops
	public static Block cropTransition;
	
	public static void init() {
//		Normal Blocks
		hStone = new BlockBase("hardened_stone", 5.0F, 20.0F, "pickaxe", 1, MTCreativeTabs.blocks);
		
//		Machines
		cGen = new BlockBase("coal_generator", 0, 0, "pickaxe", 0, MTCreativeTabs.machines);
		grinder = new BlockBase("grinder", 0, 0, "pickaxe", 0, MTCreativeTabs.machines);
		
//		Crops
		cropTransition = new BlockCropTransition("transition_plant");
	}
	
	public static void register() {
//		Normal Blocks
		registerBlock(hStone);
		
//		Machines
		registerBlock(cGen);
		registerBlock(grinder);
		
//		Crops
		GameRegistry.register(cropTransition);
	}

	public static void registerRenders() {
//		Normal Blocks
		registerRender(hStone);
		
//		Machines
		registerRender(cGen);
		registerRender(grinder);
		
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
