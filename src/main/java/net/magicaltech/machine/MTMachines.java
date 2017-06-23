package net.magicaltech.machine;

import net.magicaltech.api.machine.Machine;
import net.magicaltech.api.machine.MachineSlotFluid;
import net.magicaltech.api.machine.MachineSlotItem;

public class MTMachines {
	
	public static final MachineSlotItem INPUT_ITEM = new MachineSlotItem("input");
	public static final MachineSlotFluid INPUT_FLUID = new MachineSlotFluid("input_lava", 4000);
	
	public static Machine cGen;;

}
