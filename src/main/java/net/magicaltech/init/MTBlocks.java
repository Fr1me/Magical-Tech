package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.block.BlockCoalGenerator;
import net.magicaltech.block.BlockLevitator;
import net.magicaltech.block.BlockMachineBase;
import net.magicaltech.block.BlockGeneratedBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xfireeyez.core.block.BlockBase;
import xfireeyez.core.block.BlockCropBase;
import xfireeyez.core.util.Utils;

public class MTBlocks {
	
//	Normal Blocks
	public static Block hStone;
	public static Block tBlock;
	public static Block pIBlock;
	
//	Ores
	public static Block rQOre;
	
//	Machines
	public static Block cGen;
	public static Block grinder;
	
//	Crops
	public static Block cropTransition;
	
//	Special Blocks
	public static Block levitator;
	
	public static void init() {
//		Normal Blocks
		tBlock = new BlockBase("transistium_block", MTCreativeTabs.blocks, 5.0F, 20.0F, "pickaxe", 0, Material.IRON);
		pIBlock = new BlockBase("prophecy_iron_block", MTCreativeTabs.blocks, 5.0F, 20.0F, "pickaxe", 0, Material.IRON);
		
//		Worldgen Blocks
		hStone = new BlockGeneratedBase("hardened_stone", 5.0F, 20.0F, "pickaxe", 1);
		rQOre = new BlockGeneratedBase("rose_quartz_ore", 5.0F, 20.0F, "pickaxe", 0);
			
//		Machines
		cGen = new BlockCoalGenerator("coal_generator", 5.0F, 20.0F, "pickaxe", 0);
		grinder = new BlockMachineBase("grinder", 5.0F, 20.0F, "pickaxe", 0);
		
//		Crops
		cropTransition = new BlockCropBase("transition_plant", MTItems.seedTransition, MTItems.tTFragment);
		
//		Special Blocks
		levitator = new BlockLevitator("levitator");
	}
	
	public static void register() {
//		Normal Blocks
		registerBlock(hStone);
		registerBlock(tBlock);
		registerBlock(pIBlock);
		
//		Ores
		registerBlock(rQOre);
		
//		Machines
		registerBlock(cGen);
		registerBlock(grinder);
		
//		Crops
		GameRegistry.register(cropTransition);
		
//		Special Blocks
		registerBlock(levitator);
	}

	public static void registerRenders() {
//		Normal Blocks
		registerRender(hStone);
		registerRender(tBlock);
		registerRender(pIBlock);
		
//		Ores
		registerRender(rQOre);
		
//		Machines
		registerRender(cGen);
		registerRender(grinder);
		
//		Special Blocks
		registerRender(levitator);
		
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
