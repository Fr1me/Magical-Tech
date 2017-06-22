package net.magicaltech.proxy;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.magicaltech.tile.TileEntityMachineBase;
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
    	GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + ":generator_base");
		GameRegistry.registerTileEntity(TileEntityMachineBase.class, Reference.MODID + ":machine_base");
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
