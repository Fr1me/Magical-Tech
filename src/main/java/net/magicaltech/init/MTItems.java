package net.magicaltech.init;

import org.apache.logging.log4j.Level;

import net.magicaltech.MagicalTech;
import net.minecraft.item.Item;
import net.thegaminghuskymc.huskylib.items.ItemBase;
import net.thegaminghuskymc.huskylib.items.ItemIngotBase;
import net.thegaminghuskymc.huskylib.items.ItemSeedBase;

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
	public static Item flower;
	
	public static Item sIngot;
	
	public static void init() {
//		Normal Items
		magicWand = new ItemBase("wand", MTCreativeTabs.items);
		pIron = new ItemIngotBase("prophecy_iron", MTCreativeTabs.items);
		tIngot = new ItemIngotBase("transistium", MTCreativeTabs.items);
		tNugget = new ItemBase("transistium_nugget", MTCreativeTabs.items);
		tPiece = new ItemBase("transistium_piece", MTCreativeTabs.items);
		tFragment = new ItemBase("transistium_fragment", MTCreativeTabs.items);
		tTFragment = new ItemBase("tiny_transistium_fragment", MTCreativeTabs.items);
		iStone = new ItemBase("illusion_stone", MTCreativeTabs.items);
		cIStone = new ItemBase("cursed_illusion_stone", MTCreativeTabs.items);
		rQuartz = new ItemBase("rose_quartz", MTCreativeTabs.items);
		flower = new ItemBase("flower", MTCreativeTabs.items);
		
		sIngot = new ItemIngotBase("satanium", MTCreativeTabs.items);
		
//		Seeds
		seedTransition = new ItemSeedBase("transistium", MTBlocks.cropTransition, MTCreativeTabs.items);
	}
	
	public static void register() {
		registerItem(magicWand);
		
		registerItem(pIron);
		registerItem(tIngot);
		registerItem(sIngot);
		registerItem(rQuartz);
		
		registerItem(tNugget);
		registerItem(tPiece);
		registerItem(tFragment);
		registerItem(tTFragment);
	}
	
	public static void registerRenders() {
		registerRender(magicWand);
		
		registerRender(pIron);
		registerRender(tIngot);
		registerRender(sIngot);
		registerRender(rQuartz);
		
		registerRender(tNugget);
		registerRender(tPiece);
		registerRender(tFragment);
		registerRender(tTFragment);
	}
	
	public static void registerItem(Item item) {
		RebornRegistry.registerItem(item);
		MagicalTech.logger.log(Level.INFO, "Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		RebornRegistry.registerItemModel(item, 0);
		MagicalTech.logger.log(Level.INFO, "Registered Render For " + item.getUnlocalizedName().substring(5));
	}

}
