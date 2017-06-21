package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemAxeBase;
import net.magicaltech.item.ItemHoeBase;
import net.magicaltech.item.ItemPickaxeBase;
import net.magicaltech.item.ItemShovelBase;
import net.magicaltech.item.ItemSwordBase;
import net.magicaltech.item.ItemToolHelperFutopia;
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
	
	public static Item[] toolsBlue;
    public static Item[] toolsGreen;
    public static Item[] toolsRed;
    public static Item[] toolsPurple;
    public static Item[] toolsTungsten;
    public static Item[] toolsZinc;
    
    public static Item.ToolMaterial toolMaterialBlue = EnumHelper.addToolMaterial("blue", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialGreen = EnumHelper.addToolMaterial("green", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialRed = EnumHelper.addToolMaterial("red", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialPurple = EnumHelper.addToolMaterial("purple", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialTungsten = EnumHelper.addToolMaterial("tungsten", 2, 700, 6.1F, 2.1F, 15);
    private static Item.ToolMaterial toolMaterialZinc = EnumHelper.addToolMaterial("zinc", 2, 700, 6.1F, 2.1F, 15);
    private static ItemToolHelperFutopia toolHelper = new ItemToolHelperFutopia();
	
	public static void init() {
		tSword = new ItemSwordBase(transistium, "transistium_sword");
		tPickaxe = new ItemPickaxeBase(transistium, "transistium_pickaxe");
		tAxe = new ItemAxeBase(transistium, "transistium_axe");
		tShovel = new ItemShovelBase(transistium, "transistium_shovel");
		tHoe = new ItemHoeBase(transistium, "transistium_hoe");
		
		plSword = new ItemSwordBase(transistium, "prophecy_iron_sword");
		plPickaxe = new ItemPickaxeBase(transistium, "prophecy_iron_pickaxe");
		plAxe = new ItemAxeBase(transistium, "prophecy_iron_axe");
		plShovel = new ItemShovelBase(transistium, "prophecy_iron_shovel");
		plHoe = new ItemHoeBase(transistium, "prophecy_iron_hoe");
		
		rQSword = new ItemSwordBase(transistium, "rose_quartz_sword");
		rQPickaxe = new ItemPickaxeBase(transistium, "rose_quartz_pickaxe");
		rQAxe = new ItemAxeBase(transistium, "rose_quartz_axe");
		rQShovel = new ItemShovelBase(transistium, "rose_quartz_shovel");
		rQHoe = new ItemHoeBase(transistium, "rose_quartz_hoe");
		
		toolsBlue = toolHelper.createToolset("blue", toolMaterialBlue);
        toolsGreen = toolHelper.createToolset("green", toolMaterialGreen);
        toolsRed = toolHelper.createToolset("red", toolMaterialRed);
        toolsPurple = toolHelper.createToolset("purple", toolMaterialPurple);
        toolsTungsten = toolHelper.createToolset("tungsten", toolMaterialTungsten);
        toolsZinc = toolHelper.createToolset("zinc", toolMaterialZinc);
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
		
		registerItem(toolsBlue);
		registerItem(toolsGreen);
		registerItem(toolsRed);
		registerItem(toolsPurple);
		registerItem(toolsTungsten);
		registerItem(toolsZinc);
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

		registerRender(toolsBlue, 0, null);
		registerRender(toolsGreen, 0, null);
		registerRender(toolsRed, 0, null);
		registerRender(toolsPurple, 0, null);
		registerRender(toolsTungsten, 0, null);
		registerRender(toolsZinc, 0, null);
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
