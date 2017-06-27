package net.magicaltech.tile;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public class TileArcaneTable extends TileCraftingBase{
	
	private ItemStack stack;
	
	public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
        markDirty();
        if (world != null) {
            IBlockState state = world.getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 3);
        }
    }

}
