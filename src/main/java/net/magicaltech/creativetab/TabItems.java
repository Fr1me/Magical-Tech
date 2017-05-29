package net.magicaltech.creativetab;

import net.magicaltech.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabItems extends CreativeTabs {

	public TabItems() {
		super("items");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (ModItems.magicWand);
  	}

}
