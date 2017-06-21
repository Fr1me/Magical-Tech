package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemArmorBase;
import net.magicaltech.item.ItemArmorHelperFutopia;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTArmor {
	
	public static ArmorMaterial transistiumMaterial = EnumHelper.addArmorMaterial("transistium", Reference.MODID + ":transistium", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	public static ArmorMaterial prophecyIronMaterial = EnumHelper.addArmorMaterial("prophecy_iron", Reference.MODID + ":prophecy_iron", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	public static ArmorMaterial roseQuartsMaterial = EnumHelper.addArmorMaterial("rose_quartz", Reference.MODID + ":rose_quartz", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	
	public static ItemArmor tHelmet;
	public static ItemArmor tChestplate;
	public static ItemArmor tLeggings;
	public static ItemArmor tBoots;
	
	public static ItemArmor plHelmet;
	public static ItemArmor plChestplate;
	public static ItemArmor plLeggings;
	public static ItemArmor plBoots;
	
	public static ItemArmor rQHelmet;
	public static ItemArmor rQChestplate;
	public static ItemArmor rQLeggings;
	public static ItemArmor rQBoots;
	
	public static Item[] armorBlue;
    public static Item[] armorGreen;
    public static Item[] armorRed;
    public static Item[] armorPurple;
    public static Item[] armorTungsten;
    public static Item[] armorZinc;

    private static ItemArmorHelperFutopia armorHelper = new ItemArmorHelperFutopia();
	
	public static void init() {
		tHelmet = new ItemArmorBase(transistiumMaterial, 1, EntityEquipmentSlot.HEAD, "transistium_helmet");
		tChestplate = new ItemArmorBase(transistiumMaterial, 1, EntityEquipmentSlot.CHEST, "transistium_chestplate");
		tLeggings = new ItemArmorBase(transistiumMaterial, 2, EntityEquipmentSlot.LEGS, "transistium_leggings");
		tBoots = new ItemArmorBase(transistiumMaterial, 1, EntityEquipmentSlot.FEET, "transistium_boots");
		
		plHelmet = new ItemArmorBase(prophecyIronMaterial, 1, EntityEquipmentSlot.HEAD, "prophecy_iron_helmet");
		plChestplate = new ItemArmorBase(prophecyIronMaterial, 1, EntityEquipmentSlot.CHEST, "prophecy_iron_chestplate");
		plLeggings = new ItemArmorBase(prophecyIronMaterial, 2, EntityEquipmentSlot.LEGS, "prophecy_iron_leggings");
		plBoots = new ItemArmorBase(prophecyIronMaterial, 1, EntityEquipmentSlot.FEET, "prophecy_iron_boots");
		
		rQHelmet = new ItemArmorBase(roseQuartsMaterial, 1, EntityEquipmentSlot.HEAD, "rose_quartz_helmet");
		rQChestplate = new ItemArmorBase(roseQuartsMaterial, 1, EntityEquipmentSlot.CHEST, "rose_quartz_chestplate");
		rQLeggings = new ItemArmorBase(roseQuartsMaterial, 2, EntityEquipmentSlot.LEGS, "rose_quartz_leggings");
		rQBoots = new ItemArmorBase(roseQuartsMaterial, 1, EntityEquipmentSlot.FEET, "rose_quartz_boots");
		
		armorBlue = armorHelper.createArmorSet("blue", EnumHelper.addArmorMaterial("blue", Reference.MODID + ":blue", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorGreen = armorHelper.createArmorSet("green", EnumHelper.addArmorMaterial("green", Reference.MODID + ":green", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorRed = armorHelper.createArmorSet("red", EnumHelper.addArmorMaterial("red", Reference.MODID + ":red", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorPurple = armorHelper.createArmorSet("purple", EnumHelper.addArmorMaterial("purple", Reference.MODID + ":purple", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorTungsten = armorHelper.createArmorSet("tungsten", EnumHelper.addArmorMaterial("tungsten", Reference.MODID + ":tungsten", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
        armorZinc = armorHelper.createArmorSet("zinc", EnumHelper.addArmorMaterial("zinc", Reference.MODID + ":zinc", 16, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.1F));
	}
	
	public static void register() {
		registerItem(tHelmet);
		registerItem(tChestplate);
		registerItem(tLeggings);
		registerItem(tBoots);

		registerItem(plHelmet);
		registerItem(plChestplate);
		registerItem(plLeggings);
		registerItem(plBoots);

		registerItem(rQHelmet);
		registerItem(rQChestplate);
		registerItem(rQLeggings);
		registerItem(rQBoots);

		registerItem(armorBlue);
		registerItem(armorGreen);
		registerItem(armorRed);
		registerItem(armorPurple);
		registerItem(armorTungsten);
		registerItem(armorZinc);
	}

	public static void registerRenders() {
		registerRender(tHelmet);
		registerRender(tChestplate);
		registerRender(tLeggings);
		registerRender(tBoots);

		registerRender(plHelmet);
		registerRender(plChestplate);
		registerRender(plLeggings);
		registerRender(plBoots);

		registerRender(rQHelmet);
		registerRender(rQChestplate);
		registerRender(rQLeggings);
		registerRender(rQBoots);

		registerRender(armorBlue);
		registerRender(armorGreen);
		registerRender(armorRed);
		registerRender(armorPurple);
		registerRender(armorTungsten);
		registerRender(armorZinc);
	}
	
	public static void registerItem (Item item) {
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Armor Piece: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For: " + item.getUnlocalizedName().substring(5));
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
	}
	
	public static void registerRender(Item[] item) {
		ModelLoader.setCustomModelResourceLocation(item[0], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[0].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[0].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[1], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[1].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[1].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[2], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[2].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[2].getUnlocalizedName().substring(5));
		
		ModelLoader.setCustomModelResourceLocation(item[3], 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item[3].getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item[3].getUnlocalizedName().substring(5));
	}
}