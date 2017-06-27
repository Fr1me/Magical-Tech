package net.magicaltech.blocks;

import net.magicaltech.MagicalTech;
import net.magicaltech.tile.TileResearchTable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockResearchTable extends BlockTCDevice
    implements IBlockFacingHorizontal
{

    public BlockResearchTable()
    {
        super(Material.WOOD, TileResearchTable.class);
        setSoundType(this.getSoundType());
    }

    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return false;
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, 
            float hitZ)
    {
        if(world.isRemote)
        {
            return true;
        } else
        {
            player.openGui(MagicalTech.instance, 10, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, 
            EntityLivingBase placer)
    {
        IBlockState bs = getDefaultState();
        bs = bs.withProperty(IBlockFacingHorizontal.FACING, placer.getHorizontalFacing());
        return bs;
    }
}
