package keri.ninetaillib.item;

import java.util.List;

import keri.ninetaillib.block.BlockBase;
import keri.ninetaillib.block.IMetaBlock;
import keri.ninetaillib.util.CommonUtils;
import keri.ninetaillib.util.ICustomLocalization;
import keri.ninetaillib.util.IShiftDescription;
import keri.ninetaillib.util.LanguageUtils;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockBase extends ItemBlock {

    public ItemBlockBase(Block block) {
        super(block);

        if(block instanceof BlockBase){
            BlockBase blockBase = (BlockBase)block;

            if(blockBase instanceof IMetaBlock){
                this.setHasSubtypes(true);
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        if(this.block instanceof BlockBase){
            BlockBase blockBase = (BlockBase)this.block;

            if(blockBase instanceof IMetaBlock){
                return damage;
            }
            else{
                return super.getMetadata(damage);
            }
        }
        else{
            return super.getMetadata(damage);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        this.block.getSubBlocks(tab, subItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getUnlocalizedName(ItemStack stack){
        if(this.block instanceof BlockBase){
            BlockBase blockBase = (BlockBase)this.block;

            if(blockBase instanceof ICustomLocalization){
                ICustomLocalization iface = (ICustomLocalization)blockBase;
                return iface.getUnlocalizedNameCustom();
            }
            else{
                if(blockBase instanceof IMetaBlock){
                    IMetaBlock iface = (IMetaBlock)blockBase;
                    return this.getUnlocalizedName() + "." + iface.getSubNames()[stack.getMetadata()];
                }
                else{
                    return this.getUnlocalizedName();
                }
            }
        }
        else{
            return this.getUnlocalizedName();
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if(this.block instanceof IShiftDescription){
            IShiftDescription iface = (IShiftDescription)this.block;

            if(CommonUtils.isShiftPressed()){
                iface.addDescription(stack, player, tooltip);
            }
            else{
                tooltip.add(LanguageUtils.PRESS_KEY + " " + LanguageUtils.KEY_SHIFT + " " + LanguageUtils.SHOW_INFO);
            }
        }
    }

}
