package net.magicaltech.config;

import net.minecraftforge.common.config.Configuration;

public class GeneratorBaseConfiguration {

    public static final String CATEGORY_GENERATOR_BASE = "generator_base";
    public static int MAXENERGY = 500000;
    public static int SENDPERTICK = 2000;
    public static int CHARGEITEMPERTICK = 1000;
    public static int rfPerTick = 60;
    public static int ticksPerCoal = 600;

    public static void init(Configuration cfg) {
        rfPerTick = cfg.get(CATEGORY_GENERATOR_BASE, "generatePerTick", rfPerTick, "Amount of RF generated per tick").getInt();
        ticksPerCoal = cfg.get(CATEGORY_GENERATOR_BASE, "ticksPerCoal", ticksPerCoal, "Amount of ticks generated per coal").getInt();
        MAXENERGY = cfg.get(CATEGORY_GENERATOR_BASE, "generatorMaxRF", MAXENERGY,
                "Maximum RF storage that the generator can hold").getInt();
        SENDPERTICK = cfg.get(CATEGORY_GENERATOR_BASE, "generatorRFPerTick", SENDPERTICK,
                              "RF per tick that the generator can send").getInt();
        CHARGEITEMPERTICK = cfg.get(CATEGORY_GENERATOR_BASE, "generatorChargePerTick", CHARGEITEMPERTICK,
                              "RF per tick that the generator can charge items with").getInt();
    }
}
