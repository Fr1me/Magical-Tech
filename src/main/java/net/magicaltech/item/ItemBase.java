package net.magicaltech.item;

import net.minecraft.item.Item;

public class ItemBase extends Item{
	
	public ItemBase(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}

}
