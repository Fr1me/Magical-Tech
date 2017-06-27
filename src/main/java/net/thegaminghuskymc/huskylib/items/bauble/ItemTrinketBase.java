package net.thegaminghuskymc.huskylib.items.bauble;

import baubles.api.BaubleType;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTrinketBase extends ItemBaubleBase{

	public ItemTrinketBase(String name, CreativeTabs tabs) {
		super(name + "_trinket", BaubleType.TRINKET, tabs);
	}

}
