package net.thegaminghuskymc.huskylib.lib.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.lib.utils.ProxyRegistry;

public class BlockBase extends Block {

	public BlockBase(String modID, String name, CreativeTabs creativetab) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(modID, name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(creativetab);
		ProxyRegistry.register(this);
		ProxyRegistry.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
