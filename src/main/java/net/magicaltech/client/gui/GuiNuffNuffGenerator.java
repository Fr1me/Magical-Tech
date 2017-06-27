package net.magicaltech.client.gui;

import net.magicaltech.inventory.ContainerGeneratorBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.minecraft.inventory.IInventory;
 
public class GuiNuffNuffGenerator extends GuiGeneratorBase {
	
    public GuiNuffNuffGenerator(IInventory playerInventory, TileEntityGeneratorBase tileEntity) {
        super(new ContainerGeneratorBase(playerInventory, tileEntity), "Nuff Nuff ");
    }
    
}
