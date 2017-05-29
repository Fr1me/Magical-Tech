package net.magicaltech.creativetab;

import net.magicaltech.init.MTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabWorldgen extends CreativeTabs {

	public TabWorldgen() {
		super("worldgen");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (MTItems.magicWand);
  	}

}
