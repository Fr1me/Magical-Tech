package net.magicaltech.integration;

import net.minecraftforge.fml.common.Loader;

public final class Hooks {
	
	public boolean IC2Loaded = false;
//	public boolean RailcraftLoaded = false;
	public boolean CoFHCoreLoaded = false;
//	public boolean TELoaded = false;
//	public boolean CCLoaded = false;
//	public boolean AE2Loaded = false;
	public  boolean TeslaLoaded = false;
//	public boolean MCMPLoaded = false;
	
	public void hook() {
		
		if(Loader.isModLoaded("CoFHCore")) CoFHCoreLoaded = true;
		if(Loader.isModLoaded("IC2")) IC2Loaded = true;
//		if(Loader.isModLoaded("Railcraft")) RailcraftLoaded = true;
//		if(Loader.isModLoaded("ThermalExpansion")) TELoaded = true;
//		if(Loader.isModLoaded("ComputerCraft")) CCLoaded = true;
//		if(Loader.isModLoaded("appliedenergistics2")) AE2Loaded = true;
		if(Loader.isModLoaded("tesla")) TeslaLoaded = true;
//		if(Loader.isModLoaded("mcmultipart")) MCMPLoaded = true;
		
	}
	
	

}
