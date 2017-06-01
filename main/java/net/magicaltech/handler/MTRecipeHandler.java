package net.magicaltech.handler;

import net.magicaltech.init.MTItems;
import net.magicaltech.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTRecipeHandler {
	
	public static void registerCraftingRecipes(GameRegistry registry) {
		Utils.getLogger().info("Registering Crafting Recipes...");
		
		registry.addRecipe(new ItemStack(MTItems.tIngot), new Object[] {  "NNN", "NNN", "NNN", 'N', MTItems.tNugget });
		registry.addRecipe(new ItemStack(MTItems.tNugget), new Object[] {  "PPP", "PPP", "PPP", 'P', MTItems.tPiece });
		registry.addRecipe(new ItemStack(MTItems.tPiece), new Object[] {  "FFF", "FFF", "FFF", 'F', MTItems.tFragment });
		registry.addRecipe(new ItemStack(MTItems.tFragment), new Object[] {  "TTT", "TTT", "TTT", 'T', MTItems.tTFragment });
		registry.addRecipe(new ItemStack(MTItems.seedTransition), new Object[] {  "SDS", "DND", "SDS", 'S', Items.WHEAT_SEEDS, 'D', Items.DIAMOND, 'N', Items.NETHER_STAR });
		
		Utils.getLogger().info("Registered Crafting Recipes.");
	}
	
	public static void registerSmeltingRecipes(GameRegistry registry) {
		Utils.getLogger().info("Registering Smelting Recipes...");
		
		
		
		Utils.getLogger().info("Registered Smelting Recipes Recipes.");
	}

}
