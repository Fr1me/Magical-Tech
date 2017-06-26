package net.magicaltech.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidBase extends BlockFluidClassic {

    public BlockFluidBase(Fluid fluid, Material material) {
        super(fluid, material);
    }
}
