package net.magicaltech.proxy;

import net.magicaltech.client.render.RenderCrafter;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.tile.TileCraftingBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements IMTProxy {
	
	@Override
	public void registerRenders() {
		MTBlocks.registerRenders();
		MTItems.registerRenders();
		MTTools.registerRenders();
		MTArmor.registerRenders();
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		MTItems.init();
		MTBlocks.init();
		MTTools.init();
		MTArmor.init();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileCraftingBase.class, new RenderCrafter());
		
        MTCreativeTabs.initTabs();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public void registerTileEntities() {
		
	}

}
