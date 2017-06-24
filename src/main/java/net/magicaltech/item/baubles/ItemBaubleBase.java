package net.magicaltech.item.baubles;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.magicaltech.item.ItemBase;
import net.minecraft.item.ItemStack;

public class ItemBaubleBase extends ItemBase implements IBauble{
	
	public BaubleType type;

	public ItemBaubleBase(String name, BaubleType type) {
		super(name, false);
		this.type = type;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return type;
	}

}
