package net.magicaltech.proxy;

import net.magicaltech.init.ModBlocks;
import net.magicaltech.init.ModItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

}
