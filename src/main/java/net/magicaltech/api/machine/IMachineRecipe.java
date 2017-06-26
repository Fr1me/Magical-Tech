package net.magicaltech.api.machine;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import gnu.trove.map.TObjectFloatMap;
import gnu.trove.map.TObjectIntMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fluids.FluidStack;
import xfireeyez.core.compat.StackHelper;

import org.apache.commons.lang3.tuple.Pair;

public abstract interface IMachineRecipe
{
  public static Map<MachineSlotItem, ItemStack> getVanillaContainerItems(Map<MachineSlotItem, ItemStack> inputItems)
  {
    ImmutableMap.Builder<MachineSlotItem, ItemStack> builder = ImmutableMap.builder();
    for (Map.Entry<MachineSlotItem, ItemStack> entry : inputItems.entrySet())
    {
      ItemStack container = ForgeHooks.getContainerItem((ItemStack)entry.getValue());
      if (StackHelper.isNonNull(container)) {
        builder.put(entry.getKey(), container);
      }
    }
    return builder.build();
  }
  
  public abstract List<Pair<Map<MachineSlotItem, List<ItemStack>>, Map<MachineSlotFluid, List<FluidStack>>>> getJEIInputItemExamples();
  
  public abstract boolean allowInputItem(MachineSlotItem paramMachineSlotItem, ItemStack paramItemStack, Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public abstract boolean allowInputFluid(MachineSlotFluid paramMachineSlotFluid, FluidStack paramFluidStack, Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public abstract boolean matches(Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public abstract Map<MachineSlotItem, ItemStack> getItemOutputs(Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public abstract Map<MachineSlotFluid, FluidStack> getFluidOutputs(Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public abstract int getEnergyOutput(Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public abstract int getProcessingTime(Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public float getEnergyRate(Map<MachineSlotItem, ItemStack> inputItems, Map<MachineSlotFluid, FluidStack> inputFluids);
  
  public abstract TObjectIntMap<MachineSlot> getAmountToConsume(Map<MachineSlotItem, ItemStack> paramMap, Map<MachineSlotFluid, FluidStack> paramMap1);
  
  public Map<MachineSlotItem, ItemStack> getContainerItems(Map<MachineSlotItem, ItemStack> inputItems, Map<MachineSlotFluid, FluidStack> inputFluids);
  
  @Nullable
  public TObjectFloatMap<MachineSlot> getProbabilityModifier(Map<MachineSlotItem, ItemStack> inputItems, Map<MachineSlotFluid, FluidStack> inputFluids);
}