package net.magicaltech.client.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.magicaltech.Reference;
import net.magicaltech.client.gui.widget.EnumRenderType;
import net.magicaltech.inventory.ContainerCoalGenerator;
import net.magicaltech.tile.TileEntityCoalGenerator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import xfireeyez.core.client.container.builder.BuiltContainer;
 
public class GuiCoalGenerator extends GuiContainer {
	
    private IInventory playerInventory;
    private TileEntityCoalGenerator tileEntity;
    public BuiltContainer container;
    public GuiBuilder guiBuilder = new GuiBuilder(new ResourceLocation(Reference.MODID, "textures/gui/container/coal_generator.png"));
    protected boolean drawTitle;
    protected boolean drawInventory;
    protected int mouseX;
    protected int mouseY;
    protected int lastIndex;
    protected String name;
    public ArrayList tabs;
    protected ArrayList elements;
    protected List tooltip;
    protected boolean tooltips;
    
    private MTBuilder builder = new MTBuilder();
 
    public GuiCoalGenerator(IInventory playerInventory, TileEntityCoalGenerator tile) {
        super(new ContainerCoalGenerator(playerInventory, tile));
 
        this.playerInventory = playerInventory;
        this.tileEntity = tile;
 
        xSize = 176;
        ySize = 190;
    }
 
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
    	/*GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/coal_generator.png"));
        drawTexturedModalRect(guiLeft, guiTop - 4, 0, 0, xSize, ySize);
        
        builder.drawInfo(this, x, y, 10, 30, true);*/
    	
    	
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/coal_generator.png"));
		final int k = (this.width - this.xSize) / 2;
		final int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
 
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    	/*if(drawTitle & (name != null))
            fontRenderer.drawString(StringHelper.localize(name), getCenteredOffset(StringHelper.localize(name)), 6, 0x404040);
        if(drawInventory)
            fontRenderer.drawString(I18n.translateToLocal("container.inventory"), 8, (ySize - 96) + 3, 0x404040);*/
//        this.builder.drawPlayerSlots(this, guiLeft - 64, guiTop + 49, true);
    	
    	final String name = "Coal Generator";
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
			4210752);
		this.fontRendererObj.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
			this.ySize - 96 + 2, 4210752);
    }
    
    protected int getCenteredOffset(String string)
    {
        return getCenteredOffset(string, xSize);
    }

    protected int getCenteredOffset(String string, int xWidth)
    {
        return (xWidth - fontRendererObj.getStringWidth(string)) / 2;
    }
    
    protected void drawArmourSlots(int x, int y, EnumRenderType layer) {
		if (layer == EnumRenderType.BACKGROUND) {
			x += guiLeft;
			y += guiTop;
		}
		builder.drawSlot(this, x - 1, y - 1);
		builder.drawSlot(this, x - 1, y - 1 + 18);
		builder.drawSlot(this, x - 1, y - 1 + 18 + 18);
		builder.drawSlot(this, x - 1, y - 1 + 18 + 18 + 18);
	}
    
    @Override
	public void drawScreen(int x, int y, float partialTicks) {
    	super.drawScreen(x, y, partialTicks);
    	/*this.drawGuiContainerForegroundLayer(x, y);
    	this.drawGuiContainerBackgroundLayer(partialTicks, x, y);*/
//    	this.renderHoveredToolTip(x, y);
	}
	
	public void drawTooltip(List list)
    {
        drawTooltipHoveringText(list, mouseX + guiLeft, mouseY + guiTop, fontRendererObj);
        tooltip.clear();
    }
	
	protected void drawTooltipHoveringText(List list, int x, int y, FontRenderer font)
    {
        if(list == null || list.isEmpty())
            return;
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        int k = 0;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            int l = font.getStringWidth(s);
            if(l > k)
                k = l;
        } while(true);
        int i1 = x + 12;
        int j1 = y - 12;
        int k1 = 8;
        if(list.size() > 1)
            k1 += 2 + (list.size() - 1) * 10;
        if(i1 + k > width)
            i1 -= 28 + k;
        if(j1 + k1 + 6 > height)
            j1 = height - k1 - 6;
        zLevel = 300F;
        itemRender.zLevel = 300F;
        int l1 = 0xf0100010;
        drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
        drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
        drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
        drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
        drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
        int i2 = 0x505000ff;
        int j2 = (i2 & 0xfefefe) >> 1 | i2 & 0xff000000;
        drawGradientRect(i1 - 3, (j1 - 3) + 1, (i1 - 3) + 1, (j1 + k1 + 3) - 1, i2, j2);
        drawGradientRect(i1 + k + 2, (j1 - 3) + 1, i1 + k + 3, (j1 + k1 + 3) - 1, i2, j2);
        drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, (j1 - 3) + 1, i2, i2);
        drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);
        for(int k2 = 0; k2 < list.size(); k2++)
        {
            String s1 = (String)list.get(k2);
            font.drawStringWithShadow(s1, i1, j1, -1);
            if(k2 == 0)
                j1 += 2;
            j1 += 10;
        }

        zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        GlStateManager.enableRescaleNormal();
    }
 
    private int getProgressScaled(int pixels){
        int i = tileEntity.getBurnTime();
        int j = tileEntity.getTotalBurnTime();
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
