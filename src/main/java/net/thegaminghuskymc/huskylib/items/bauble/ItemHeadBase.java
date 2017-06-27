package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemHeadBase extends ItemBaubleBase{

	public ItemHeadBase(String name, CreativeTabs tabs) {
		super(name + "_head", BaubleType.HEAD, tabs);
	}

}
