package net.thegaminghuskymc.huskylib.tiles;

import ic2.api.energy.tile.IEnergyEmitter;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityMachineBase extends TileEntity implements IEnergySink{
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		return compound;
	}
	
	@Override
	public boolean canRenderBreaking() {
		return true;
	}

	@Override
	public boolean acceptsEnergyFrom(IEnergyEmitter emitter, EnumFacing side) {
		return true;
	}

	@Override
	public double getDemandedEnergy() {
		return 0;
	}

	@Override
	public int getSinkTier() {
		return 0;
	}

	@Override
	public double injectEnergy(EnumFacing directionFrom, double amount, double voltage) {
		return 0;
	}

}
