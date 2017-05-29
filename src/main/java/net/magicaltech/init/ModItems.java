package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemBase;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item magicWand;
	
	public static void init() {
		magicWand = new ItemBase("wand", "wand");
	}
	
	public static void register() {
		registerItem(magicWand);
	}
	
	public static void registerRenders() {
		registerRender(magicWand, 0, null);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item.getUnlocalizedName().substring(5));
	}

}
