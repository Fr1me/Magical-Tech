package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.item.ItemBase;
import net.magicaltech.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
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
	public static Item iStone;
	public static Item cIStone;
	public static Item rQuartz;
	
	public static void init() {
//		Normal Items
		magicWand = new ItemBase("wand", false);
		pIron = new ItemBase("prophecy_iron_ingot", false);
		tIngot = new ItemBase("transistium_ingot", true);
		tNugget = new ItemBase("transistium_nugget", false);
		tPiece = new ItemBase("transistium_piece", false);
		tFragment = new ItemBase("transistium_fragment", false);
		tTFragment = new ItemBase("tiny_transistium_fragment", false);
		iStone = new ItemBase("illusion_stone", false);
		cIStone = new ItemBase("cursed_illusion_stone", true);
		rQuartz = new ItemBase("rose_quartz", false);
		
//		Seeds
		seedTransition = new ItemSeeds(MTBlocks.cropTransition, Blocks.FARMLAND).setUnlocalizedName("transition_seeds").setRegistryName("transition_seeds").setCreativeTab(MTCreativeTabs.items);
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
		registerItem(iStone);
		registerItem(cIStone);
		registerItem(rQuartz);
		
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
		registerRender(iStone, 0, null);
		registerRender(cIStone, 0, null);
		registerRender(rQuartz, 0, null);
		
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
