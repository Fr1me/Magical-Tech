package xfireeyez.core.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * 
 * @author EwyBoy
 *
 */

public class PlayerUtils {

    public static boolean canPlayerFit(World world, BlockPos pos) {
        return world.isAirBlock(pos) && world.isAirBlock(pos.up(1));
    }

    public static EnumFacing getPlayerFacing(EntityPlayer player) {
        int playerFacing = MathHelper.floor((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;

        switch (playerFacing) {
            case 0: return EnumFacing.NORTH;
            case 1: return EnumFacing.EAST;
            case 2: return EnumFacing.SOUTH;
            case 3: return EnumFacing.WEST;

            default: return null;
        }
    }
}