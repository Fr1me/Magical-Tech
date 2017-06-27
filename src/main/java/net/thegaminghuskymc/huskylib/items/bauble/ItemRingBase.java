package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemRingBase extends ItemBaubleBase{

	public ItemRingBase(String name, CreativeTabs tabs) {
		super(name + "_ring", BaubleType.RING, tabs);
	}

}
