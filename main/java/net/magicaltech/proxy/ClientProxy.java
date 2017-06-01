package net.magicaltech.proxy;

import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy implements IMTProxy {
	
	@Override
	public void registerRenders() {
		MTItems.registerRenders();
		MTBlocks.registerRenders();
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MTItems.init();
		MTBlocks.init();
		
        MTCreativeTabs.initTabs();
	}

	@Override
	public void init(FMLInitializationEvent event) {

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

}
