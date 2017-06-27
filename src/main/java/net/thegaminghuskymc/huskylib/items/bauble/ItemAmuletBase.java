package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemAmuletBase extends ItemBaubleBase{

	public ItemAmuletBase(String name, CreativeTabs tabs) {
		super(name + "_amulet", BaubleType.AMULET, tabs);
	}

}
