package keri.ninetaillib.render;

import codechicken.lib.render.CCRenderState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderingConstants {

    private static final CCRenderState renderState = CCRenderState.instance();

    public static CCRenderState getRenderState(){
        return renderState;
    }

}
