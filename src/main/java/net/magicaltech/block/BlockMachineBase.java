package net.magicaltech.block;

import java.util.Random;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockMachineBase extends Block {
	
	public BlockMachineBase(String name, float hardness, float resistance, String harvestTool, int harvestLevel) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(harvestTool, harvestLevel);
		setCreativeTab(MTCreativeTabs.machines);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return Item.getItemFromBlock(this);
	}

}
