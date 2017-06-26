package net.magicaltech.block.fluid;

import net.magicaltech.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidBase extends Fluid {

    public FluidBase(String fluidName, int viscosity, int density, int luminosity) {
        super(fluidName,
                new ResourceLocation(Reference.MODID + ":" + "blocks" + "/" + fluidName + "_still"),
                new ResourceLocation(Reference.MODID + ":" + "blocks" + "/" + fluidName + "_flow")
        );
        this.setViscosity(viscosity);
        this.setDensity(density);
        this.setLuminosity(luminosity);
        FluidRegistry.registerFluid(this);
    }
}
