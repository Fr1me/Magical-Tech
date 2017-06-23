package net.magicaltech.inventory;

import net.magicaltech.tile.TileEntityCoalGenerator;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumFacing.AxisDirection;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
 
public class ContainerCoalGenerator extends Container {
    private IItemHandler handler;
 
    public ContainerCoalGenerator(IInventory player, TileEntityCoalGenerator tileEntity) {
        handler = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.getFacingFromAxis(AxisDirection.POSITIVE, Axis.Y));
 
        addSlotToContainer(new SlotItemHandler(handler, 0, 79, 50));
 
    	int xs = 8, ys = 8 + 9;
    	/*IItemHandler inventory = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
    	for (int i = 0; i < 3; i++) for (int j = 0; j < 9; j++)
    	        addSlotToContainer(new SlotItemHandler(inventory, j + i * 9, xs + (j * 18), ys + (i * 18))); // Tile Inventory
*/
    	for(int y = 0; y < 3; y++) 
    		for(int x = 0; x < 9; x++)
    	        addSlotToContainer(new Slot(player, x + y * 9 + 9, xs + (x * 18), ys + (y * 18) + 92)); // Player Inventory

    	for(int k = 0; k < 9; k++)
    	    addSlotToContainer(new Slot(player, k, xs + (k * 18), ys + 83 + 67)); // Player Hotbar
    }
 
    /*@Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = inventorySlots.get(fromSlot);
 
        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
 
            if (fromSlot < handler.getSlots()) {
                if (!mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
                    return null;
            } else {
                if (mergeItemStack(current, 0, handler.getSlots(), false))
                    return null;
            }
 
            if (current.getCount() == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
 
            if (current.getCount() == previous.getCount())
                return null;
            (slot).onTake(playerIn, current);
        }
 
        return previous;
    }*/
 
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
