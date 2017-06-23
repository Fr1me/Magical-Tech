package net.magicaltech.client.gui;

import net.magicaltech.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class GuiGeneratorBase extends GuiContainerBase{
	
	private String name;

	public GuiGeneratorBase(Container container, String name) {
		super(container);
		this.name = name;
		
		xSize = 176;
        ySize = 190;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/coal_generator.png"));
		final int k = (this.width - this.xSize) / 2;
		final int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final String name = this.name + " " + "Generator";
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6,
			4210752);
		this.fontRenderer.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
			this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	public void drawScreen(int x, int y, float partialTicks) {
    	super.drawScreen(x, y, partialTicks);
    	this.renderHoveredToolTip(x, y);
	}

}
