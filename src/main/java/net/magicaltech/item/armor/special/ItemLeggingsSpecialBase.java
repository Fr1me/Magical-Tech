package net.magicaltech.item.armor.special;

import net.magicaltech.item.armor.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemLeggingsSpecialBase extends ItemArmorBase{

	public ItemLeggingsSpecialBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 2, EntityEquipmentSlot.LEGS, name + "_leggings");
	}

}
