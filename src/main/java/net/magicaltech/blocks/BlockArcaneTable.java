package net.magicaltech.blocks;

import java.util.List;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockArcaneTable extends BlockCraftingBase{

	public BlockArcaneTable() {
		super("arcane_table", MTCreativeTabs.blocks);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) {
		
	}
	
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		
	}
	
	@Override
	public boolean addLandingEffects(IBlockState state, WorldServer worldObj, BlockPos blockPosition,
			IBlockState iblockstate, EntityLivingBase entity, int numberOfParticles) {
		return super.addLandingEffects(state, worldObj, blockPosition, iblockstate, entity, numberOfParticles);
	}
	
	@Override
	public boolean addDestroyEffects(World world, BlockPos pos, ParticleManager manager) {
		return super.addDestroyEffects(world, pos, manager);
	}
	
	@Override
	public boolean addHitEffects(IBlockState state, World worldObj, RayTraceResult target, ParticleManager manager) {
		return super.addHitEffects(state, worldObj, target, manager);
	}
	
	@Override
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		return super.canRenderInLayer(state, layer);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return super.getBoundingBox(state, source, pos);
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

}
