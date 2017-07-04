package net.magicaltech.blocks.worldgen;

import net.magicaltech.Reference;
import net.magicaltech.init.MTCreativeTabs;
import net.thegaminghuskymc.huskylib.lib.blocks.BlockOreBase;

public class BlockWorldGenBase extends BlockOreBase{

	public BlockWorldGenBase(String name) {
		super(Reference.MODID, name, MTCreativeTabs.worldgen);
	}

}
