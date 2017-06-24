package net.magicaltech.item.armor.special;

import net.magicaltech.item.armor.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemBootsSpecialBase extends ItemArmorBase{

	public ItemBootsSpecialBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 1, EntityEquipmentSlot.FEET, name + "_boots");
	}

}
