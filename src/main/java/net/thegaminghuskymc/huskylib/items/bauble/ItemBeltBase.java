package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemBeltBase extends ItemBaubleBase{

	public ItemBeltBase(String name, CreativeTabs tabs) {
		super(name + "_belt", BaubleType.BELT, tabs);
	}

}
