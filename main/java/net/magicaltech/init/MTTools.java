package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemTransistiumAxe;
import net.magicaltech.item.ItemHoeBase;
import net.magicaltech.item.ItemPickaxeBase;
import net.magicaltech.item.ItemShovelBase;
import net.magicaltech.item.ItemSwordBase;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTTools {
	
	public static final ToolMaterial transistium = EnumHelper.addToolMaterial(Reference.MODID + ":transistium", 3, 1826, 12.0F, 12.0F, 30);
	
	public static ItemSword tSword;
	public static ItemPickaxe tPickaxe;
	public static ItemTransistiumAxe tAxe;
	public static ItemSpade tShovel;
	public static ItemHoe tHoe;
	
	public static void init() {
		tSword = new ItemSwordBase(transistium, "transistium_sword");
		tPickaxe = new ItemPickaxeBase(transistium, "transistium_pickaxe");
		tAxe = new ItemTransistiumAxe(transistium, "transistium_axe");
		tShovel = new ItemShovelBase(transistium, "transistium_shovel");
		tHoe = new ItemHoeBase(transistium, "transistium_hoe");
	}
	
	public static void register() {
		registerItem(tSword);
		registerItem(tPickaxe);
		registerItem(tAxe);
		registerItem(tShovel);
		registerItem(tHoe);
	}
	
	public static void registerRenders() {
		registerRender(tSword, 0, null);
		registerRender(tPickaxe, 0, null);
		registerRender(tAxe, 0, null);
		registerRender(tShovel, 0, null);
		registerRender(tHoe, 0, null);
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
