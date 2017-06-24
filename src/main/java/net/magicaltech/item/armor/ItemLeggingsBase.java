package net.magicaltech.item.armor;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemLeggingsBase extends ItemArmorBase{

	public ItemLeggingsBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 2, EntityEquipmentSlot.LEGS, name + "_leggings");
	}

}
