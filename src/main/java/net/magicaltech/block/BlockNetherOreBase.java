package net.magicaltech.block;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNetherOreBase extends Block {
	
	public BlockNetherOreBase(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(MTCreativeTabs.worldgen);
	}

}
