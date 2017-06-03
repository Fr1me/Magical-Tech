package net.magicaltech.item;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemShovelBase extends ItemSpade {
	
	public ItemShovelBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MTCreativeTabs.tools);
	}
}
