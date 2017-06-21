package net.magicaltech.handler;

import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.util.MTCraftingHelper;
import net.magicaltech.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTRecipeHandler {
	
	public static void registerCraftingRecipes() {
		Utils.getLogger().info("Registering all of the Crafting Recipes...");
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tIngot), new Object[] {  "NNN", "NNN", "NNN", 'N', MTItems.tNugget });
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tNugget), new Object[] {  "PPP", "PPP", "PPP", 'P', MTItems.tPiece });
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tPiece), new Object[] {  "FFF", "FFF", "FFF", 'F', MTItems.tFragment });
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.tFragment), new Object[] {  "TTT", "TTT", "TTT", 'T', MTItems.tTFragment });
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTItems.seedTransition), new Object[] {  "SDS", "DND", "SDS", 'S', Items.WHEAT_SEEDS, 'D', Items.DIAMOND, 'N', Items.NETHER_STAR });
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTBlocks.tBlock), new Object[]{ "III", "III", "III", 'I', MTItems.tIngot});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTBlocks.pIBlock), new Object[]{ "III", "III", "III", 'I', MTItems.pIron});
		
		Utils.getLogger().info("Registered all of the Crafting Recipes.");
	}
	
	public static void registerSmeltingRecipes() {
		Utils.getLogger().info("Registering all of the Smelting Recipes...");
		
		MTCraftingHelper.addSmelting(MTBlocks.rQOre, new ItemStack(MTItems.rQuartz), 8);
		MTCraftingHelper.addSmelting(MTBlocks.plOre, new ItemStack(MTItems.pIron), 8);
		
		Utils.getLogger().info("Registered all of the Smelting Recipes.");
	}
	
	public static void registerToolRecipes() {
		Utils.getLogger().info("Registering Tool Recipes...");
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.tHoe), new Object[] {" TT", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.plHoe), new Object[] {" TT", " S ", " S ", 'T', MTItems.pIron, 'S', Items.STICK});
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTTools.rQHoe), new Object[] {" TT", " S ", " S ", 'T', MTItems.rQuartz, 'S', Items.STICK});
		
		Utils.getLogger().info("Registered all of the Tool Recipes.");
	}
	
	public static void registerArmorRecipes() {
		Utils.getLogger().info("Registering all of the Armor Recipes...");
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.tIngot});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tHelmet), new Object[] { "   ", "TTT", "T T", 'T', MTItems.tIngot});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.tIngot});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.tIngot});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tBoots), new Object[] { "T T", "T T", "   ", 'T', MTItems.tIngot});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.tBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.tIngot});
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.pIron});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plHelmet), new Object[] { "   ", "TTT", "T T", 'T', MTItems.pIron});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.pIron});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.pIron});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plBoots), new Object[] { "T T", "T T", "   ", 'T', MTItems.pIron});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.plBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.pIron});
		
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.rQuartz});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQHelmet), new Object[] { "   ", "TTT", "T T", 'T', MTItems.rQuartz});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.rQuartz});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.rQuartz});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQBoots), new Object[] { "T T", "T T", "   ", 'T', MTItems.rQuartz});
		MTCraftingHelper.addShapedOreRecipe(new ItemStack(MTArmor.rQBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.rQuartz});
	
		Utils.getLogger().info("Registered all of the Armor Recipes.");
	}

}
