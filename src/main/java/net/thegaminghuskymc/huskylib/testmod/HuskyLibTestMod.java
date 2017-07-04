package net.thegaminghuskymc.huskylib.testmod;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.huskylib.lib.blocks.BlockBase;
import net.thegaminghuskymc.huskylib.testmod.proxy.CommonProxy;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class HuskyLibTestMod {
	
	@Instance(value = Refs.MODID)
	public static HuskyLibTestMod instance = new HuskyLibTestMod();

    @SidedProxy(clientSide = Refs.CSIDE, serverSide = Refs.SSIDE)
    public static CommonProxy proxy;
    
    public static Logger logger = Logger.getLogger(Refs.NAME);
    
    public static Block test_block;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	test_block = new BlockBase(Refs.MODID, "test_block", CreativeTabs.BUILDING_BLOCKS);
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
