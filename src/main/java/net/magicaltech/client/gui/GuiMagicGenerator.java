package net.magicaltech.client.gui;

import net.magicaltech.inventory.ContainerGeneratorBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.minecraft.inventory.IInventory;
 
public class GuiMagicGenerator extends GuiGeneratorBase {

    public GuiMagicGenerator(IInventory playerInventory, TileEntityGeneratorBase tileEntity) {
        super(new ContainerGeneratorBase(playerInventory, tileEntity), "Magical");
    }
    
}
