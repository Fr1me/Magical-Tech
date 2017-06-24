package net.magicaltech.item.tools;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemHoeBase extends ItemHoe {
	
	public ItemHoeBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name + "_hoe");
		setRegistryName(name + "_hoe");
		setCreativeTab(MTCreativeTabs.tools);
	}

}
