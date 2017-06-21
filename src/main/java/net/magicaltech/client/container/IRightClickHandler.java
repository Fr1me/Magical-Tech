package net.magicaltech.client.container;

import net.magicaltech.client.container.builder.BuiltContainer;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Mark on 12/04/2017.
 */
public interface IRightClickHandler {

	public boolean handleRightClick(int slotID, EntityPlayer player, BuiltContainer container);
}
