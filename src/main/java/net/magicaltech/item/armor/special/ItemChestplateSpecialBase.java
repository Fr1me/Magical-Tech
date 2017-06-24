package net.magicaltech.item.armor.special;

import net.magicaltech.item.armor.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemChestplateSpecialBase extends ItemArmorBase{

	public ItemChestplateSpecialBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 1, EntityEquipmentSlot.CHEST, name + "_chestplate");
	}

}
