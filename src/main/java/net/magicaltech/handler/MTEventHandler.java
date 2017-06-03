package net.magicaltech.handler;

import net.magicaltech.init.MTItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class MTEventHandler {
	
	@SubscribeEvent
	public void itemCrafted(ItemCraftedEvent event) {
		if(event.crafting.getItem().equals(MTItems.tIngot)) {
			event.player.addStat(MTAchievementHandler.achievementTransistium, 1);
		}
			
		
	}

}
