package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.blocks.other.BlockProphechyIronStorage;
import net.magicaltech.blocks.other.BlockRoseQuartzStorage;
import net.magicaltech.blocks.other.BlockTransistiumStorage;
import net.magicaltech.blocks.worldgen.BlockHardenedStone;
import net.magicaltech.blocks.worldgen.BlockProphecyIronNetherOre;
import net.magicaltech.blocks.worldgen.BlockProphecyIronOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzNetherOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
@GameRegistry.ObjectHolder(Reference.MODID)
public class MTBlocks {

	@GameRegistry.ObjectHolder(BlockHardenedStone.INTERNAL_NAME)
	public static final BlockHardenedStone hStone = null;
	
	@GameRegistry.ObjectHolder(BlockTransistiumStorage.INTERNAL_NAME)
	public static final BlockTransistiumStorage tBlock = null;
	
	@GameRegistry.ObjectHolder(BlockProphechyIronStorage.INTERNAL_NAME)
	public static final BlockProphechyIronStorage pIBlock = null;
	
	@GameRegistry.ObjectHolder(BlockRoseQuartzStorage.INTERNAL_NAME)
	public static final BlockRoseQuartzStorage rQBlock = null;
	
	@GameRegistry.ObjectHolder(BlockRoseQuartzOre.INTERNAL_NAME)
	public static final BlockRoseQuartzOre rQOre = null;
	
	@GameRegistry.ObjectHolder(BlockProphecyIronOre.INTERNAL_NAME)
	public static final BlockProphecyIronOre plOre = null;
	
	@GameRegistry.ObjectHolder(BlockRoseQuartzNetherOre.INTERNAL_NAME)
	public static final BlockRoseQuartzNetherOre rQNetherOre = null;
	
	@GameRegistry.ObjectHolder(BlockProphecyIronNetherOre.INTERNAL_NAME)
	public static final BlockProphecyIronNetherOre plNetherOre = null;
	
//	@GameRegistry.ObjectHolder("coal_generator")
//	public static final BlockGeneratorBase cGen = null;
//	
//	@GameRegistry.ObjectHolder("magic_generator")
//	public static final BlockGeneratorBase mGen = null;
//	
//	@GameRegistry.ObjectHolder("nuff_nuff_generator")
//	public static final BlockGeneratorBase nnGen = null;
//	
//	@GameRegistry.ObjectHolder("fluffy_generator")
//	public static final BlockGeneratorBase fGen = null;
	
	public static Block grinder;
	
	public static Block crafterT1;
	public static Block crafterT2;
	public static Block crafterT3;
	public static Block crafterTC;
	
	public static Block crafter;
	
	public static Block cropTransition;
	
	public static Block researchTable;

}
