package net.magicaltech.client.gui;

import net.magicaltech.inventory.ContainerGeneratorBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.minecraft.inventory.IInventory;
 
public class GuiCoalGenerator extends GuiGeneratorBase {
	
    public GuiCoalGenerator(IInventory playerInventory, TileEntityGeneratorBase tileEntity) {
        super(new ContainerGeneratorBase(playerInventory, tileEntity), "Coal ");
    }

}