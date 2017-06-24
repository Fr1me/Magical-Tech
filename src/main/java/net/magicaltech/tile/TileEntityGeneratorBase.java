package net.magicaltech.tile;

import cofh.api.energy.EnergyConfig;
import cofh.api.energy.EnergyStorage;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityGeneratorBase extends TilePoweredBase implements ITickable, IEnergySource {
	
	private ItemStackHandler handler;
	private int totalBurnTime;
	private int burnTime;
	private boolean isBurning;
	
	byte facing = 1;
	protected EnergyStorage energyStorage = new EnergyStorage(100);
	protected EnergyConfig config;
	
	public TileEntityGeneratorBase() {
		handler = new ItemStackHandler(1);
	}
	
	@Override
	public void update() {
		if (world != null) {
			if (!TileEntityFurnace.isItemFuel(handler.getStackInSlot(0))) {
				return;
			}
			
			if (isBurning) {
				
				if(handler.getStackInSlot(0).getItem() != null) {
					isBurning = false;
				}
				
				if (burnTime < 0) {
					handler.setStackInSlot(0, new ItemStack(handler.getStackInSlot(0).getItem(), handler.getStackInSlot(0).getCount() - 1));
					isBurning = false;
					return;
				}
				
				burnTime--;
				return;
				
			}
			
			else if(!isBurning){
                totalBurnTime = burnTime = TileEntityFurnace.getItemBurnTime(handler.getStackInSlot(0));
                isBurning = true;
            }	
		}
	}
	
	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return true;
        return super.hasCapability(capability, facing);
    }
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("ItemStackHandler", handler.serializeNBT());
        compound.setInteger("BurnTime", burnTime);
		return super.writeToNBT(compound);
	}
		
	public boolean isBurning() {
		return isBurning;
	}
		
	public int getTotalBurnTime() {
		return totalBurnTime;
	}
		
	public int getBurnTime() {
		return burnTime;
	}
	
	@Override
	public void drawEnergy(double amount) {
		super.drawEnergy(amount);
	}
	
	@Override
	public boolean emitsEnergyTo(IEnergyAcceptor iEnergyAcceptor, EnumFacing enumFacing) {
		return super.emitsEnergyTo(iEnergyAcceptor, enumFacing);
	}
	
	@Override
	public double getOfferedEnergy() {
		return super.getOfferedEnergy();
	}
	
	@Override
	public int getSourceTier() {
		return super.getSourceTier();
	}

}
