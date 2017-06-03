package net.magicaltech.item;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {
	
	public boolean hasEffect;
	
	public ItemBase(String name, Boolean effect) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MTCreativeTabs.items);
		effect = hasEffect;
		
	}
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return hasEffect;
	}

}
