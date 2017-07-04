package net.thegaminghuskymc.huskylib.lib.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.lib.utils.ProxyRegistry;

public class BlockNetherOreBase extends Block {
	
	public BlockNetherOreBase(String modid, String name, CreativeTabs creativetab) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(modid, name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(creativetab);
		ProxyRegistry.register(this);
		ProxyRegistry.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
