package net.magicaltech.item;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword {

	public ItemSwordBase(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MTCreativeTabs.combat);
	}

}
