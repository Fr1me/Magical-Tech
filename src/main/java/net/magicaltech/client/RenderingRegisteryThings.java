package net.magicaltech.client;

import keri.ninetaillib.render.registry.SimpleRenderingRegistry;
import keri.ninetaillib.texture.IIconRegistrar;
import net.magicaltech.MagicalTech;
import net.magicaltech.Reference;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderingRegisteryThings extends SimpleRenderingRegistry {

    @Override
    public String getModid() {
        return Reference.MODID;
    }

    @Override
    public IIconRegistrar getIconRegistrar() {
        return MagicalTech.proxy.getIconRegistrar();
    }

}
