package net.magicaltech.api.machine;

import javax.annotation.Nullable;
import net.minecraftforge.fluids.FluidStack;

public class MachineSlotFluid
  extends MachineSlot<FluidStack>
{
  @Nullable
  public final FluidStack filterStack;
  
  public MachineSlotFluid(String name)
  {
    this(name, 1000, null);
  }
  
  public MachineSlotFluid(String name, int stackCapacity, @Nullable FluidStack filterStack)
  {
    this(name, stackCapacity, false, filterStack);
  }
  
  public MachineSlotFluid(String name, int stackCapacity, boolean optional, @Nullable FluidStack filterStack)
  {
    this(name, stackCapacity, -1, optional, filterStack);
  }
  
  public MachineSlotFluid(String name, int stackCapacity, int color, boolean optional, @Nullable FluidStack filterStack)
  {
    super(name, color, optional, stackCapacity);
    this.filterStack = filterStack;
  }
  
  public MachineSlotFluid(String name, int stackCapacity)
  {
    this(name, stackCapacity, null);
  }
  
  public String toString()
  {
    return "SlotFluid{" + this.name + "}";
  }
  
  public boolean matchesFluidInput(FluidStack stack)
  {
    return (this.filterStack == null) || (this.filterStack.isFluidEqual(stack));
  }
}