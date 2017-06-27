package net.magicaltech.blocks;

import java.util.ArrayList;

import net.magicaltech.BlockStateUtils;
import net.magicaltech.tile.TileEntityTC;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTCDevice extends BlockTC
    implements ITileEntityProvider
{

    public BlockTCDevice(Material mat, Class<?> tc)
    {
        super(mat);
        setHardness(2.0F);
        setResistance(20F);
        tileClass = tc;
        isBlockContainer = true;
        IBlockState bs = blockState.getBaseState();
        if(this instanceof IBlockFacingHorizontal)
            bs.withProperty(IBlockFacingHorizontal.FACING, EnumFacing.NORTH);
        else
        if(this instanceof IBlockFacing)
            bs.withProperty(IBlockFacing.FACING, EnumFacing.UP);
        if(this instanceof IBlockEnabled)
            bs.withProperty(IBlockEnabled.ENABLED, Boolean.valueOf(true));
        setDefaultState(bs);
    }

    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
    {
        return true;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
    	return new TileEntityTC();
    }

    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        updateState(worldIn, pos, state);
    }

    /*public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if(tileentity != null && (tileentity instanceof IInventory) && !keepInventory)
            InventoryUtils.dropItems(worldIn, pos);
        if(tileentity != null && (tileentity instanceof IEssentiaTransport) && spillEssentia && !worldIn.isRemote)
        {
            int ess = ((IEssentiaTransport)tileentity).getEssentiaAmount(EnumFacing.UP);
            if(ess > 0)
                AuraHelper.pollute(worldIn, pos, ess, true);
        }
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }*/

    /*public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        updateState(worldIn, pos, state);
    }

    public boolean func_180648_a(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity != null ? tileentity.receiveClientEvent(eventID, eventParam) : false;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, 
            EntityLivingBase placer)
    {
        IBlockState bs = getDefaultState();
        if(this instanceof IBlockFacingHorizontal)
            bs = bs.withProperty(IBlockFacingHorizontal.FACING, placer.isSneaking() ? ((Comparable) (placer.getHorizontalFacing())) : ((Comparable) (placer.getHorizontalFacing().getOpposite())));
        if(this instanceof IBlockFacing)
            bs = bs.withProperty(IBlockFacing.FACING, placer.isSneaking() ? ((Comparable) (BlockPistonBase.(worldIn, pos, placer).getOpposite())) : ((Comparable) (BlockPistonBase.func_180695_a(worldIn, pos, placer))));
        if(this instanceof IBlockEnabled)
            bs = bs.withProperty(IBlockEnabled.ENABLED, Boolean.valueOf(true));
        return bs;
    }*/

    protected void updateState(World worldIn, BlockPos pos, IBlockState state)
    {
        if(this instanceof IBlockEnabled)
        {
            boolean flag = !worldIn.isBlockPowered(pos);
            if(flag != ((Boolean)state.getValue(IBlockEnabled.ENABLED)).booleanValue())
                worldIn.setBlockState(pos, state.withProperty(IBlockEnabled.ENABLED, Boolean.valueOf(flag)), 3);
        }
    }

    public void updateFacing(World world, BlockPos pos, EnumFacing face)
    {
        if((this instanceof IBlockFacing) || (this instanceof IBlockFacingHorizontal))
        {
            if(face == BlockStateUtils.getFacing(world.getBlockState(pos)))
                return;
            if((this instanceof IBlockFacingHorizontal) && face.getHorizontalIndex() >= 0)
                world.setBlockState(pos, world.getBlockState(pos).withProperty(IBlockFacingHorizontal.FACING, face), 3);
            if(this instanceof IBlockFacing)
                world.setBlockState(pos, world.getBlockState(pos).withProperty(IBlockFacing.FACING, face), 3);
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState bs = getDefaultState();
        try
        {
            if(this instanceof IBlockFacingHorizontal)
                bs = bs.withProperty(IBlockFacingHorizontal.FACING, BlockStateUtils.getFacing(meta));
            if(this instanceof IBlockFacing)
                bs = bs.withProperty(IBlockFacing.FACING, BlockStateUtils.getFacing(meta));
            if(this instanceof IBlockEnabled)
                bs = bs.withProperty(IBlockEnabled.ENABLED, Boolean.valueOf(BlockStateUtils.isEnabled(meta)));
        }
        catch(Exception e) { }
        return bs;
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = (this instanceof IBlockFacingHorizontal) ? b0 | ((EnumFacing)state.getValue(IBlockFacingHorizontal.FACING)).getIndex() : (this instanceof IBlockFacing) ? b0 | ((EnumFacing)state.getValue(IBlockFacing.FACING)).getIndex() : ((int) (b0));
        if((this instanceof IBlockEnabled) && !((Boolean)state.getValue(IBlockEnabled.ENABLED)).booleanValue())
            i |= 8;
        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        ArrayList<PropertyHelper> ip = new ArrayList<PropertyHelper>();
        if(this instanceof IBlockFacingHorizontal)
            ip.add(IBlockFacingHorizontal.FACING);
        if(this instanceof IBlockFacing)
            ip.add(IBlockFacing.FACING);
        if(this instanceof IBlockEnabled)
            ip.add(IBlockEnabled.ENABLED);
        return ip.size() != 0 ? new BlockStateContainer(this, (IProperty[])ip.toArray(new IProperty[ip.size()])) : super.createBlockState();
    }

    protected final Class<?> tileClass;
    protected static boolean keepInventory = false;
    protected static boolean spillEssentia = true;

}
