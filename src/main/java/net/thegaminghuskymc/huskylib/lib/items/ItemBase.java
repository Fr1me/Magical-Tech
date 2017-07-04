package net.thegaminghuskymc.huskylib.lib.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	
	public ItemBase(String name, CreativeTabs creativetab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(creativetab);
	}

}
