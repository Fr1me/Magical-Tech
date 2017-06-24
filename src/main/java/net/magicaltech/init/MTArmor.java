package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.armor.ItemBootsBase;
import net.magicaltech.item.armor.ItemChestplateBase;
import net.magicaltech.item.armor.ItemHelmetBase;
import net.magicaltech.item.armor.ItemLeggingsBase;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
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
	public static ArmorMaterial lavaMaterial = EnumHelper.addArmorMaterial("lava", Reference.MODID + ":lava", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	
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
	
	public static void init() {
		tHelmet = new ItemHelmetBase(transistiumMaterial, "transistium");
		tChestplate = new ItemChestplateBase(transistiumMaterial, "transistium");
		tLeggings = new ItemLeggingsBase(transistiumMaterial, "transistium");
		tBoots = new ItemBootsBase(transistiumMaterial, "transistium");
		
		plHelmet = new ItemHelmetBase(prophecyIronMaterial, "prophecy_iron");
		plChestplate = new ItemChestplateBase(prophecyIronMaterial, "prophecy_iron");
		plLeggings = new ItemLeggingsBase(prophecyIronMaterial, "prophecy_iron");
		plBoots = new ItemBootsBase(prophecyIronMaterial, "prophecy_iron");
		
		rQHelmet = new ItemHelmetBase(roseQuartsMaterial, "rose_quartz");
		rQChestplate = new ItemChestplateBase(roseQuartsMaterial, "rose_quartz");
		rQLeggings = new ItemLeggingsBase(roseQuartsMaterial, "rose_quartz");
		rQBoots = new ItemBootsBase(roseQuartsMaterial, "rose_quartz");
		
		lHelmet = new ItemHelmetBase(lavaMaterial, "lava");
		lChestplate = new ItemChestplateBase(lavaMaterial, "lava");
		lLeggings = new ItemLeggingsBase(lavaMaterial, "lava");
		lBoots = new ItemBootsBase(lavaMaterial, "lava");
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
		
		registerItem(lHelmet);
		registerItem(lChestplate);
		registerItem(lLeggings);
		registerItem(lBoots);
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
		
		registerRender(lHelmet);
		registerRender(lChestplate);
		registerRender(lLeggings);
		registerRender(lBoots);
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