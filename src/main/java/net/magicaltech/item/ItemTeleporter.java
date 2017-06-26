package net.magicaltech.item;

import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.init.MTTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import xfireeyez.core.item.ItemBase;
import xfireeyez.core.util.helper.SoundHelper;

public class ItemTeleporter extends ItemBase {	
		
	public ItemTeleporter(String name, CreativeTabs tab, Boolean effect) {
		super(name, tab, effect);
		setMaxStackSize(1);
	
	}

	 @Override
	    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		 
	        if (!world.isRemote) {
	            int distance = 50;
	            Vec3d lookVec = player.getLookVec();
	            Vec3d start = new Vec3d(player.posX, player.posY + player.getEyeHeight(), player.posZ);
	            if (player.isSneaking()) {
	                distance /= 2;
	            }
	            Vec3d end = start.addVector(lookVec.xCoord * distance, lookVec.yCoord * distance, lookVec.zCoord * distance);
	            RayTraceResult position = world.rayTraceBlocks(start, end);
	            if (position == null) {
	                player.setPositionAndUpdate(end.xCoord , end.yCoord, end.zCoord);
	            } else {
	                BlockPos blockPos = position.getBlockPos();
	                int x = blockPos.getX();
	                int y = blockPos.getY();
	                int z = blockPos.getZ();
	                if (world.isAirBlock(blockPos.up()) && world.isAirBlock(blockPos.up(2))) {
	                    player.setPositionAndUpdate(x+.5, y + 1, z+.5);
	                    SoundHelper.playTeleportSound(world, blockPos);
//	                    ParticleEngineHelper.spawnHelixEffect(world, pos.getX(), side == EnumFacing.DOWN ? pos.getY() : pos.down().getY(), pos.getZ(), EnumParticleTypes.PORTAL, 1);
	                } else {
	                    switch (position.sideHit) {
	                        case DOWN:
	                            player.setPositionAndUpdate(x+.5, y - 2, z+.5);
	                            SoundHelper.playTeleportSound(world, blockPos);
	                            break;
	                        case UP:
	                            return new ActionResult(EnumActionResult.FAIL, this);
	                        case NORTH:
	                            player.setPositionAndUpdate(x+.5, y, z - 1 + .5);
	                            SoundHelper.playTeleportSound(world, blockPos);
	                            break;
	                        case SOUTH:
	                            player.setPositionAndUpdate(x+.5, y, z + 1+.5);
	                            SoundHelper.playTeleportSound(world, blockPos);
	                            break;
	                        case WEST:
	                            player.setPositionAndUpdate(x - 1+.5, y, z+.5);
	                            SoundHelper.playTeleportSound(world, blockPos);
	                            break;
	                        case EAST:
	                            player.setPositionAndUpdate(x + 1+.5, y, z+.5);
	                            SoundHelper.playTeleportSound(world, blockPos);
	                            break;
	                    }
	                }
	            }
	        }
	        return ActionResult.newResult(EnumActionResult.SUCCESS, new ItemStack(this));
	    }

		
}
