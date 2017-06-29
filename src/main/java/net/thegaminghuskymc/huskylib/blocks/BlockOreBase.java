package net.thegaminghuskymc.huskylib.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreBase extends Block {
	
	public BlockOreBase(String modID, String name, CreativeTabs creativetab) {
		super(Material.ROCK);
		setHardness(5.0F);
		setUnlocalizedName(name);
		setRegistryName(modID, name);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(creativetab);
	}

}
