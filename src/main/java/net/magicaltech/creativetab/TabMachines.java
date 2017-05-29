package net.magicaltech.creativetab;

import net.magicaltech.init.MTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMachines extends CreativeTabs {

	public TabMachines() {
		super("machines");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (MTItems.magicWand);
  	}

}
