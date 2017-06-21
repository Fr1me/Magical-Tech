package net.magicaltech.block;

import java.util.Random;

import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

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
	
	/*@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		if(this.getDefaultState() == MTBlocks.rQOre){
			return MTItems.rQuartz;
		}
		else if(this.getDefaultState() == MTBlocks.plOre){
			return MTItems.pIron;
		}
		else if(this.getDefaultState() == MTBlocks.tOre){
			return MTItems.tIngot;
		}
		else
			return Item.getItemFromBlock(this);
	}*/

}
