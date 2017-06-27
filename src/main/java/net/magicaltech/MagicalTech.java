package net.magicaltech;

import java.util.logging.Logger;

import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.handler.MTRecipeHandler;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.proxy.IMTProxy;
import net.magicaltech.tile.TileCraftingBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.magicaltech.world.gen.OreGen;
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
	public static IMTProxy proxy;
	public static Logger logger = Logger.getLogger(Reference.NAME);
	
	public static IMTLogger loggerMT;
	
	static {
		FluidRegistry.enableUniversalBucket();
		FluidRegistry.validateFluidRegistry();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		loggerMT.logInfo("Pre-Initializing");

		proxy.preInit(event);

		MTBlocks.init();
		MTItems.init();
		MTTools.init();
		MTArmor.init();
		MTBlocks.register();
		MTItems.register();
		MTTools.register();
		MTArmor.register();

		GameRegistry.registerTileEntity(TileEntityMachineBase.class, Reference.MODID + ":machine_base");
		GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + ":generator_base");
		GameRegistry.registerTileEntity(TileCraftingBase.class, Reference.MODID + ":crafter_base");
		NetworkRegistry.INSTANCE.registerGuiHandler(MagicalTech.instance, new MTGuiHandler());

		proxy.registerRenders();
		proxy.registerTileEntities();

		loggerMT.logInfo("Pre-Initialization Complete");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		loggerMT.logInfo("Initializing");

		proxy.init(event);

		GameRegistry.registerWorldGenerator(new OreGen(), 0);

		MTRecipeHandler.registerCraftingRecipes();
		MTRecipeHandler.registerSmeltingRecipes();
		MTRecipeHandler.registerArmorRecipes();
		MTRecipeHandler.registerToolRecipes();

		loggerMT.logInfo("Initialization Complete");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		loggerMT.logInfo("Post-Initializing");

		proxy.postInit(event);

		loggerMT.logInfo("Post-Initialization Complete");
	}

}
