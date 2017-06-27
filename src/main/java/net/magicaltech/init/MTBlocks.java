package net.magicaltech.init;

import net.magicaltech.MagicalTech;
import net.magicaltech.blocks.BlockCraftingBase;
import net.magicaltech.blocks.BlockGeneratorBase;
import net.magicaltech.blocks.BlockResearchTable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;
import net.thegaminghuskymc.huskylib.blocks.BlockMachineBase;
import net.thegaminghuskymc.huskylib.blocks.BlockNetherOreBase;
import net.thegaminghuskymc.huskylib.blocks.BlockOreBase;

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
	
	public static Block researchTable;
	
	public static void init() {
//		Normal Blocks
		hStone = new BlockOreBase("hardened_stone", MTCreativeTabs.worldgen);
		
		tBlock = new BlockBase("transistium_block", MTCreativeTabs.blocks);
		pIBlock = new BlockBase("prophecy_iron_block", MTCreativeTabs.blocks);
		rQBlock = new BlockBase("rose_quartz_block", MTCreativeTabs.blocks);
		
//		Ores
		rQOre = new BlockOreBase("rose_quartz_ore", MTCreativeTabs.worldgen);
		plOre = new BlockOreBase("prophecy_iron_ore", MTCreativeTabs.worldgen);
		
//		Nether Ores
		rQNetherOre = new BlockNetherOreBase("rose_quartz_nether_ore", MTCreativeTabs.worldgen);
		plNetherOre = new BlockNetherOreBase("prophecy_iron_nether_ore", MTCreativeTabs.worldgen);
			
//		Machines
		cGen = new BlockGeneratorBase("coal", MTCreativeTabs.machines);
		mGen = new BlockGeneratorBase("magic", MTCreativeTabs.machines);
		nnGen = new BlockGeneratorBase("nuff_nuff", MTCreativeTabs.machines);
		fGen = new BlockGeneratorBase("fluffy", MTCreativeTabs.machines);
		
		grinder = new BlockMachineBase("grinder", MTCreativeTabs.machines);
		
		crafter = new BlockCraftingBase("crafter", MTCreativeTabs.machines);
		
		crafterT1 = new BlockCraftingBase("crafter_tire_1", MTCreativeTabs.machines);
		crafterT2 = new BlockCraftingBase("crafter_tire_2", MTCreativeTabs.machines);
		crafterT3 = new BlockCraftingBase("crafter_tire_3", MTCreativeTabs.machines);
		crafterTC = new BlockCraftingBase("crafter_creative", MTCreativeTabs.machines);
		
		researchTable = new BlockResearchTable();
		
//		Crops
//		cropTransition = new BlockCropBase("transition_plant", MTItems.seedTransition, MTItems.tFragment);
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
		
//		registerBlock(grinder);
		
		registerBlock(crafterT1);
		registerBlock(crafterT2);
		registerBlock(crafterT3);
		registerBlock(crafterTC);
		
		registerBlock(researchTable);
		
//		Crops
//		registerBlockSpecial(cropTransition);
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
		
//		registerRender(grinder);
		
		registerRender(crafterT1);
		registerRender(crafterT2);
		registerRender(crafterT3);
		registerRender(crafterTC);
		
		registerRender(researchTable);
		
//		registerRender(cropTransition);
		
	}
	
	public static void registerBlock(Block block) {
		GameData.register_impl(block);
		GameData.register_impl(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		MagicalTech.loggerMT.logInfo("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		RebornRegistry.registerItemModel(block, 0);
		MagicalTech.loggerMT.logInfo("Registered Render For " + block.getUnlocalizedName().substring(5));
	}
}
