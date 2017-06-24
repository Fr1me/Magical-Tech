package net.magicaltech.item.tools;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemShovelBase extends ItemSpade {
	
	public ItemShovelBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name + "_shovel");
		setRegistryName(name + "_shovel");
		setCreativeTab(MTCreativeTabs.tools);
	}
}
