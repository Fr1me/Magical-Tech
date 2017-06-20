package net.magicaltech.block;

import net.magicaltech.MagicalTech;
import net.magicaltech.handler.MTGuiHandler;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCoalGenerator extends BlockMachineBase implements ITileEntityProvider {

	public BlockCoalGenerator(String name, float hardness, float resistance, String harvestTool, int harvestLevel) {
		super(name, hardness, resistance, harvestTool, harvestLevel);
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCoalGenerator();
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
