package net.magicaltech.client.gui.widget.tabs;

import net.magicaltech.client.gui.GuiBase;
import net.magicaltech.client.gui.widget.element.ElementBase;
import net.magicaltech.client.gui.widget.element.ElementEnergyStored;
import net.magicaltech.client.gui.widget.element.TabBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class GuiInformationTab extends TabBase{
	
	private static ElementEnergyStored energy;

	public GuiInformationTab(GuiBase gui) {
		super(gui);
	}
	
	@Override
	public ElementBase addElement(ElementBase element) {
		return super.addElement(energy);
	}
	
	@Override
	public void drawBackground(int mouseX, int mouseY, float gameTicks) {
		this.drawBackground();
	}
	
	@Override
	public void drawForeground(int mouseX, int mouseY) {
		this.drawForeground();
	}
	
	@Override
	protected void drawTabIcon(TextureAtlasSprite iconName) {
		this.drawTabIcon(iconName);
	}
	
	@Override
	public ElementBase setTexture(String texture, int texW, int texH) {
		return super.setTexture(texture, texW, texH);
	}

}
