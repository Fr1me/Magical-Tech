package keri.ninetaillib.internal.proxy;

import keri.ninetaillib.internal.util.ModPrefs;
import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.render.registry.SimpleRenderingRegistry;
import keri.ninetaillib.texture.DefaultIconRegistrar;
import keri.ninetaillib.texture.IIconRegistrar;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements INineTailProxy {

    private static final DefaultIconRegistrar iconRegistrar = new DefaultIconRegistrar();
    private static final SimpleRenderingRegistry renderingRegistry = new SimpleRenderingRegistry() {
        @Override
        public String getModid() {
            return ModPrefs.MODID;
        }

        @Override
        public IIconRegistrar getIconRegistrar() {
            return iconRegistrar;
        }
    };

    @Override
    public void preInit(FMLPreInitializationEvent event){
        iconRegistrar.preInit();
        renderingRegistry.preInit();
    }

    @Override
    public void init(FMLInitializationEvent event){
//        PacketCustom.assignHandler(NineTailLib.INSTANCE, new NineTailLibCPH());
        renderingRegistry.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        renderingRegistry.postInit();
    }

    @Override
    public IIconRegistrar getIconRegistrar() {
        return iconRegistrar;
    }

    @Override
    public IRenderingRegistry getRenderingRegistry() {
        return renderingRegistry;
    }

}
