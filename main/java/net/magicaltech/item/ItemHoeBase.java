package net.magicaltech.item;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemHoeBase extends ItemHoe {
	
	public ItemHoeBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MTCreativeTabs.tools);
	}

}
