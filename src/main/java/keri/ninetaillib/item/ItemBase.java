package keri.ninetaillib.item;

import java.util.List;

import keri.ninetaillib.render.registry.IRenderingRegistry;
import keri.ninetaillib.texture.IIconItem;
import keri.ninetaillib.texture.IIconRegistrar;
import keri.ninetaillib.util.CommonUtils;
import keri.ninetaillib.util.HideInventory;
import keri.ninetaillib.util.ICustomLocalization;
import keri.ninetaillib.util.IShiftDescription;
import keri.ninetaillib.util.LanguageUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemBase extends Item implements IIconItem {

    private String itemName;
    private String modid;
    private String[] subNames = null;

    public ItemBase(String modid, String itemName) {
        this.itemName = itemName;
        this.modid = modid;
        this.register();
    }

    public ItemBase(String modid, String itemName, String... subNames) {
        this.itemName = itemName;
        this.modid = modid;
        this.subNames = subNames;
        this.setHasSubtypes(true);
        this.register();
    }

    private void register(){
        this.setRegistryName(this.modid, this.itemName);
        this.setUnlocalizedName(this.modid + "." + this.itemName);

        if(super.getClass().isAnnotationPresent(HideInventory.class)){
            HideInventory annotation = super.getClass().getAnnotation(HideInventory.class);

            if(!annotation.onlySubtypes()){
                this.setCreativeTab((CreativeTabs)null);
            }
        }
        else{
            this.setCreativeTab(this.getCreativeTab());
        }

        if(this.getRenderingRegistry() != null){
            this.getRenderingRegistry().handleItem(this);
        }

        GameRegistry.register(this);
    }

    @Override
    public int getMetadata(int damage) {
        if(this.subNames != null){
            return damage;
        }
        else{
            return 0;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList subItems) {
        if(this.subNames != null){
            if(super.getClass().isAnnotationPresent(HideInventory.class)){
                HideInventory annotation = super.getClass().getAnnotation(HideInventory.class);

                if(annotation.onlySubtypes()){
                    subItems.add(new ItemStack(this, 1, 0));
                }
                else{
                    for(int i = 0; i < this.subNames.length; i++){
                        subItems.add(new ItemStack(this, 1, i));
                    }
                }
            }
            else{
                for(int i = 0; i < this.subNames.length; i++){
                    subItems.add(new ItemStack(this, 1, i));
                }
            }
        }
        else{
            subItems.add(new ItemStack(this, 1, 0));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getUnlocalizedName(ItemStack stack) {
        if(this instanceof ICustomLocalization){
            ICustomLocalization iface = (ICustomLocalization)this;
            return iface.getUnlocalizedNameCustom();
        }
        else{
            if(this.subNames != null){
                return this.getUnlocalizedName() + "." + this.subNames[stack.getMetadata()];
            }
            else{
                return this.getUnlocalizedName();
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if(this instanceof IShiftDescription){
            IShiftDescription iface = (IShiftDescription)this;

            if(CommonUtils.isShiftPressed()){
                iface.addDescription(stack, player, tooltip);
            }
            else{
                tooltip.add(LanguageUtils.PRESS_KEY + " " + LanguageUtils.KEY_SHIFT + " " + LanguageUtils.SHOW_INFO);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegistrar registrar) {
        if(!this.isModelRenderer()){
            if(this.getSubNames() != null){
                this.texture = new TextureAtlasSprite[this.subNames.length];

                for(int i = 0; i < this.subNames.length; i++){
                    this.texture[i] = registrar.registerIcon(this.modid + ":items/" + this.itemName + "_" + this.subNames[i]);
                }
            }
            else{
                this.texture = new TextureAtlasSprite[1];
                this.texture[0] = registrar.registerIcon(this.modid + ":items/" + this.itemName);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(int meta) {
        return this.texture[meta];
    }

    public String getInternalName(){
        return this.itemName;
    }

    public String[] getSubNames(){
        return this.subNames;
    }

    public int getRenderType(){
        return 0;
    }

    @Override
    public CreativeTabs getCreativeTab(){
        return CreativeTabs.SEARCH;
    }

    /*public IItemRenderingHandler getRenderingHandler(){
        return new DefaultItemRenderer(TransformUtils.DEFAULT_ITEM);
    }*/

    public String getModId(){
        return this.modid;
    }

    public boolean isModelRenderer(){
        return false;
    }

    public abstract IRenderingRegistry getRenderingRegistry();

}
