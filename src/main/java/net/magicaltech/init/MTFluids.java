package net.magicaltech.init;

import net.magicaltech.Reference;
import net.magicaltech.block.fluid.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelFluid.FluidLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xfireeyez.core.util.Utils;

public class MTFluids {
	
	public static final BlockFluidClassic liquid_ender = new BlockFluidBase(MTFluids.LIQUID_ENDER, Material.WATER);

    public static Fluid LIQUID_ENDER;

    public static void init() {
        LIQUID_ENDER = new FluidBase("liquid_ender", 0, 200, 15);
        LIQUID_ENDER = FluidRegistry.getFluid("liquid_ender");
        if (!FluidRegistry.getBucketFluids().contains(LIQUID_ENDER)) FluidRegistry.addBucketForFluid(LIQUID_ENDER);
    }
    
    public static void register() {
    	registerFluid(liquid_ender);
    }
    
    public static void registerRenders() {
    	registerRender(liquid_ender);
    }
    
    public static void registerFluid (Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Fluid: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render For " + block.getUnlocalizedName().substring(5));
	}
    
}