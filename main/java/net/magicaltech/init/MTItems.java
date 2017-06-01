package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemBase;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTItems {
	
	public static Item magicWand;
	public static Item pIron;
	public static Item tIngot;
	public static Item seedTransition;
	public static Item tNugget;
	public static Item tPiece;
	public static Item tFragment;
	public static Item tTFragment;
	
	public static void init() {
//		Normal Items
		magicWand = new ItemBase("wand", MTCreativeTabs.items);
		pIron = new ItemBase("prophecy_iron", MTCreativeTabs.items);
		tIngot = new ItemBase("transistium_ingot", MTCreativeTabs.items);
		tNugget = new ItemBase("transistium_nugget", MTCreativeTabs.items);
		tPiece = new ItemBase("transistium_piece", MTCreativeTabs.items);
		tFragment = new ItemBase("transistium_fragment", MTCreativeTabs.items);
		tTFragment = new ItemBase("tiny_transistium_fragment", MTCreativeTabs.items);
		
//		Seeds
		seedTransition = new ItemSeeds(MTBlocks.cropTransition, Blocks.FARMLAND).setUnlocalizedName("transition_seeds").setRegistryName("transition_seeds");
	}
	
	public static void register() {
//		Normal Items
		registerItem(magicWand);
		registerItem(pIron);
		registerItem(tIngot);
		registerItem(tNugget);
		registerItem(tPiece);
		registerItem(tFragment);
		registerItem(tTFragment);
		
//		Seeds
		registerItem(seedTransition);
	}
	
	public static void registerRenders() {
//		Normal Items
		registerRender(magicWand, 0, null);
		registerRender(pIron, 0, null);
		registerRender(tIngot, 0, null);
		registerRender(tNugget, 0, null);
		registerRender(tPiece, 0, null);
		registerRender(tFragment, 0, null);
		registerRender(tTFragment, 0, null);
		
//		Seeds
		registerRender(seedTransition, 0, null);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + item.getUnlocalizedName().substring(5));
	}

}
