package net.magicaltech.creativetab;

import net.magicaltech.init.MTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBlocks extends CreativeTabs {

	public TabBlocks() {
		super("blocks");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (MTItems.magicWand);
  	}

}
