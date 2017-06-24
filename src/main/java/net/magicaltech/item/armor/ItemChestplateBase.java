package net.magicaltech.item.armor;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemChestplateBase extends ItemArmorBase{

	public ItemChestplateBase(ArmorMaterial materialIn, String name) {
		super(materialIn, 1, EntityEquipmentSlot.CHEST, name + "_chestplate");
	}

}
