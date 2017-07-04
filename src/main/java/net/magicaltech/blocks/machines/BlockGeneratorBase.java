package net.magicaltech.blocks.machines;

import java.util.List;

import net.magicaltech.MagicalTech;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.init.MTBlocks;
import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib.lib.blocks.BlockMachineBase;
import net.thegaminghuskymc.huskylib.lib.utils.Names;
import net.thegaminghuskymc.huskylib.lib.utils.StringHelper;

public class BlockGeneratorBase extends BlockMachineBase{

	public BlockGeneratorBase(String name) {
		super(name + "_generator", MTCreativeTabs.machines);
	}
	
	@Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.shiftForDetails());
        } else {
        	tooltip.add(Names.HelpToolTips.WIP_BLOCK);
        }
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!playerIn.isSneaking() && worldIn.isRemote){
			if(state.getBlock() == MTBlocks.cGen){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.COAL_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else if(state.getBlock() == MTBlocks.mGen){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.MAGICAL_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else if(state.getBlock() == MTBlocks.nnGen){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.NUFF_NUFF_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else if(state.getBlock() == MTBlocks.fGen){
				playerIn.openGui(MagicalTech.instance, MTGuiHandler.FLUFFY_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else 
				return false;
		}
		
		return false;
	}

}
