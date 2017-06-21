package codechicken.lib.render.item;

import javax.vecmath.Matrix4f;

import codechicken.lib.asm.ObfMapping;
import codechicken.lib.util.ReflectionManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderItem;

/**
 * Created by covers1624 on 17/10/2016.
 * TODO, Generify how this works. might be different from vanilla in the end but we should probably try and sniff off if the model is ours at an earlier date.
 * TODO, Some sort of registry over IMC for mods to add their own hooks to this.
 */
public class CCRenderItem extends ItemModelMesher {

    private static CCRenderItem instance;
    private static boolean hasInit;

    //Because forge has this private.
    private static final Matrix4f flipX;
    
    private static ItemModelMesher itemModelMesher;
    static {
        flipX = new Matrix4f();
        flipX.setIdentity();
        flipX.m00 = -1;
    }

    public CCRenderItem(ItemModelMesher renderItem) {
        super(itemModelMesher.getModelManager());
    }

    public static void init() {
        if (!hasInit) {
            instance = new CCRenderItem(Minecraft.getMinecraft().getRenderItem().getItemModelMesher());
            ObfMapping mapping = new ObfMapping("net/minecraft/client/Minecraft", "field_175621_X", "");
            ReflectionManager.setField(mapping, Minecraft.getMinecraft(), instance);
            hasInit = true;
        }
    }

    /**
     * Gets the current RenderItem instance, attempts to initialize CCL's if needed.
     *
     * @return The current RenderItem.
     */
    public static RenderItem getOverridenRenderItem() {
        init();
        return Minecraft.getMinecraft().getRenderItem();
    }

    /*@Override
    public void renderItem(Item stack, IBakedModel model) {
        if (stack != null && model instanceof IItemRenderer) {
            IItemRenderer renderer = (IItemRenderer) model;
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5F, -0.5F, -0.5F);

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableRescaleNormal();
            GlStateTracker.pushState();
            renderer.renderItem(stack, lastKnownTransformType);
            GlStateTracker.popState();
            GlStateManager.popMatrix();
            return;

        }
        parent.register(stack, itemMeshDefinition);
    }*/

    /*@Override
    public void renderItemModel(ItemStack stack, IBakedModel bakedModel, TransformType transform, boolean leftHanded) {
        if (stack.getItem() != null) {
            if (isValidModel(bakedModel)) {
                CCRenderItem.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                CCRenderItem.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(516, 0.1F);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.pushMatrix();

                bakedModel = handleTransforms(stack, bakedModel, transform, leftHanded);

                this.renderItem(stack, bakedModel);
                GlStateManager.cullFace(GlStateManager.CullFace.BACK);
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
                CCRenderItem.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                CCRenderItem.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
            } else {
                parent.zLevel = this.zLevel;
                parent.getItemModelMesher();
            }
        }
    }*/

    /*@Override
    public void renderItemModelIntoGUI(ItemStack stack, int x, int y, IBakedModel bakedModel) {
        if (isValidModel(bakedModel)) {
            GlStateManager.pushMatrix();
            CCRenderItem.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            CCRenderItem.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.1F);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//            this.setupGuiTransform(x, y, bakedModel.isGui3d());

            bakedModel = handleTransforms(stack, bakedModel, ItemCameraTransforms.TransformType.GUI, false);

            this.renderItem(stack, bakedModel);
            GlStateManager.disableAlpha();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableLighting();
            GlStateManager.popMatrix();
            CCRenderItem.textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            CCRenderItem.textureManager.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        } else {
            parent.zLevel = this.zLevel;
//            parent.renderItemModelIntoGUI(stack, x, y, bakedModel);
        }
    }

    // region Other Overrides

    @Override
    public void renderItem(ItemStack stack, TransformType cameraTransformType) {
        if (stack != null) {
            IBakedModel bakedModel = this.getItemModelWithOverrides(stack, null, null);
            if (isValidModel(bakedModel)) {
                this.renderItemModel(stack, bakedModel, cameraTransformType, false);
            }
            parent.zLevel = this.zLevel;
            parent.renderItem(stack, cameraTransformType);
        }
    }

    @Override
    public void renderItem(ItemStack stack, EntityLivingBase livingBase, TransformType transform, boolean leftHanded) {
        if (stack != null && livingBase != null && stack.getItem() != null) {
            IBakedModel bakedModel = this.getItemModelWithOverrides(stack, livingBase.world, livingBase);
            if (isValidModel(bakedModel)) {
                this.renderItemModel(stack, bakedModel, transform, leftHanded);
            } else {
                parent.zLevel = this.zLevel;
                parent.renderItem(stack, livingBase, transform, leftHanded);
            }
        }
    }

    @Override
    public void renderItemIntoGUI(ItemStack stack, int x, int y) {
        IBakedModel bakedModel = this.getItemModelWithOverrides(stack, null, null);
        if (isValidModel(bakedModel)) {
            this.renderItemModelIntoGUI(stack, x, y, bakedModel);
        } else {
            parent.zLevel = this.zLevel;
            parent.renderItemIntoGUI(stack, x, y);
        }
    }

    @Override
    public void renderItemAndEffectIntoGUI(ItemStack stack, int xPosition, int yPosition) {
        this.renderItemAndEffectIntoGUI(Minecraft.getMinecraft().player, stack, xPosition, yPosition);
    }

    @Override
    public void renderItemAndEffectIntoGUI(@Nullable EntityLivingBase livingBase, final ItemStack stack, int x, int y) {
        if (stack != null && stack.getItem() != null) {
            try {

                IBakedModel model = this.getItemModelWithOverrides(stack, null, livingBase);
                if (isValidModel(model)) {
                    this.zLevel += 50.0F;
                    this.renderItemModelIntoGUI(stack, x, y, model);
                    this.zLevel -= 50.0F;
                } else {
                    parent.zLevel = this.zLevel;
                    parent.renderItemAndEffectIntoGUI(livingBase, stack, x, y);
                }

            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Rendering item");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Item being rendered");
                crashreportcategory.addDetail("Item Type", () -> String.valueOf(stack.getItem()));
                crashreportcategory.addDetail("Item Aux", () -> String.valueOf(stack.getMetadata()));
                crashreportcategory.addDetail("Item NBT", () -> String.valueOf(stack.getTagCompound()));
                crashreportcategory.addDetail("Item Foil", () -> String.valueOf(stack.hasEffect()));
                throw new ReportedException(crashreport);
            }
        }
    }*/

    // endregion

    // region parentOverrides
    /*@Override
    public void registerItems() {
        //We don't want to register any more items as we are just a wrapper.
    }

    @Override
    public void registerItem(Item item, int subType, String identifier) {
        //Pass this through because why not.
        parent.registerItem(item, subType, identifier);
    }*/

    /*@Override
    public void isNotRenderingEffectsInGUI(boolean isNot) {
        parent.isNotRenderingEffectsInGUI(isNot);
    }*/

    /*@Override
    public ItemModelMesher getItemModelMesher() {
        return parent.getItemModelMesher();
    }

    @Override
    public boolean shouldRenderItemIn3D(ItemStack stack) {
        return parent.shouldRenderItemIn3D(stack);
    }

    @Override
    public IBakedModel getItemModelWithOverrides(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entitylivingbaseIn) {
        return parent.getItemModelWithOverrides(stack, worldIn, entitylivingbaseIn);
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
        parent.onResourceManagerReload(resourceManager);
    }*/

    //endregion
}
