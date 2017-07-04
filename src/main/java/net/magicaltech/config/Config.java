
package net.magicaltech.config;

import org.apache.logging.log4j.Level;

import net.magicaltech.MagicalTech;
import net.magicaltech.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_WORLDGEN = "worldgen";

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1) {
            MagicalTech.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration of the mod");
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_WORLDGEN, "Worldgen configuration");
    }
}