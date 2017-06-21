package net.magicaltech.block;

import java.util.List;

import net.magicaltech.MagicalTech;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.magicaltech.tile.TileEntityMachineBase;
import net.magicaltech.util.Names;
import net.magicaltech.util.StringHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BlockGeneratorBase extends BlockMachineBase{

	public BlockGeneratorBase(String name) {
		super(name + "_generator", new TileEntityMachineBase());
	}
	
	@Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(Names.HelpToolTips.SHIFT_FOR_INFO);
        } else {
        	tooltip.add(Names.HelpToolTips.WIP_BLOCK);
        }
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!playerIn.isSneaking()){
			playerIn.openGui(MagicalTech.instance, MTGuiHandler.COAL_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		else
			return false;
	}

}
