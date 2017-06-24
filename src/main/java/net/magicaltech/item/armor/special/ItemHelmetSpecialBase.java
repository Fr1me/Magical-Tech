package net.magicaltech.item.armor.special;

import net.magicaltech.item.armor.ItemArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemHelmetSpecialBase extends ItemArmorBase{

	public ItemHelmetSpecialBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 1, EntityEquipmentSlot.HEAD, name + "_helmet");
	}

}
