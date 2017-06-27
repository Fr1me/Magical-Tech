package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemCharmBase extends ItemBaubleBase{

	public ItemCharmBase(String name, CreativeTabs tabs) {
		super(name + "_charm", BaubleType.CHARM, tabs);
	}

}
