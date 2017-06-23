package net.magicaltech.handler;

import net.magicaltech.client.gui.GuiCoalGenerator;
import net.magicaltech.client.gui.GuiCrafter;
import net.magicaltech.client.gui.GuiFluffGenerator;
import net.magicaltech.client.gui.GuiGeneratorBase;
import net.magicaltech.client.gui.GuiMagicGenerator;
import net.magicaltech.client.gui.GuiNuffNuffGenerator;
import net.magicaltech.inventory.ContainerCrafter;
import net.magicaltech.inventory.ContainerGeneratorBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MTGuiHandler implements IGuiHandler{
	
    public static final int GENERATOR = 0;
    public static final int COAL_GENERATOR = GENERATOR + 0;
    public static final int MAGICAL_GENERATOR = GENERATOR + 1;
    public static final int NUFF_NUFF_GENERATOR = GENERATOR + 2;
    public static final int FLUFFY_GENERATOR = GENERATOR + 3;
    public static final int CRAFTER = 1;
 
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if(id == GENERATOR) {
            return new ContainerGeneratorBase(player.inventory, (TileEntityGeneratorBase) world.getTileEntity(new BlockPos(x, y, z)));
        }
        if(id == CRAFTER) {
            return new ContainerCrafter(player.inventory, world, new BlockPos(x, y, z));
        }
        return null;
    }
 
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if(id == GENERATOR) {
        	TileEntityGeneratorBase tile = (TileEntityGeneratorBase)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiGeneratorBase(new ContainerGeneratorBase(player.inventory, tile), "");
        }
        if(id == COAL_GENERATOR) {
        	TileEntityGeneratorBase tile = (TileEntityGeneratorBase)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiCoalGenerator(player.inventory, tile);
        }
        if(id == MAGICAL_GENERATOR) {
        	TileEntityGeneratorBase tile = (TileEntityGeneratorBase)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiMagicGenerator(player.inventory, tile);
        }
        if(id == NUFF_NUFF_GENERATOR) {
        	TileEntityGeneratorBase tile = (TileEntityGeneratorBase)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiNuffNuffGenerator(player.inventory, tile);
        }
        if(id == FLUFFY_GENERATOR) {
        	TileEntityGeneratorBase tile = (TileEntityGeneratorBase)world.getTileEntity(new BlockPos(x, y, z));
            return new GuiFluffGenerator(player.inventory, tile);
        }
        if(id == CRAFTER){
        	return new GuiCrafter(player.inventory, world, new BlockPos(x, y, z));
        }
        return null;
    }
}
