package net.magicaltech.tile;

import cofh.api.energy.EnergyConfig;
import cofh.api.energy.EnergyStorage;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.thegaminghuskymc.huskylib.tiles.TileEntityBase;

public class TileEntityGeneratorBase extends TileEntityBase implements ITickable, IEnergySource, IEnergyStorage {
	
	private ItemStackHandler handler;
	
	byte facing = 1;
	protected EnergyStorage energyStorage = new EnergyStorage(100);
	protected EnergyConfig config;

	@Override
	public void update() {
		
		if(world.isRaining()){
			this.addEnergy(100);
		}
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("ItemStackHandler", handler.serializeNBT());
		energyStorage.writeToNBT(compound);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		energyStorage.readFromNBT(tag);
	}

	@Override
	public boolean emitsEnergyTo(IEnergyAcceptor receiver, EnumFacing side) {
		return true;
	}

	@Override
	public double getOfferedEnergy() {
		return 0;
	}

	@Override
	public void drawEnergy(double amount) {
		
	}

	@Override
	public int getSourceTier() {
		return 1;
	}

	@Override
	public int getStored() {
		return energyStorage.getEnergyStored();
	}

	@Override
	public void setStored(int energy) {
		energyStorage.setEnergyStored(energy);
	}

	@Override
	public int addEnergy(int amount) {
		return amount;
	}

	@Override
	public int getCapacity() {
		return energyStorage.getMaxEnergyStored();
	}

	@Override
	public int getOutput() {
		return energyStorage.getMaxExtract();
	}

	@Override
	public double getOutputEnergyUnitsPerTick() {
		return energyStorage.getMaxExtract();
	}

	@Override
	public boolean isTeleporterCompatible(EnumFacing side) {
		if(side == EnumFacing.UP){
			return false;
		}
		else if(side == EnumFacing.DOWN){
			return false;
		}
		else if(side == EnumFacing.NORTH){
			return false;
		}
		else if(side == EnumFacing.SOUTH){
			return true;
		}
		else if(side == EnumFacing.EAST){
			return false;
		}
		else if(side == EnumFacing.WEST){
			return false;
		}
		else
			return false;
	}

}
