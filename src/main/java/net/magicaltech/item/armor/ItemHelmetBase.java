package net.magicaltech.item.armor;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemHelmetBase extends ItemArmorBase{

	public ItemHelmetBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 1, EntityEquipmentSlot.HEAD, name + "_helmet");
	}

}
