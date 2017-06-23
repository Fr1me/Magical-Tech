package net.magicaltech.api.machine;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.ModContainer;
import org.apache.commons.lang3.Validate;

public class Machine {
	
  @Nonnull
  public final String name;
  @Nonnull
  public final ResourceLocation location;
  public final int energyBufferSize;
  public final int energyTransferLimit;
  public final ImmutableList<MachineSlotItem> itemInputs;
  public final ImmutableList<MachineSlotItem> itemOutputs;
  public final ImmutableList<MachineSlotFluid> fluidInputs;
  public final ImmutableList<MachineSlotFluid> fluidOutputs;
  public final String frontTexture;
  public final String frontTextureActive;
  public final MachineRecipeRegistry recipes_registry = new MachineRecipeRegistry();
  @Nonnull
  public final EnergyMode energyMode;
  public final int color;
  @Nullable
  public final String textureTop;
  @Nullable
  public final String textureBase;
  @Nullable
  public final String textureBottom;
  @Nullable
  public final String textureTopOverlay;
  public int defaultEnergy = -1;
  public int defaultProcessingTime = -1;
  ModContainer container = null;
  
  public Machine(@Nonnull String name, int energyBufferSize, int energyTransferLimit, @Nonnull List<MachineSlotItem> itemInputs, @Nonnull List<MachineSlotFluid> fluidInputs, @Nonnull List<MachineSlotItem> itemOutputs, @Nonnull List<MachineSlotFluid> fluidOutputs, @Nonnull String frontTexture, @Nonnull String frontTextureActive, @Nonnull EnergyMode energyMode, int color, @Nullable String textureTop, @Nullable String textureBase, @Nullable String textureBottom, @Nullable String textureTopOverlay) {
	  
    this.energyTransferLimit = energyTransferLimit;
    this.color = color;
    this.textureTop = textureTop;
    this.textureBase = textureBase;
    this.textureBottom = textureBottom;
    this.textureTopOverlay = textureTopOverlay;
    
    ResourceLocation location = new ResourceLocation(name);
    Validate.isTrue(!"minecraft".equals(location.getResourceDomain()), "Name %s must be in resource location format and not be in the minecraft domain.", new Object[] { name });
    this.name = location.toString();
    this.location = location;
    this.energyBufferSize = energyBufferSize;
    this.itemInputs = ImmutableList.copyOf(itemInputs);
    this.itemOutputs = ImmutableList.copyOf(itemOutputs);
    this.fluidInputs = ImmutableList.copyOf(fluidInputs);
    this.fluidOutputs = ImmutableList.copyOf(fluidOutputs);
    this.frontTexture = frontTexture;
    this.frontTextureActive = frontTextureActive;
    this.energyMode = energyMode;
  }
  
  public Machine setDefaults(int energy, int time) {
	  
    this.defaultEnergy = energy;
    this.defaultProcessingTime = time;
    return this;
  }
  
  public void processingTick(TileEntity tileMachine, IMachineRecipe curRecipe, int processTime, int n) {}
  
  public void clientTick(TileEntity tileMachine, boolean active) {}
  
  public static enum EnergyMode {
	  
    USES_ENERGY,  GENERATES_ENERGY;
    
    private EnergyMode() {}
  }
}