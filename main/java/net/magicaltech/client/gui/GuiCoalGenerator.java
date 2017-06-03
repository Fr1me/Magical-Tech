package net.magicaltech.client.gui;

import net.magicaltech.Reference;
import net.magicaltech.inventory.ContainerCoalGenerator;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
 
import java.awt.image.TileObserver;
 
public class GuiCoalGenerator extends GuiContainer {
    private IInventory playerInventory;
    private TileEntityCoalGenerator tileEntity;
 
    public GuiCoalGenerator(IInventory playerInventory, TileEntityCoalGenerator tileEntity) {
        super(new ContainerCoalGenerator(playerInventory, tileEntity));
 
        this.playerInventory = playerInventory;
        this.tileEntity = tileEntity;
 
        xSize = 176;
        ySize = 166;
    }
 
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/coal_generator.png"));
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
 
        if(tileEntity != null){
            if(tileEntity.isBurning()){
                int l = getProgressScaled(24);
                this.drawTexturedModalRect((this.width - this.xSize) / 2 + 79, (this.height - this.ySize) / 2 + 34, 176, 11, 24 - l, 16);
            }
        }
    }
 
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String title = I18n.format("container.coal_generator");
 
        mc.fontRendererObj.drawString(title, xSize / 2 - mc.fontRendererObj.getStringWidth(title) / 2, 6, 4210752);
        mc.fontRendererObj.drawString(playerInventory.getDisplayName().getFormattedText(), 8, 72, 4210752);
    }
 
 
    private int getProgressScaled(int pixels){
        int i = tileEntity.getBurnTime();
        int j = tileEntity.getTotalBurnTime();
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
