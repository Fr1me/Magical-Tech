package net.magicaltech.creativetab;

import net.magicaltech.init.MTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCombat extends CreativeTabs {

	public TabCombat() {
		super("combat");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack (MTItems.magicWand);
  	}

}
