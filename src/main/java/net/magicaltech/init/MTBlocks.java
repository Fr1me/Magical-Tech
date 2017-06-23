package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.block.BlockBase;
import net.magicaltech.block.BlockCraftingBase;
import net.magicaltech.block.BlockGeneratorBase;
import net.magicaltech.block.BlockMachineBase;
import net.magicaltech.block.BlockNetherOreBase;
import net.magicaltech.block.BlockOreBase;
import net.magicaltech.block.crop.BlockCropBase;
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
	public static Block rQBlock;
	
//	Ores
	public static Block rQOre;
	public static Block plOre;
	
//	Nether Ores
	public static Block rQNetherOre;
	public static Block plNetherOre;
	
//	Machines
	public static Block cGen;
	public static Block mGen;
	public static Block nnGen;
	public static Block fGen;
	public static Block grinder;
	
	public static Block crafterT1;
	public static Block crafterT2;
	public static Block crafterT3;
	public static Block crafterTC;
	
	public static Block crafter;
	
//	Crops
	public static Block cropTransition;
	public static Block testCrop;
	
	public static void init() {
//		Normal Blocks
		hStone = new BlockOreBase("hardened_stone");
		
		tBlock = new BlockBase("transistium_block");
		pIBlock = new BlockBase("prophecy_iron_block");
		rQBlock = new BlockBase("rose_quartz_block");
		
//		Ores
		rQOre = new BlockOreBase("rose_quartz_ore");
		plOre = new BlockOreBase("prophecy_iron_ore");
		
//		Nether Ores
		rQNetherOre = new BlockNetherOreBase("rose_quartz_nether_ore");
		plNetherOre = new BlockNetherOreBase("prophecy_iron_nether_ore");
			
//		Machines
		cGen = new BlockGeneratorBase("coal");
		mGen = new BlockGeneratorBase("magic");
		nnGen = new BlockGeneratorBase("nuff_nuff");
		fGen = new BlockGeneratorBase("fluffy");
		
		grinder = new BlockMachineBase("grinder");
		
		crafter = new BlockCraftingBase("crafter");
		
//		crafterT1 = new BlockCraftingBase("crafter_tire_1");
//		crafterT2 = new BlockCraftingBase("crafter_tire_2");
//		crafterT3 = new BlockCraftingBase("crafter_tire_3");
//		crafterTC = new BlockCraftingBase("crafter_creative");
		
//		Crops
		cropTransition = new BlockCropBase("transition_plant", MTItems.seedTransition, MTItems.tFragment);
		testCrop = new BlockCropBase("test_crop", MTItems.magicWand, MTItems.seedTransition);
	}
	
	public static void register() {
//		Normal Blocks
		registerBlock(hStone);
		
		registerBlock(tBlock);
		registerBlock(pIBlock);
		registerBlock(rQBlock);
		
//		Ores
		registerBlock(rQOre);
		registerBlock(plOre);
		
//		Nether Ores
		registerBlock(rQNetherOre);
		registerBlock(plNetherOre);
		
//		Machines
		registerBlock(cGen);
		registerBlock(mGen);
		registerBlock(nnGen);
		registerBlock(fGen);
		
		registerBlock(grinder);
		
//		registerBlock(crafterT1);
//		registerBlock(crafterT2);
//		registerBlock(crafterT3);
//		registerBlock(crafterTC);
		
//		Crops
		registerBlockSpecial(cropTransition);
	}

	public static void registerRenders() {
//		Normal Blocks
		registerRender(hStone);
		
		registerRender(tBlock);
		registerRender(pIBlock);
		registerRender(rQBlock);
		
//		Ores
		registerRender(rQOre);
		registerRender(plOre);
		
//		Nether Ores
		registerRender(rQNetherOre);
		registerRender(plNetherOre);
		
//		Machines
		registerRender(cGen);
		registerRender(mGen);
		registerRender(nnGen);
		registerRender(grinder);
		
//		registerRender(crafterT1);
//		registerRender(crafterT2);
//		registerRender(crafterT3);
//		registerRender(crafterTC);
		
		registerRender(cropTransition);
		
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlockSpecial(Block block) {
		GameRegistry.register(block);
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + block.getUnlocalizedName().substring(5));
	}
}
