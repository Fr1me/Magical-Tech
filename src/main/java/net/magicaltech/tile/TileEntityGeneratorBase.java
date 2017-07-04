package net.magicaltech.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;
import net.thegaminghuskymc.huskylib.lib.tiles.TileEntityBase;

public class TileEntityGeneratorBase extends TileEntityBase implements ITickable {
	
	private ItemStackHandler handler;
	
	byte facing = 1;

	@Override
	public void update() {
		
		if(world.isRaining()){
			
		}
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("ItemStackHandler", handler.serializeNBT());
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		
	}

}
