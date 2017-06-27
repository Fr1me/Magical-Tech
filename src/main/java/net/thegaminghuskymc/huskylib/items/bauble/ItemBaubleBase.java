package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.huskylib.items.ItemBase;

public class ItemBaubleBase extends ItemBase implements IBauble{
	
	public BaubleType type;

	public ItemBaubleBase(String name, BaubleType type, CreativeTabs tabs) {
		super(name, tabs);
		this.type = type;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return type;
	}

}
