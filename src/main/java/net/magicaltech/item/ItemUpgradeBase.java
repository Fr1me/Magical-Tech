package net.magicaltech.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemUpgradeBase extends ItemBase{

	public ItemUpgradeBase(String name, Boolean effect) {
		super(name, effect);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		super.getSubItems(tab, items);
	}

}
