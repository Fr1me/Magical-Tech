package net.magicaltech.inventory;

import net.magicaltech.tile.TileEntityCoalGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
 
public class ContainerCoalGenerator extends Container {
    private IItemHandler handler;
 
    public ContainerCoalGenerator(IInventory playerInventory, TileEntityCoalGenerator tileEntity) {
        handler = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
 
        addSlotToContainer(new SlotItemHandler(handler, 0, 56, 53));
 
        int xPosition = 8;
        int yPosition = 84;
 
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, xPosition + x * 18, yPosition + y * 18));
            }
        }
 
        for (int x = 0; x < 9; ++x) {
            addSlotToContainer(new Slot(playerInventory, x, xPosition + x * 18, yPosition + 58));
        }
    }
 
    @Override
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
    }
 
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
