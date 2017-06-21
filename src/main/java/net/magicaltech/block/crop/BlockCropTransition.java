package net.magicaltech.block.crop;

import net.magicaltech.Reference;
import net.magicaltech.init.MTItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockCropTransition extends BlockCrops {
	
	public BlockCropTransition(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		registerRender(this);
	}
	
	@Override
	protected Item getSeed() {
		return MTItems.seedTransition;
	}
	
	@Override
	protected Item getCrop() {
		return MTItems.tTFragment;
	}
	
	private static void registerBlock (Block block) {
		GameRegistry.register(block);
	}
	
	private static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
	}

}
