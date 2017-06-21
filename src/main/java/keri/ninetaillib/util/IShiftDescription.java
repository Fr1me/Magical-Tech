package keri.ninetaillib.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public interface IShiftDescription {

    void addDescription(ItemStack stack, World player, List<String> tooltip);

}
