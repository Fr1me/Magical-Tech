package net.magicaltech.handler;

import net.magicaltech.init.MTItems;
import net.magicaltech.util.Utils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipes(GameRegistry registry) {
		Utils.getLogger().info("Registering Crafting Recipes...");
		
		registry.addRecipe(new ItemStack(MTItems.tIngot), new Object[] {  "NNN", "NNN", "NNN", 'N', MTItems.tNugget });
		registry.addRecipe(new ItemStack(MTItems.tNugget), new Object[] {  "CCC", "CCC", "CCC", 'C', MTItems.tChunk });
		
		Utils.getLogger().info("Registered Crafting Recipes.");
	}
	
	public static void registerSmeltingRecipes(GameRegistry registry) {
		Utils.getLogger().info("Registering Smelting Recipes...");
		
		
		
		Utils.getLogger().info("Registered Smelting Recipes Recipes.");
	}

}
