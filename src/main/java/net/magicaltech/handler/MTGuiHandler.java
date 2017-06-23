package net.magicaltech.handler;

import net.magicaltech.client.gui.GuiCoalGenerator;
import net.magicaltech.client.gui.GuiCrafter;
import net.magicaltech.inventory.ContainerCoalGenerator;
import net.magicaltech.inventory.ContainerCrafter;
import net.magicaltech.tile.TileCraftingBase;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MTGuiHandler implements IGuiHandler{
	
    public static final int COAL_GENERATOR = 0;
    public static final int RECIPE_BOOK = 1;
    public static final int CRAFTER = 2;
 
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if(id == COAL_GENERATOR) {
            return new ContainerCoalGenerator(player.inventory, (TileEntityCoalGenerator) world.getTileEntity(new BlockPos(x, y, z)));
        }
        if(id == CRAFTER) {
        	TileCraftingBase tile = (TileCraftingBase)world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerCrafter(player.inventory, world, new BlockPos(x, y, z));
        }
        return null;
    }
 
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if(id == COAL_GENERATOR) {
            return new GuiCoalGenerator(player.inventory, (TileEntityCoalGenerator) world.getTileEntity(new BlockPos(x, y, z)));
        }
        if(id == CRAFTER){
        	TileCraftingBase tile = (TileCraftingBase)world.getTileEntity(new BlockPos(x, y, z));
        	return new GuiCrafter(player.inventory, world, new BlockPos(x, y, z));
        }
        return null;
    }
}
