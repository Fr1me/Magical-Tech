package net.magicaltech.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;

public class TileResearchTable extends TileThaumcraft
    implements IInventory
{

    public TileResearchTable()
    {
        contents = new ItemStack[2];
        researcher = null;
    }

    public void readCustomNBT(NBTTagCompound nbttagcompound)
    {
        NBTTagList var2 = nbttagcompound.getTagList("Inventory", 10);
        contents = new ItemStack[getSizeInventory()];
        for(int var3 = 0; var3 < Math.min(2, var2.tagCount()); var3++)
        {
            NBTTagCompound var4 = var2.getCompoundTagAt(var3);
            int var5 = var4.getByte("Slot") & 0xff;
            if(var5 >= 0 && var5 < contents.length)
                contents[var5] = ItemStack.EMPTY;
        }

    }

    public void writeCustomNBT(NBTTagCompound nbttagcompound)
    {
        NBTTagList var2 = new NBTTagList();
        for(int var3 = 0; var3 < contents.length; var3++)
            if(contents[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                contents[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }

        nbttagcompound.setTag("Inventory", var2);
    }

    public void markDirty()
    {
        super.markDirty();
    }

    /*public void gatherResults()
    {
        data = null;
        if(contents[1] != null && (contents[1].getItem() instanceof ItemResearchNotes))
            data = ResearchManager.getData(contents[1]);
    }

    public void placeAspect(int q, int r, Aspect aspect, EntityPlayer player)
    {
        if(data == null)
            gatherResults();
        if(!ResearchManager.consumeInkFromTable(contents[0], false))
            return;
        if(contents[1] != null && (contents[1].getItem() instanceof ItemResearchNotes) && data != null && contents[1].getItemDamage() == 0)
        {
            boolean r1 = ResearchManager.isResearchComplete(player.getName(), "RESEARCHER1");
            boolean r2 = ResearchManager.isResearchComplete(player.getName(), "RESEARCHER2");
            thaumcraft.common.lib.utils.HexUtils.Hex hex = new thaumcraft.common.lib.utils.HexUtils.Hex(q, r);
            thaumcraft.common.lib.research.ResearchManager.HexEntry he = null;
            if(aspect != null)
            {
                he = new thaumcraft.common.lib.research.ResearchManager.HexEntry(aspect, 2);
                if(r2 && world.rand.nextFloat() < 0.1F)
                    world.func_72956_a(player, "random.orb", 0.2F, 0.9F + player.world.rand.nextFloat() * 0.2F);
                else
                    data.aspects.remove(aspect, 1);
            } else
            {
                float f = world.rand.nextFloat();
                if(((thaumcraft.common.lib.research.ResearchManager.HexEntry)data.hexEntries.get(hex.toString())).aspect != null && (r1 && f < 0.25F || r2 && f < 0.5F))
                {
                    world.func_72956_a(player, "random.orb", 0.2F, 0.9F + player.world.rand.nextFloat() * 0.2F);
                    data.aspects.add(((thaumcraft.common.lib.research.ResearchManager.HexEntry)data.hexEntries.get(hex.toString())).aspect, 1);
                }
                he = new thaumcraft.common.lib.research.ResearchManager.HexEntry(null, 0);
            }
            data.hexEntries.put(hex.toString(), he);
            data.hexes.put(hex.toString(), hex);
            updateNoteAndConsumeInk();
            if(!world.isRemote && ResearchManager.checkResearchCompletion(contents[1], data, player.getName()))
            {
                contents[1].setItemDamage(1);
                if(Config.researchAmount > 0)
                    contents[1].stackSize = Config.researchAmount;
                world.addBlockEvent(getPos(), getBlockType(), 1, 1);
            }
        }
    }*/

    /*public void updateNoteAndConsumeInk()
    {
        ResearchManager.updateData(contents[1], data);
        ResearchManager.consumeInkFromTable(contents[0], true);
        world.func_175689_h(getPos());
        markDirty();
    }*/

    public int getSizeInventory()
    {
        return 2;
    }

    public ItemStack getStackInSlot(int var1)
    {
        return contents[var1];
    }

    public ItemStack decrStackSize(int var1, int var2)
    {
        if(contents[var1] != null)
        {
            ItemStack var3;
            if(contents[var1].getMaxStackSize() <= var2)
            {
                var3 = contents[var1];
                contents[var1] = null;
                markDirty();
                return var3;
            }
            var3 = contents[var1].splitStack(var2);
            if(contents[var1].getMaxStackSize() == 0)
                contents[var1] = null;
            markDirty();
            return var3;
        } else
        {
            return null;
        }
    }

    public ItemStack removeStackFromSlot(int var1)
    {
        if(contents[var1] != null)
        {
            ItemStack var2 = contents[var1];
            contents[var1] = null;
            return var2;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        contents[var1] = var2;
        if(var2 != null && var2.getCount() > getInventoryStackLimit())
            var2.setCount(getInventoryStackLimit());;
        markDirty();
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isUsableByPlayer(EntityPlayer var1)
    {
        return world.getTileEntity(getPos()) == this ? var1.getDistanceSqToCenter(getPos()) <= 64D : false;
    }

    public boolean hasCustomName()
    {
        return false;
    }

    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        /*if(itemstack == null)
            return false;
        switch(i)
        {
        default:
            break;

        case 0: // '\0'
            if(itemstack.getItem() instanceof IScribeTools)
                return true;
            break;

        case 1: // '\001'
            if(itemstack.getItem() == ItemsTC.researchNotes && itemstack.getItemDamage() == 0)
                return true;
            break;
        }*/
        return false;
    }

    /*public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
        super.onDataPacket(net, pkt);
        if(world != null && world.isRemote)
            world.on(getPos());
    }*/

    /*public boolean receiveClientEvent(int i, int j)
    {
        if(i == 1)
        {
            if(world.isRemote)
                world.playSound(getPos().getX(), getPos().getY(), getPos().getZ(), "magicaltech:learn", 1.0F, 1.0F, false);
            return true;
        } else
        {
            return super.receiveClientEvent(i, j);
        }
    }*/

    public ITextComponent getDisplayName()
    {
        return null;
    }

    public void openInventory(EntityPlayer entityplayer)
    {
    }

    public void closeInventory(EntityPlayer entityplayer)
    {
    }

    public int getField(int id)
    {
        return 0;
    }

    public void setField(int i, int j)
    {
    }

    public int getFieldCount()
    {
        return 0;
    }

    public void clear()
    {
    }

    public ItemStack contents[];
    EntityPlayer researcher;
    
    
	@Override
	public String getName() {
		return "Research Table";
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
