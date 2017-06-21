package net.magicaltech.client.gui.widget.element;

import net.magicaltech.client.gui.GuiBase;
import net.magicaltech.client.gui.GuiColor;
import net.magicaltech.util.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class ElementIcon extends ElementBase
{

    public ElementIcon(GuiBase gui, int posX, int posY, TextureAtlasSprite icon)
    {
        super(gui, posX, posY);
        color = new GuiColor(-1);
        this.icon = icon;
    }

    public ElementIcon setColor(Number color)
    {
        this.color = new GuiColor(color.intValue());
        return this;
    }

    public ElementIcon setIcon(TextureAtlasSprite icon)
    {
        this.icon = icon;
        return this;
    }

    public int getColor()
    {
        return color.getColor();
    }

    public void drawBackground(int mouseX, int mouseY, float gameTicks)
    {
        if(icon != null)
        {
            RenderHelper.setBlockTextureSheet();
            GlStateManager.color(color.getFloatR(), color.getFloatG(), color.getFloatB(), color.getFloatA());
            gui.drawColorIcon(icon, posX, posY);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void drawForeground(int i, int j)
    {
    }

    protected TextureAtlasSprite icon;
    protected GuiColor color;
}
