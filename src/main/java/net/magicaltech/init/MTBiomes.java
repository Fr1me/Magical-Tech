//package net.magicaltech.init;
//
//import net.magicaltech.util.Utils;
//import net.magicaltech.world.biome.BiomeBase;
//import net.minecraft.world.biome.Biome;
//import net.minecraftforge.common.BiomeDictionary.Type;
//import net.minecraftforge.common.BiomeManager;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//
//public class MTBiomes {
//	
//	public static Biome BiomeSp00ky;
//	
//	public static void init() {
//		BiomeSp00ky = new BiomeBase(null, 666, Type.FOREST, "sp00ky_biome");
//		BiomeManager.addSpawnBiome(BiomeSp00ky);
//	}
//	
//	public static void register() {
//		registerBiome(BiomeSp00ky);
//	}
//	
//	public static void registerBiome(Biome biome) {
//		GameRegistry.register(biome);
//		Utils.getLogger().info("Registered Biome: " + biome.getBiomeName().substring(5));
//	}
//
//}
