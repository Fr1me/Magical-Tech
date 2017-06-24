package net.magicaltech.item.tools;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword {

	public ItemSwordBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name + "_sword");
		setRegistryName(name + "_sword");
		setCreativeTab(MTCreativeTabs.combat);
	}

}
