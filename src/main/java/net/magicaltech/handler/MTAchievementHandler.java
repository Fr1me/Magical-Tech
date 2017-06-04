package net.magicaltech.handler;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.magicaltech.Reference;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MTAchievementHandler {
	
	private static List<Achievement> achievementsMT = new ArrayList<Achievement>();
	
	public static Achievement achievementJoinWorld = createAchievement("join_world", 0, 0, MTItems.flower, (Achievement)null);
	public static Achievement achievementTransistium = createAchievement("transistium", 2, 1, MTItems.tIngot, (Achievement)achievementJoinWorld);
	
	public static void registerAchievements() {
		Achievement[] achievementArray = new Achievement[achievementsMT.size()];
		for(Achievement achievement : achievementsMT) {
			achievement.initIndependentStat();
			achievement.registerStat();
			achievementArray[achievementsMT.indexOf(achievement)] = achievement;
		}
		AchievementPage.registerAchievementPage(new AchievementPage(Reference.NAME, achievementArray));
	}
	
	private static Achievement createAchievement(String name, int column, int row, Item item, Achievement parent) {
		Achievement acheivement = new Achievement("achievement." + name, name, column, row, item, (Achievement)null); //The null is for the parent this is if one achievement requires another to unlock it
		achievementsMT.add(acheivement);
		return acheivement;
	}
	
	private static Achievement createAchievement(String name, int column, int row, Block block, Achievement parent) {
		Achievement acheivement = new Achievement("achievement." + name, name, column, row, block, (Achievement)null);
		achievementsMT.add(acheivement);
		return acheivement;
	}
	
	private static Achievement createAchievement(String name, int column, int row, ItemStack stack, Achievement parent) {
		Achievement acheivement = new Achievement("achievement." + name, name, column, row, stack, (Achievement)null);
		achievementsMT.add(acheivement);
		return acheivement;
	}

}