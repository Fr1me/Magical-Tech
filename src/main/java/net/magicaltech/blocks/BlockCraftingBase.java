package net.magicaltech.blocks;

import net.magicaltech.tile.TileCraftingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib.blocks.BlockMachineBase;

public class BlockCraftingBase extends BlockMachineBase{

	public BlockCraftingBase(String name, CreativeTabs creativetab) {
		super(name, new TileCraftingBase(), creativetab);
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, 
    		EnumFacing facing, float hitX, float hitY, float hitZ){	
    	/*if(!playerIn.isSneaking() && worldIn.isRemote){
			if(state.getBlock() == MTBlocks.crafterT1){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.CRAFTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else if(state.getBlock() == MTBlocks.crafterT2){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.CRAFTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else if(state.getBlock() == MTBlocks.crafterT3){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.CRAFTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else if(state.getBlock() == MTBlocks.crafterTC){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.CRAFTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else 
				return false;
		}*/
		
		return false;
    }
    
}
