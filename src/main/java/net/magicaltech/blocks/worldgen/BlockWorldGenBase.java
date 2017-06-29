package net.magicaltech.blocks.worldgen;

import net.magicaltech.Reference;
import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.blocks.BlockOreBase;

public class BlockWorldGenBase extends BlockOreBase{

	public BlockWorldGenBase(String name) {
		super(Reference.MODID, name, MTCreativeTabs.worldgen);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
