package net.magicaltech.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	
	public ItemBase(String unlocalizedName, String registryName, CreativeTabs tab) {
		setUnlocalizedName(unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(tab);
	}

}
