package net.magicaltech.item.armor;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemBootsBase extends ItemArmorBase{

	public ItemBootsBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 1, EntityEquipmentSlot.FEET, name + "_boots");
	}

}
