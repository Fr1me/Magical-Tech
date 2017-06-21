package net.magicaltech.item;

import keri.ninetaillib.item.ItemToolHelper;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemToolHelperFutopia extends ItemToolHelper {

    public ItemToolHelperFutopia() {
        super(Reference.MODID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return MTCreativeTabs.tools;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderingRegistry getRenderingRegistry() {
        return MagicalTech.proxy.getRenderingRegistry();
    }

}
