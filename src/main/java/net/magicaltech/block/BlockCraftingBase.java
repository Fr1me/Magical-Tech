package net.magicaltech.block;

import net.magicaltech.MagicalTech;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.init.MTCreativeTabs;
import net.magicaltech.tile.TileCraftingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCraftingBase extends BlockMachineBase{

	public BlockCraftingBase(String name) {
		super(name, new TileCraftingBase());
		setCreativeTab(MTCreativeTabs.machines);
	}
	
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {	
    	if(!playerIn.isSneaking()){
			playerIn.openGui(MagicalTech.instance, MTGuiHandler.CRAFTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return false;
    }
    
}
