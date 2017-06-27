package net.magicaltech.init;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.huskylib.items.tools.ItemAxeBase;
import net.thegaminghuskymc.huskylib.items.tools.ItemHoeBase;
import net.thegaminghuskymc.huskylib.items.tools.ItemPickaxeBase;
import net.thegaminghuskymc.huskylib.items.tools.ItemShovelBase;
import net.thegaminghuskymc.huskylib.items.tools.ItemSwordBase;

public class MTTools {
	
	public static final ToolMaterial transistium = EnumHelper.addToolMaterial(Reference.MODID + ":transistium", 3, 1826, 12.0F, 12.0F, 30);
	public static final ToolMaterial prophecyIron = EnumHelper.addToolMaterial(Reference.MODID + ":prophecy_iron", 3, 1826, 12.0F, 12.0F, 30);
	public static final ToolMaterial roseQuarts = EnumHelper.addToolMaterial(Reference.MODID + ":rose_quartz", 3, 1826, 12.0F, 12.0F, 30);
	public static final ToolMaterial lava = EnumHelper.addToolMaterial(Reference.MODID + ":lava", 3, 1826, 12.0F, 12.0F, 30);
	
	public static final ToolMaterial satanium = EnumHelper.addToolMaterial(Reference.MODID + ":satanium", 3, 1826, 12.0F, 12.0F, 30);
	
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
	
	public static ItemSwordBase sSword;
	public static ItemPickaxeBase sPickaxe;
	public static ItemAxeBase sAxe;
	public static ItemShovelBase sShovel;
	public static ItemHoeBase sHoe;
	
	public static void init() {
		tSword = new ItemSwordBase(transistium, "transistium", MTCreativeTabs.tools);
		tPickaxe = new ItemPickaxeBase(transistium, "transistium", MTCreativeTabs.tools);
		tAxe = new ItemAxeBase(transistium, "transistium", MTCreativeTabs.tools);
		tShovel = new ItemShovelBase(transistium, "transistium", MTCreativeTabs.tools);
		tHoe = new ItemHoeBase(transistium, "transistium", MTCreativeTabs.tools);
		
		plSword = new ItemSwordBase(prophecyIron, "prophecy_iron", MTCreativeTabs.tools);
		plPickaxe = new ItemPickaxeBase(prophecyIron, "prophecy_iron", MTCreativeTabs.tools);
		plAxe = new ItemAxeBase(prophecyIron, "prophecy_iron", MTCreativeTabs.tools);
		plShovel = new ItemShovelBase(prophecyIron, "prophecy_iron", MTCreativeTabs.tools);
		plHoe = new ItemHoeBase(prophecyIron, "prophecy_iron", MTCreativeTabs.tools);
		
		rQSword = new ItemSwordBase(transistium, "rose_quartz", MTCreativeTabs.tools);
		rQPickaxe = new ItemPickaxeBase(transistium, "rose_quartz", MTCreativeTabs.tools);
		rQAxe = new ItemAxeBase(transistium, "rose_quartz", MTCreativeTabs.tools);
		rQShovel = new ItemShovelBase(transistium, "rose_quartz", MTCreativeTabs.tools);
		rQHoe = new ItemHoeBase(transistium, "rose_quartz", MTCreativeTabs.tools);
		
		sSword = new ItemSwordBase(satanium, "satanium", MTCreativeTabs.tools);
		sPickaxe = new ItemPickaxeBase(satanium, "satanium", MTCreativeTabs.tools);
		sAxe = new ItemAxeBase(satanium, "satanium", MTCreativeTabs.tools);
		sShovel = new ItemShovelBase(satanium, "satanium", MTCreativeTabs.tools);
		sHoe = new ItemHoeBase(satanium, "satanium", MTCreativeTabs.tools);
		
		lSword = new ItemSwordBase(lava, "lava", MTCreativeTabs.tools);
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
		
		registerItem(sSword);
		registerItem(sPickaxe);
		registerItem(sAxe);
		registerItem(sShovel);
		registerItem(sHoe);
		
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
		
		registerRender(sSword, 0, null);
		registerRender(sPickaxe, 0, null);
		registerRender(sAxe, 0, null);
		registerRender(sShovel, 0, null);
		registerRender(sHoe, 0, null);
		
		registerRender(lSword, 0, null);
	}
	
	public static void registerItem(Item item) {
		RebornRegistry.registerItem(item);
		MagicalTech.loggerMT.logInfo("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		RebornRegistry.registerItemModel(item, meta, fileName);
		MagicalTech.loggerMT.logInfo("Registered Render For " + item.getUnlocalizedName().substring(5));
	}
	
	/*public static void registerItem(Item[] item) {
		RebornRegistry.registerItem(item[0]);
		Utils.getLogger().info("Registered Item: " + item[0].getUnlocalizedName().substring(5));
		
		RebornRegistry.registerItem(item[1]);
		Utils.getLogger().info("Registered Item: " + item[1].getUnlocalizedName().substring(5));
		
		RebornRegistry.registerItem(item[2]);
		Utils.getLogger().info("Registered Item: " + item[2].getUnlocalizedName().substring(5));
		
		RebornRegistry.registerItem(item[3]);
		Utils.getLogger().info("Registered Item: " + item[3].getUnlocalizedName().substring(5));
		
		RebornRegistry.registerItem(item[4]);
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
	}*/

}
