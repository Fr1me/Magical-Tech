package net.magicaltech.proxy;

import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		MTItems.registerRenders();
		MTBlocks.registerRenders();
	}

}
