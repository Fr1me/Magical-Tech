package net.magicaltech.tile;

import net.minecraft.util.EnumFacing;
import reborncore.common.powerSystem.TilePowerAcceptor;
import reborncore.common.util.Inventory;

public class TilePoweredBase extends TilePowerAcceptor{
	
	public static int maxInput = 8192;
	public static int baseOutput = 16;
	public static int storagePerBlock = 1000000;
	public static int extraIOPerBlock = 8;

	public int connectedBlocks = 0;
	public Inventory inventory = new Inventory(2, "TilePoweredBase", 64, this);
	private double euLastTick = 0;
	private double euChange;
	private int ticks;
	private int output;
	private int maxStorage;

	public double getEuChange() {
		if (euChange == -1) {
			return 0;
		}
		return (euChange / ticks);
	}

	@Override
	public double getBaseMaxPower() {
		return maxStorage;
	}

	@Override
	public boolean canAcceptEnergy(EnumFacing direction) {
		return direction != getFacingEnum();
	}

	@Override
	public boolean canProvideEnergy(EnumFacing direction) {
		return direction == getFacingEnum();
	}

	@Override
	public double getBaseMaxOutput() {
		return output;
	}

	@Override
	public double getBaseMaxInput() {
		return maxInput;
	}

}
