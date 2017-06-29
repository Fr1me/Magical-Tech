package net.magicaltech.blocks.other;

import net.magicaltech.Reference;
import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

public class BlockStorageBase extends BlockBase{

	public BlockStorageBase(String name) {
		super(Reference.MODID, name, MTCreativeTabs.blocks);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
