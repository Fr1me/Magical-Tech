package net.thegaminghuskymc.huskylib.lib;

import java.util.logging.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib.lib.proxy.CommonProxy;
import net.thegaminghuskymc.huskylib.lib.utils.Refs;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class HuskyLib {
	
	@Instance(value = Refs.MODID)
	public static HuskyLib instance = new HuskyLib();

    @SidedProxy(clientSide = Refs.CSIDE, serverSide = Refs.SSIDE)
    public static CommonProxy proxy;
    
    public static Logger logger = Logger.getLogger(Refs.NAME);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
	

}
