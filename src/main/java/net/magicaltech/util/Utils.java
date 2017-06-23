package net.magicaltech.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ic2.api.energy.EnergyNet;
import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.config.Config.general;
import net.magicaltech.integration.Hooks;

public class Utils {
	
private static Logger logger;
private static Lang lang;
	
	public static Logger getLogger() {
		if(logger == null) {
			logger = LogManager.getFormatterLogger(Reference.MODID);
		}
		return logger;
	}
	
	public static Lang getLang() {
		if(lang == null) {
			lang = new Lang(Reference.MODID);
		}
		return lang;
	}
	
	public static boolean useRF() {
	
		return !general.blacklistRF;
		
	}
	
	public static boolean useTesla() {
		
		return MagicalTech.hooks.TeslaLoaded && !general.blacklistTesla;
		
	}
	
	public static boolean useForge() {
	
		return !general.blacklistForge;
		
	}
	
	public static boolean useIC2() {
	
		return MagicalTech.hooks.IC2Loaded && EnergyNet.instance != null && !general.blacklistIC2;
	}

}
