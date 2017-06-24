package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.tools.ItemAxeBase;
import net.magicaltech.item.tools.ItemHoeBase;
import net.magicaltech.item.tools.ItemPickaxeBase;
import net.magicaltech.item.tools.ItemShovelBase;
import net.magicaltech.item.tools.ItemSwordBase;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTTools {
	
	public static final ToolMaterial transistium = EnumHelper.addToolMaterial(Reference.MODID + ":transistium", 3, 1826, 12.0F, 12.0F, 30);
	public static final ToolMaterial prophecyIron = EnumHelper.addToolMaterial(Reference.MODID + ":prophecy_iron", 3, 1826, 12.0F, 12.0F, 30);
	public static final ToolMaterial roseQuarts = EnumHelper.addToolMaterial(Reference.MODID + ":rose_quartz", 3, 1826, 12.0F, 12.0F, 30);
	
	public static final ToolMaterial lava = EnumHelper.addToolMaterial(Reference.MODID + ":lava", 3, 1826, 12.0F, 12.0F, 30);
	
	public static ItemSwordBase tSword;
	public static ItemPickaxeBase tPickaxe;
	public static ItemAxeBase tAxe;
	public static ItemShovelBase tShovel;
	public static ItemHoeBase tHoe;
	
	public static ItemSwordBase plSword;
	public static ItemPickaxeBase plPickaxe;
	public static ItemAxeBase plAxe;
	public static ItemShovelBase plShovel;
	public static ItemHoeBase plHoe;
	
	public static ItemSwordBase rQSword;
	public static ItemPickaxeBase rQPickaxe;
	public static ItemAxeBase rQAxe;
	public static ItemShovelBase rQShovel;
	public static ItemHoeBase rQHoe;
	
	public static ItemSwordBase lSword;
	
	public static void init() {
		tSword = new ItemSwordBase(transistium, "transistium");
		tPickaxe = new ItemPickaxeBase(transistium, "transistium");
		tAxe = new ItemAxeBase(transistium, "transistium");
		tShovel = new ItemShovelBase(transistium, "transistium");
		tHoe = new ItemHoeBase(transistium, "transistium");
		
		plSword = new ItemSwordBase(transistium, "prophecy_iron");
		plPickaxe = new ItemPickaxeBase(transistium, "prophecy_iron");
		plAxe = new ItemAxeBase(transistium, "prophecy_iron");
		plShovel = new ItemShovelBase(transistium, "prophecy_iron");
		plHoe = new ItemHoeBase(transistium, "prophecy_iron");
		
		rQSword = new ItemSwordBase(transistium, "rose_quartz");
		rQPickaxe = new ItemPickaxeBase(transistium, "rose_quartz");
		rQAxe = new ItemAxeBase(transistium, "rose_quartz");
		rQShovel = new ItemShovelBase(transistium, "rose_quartz");
		rQHoe = new ItemHoeBase(transistium, "rose_quartz");
		
		lSword = new ItemSwordBase(lava, "lava");
	}
	
	public static void register() {
		registerItem(tSword);
		registerItem(tPickaxe);
		registerItem(tAxe);
		registerItem(tShovel);
		registerItem(tHoe);

		registerItem(plSword);
		registerItem(plPickaxe);
		registerItem(plAxe);
		registerItem(plShovel);
		registerItem(plHoe);

		registerItem(rQSword);
		registerItem(rQPickaxe);
		registerItem(rQAxe);
		registerItem(rQShovel);
		registerItem(rQHoe);
		
		registerItem(lSword);
	}
	
	public static void registerRenders() {
		registerRender(tSword, 0, null);
		registerRender(tPickaxe, 0, null);
		registerRender(tAxe, 0, null);
		registerRender(tShovel, 0, null);
		registerRender(tHoe, 0, null);

		registerRender(plSword, 0, null);
		registerRender(plPickaxe, 0, null);
		registerRender(plAxe, 0, null);
		registerRender(plShovel, 0, null);
		registerRender(plHoe, 0, null);

		registerRender(rQSword, 0, null);
		registerRender(rQPickaxe, 0, null);
		registerRender(rQAxe, 0, null);
		registerRender(rQShovel, 0, null);
		registerRender(rQHoe, 0, null);
		
		registerRender(lSword, 0, null);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item[] item) {
		GameRegistry.register(item[0]);
		Utils.getLogger().info("Registered Item: " + item[0].getUnlocalizedName().substring(5));
		
		GameRegistry.register(item[1]);
		Utils.getLogger().info("Registered Item: " + item[1].getUnlocalizedName().substring(5));
		
		GameRegistry.register(item[2]);
		Utils.getLogger().info("Registered Item: " + item[2].getUnlocalizedName().substring(5));
		
		GameRegistry.register(item[3]);
		Utils.getLogger().info("Registered Item: " + item[3].getUnlocalizedName().substring(5));
		
		GameRegistry.register(item[4]);
		Utils.getLogger().info("Registered Item: " + item[4].getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item[] item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item[0], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[0].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[0].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[1], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[1].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[1].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[2], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[2].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[2].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[3], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[3].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[3].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[4], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[4].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[4].getUnlocalizedName().substring(5));
	}

}
