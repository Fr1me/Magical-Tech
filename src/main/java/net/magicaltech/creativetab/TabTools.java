package net.magicaltech.creativetab;

import net.magicaltech.init.MTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabTools extends CreativeTabs {

	public TabTools() {
		super("tools");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (MTItems.magicWand);
  	}

}
