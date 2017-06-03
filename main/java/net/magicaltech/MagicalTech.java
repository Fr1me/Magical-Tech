package net.magicaltech;

import net.magicaltech.handler.*;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.proxy.IMTProxy;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.magicaltech.util.Utils;
import net.magicaltech.worldgen.OreGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		MTTools.init();
		MTArmor.init();
		MTBlocks.register();
		MTItems.register();
		MTTools.register();
		MTArmor.register();
		
		GameRegistry.registerTileEntity(TileEntityCoalGenerator.class, Reference.MODID + ":coal_generator");
		NetworkRegistry.INSTANCE.registerGuiHandler(MagicalTech.instance, new MTGuiHandler());
		
		MTAchievementHandler.registerAchievements();
		
		proxy.registerRenders();
        proxy.registerTileEntities();
		
		Utils.getLogger().info("Pre-Initialization Complete");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Utils.getLogger().info("Initializing");
		
		proxy.init(event);
		
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		
		MTRecipeHandler.registerCraftingRecipes(null);
		MTRecipeHandler.registerSmeltingRecipes(null);
		MTRecipeHandler.registerArmorRecipes(null);
		
		MinecraftForge.EVENT_BUS.register(new MTEventHandler());
		
		Utils.getLogger().info("Initialization Complete");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Utils.getLogger().info("Post-Initializing");
		
		proxy.postInit(event);
		
		MinecraftForge.EVENT_BUS.register(new MTEventHandler());
		
		Utils.getLogger().info("Post-Initialization Complete");
	}

}