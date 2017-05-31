package net.magicaltech;

import net.magicaltech.handler.RecipeHandler;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTItems;
import net.magicaltech.proxy.IMTProxy;
import net.magicaltech.util.Utils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MagicalTech {
	
	@Mod.Instance(Reference.MODID)
	public static MagicalTech instance = new MagicalTech();
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static IMTProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Utils.getLogger().info("Pre-Initializing");
		
        proxy.preInit(event);
        MTBlocks.init();
		MTItems.init();
		MTBlocks.register();
		MTItems.register();
        proxy.registerRenders();
		
		Utils.getLogger().info("Pre-Initialization Complete");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Utils.getLogger().info("Initializing");
		
		proxy.init(event);
		RecipeHandler.registerCraftingRecipes(null);
		RecipeHandler.registerSmeltingRecipes(null);
		
		Utils.getLogger().info("Initialization Complete");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Utils.getLogger().info("Post-Initializing");
		
		proxy.postInit(event);
		
		Utils.getLogger().info("Post-Initialization Complete");
	}

}
