package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.blocks.machines.BlockCoalGenerator;
import net.magicaltech.blocks.machines.BlockFluffyGenerator;
import net.magicaltech.blocks.machines.BlockMagicalGenerator;
import net.magicaltech.blocks.machines.BlockNuffNuffGenerator;
import net.magicaltech.blocks.other.BlockProphechyIronStorage;
import net.magicaltech.blocks.other.BlockRoseQuartzStorage;
import net.magicaltech.blocks.other.BlockTransistiumStorage;
import net.magicaltech.blocks.worldgen.BlockHardenedStone;
import net.magicaltech.blocks.worldgen.BlockProphecyIronNetherOre;
import net.magicaltech.blocks.worldgen.BlockProphecyIronOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzNetherOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	
	@GameRegistry.ObjectHolder(BlockCoalGenerator.INTERNAL_NAME)
	public static final BlockCoalGenerator cGen = null;
	
	@GameRegistry.ObjectHolder(BlockMagicalGenerator.INTERNAL_NAME)
	public static final BlockMagicalGenerator mGen = null;
	
	@GameRegistry.ObjectHolder(BlockNuffNuffGenerator.INTERNAL_NAME)
	public static final BlockNuffNuffGenerator nnGen = null;
	
	@GameRegistry.ObjectHolder(BlockFluffyGenerator.INTERNAL_NAME)
	public static final BlockFluffyGenerator fGen = null;
	
	public static Block grinder;
	
	public static Block crafterT1;
	public static Block crafterT2;
	public static Block crafterT3;
	public static Block crafterTC;
	
	public static Block crafter;
	
	public static Block cropTransition;
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockHardenedStone());
        event.getRegistry().register(new BlockProphecyIronNetherOre());
        event.getRegistry().register(new BlockProphecyIronOre());
        event.getRegistry().register(new BlockRoseQuartzNetherOre());
        event.getRegistry().register(new BlockRoseQuartzOre());
        
        event.getRegistry().register(new BlockProphechyIronStorage());
        event.getRegistry().register(new BlockRoseQuartzStorage());
        event.getRegistry().register(new BlockTransistiumStorage());
        
        event.getRegistry().register(new BlockCoalGenerator());
        event.getRegistry().register(new BlockFluffyGenerator());
        event.getRegistry().register(new BlockMagicalGenerator());
        event.getRegistry().register(new BlockNuffNuffGenerator());

//        GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + "_generator_base");
//        GameRegistry.registerTileEntity(TileCraftingBase.class, Reference.MODID + "_crafter_base");
    }
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        hStone.initModel();
        tBlock.initModel();
        pIBlock.initModel();
        rQBlock.initModel();
        rQOre.initModel();
        plOre.initModel();
        rQNetherOre.initModel();
        plNetherOre.initModel();
        cGen.initModel();
        mGen.initModel();
        nnGen.initModel();
        fGen.initModel();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(MTBlocks.hStone).setRegistryName(MTBlocks.hStone.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.tBlock).setRegistryName(MTBlocks.tBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.pIBlock).setRegistryName(MTBlocks.pIBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.rQBlock).setRegistryName(MTBlocks.rQBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.rQOre).setRegistryName(MTBlocks.rQOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.plOre).setRegistryName(MTBlocks.plOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.rQNetherOre).setRegistryName(MTBlocks.rQNetherOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.plNetherOre).setRegistryName(MTBlocks.plNetherOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.cGen).setRegistryName(MTBlocks.cGen.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.mGen).setRegistryName(MTBlocks.mGen.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.nnGen).setRegistryName(MTBlocks.nnGen.getRegistryName()));
        event.getRegistry().register(new ItemBlock(MTBlocks.fGen).setRegistryName(MTBlocks.fGen.getRegistryName()));
    }

}
