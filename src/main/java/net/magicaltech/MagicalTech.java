package net.magicaltech;

import java.util.logging.Logger;

import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.handler.MTRecipeHandler;
import net.magicaltech.init.MTArmor;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.magicaltech.init.MTTools;
import net.magicaltech.proxy.IMTProxy;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.magicaltech.tile.TileEntityMachineBase;
import net.magicaltech.util.Utils;
import net.magicaltech.world.gen.OreGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MC_VERSION)
public class MagicalTech {

	@Mod.Instance(Reference.MODID)
	public static MagicalTech instance;
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static IMTProxy proxy;
	public static Logger logger = Logger.getLogger(Reference.NAME);

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

		GameRegistry.registerTileEntity(TileEntityMachineBase.class, Reference.MODID + ":machine_base");
		GameRegistry.registerTileEntity(TileEntityGeneratorBase.class, Reference.MODID + ":generator_base");
		NetworkRegistry.INSTANCE.registerGuiHandler(MagicalTech.instance, new MTGuiHandler());

		proxy.registerRenders();
		proxy.registerTileEntities();

		Utils.getLogger().info("Pre-Initialization Complete");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		Utils.getLogger().info("Initializing");

		proxy.init(event);

		GameRegistry.registerWorldGenerator(new OreGen(), 0);

		MTRecipeHandler.registerCraftingRecipes();
		MTRecipeHandler.registerSmeltingRecipes();
		MTRecipeHandler.registerArmorRecipes();
		MTRecipeHandler.registerToolRecipes();

		Utils.getLogger().info("Initialization Complete");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Utils.getLogger().info("Post-Initializing");

		proxy.postInit(event);

		Utils.getLogger().info("Post-Initialization Complete");
	}

}
