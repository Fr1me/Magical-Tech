//package net.magicaltech.init;
//
//import net.magicaltech.Reference;
//import net.magicaltech.api.machine.Machine;
//import net.magicaltech.api.machine.MachineSlotFluid;
//import net.magicaltech.api.machine.MachineSlotItem;
//import net.magicaltech.util.Utils;
//import net.minecraft.block.Block;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemBlock;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.model.ModelLoader;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//
//public class MTMachines {
//	
//	public static final MachineSlotItem INPUT_ITEM = new MachineSlotItem("input");
//	public static final MachineSlotFluid INPUT_FLUID = new MachineSlotFluid("input_lava", 4000);
//	
//	public static Machine cGen;
//	
//	public static void init() {
//		cGen = new 
//	}
//	
//	public static void register() {
//		
//	}
//	
//	public static void registerRenders() {
//		
//	}
//	
//	public static void registerMachine (Block block) {
//		GameRegistry.register(block);
//		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
//		Utils.getLogger().info("Registered Machine: " + block.getUnlocalizedName().substring(5));
//	}
//	
//	public static void registerRender(Block block) {
//		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
//		Utils.getLogger().info("Registered Render For " + block.getUnlocalizedName().substring(5));
//	}
//
//}
