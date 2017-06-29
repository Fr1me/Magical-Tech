package net.magicaltech.proxy;

import net.magicaltech.client.render.RenderCrafter;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.tile.TileCraftingBase;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	/*@Override
	public void registerRenders() {
		MTItems.registerRenders();
		MTTools.registerRenders();
		MTArmor.registerRenders();
	}*/

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileCraftingBase.class, new RenderCrafter());
		
        MTCreativeTabs.initTabs();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
	@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        MTBlocks.initModels();
    }

}
