package net.magicaltech.init;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.blocks.machines.BlockCoalGenerator;
import net.magicaltech.blocks.machines.BlockCraftingBase;
import net.magicaltech.blocks.machines.BlockMagicalGenerator;
import net.magicaltech.blocks.machines.BlockNuffNuffGenerator;
import net.magicaltech.blocks.other.BlockProphechyIronStorage;
import net.magicaltech.blocks.other.BlockRoseQuartzStorage;
import net.magicaltech.blocks.other.BlockTransistiumStorage;
import net.magicaltech.blocks.worldgen.BlockHardenedStone;
import net.magicaltech.blocks.worldgen.BlockProphecyIronNetherOre;
import net.magicaltech.blocks.worldgen.BlockProphecyIronOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzNetherOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzOre;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.huskylib.lib.blocks.BlockMachineBase;
import net.thegaminghuskymc.huskylib.lib.blocks.crops.BlockCropBase;

public class MTBlocks {

	public static Block hStone;
	
	public static Block tBlock;
	public static Block pIBlock;
	public static Block rQBlock;
	
	public static Block rQOre;
	public static Block plOre;
	public static Block rQNetherOre;
	public static Block plNetherOre;
	
	public static Block cGen;
	public static Block mGen;
	public static Block nnGen;
	public static Block fGen;
	
	public static Block grinder;
	
	public static Block crafterT1;
	public static Block crafterT2;
	public static Block crafterT3;
	public static Block crafterTC;
	
	public static Block cropTransition;
	
	public static void init() {
		
//		Normal Blocks
		tBlock = new BlockTransistiumStorage();
		pIBlock = new BlockProphechyIronStorage();
		rQBlock = new BlockRoseQuartzStorage();
		
//		Worldgen Blocks
		hStone = new BlockHardenedStone();
		
		plOre = new BlockProphecyIronOre();
		rQOre = new BlockRoseQuartzOre();
		
		plNetherOre = new BlockProphecyIronNetherOre();
		rQNetherOre = new BlockRoseQuartzNetherOre();
			
//		Machines
		cGen = new BlockCoalGenerator();
		mGen = new BlockMagicalGenerator();
		nnGen = new BlockNuffNuffGenerator();
		
		crafterT1 = new BlockCraftingBase("crafter_tire_1");
		crafterT2 = new BlockCraftingBase("crafter_tire_2");
		crafterT3 = new BlockCraftingBase("crafter_tire_3");
		crafterTC = new BlockCraftingBase("crafter_tire_creative");
		
		grinder = new BlockMachineBase("grinder", MTCreativeTabs.machines);
		
//		Crops
		cropTransition = new BlockCropBase("transition_plant", MTItems.seedTransition, MTItems.tTFragment);
	}
	
	public static void register() {
//		Normal Blocks
		registerBlock(tBlock);
		registerBlock(pIBlock);
		registerBlock(rQBlock);
		
//		Ores
		registerBlock(plOre);
		registerBlock(rQOre);
		
		registerBlock(plNetherOre);
		registerBlock(rQNetherOre);
		
		registerBlock(hStone);
		
//		Machines
		registerBlock(cGen);
		registerBlock(mGen);
		registerBlock(nnGen);
		
		registerBlock(crafterT1);
		registerBlock(crafterT2);
		registerBlock(crafterT3);
		registerBlock(crafterTC);
		
		registerBlock(grinder);
		
//		Crops
		ForgeRegistries.BLOCKS.register(cropTransition);
	}

	public static void registerRenders() {
//		Normal Blocks
		registerRender(hStone);
		
		registerRender(tBlock);
		registerRender(rQBlock);
		registerRender(pIBlock);
		
//		Ores
		registerRender(rQOre);
		registerRender(plOre);
		
		registerRender(plNetherOre);
		registerRender(rQNetherOre);
		
//		Machines
		registerRender(cGen);
		registerRender(mGen);
		registerRender(nnGen);
		
		registerRender(crafterT1);
		registerRender(crafterT2);
		registerRender(crafterT3);
		registerRender(crafterTC);
		
		registerRender(grinder);
		
	}
	
	public static void registerBlock (Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		MagicalTech.logger.info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerOnlyBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		MagicalTech.logger.info("Registered Special Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		MagicalTech.logger.info("Registered Render For " + block.getUnlocalizedName().substring(5));
	}

}
