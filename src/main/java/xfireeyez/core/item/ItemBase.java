package xfireeyez.core.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {
	
	public boolean hasEffect;
	
	public ItemBase(String name, CreativeTabs tab, boolean effect) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		effect = hasEffect;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return hasEffect;
	}

}
