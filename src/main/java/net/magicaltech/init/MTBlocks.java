package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.block.BlockBase;
import net.magicaltech.block.BlockCoalGenerator;
import net.magicaltech.block.BlockMachineBase;
import net.magicaltech.block.BlockOreBase;
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
	public static Block tBlock;
	public static Block pIBlock;
	
//	Ores
	public static Block rQOre;
	
//	Machines
	public static Block cGen;
	public static Block grinder;
	
//	Crops
	public static Block cropTransition;
	
	public static void init() {
//		Normal Blocks
		hStone = new BlockOreBase("hardened_stone", 5.0F, 20.0F, "pickaxe", 1);
		tBlock = new BlockBase("transistium_block", 5.0F, 20.0F, "pickaxe", 0);
		pIBlock = new BlockBase("prophecy_iron_block", 5.0F, 20.0F, "pickaxe", 0);
		
//		Ores
		rQOre = new BlockOreBase("rose_quartz_ore", 0, 0, "pickaxe", 0);
			
//		Machines
		cGen = new BlockCoalGenerator("coal_generator", 5.0F, 20.0F, "pickaxe", 0);
		grinder = new BlockMachineBase("grinder", 0, 0, "pickaxe", 0);
		
//		Crops
		cropTransition = new BlockCropTransition("transition_plant");
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
