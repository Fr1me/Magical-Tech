package net.magicaltech.blocks.other;

import net.magicaltech.Reference;
import net.magicaltech.init.MTCreativeTabs;
import net.thegaminghuskymc.huskylib.lib.blocks.BlockBase;

public class BlockStorageBase extends BlockBase{

	public BlockStorageBase(String name) {
		super(Reference.MODID, name + "_storage", MTCreativeTabs.blocks);
	}

}
