package net.magicaltech.client.container;

import net.magicaltech.client.container.builder.BuiltContainer;
import net.minecraft.entity.player.EntityPlayer;

public interface IContainerProvider {
	BuiltContainer createContainer(EntityPlayer player);
}
