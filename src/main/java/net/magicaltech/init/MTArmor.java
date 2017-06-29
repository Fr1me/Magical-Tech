package net.magicaltech.init;

import org.apache.logging.log4j.Level;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.items.ItemWitchHat;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.huskylib.items.armor.ItemBootsBase;
import net.thegaminghuskymc.huskylib.items.armor.ItemChestplateBase;
import net.thegaminghuskymc.huskylib.items.armor.ItemHelmetBase;
import net.thegaminghuskymc.huskylib.items.armor.ItemLeggingsBase;
import net.thegaminghuskymc.huskylib.items.armor.special.ItemBootsSpecialBase;
import net.thegaminghuskymc.huskylib.items.armor.special.ItemChestplateSpecialBase;
import net.thegaminghuskymc.huskylib.items.armor.special.ItemHelmetSpecialBase;
import net.thegaminghuskymc.huskylib.items.armor.special.ItemLeggingsSpecialBase;

public class MTArmor {
	
	public static ArmorMaterial transistiumMaterial = EnumHelper.addArmorMaterial("transistium", Reference.MODID + ":transistium", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	public static ArmorMaterial prophecyIronMaterial = EnumHelper.addArmorMaterial("prophecy_iron", Reference.MODID + ":prophecy_iron", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	public static ArmorMaterial roseQuartsMaterial = EnumHelper.addArmorMaterial("rose_quartz", Reference.MODID + ":rose_quartz", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	public static ArmorMaterial lavaMaterial = EnumHelper.addArmorMaterial("lava", Reference.MODID + ":lava", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	
	public static ArmorMaterial sataniumMaterial = EnumHelper.addArmorMaterial("lava", Reference.MODID + ":satanium", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	
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
	
	public static ItemArmor lHelmet;
	public static ItemArmor lChestplate;
	public static ItemArmor lLeggings;
	public static ItemArmor lBoots;
	
	public static ItemArmor sHelmet;
	public static ItemArmor sChestplate;
	public static ItemArmor sLeggings;
	public static ItemArmor sBoots;
	
	public static ItemWitchHat witchHat;
	
	public static void init() {
		tHelmet = new ItemHelmetBase(transistiumMaterial, "transistium", MTCreativeTabs.combat);
		tChestplate = new ItemChestplateBase(transistiumMaterial, "transistium", MTCreativeTabs.combat);
		tLeggings = new ItemLeggingsBase(transistiumMaterial, "transistium", MTCreativeTabs.combat);
		tBoots = new ItemBootsBase(transistiumMaterial, "transistium", MTCreativeTabs.combat);
		
		plHelmet = new ItemHelmetBase(prophecyIronMaterial, "prophecy_iron", MTCreativeTabs.combat);
		plChestplate = new ItemChestplateBase(prophecyIronMaterial, "prophecy_iron", MTCreativeTabs.combat);
		plLeggings = new ItemLeggingsBase(prophecyIronMaterial, "prophecy_iron", MTCreativeTabs.combat);
		plBoots = new ItemBootsBase(prophecyIronMaterial, "prophecy_iron", MTCreativeTabs.combat);
		
		rQHelmet = new ItemHelmetBase(roseQuartsMaterial, "rose_quartz", MTCreativeTabs.combat);
		rQChestplate = new ItemChestplateBase(roseQuartsMaterial, "rose_quartz", MTCreativeTabs.combat);
		rQLeggings = new ItemLeggingsBase(roseQuartsMaterial, "rose_quartz", MTCreativeTabs.combat);
		rQBoots = new ItemBootsBase(roseQuartsMaterial, "rose_quartz", MTCreativeTabs.combat);
		
		sHelmet = new ItemHelmetSpecialBase(sataniumMaterial, "satanium", MTCreativeTabs.combat);
		sChestplate = new ItemChestplateSpecialBase(sataniumMaterial, "satanium", MTCreativeTabs.combat);
		sLeggings = new ItemLeggingsSpecialBase(sataniumMaterial, "satanium", MTCreativeTabs.combat);
		sBoots = new ItemBootsSpecialBase(sataniumMaterial, "satanium", MTCreativeTabs.combat);
		
		witchHat = new ItemWitchHat();
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
		
		registerItem(sHelmet);
		registerItem(sChestplate);
		registerItem(sLeggings);
		registerItem(sBoots);
		
		registerItem(witchHat);
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
		
		registerRender(sHelmet);
		registerRender(sChestplate);
		registerRender(sLeggings);
		registerRender(sBoots);
		
		registerRender(witchHat);
	}
	
	public static void registerItem (Item item) {
		RebornRegistry.registerItem(item);
		MagicalTech.logger.log(Level.INFO, "Registered Armor Piece: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		RebornRegistry.registerItemModel(item, 0);
		MagicalTech.logger.log(Level.INFO, "Registered Render For: " + item.getUnlocalizedName().substring(5));
	}
}