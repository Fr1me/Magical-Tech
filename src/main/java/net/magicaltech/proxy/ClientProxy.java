package net.magicaltech.proxy;

import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.DefaultIconRegistrar;
import keri.ninetaillib.texture.IIconRegistrar;
import net.magicaltech.client.RenderingRegisteryThings;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy implements IMTProxy {
	
	private static final DefaultIconRegistrar iconRegistrar = new DefaultIconRegistrar();
	private static final RenderingRegisteryThings renderingRegistry = new RenderingRegisteryThings();
	
	@Override
	public void registerRenders() {
		MTItems.registerRenders();
		MTBlocks.registerRenders();
		MTTools.registerRenders();
		MTArmor.registerRenders();
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MTItems.init();
		MTBlocks.init();
		MTTools.init();
		MTArmor.init();
		
        MTCreativeTabs.initTabs();
	}
	
	@Override
    public IRenderingRegistry getRenderingRegistry() {
        return renderingRegistry;
    }

    @Override
    public IIconRegistrar getIconRegistrar() {
        return iconRegistrar;
    }

	@Override
	public void init(FMLInitializationEvent event) {

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

}
