package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBodyBase extends ItemBaubleBase{

	public ItemBodyBase(String name, CreativeTabs tabs) {
		super(name + "_body", BaubleType.BODY, tabs);
	}

}
