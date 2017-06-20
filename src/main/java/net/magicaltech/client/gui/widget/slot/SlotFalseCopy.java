package net.magicaltech.client.gui.widget.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFalseCopy extends Slot
{

    public SlotFalseCopy(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
        slotIndex = 0;
        slotIndex = index;
    }

    public boolean canTakeStack(EntityPlayer player)
    {
        return false;
    }

    public boolean isItemValid(ItemStack stack)
    {
        return true;
    }

    public void putStack(ItemStack stack)
    {
        if(stack != null)
            stack.getCount();
        inventory.setInventorySlotContents(slotIndex, stack);
        onSlotChanged();
    }

    public int slotIndex;
}
