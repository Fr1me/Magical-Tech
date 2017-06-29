package net.magicaltech;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.proxy.CommonProxy;
import net.magicaltech.proxy.IMTProxy;
import net.magicaltech.tile.TileCraftingBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.huskylib.tiles.TileEntityMachineBase;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPS ,acceptedMinecraftVersions = Reference.MC_VERSION)
public class MagicalTech {

	@Mod.Instance(Reference.MODID)
	public static MagicalTech instance;
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	public static Logger logger;
	
	public static IMTLogger loggerMT;
	
	static {
		FluidRegistry.enableUniversalBucket();
		FluidRegistry.validateFluidRegistry();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
//		logger.log(Level.INFO, "Pre-Initializing");
		logger = event.getModLog();

		proxy.preInit(event);

		MTItems.init();
		MTTools.init();
		MTArmor.init();
		MTItems.register();
		MTTools.register();
		MTArmor.register();

		GameRegistry.registerTileEntity(TileEntityMachineBase.class, Reference.MODID + ":machine_base");
		GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + ":generator_base");
		GameRegistry.registerTileEntity(TileCraftingBase.class, Reference.MODID + ":crafter_base");
		NetworkRegistry.INSTANCE.registerGuiHandler(MagicalTech.instance, new MTGuiHandler());

//		logger.log(Level.INFO, "Pre-Initialization Complete");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
//		logger.log(Level.INFO, "Initializing");

		proxy.init(event);

//		GameRegistry.registerWorldGenerator(new OreGen(), 0);

//		MTRecipeHandler.registerCraftingRecipes();
//		MTRecipeHandler.registerSmeltingRecipes();
//		MTRecipeHandler.registerArmorRecipes();
//		MTRecipeHandler.registerToolRecipes();

//		logger.log(Level.INFO, "Initialization Complete");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
//		logger.log(Level.INFO, "Post-Initializing");

		proxy.postInit(event);

//		logger.log(Level.INFO, "Post-Initialization Complete");
	}

}
