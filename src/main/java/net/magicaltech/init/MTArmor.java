package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemArmorBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xfireeyez.core.util.Utils;

public class MTArmor {
	
	public static ArmorMaterial transistiumMaterial = EnumHelper.addArmorMaterial("transistium", Reference.MODID + ":transistium", 89, new int[] {4,12,10,4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	
	public static ItemArmor tHelmet;
	public static ItemArmor tChestplate;
	public static ItemArmor tLeggings;
	public static ItemArmor tBoots;
	
	public static void init() {
		tHelmet = new ItemArmorBase(transistiumMaterial, 1, EntityEquipmentSlot.HEAD, "transistium_helmet");
		tChestplate = new ItemArmorBase(transistiumMaterial, 1, EntityEquipmentSlot.CHEST, "transistium_chestplate");
		tLeggings = new ItemArmorBase(transistiumMaterial, 2, EntityEquipmentSlot.LEGS, "transistium_leggings");
		tBoots = new ItemArmorBase(transistiumMaterial, 1, EntityEquipmentSlot.FEET, "transistium_boots");
	}
	
	public static void register() {
		registerItem(tHelmet);
		registerItem(tChestplate);
		registerItem(tLeggings);
		registerItem(tBoots);
	}

	public static void registerRenders() {
		registerRender(tHelmet);
		registerRender(tChestplate);
		registerRender(tLeggings);
		registerRender(tBoots);
	}
	
	public static void registerItem (Item item) {
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Armor Piece: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For: " + item.getUnlocalizedName().substring(5));
	}
}