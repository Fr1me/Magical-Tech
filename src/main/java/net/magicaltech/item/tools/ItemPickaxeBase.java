package net.magicaltech.item.tools;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeBase extends ItemPickaxe {

	public ItemPickaxeBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name + "_pickaxe");
		setRegistryName(name + "_pickaxe");
		setCreativeTab(MTCreativeTabs.tools);
	}

}
