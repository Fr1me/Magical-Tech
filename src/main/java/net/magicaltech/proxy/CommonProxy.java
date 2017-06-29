package net.magicaltech.proxy;

import java.io.File;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.blocks.other.BlockProphechyIronStorage;
import net.magicaltech.blocks.other.BlockRoseQuartzStorage;
import net.magicaltech.blocks.other.BlockTransistiumStorage;
import net.magicaltech.blocks.worldgen.BlockHardenedStone;
import net.magicaltech.blocks.worldgen.BlockProphecyIronNetherOre;
import net.magicaltech.blocks.worldgen.BlockProphecyIronOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzNetherOre;
import net.magicaltech.blocks.worldgen.BlockRoseQuartzOre;
import net.magicaltech.config.Config;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.init.MTBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class CommonProxy implements IMTProxy {

    /*@Override
    public void registerTileEntities() {
    	GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + ":generator_base");
		GameRegistry.registerTileEntity(TileEntityMachineBase.class, Reference.MODID + ":machine_base");
		GameRegistry.registerTileEntity(TileCraftingBase.class, Reference.MODID + ":crafter_base");
    }*/
    
    // Config instance
    public static Configuration config;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
    	File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "magicaltech.cfg"));
        Config.readConfig();
    }

    @Override
    public void init(FMLInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(MagicalTech.instance, new MTGuiHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    	if (config.hasChanged()) {
            config.save();
        }
    }
    
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
        
//        event.getRegistry().register(new BlockBaseMT());
//        event.getRegistry().register(new BlockGeneratorBase());

//        GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + "_generator_base");
//        GameRegistry.registerTileEntity(TileCraftingBase.class, Reference.MODID + "_crafter_base");
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
//        event.getRegistry().register(new ItemBlock(MTBlocks.cGen).setRegistryName(MTBlocks.cGen.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(MTBlocks.mGen).setRegistryName(MTBlocks.mGen.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(MTBlocks.nnGen).setRegistryName(MTBlocks.nnGen.getRegistryName()));
//        event.getRegistry().register(new ItemBlock(MTBlocks.fGen).setRegistryName(MTBlocks.fGen.getRegistryName()));
    }
    
}
