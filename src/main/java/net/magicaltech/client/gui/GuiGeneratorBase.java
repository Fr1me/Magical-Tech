package net.magicaltech.client.gui;

import net.magicaltech.Reference;
import net.magicaltech.inventory.ContainerGeneratorBase;
import net.magicaltech.tile.TileEntityGeneratorBase;
import net.magicaltech.util.colours.ColourRGBA;
import net.magicaltech.util.math.Point2i;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class GuiGeneratorBase extends GuiContainerBase{
	
	private String name;
	
	private TileEntityGeneratorBase generatorTE;
	
	private ContainerGeneratorBase generator;

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
		
//		this.drawBackground(new Point2i(k, l), new Point2i(176, 190), GuiContainerBase.ALIGNMENT_NONE);
		
//		this.drawEnergyBar(this, this.guiLeft + 151, this.guiTop, 76, generatorTE, generator.getMaxEnergyStored(EnumFacing.UP), mouseX, mouseY, "RF");
		
		this.drawRectangle(new Point2i(this.guiLeft + 51, this.guiTop + 20), new Point2i(60, 60), new ColourRGBA(0, 224, 224, 255 / 2), new ColourRGBA(50, 50, 240, 255 / 2));
		
//		this.drawPowerBar(new Point2i(this.guiLeft + 151, this.guiTop), GuiContainerBase.BACKGROUND_LIGHT, GuiContainerBase.POWER_MT, 5000000, 10000000);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final String name = this.name + " " + "Generator";
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6,
			4210752);
		this.fontRenderer.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
			this.ySize - 96 + 2, 4210752);
		/*this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator.euOut) + "/t", 10, 20,
			Color.WHITE.getRGB());
		this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator.storedEu), 10, 30,
			Color.WHITE.getRGB());
		this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator.euChange) + " change", 10, 40,
			Color.WHITE.getRGB());
		this.fontRenderer.drawString(PowerSystem.getLocaliszedPower(generator.euStorage) + " max", 10, 60,
			Color.WHITE.getRGB());*/
		
		this.drawGradientRect(this.guiLeft + 10, this.guiTop + 10, this.guiLeft + 10, this.guiTop + 100, 0x00E0E0, 0x37DD00);
	}
	
	@Override
	public void drawScreen(int x, int y, float partialTicks) {
    	super.drawScreen(x, y, partialTicks);
    	this.renderHoveredToolTip(x, y);
	}

}
