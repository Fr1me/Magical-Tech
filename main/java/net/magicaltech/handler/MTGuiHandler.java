package net.magicaltech.handler;

import net.magicaltech.client.gui.GuiCoalGenerator;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.magicaltech.tile.container.ContainerCoalGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MTGuiHandler implements IGuiHandler{
    public static final int COAL_GENERATOR = 0;
 
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if(id == COAL_GENERATOR) {
            return new ContainerCoalGenerator(player.inventory, (TileEntityCoalGenerator) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }
 
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if(id == COAL_GENERATOR) {
            return new GuiCoalGenerator(player.inventory, (TileEntityCoalGenerator) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }
}
