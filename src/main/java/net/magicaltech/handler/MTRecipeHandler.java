package net.magicaltech.handler;

import net.magicaltech.MagicalTech;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.huskylib.lib.utils.HLCraftingHelper;

public class MTRecipeHandler {
	
	public static void registerCraftingRecipes() {
		MagicalTech.logger.info("Registering all of the Crafting Recipes...");
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tIngot), new Object[] {  "NNN", "NNN", "NNN", 'N', MTItems.tNugget });
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tNugget), new Object[] {  "PPP", "PPP", "PPP", 'P', MTItems.tPiece });
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tPiece), new Object[] {  "FFF", "FFF", "FFF", 'F', MTItems.tFragment });
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tFragment), new Object[] {  "TTT", "TTT", "TTT", 'T', MTItems.tTFragment });
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.seedTransition), new Object[] {  "SDS", "DND", "SDS", 'S', Items.WHEAT_SEEDS, 'D', Items.DIAMOND, 'N', Items.NETHER_STAR });
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTBlocks.tBlock), new Object[]{ "III", "III", "III", 'I', MTItems.tIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTBlocks.pIBlock), new Object[]{ "III", "III", "III", 'I', MTItems.pIron});
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTBlocks.cGen), new Object[]{ "III", "ICI", "IRI", 'C', Items.COAL, 'I', Blocks.IRON_BLOCK, 'R', Items.REDSTONE});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTBlocks.mGen), new Object[]{ "TTT", "TST", "TRT", 'S', MTItems.sIngot, 'T', MTBlocks.tBlock, 'R', Items.REDSTONE});
		
		MagicalTech.logger.info("Registered all of the Crafting Recipes.");
	}
	
	public static void registerSmeltingRecipes() {
		MagicalTech.logger.info("Registering all of the Smelting Recipes...");
		
		HLCraftingHelper.addSmelting(MTBlocks.rQOre, new ItemStack(MTItems.rQuartz), 8);
		HLCraftingHelper.addSmelting(MTBlocks.plOre, new ItemStack(MTItems.pIron), 8);
		
		HLCraftingHelper.addSmelting(MTBlocks.rQNetherOre, new ItemStack(MTItems.rQuartz), 8);
		HLCraftingHelper.addSmelting(MTBlocks.plNetherOre, new ItemStack(MTItems.pIron), 8);
		
		MagicalTech.logger.info("Registered all of the Smelting Recipes.");
	}
	
	public static void registerToolRecipes() {
		MagicalTech.logger.info("Registering Tool Recipes...");
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.tIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.pIron, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});

		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.rQuartz, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.sIngot, 'S', Items.STICK});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.sHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.sIngot, 'S', Items.STICK});
		
		MagicalTech.logger.info("Registered all of the Tool Recipes.");
	}
	
	public static void registerArmorRecipes() {
		MagicalTech.logger.info("Registering all of the Armor Recipes...");
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.tIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.tIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.tIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.tIngot});
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.pIron});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.pIron});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.pIron});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.pIron});
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.rQuartz});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.rQuartz});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.rQuartz});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.rQuartz});
		
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.sHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.sIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.sChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.sIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.sLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.sIngot});
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.sBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.sIngot});
	
		MagicalTech.logger.info("Registered all of the Armor Recipes.");
	}

}
