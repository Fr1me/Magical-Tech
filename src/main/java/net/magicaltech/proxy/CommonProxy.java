package net.magicaltech.proxy;

import java.io.File;

import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.config.Config;
import net.magicaltech.handler.MTGuiHandler;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
    
}
