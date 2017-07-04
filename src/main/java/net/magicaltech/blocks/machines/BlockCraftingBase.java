package net.magicaltech.blocks.machines;

import net.magicaltech.init.MTCreativeTabs;
import net.thegaminghuskymc.huskylib.lib.blocks.BlockMachineBase;

public class BlockCraftingBase extends BlockMachineBase{

	public BlockCraftingBase(String name) {
		super(name, MTCreativeTabs.machines);
	}
	
	/*@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, 
    		EnumFacing facing, float hitX, float hitY, float hitZ){	
    	if(!playerIn.isSneaking() && worldIn.isRemote){
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
		}
		return false;
    }*/
    
}
