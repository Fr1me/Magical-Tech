package net.magicaltech.proxy;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IMTProxy {

    @Override
    public void registerRenders() {
    	
    }
    	
    @Override
    public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityCoalGenerator.class, Reference.MODID + ":coal_generator");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(MagicalTech.instance, new MTGuiHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
