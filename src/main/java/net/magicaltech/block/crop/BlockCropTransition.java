package net.magicaltech.block.crop;

import net.magicaltech.init.MTItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropTransition extends BlockCrops {
	
	public BlockCropTransition(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	@Override
	protected Item getSeed() {
		return MTItems.seedTransition;
	}
	
	@Override
	protected Item getCrop() {
		return MTItems.tFragment;
	}

}
