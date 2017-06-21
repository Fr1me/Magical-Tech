package net.magicaltech.item;

import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemSeedBase extends ItemSeeds{

	public ItemSeedBase(String name) {
		super(MTBlocks.cropTransition, Blocks.FARMLAND);
		setUnlocalizedName(name + "_seed");
		setRegistryName(name + "_seed");
		setCreativeTab(MTCreativeTabs.items);
	}

}
