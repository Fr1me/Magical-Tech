package net.magicaltech.handler;

import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTRecipeHandler {
	
	public static void registerCraftingRecipes(GameRegistry registry) {
		Utils.getLogger().info("Registering Crafting Recipes...");
		
		registry.addRecipe(new ItemStack(MTItems.tIngot), new Object[] {  "NNN", "NNN", "NNN", 'N', MTItems.tNugget });
		registry.addRecipe(new ItemStack(MTItems.tNugget), new Object[] {  "FFF", "FFF", "FFF", 'F', MTItems.tFragment });
		registry.addRecipe(new ItemStack(MTItems.tFragment), new Object[] {  "TTT", "TTT", "TTT", 'T', MTItems.tTFragment });
		registry.addRecipe(new ItemStack(MTItems.seedTransition), new Object[] {  "IGI", "GSG", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'S', Items.WHEAT_SEEDS });
		
		Utils.getLogger().info("Registered Crafting Recipes.");
	}
	
	public static void registerSmeltingRecipes(GameRegistry registry) {
		Utils.getLogger().info("Registering Smelting Recipes...");
		
		registry.addSmelting(MTBlocks.rQOre, new ItemStack(MTItems.rQuartz), 8);;
		
		Utils.getLogger().info("Registered Smelting Recipes Recipes.");
	}
	
	public static void registerToolRecipes(GameRegistry registry) {
		registry.addRecipe(new ItemStack(MTTools.tSword), new Object[] {"T  ", "T  ", "S  ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tSword), new Object[] {" T ", " T ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tSword), new Object[] {"  T", "  T", "  S", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tPickaxe), new Object[] {"TTT", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tAxe), new Object[] {"TT ", "TS ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tAxe), new Object[] {" TT", " ST", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tShovel), new Object[] {"T  ", "S  ", "S  ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tShovel), new Object[] {" T ", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tShovel), new Object[] {"  T", "  S", "  S", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tHoe), new Object[] {"TT ", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		registry.addRecipe(new ItemStack(MTTools.tHoe), new Object[] {" TT", " S ", " S ", 'T', MTItems.tIngot, 'S', Items.STICK});
		
	}
	
	public static void registerArmorRecipes(GameRegistry registry) {
		registry.addRecipe(new ItemStack(MTArmor.tHelmet), new Object[] { "TTT", "T T", "   ", 'T', MTItems.tIngot});
		registry.addRecipe(new ItemStack(MTArmor.tHelmet), new Object[] { "   ", "TTT", "T T", 'T', MTItems.tIngot});
		registry.addRecipe(new ItemStack(MTArmor.tChestplate), new Object[] { "T T", "TTT", "TTT", 'T', MTItems.tIngot});
		registry.addRecipe(new ItemStack(MTArmor.tLeggings), new Object[] { "TTT", "T T", "T T", 'T', MTItems.tIngot});
		registry.addRecipe(new ItemStack(MTArmor.tBoots), new Object[] { "T T", "T T", "   ", 'T', MTItems.tIngot});
		registry.addRecipe(new ItemStack(MTArmor.tBoots), new Object[] { "   ", "T T", "T T", 'T', MTItems.tIngot});
	}

}
