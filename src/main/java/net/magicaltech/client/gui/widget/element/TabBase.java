// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TabBase.java

package net.magicaltech.client.gui.widget.element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.input.Mouse;

import net.magicaltech.client.gui.GuiBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import xfireeyez.core.util.helper.RenderHelper;
import xfireeyez.core.util.math.Rectangle4i;

public abstract class TabBase extends ElementBase
{

    public TabBase(GuiBase gui)
    {
        super(gui, 0, 0);
        offsetX = 0;
        offsetY = 0;
        side = 1;
        headerColor = 0xe1c92f;
        subheaderColor = 0xaaafb8;
        textColor = 0;
        backgroundColor = 0xffffff;
        currentShiftX = 0;
        currentShiftY = 0;
        minWidth = 22;
        maxWidth = 124;
        currentWidth = minWidth;
        minHeight = 22;
        maxHeight = 22;
        currentHeight = minHeight;
        elements = new ArrayList();
        texture = DEFAULT_TEXTURE_RIGHT;
    }

    public TabBase(GuiBase gui, int side)
    {
        super(gui, 0, 0);
        offsetX = 0;
        offsetY = 0;
        this.side = 1;
        headerColor = 0xe1c92f;
        subheaderColor = 0xaaafb8;
        textColor = 0;
        backgroundColor = 0xffffff;
        currentShiftX = 0;
        currentShiftY = 0;
        minWidth = 22;
        maxWidth = 124;
        currentWidth = minWidth;
        minHeight = 22;
        maxHeight = 22;
        currentHeight = minHeight;
        elements = new ArrayList();
        this.side = side;
        if(side == 0)
            texture = DEFAULT_TEXTURE_LEFT;
        else
            texture = DEFAULT_TEXTURE_RIGHT;
    }

    public TabBase setOffsets(int x, int y)
    {
        posX -= offsetX;
        posY -= offsetY;
        offsetX = x;
        offsetY = y;
        posX += offsetX;
        posY += offsetY;
        return this;
    }

    /*public TabBase setPosition(int posX, int posY)
    {
        this.posX = posX + offsetX;
        this.posY = posY + offsetY;
        return this;
    }*/

    protected void drawForeground()
    {
    }

    protected void drawBackground()
    {
        float colorR = (float)(backgroundColor >> 16 & 0xff) / 255F;
        float colorG = (float)(backgroundColor >> 8 & 0xff) / 255F;
        float colorB = (float)(backgroundColor & 0xff) / 255F;
        GlStateManager.color(colorR, colorG, colorB, 1.0F);
        RenderHelper.bindTexture(texture);
        int xPosition = posX();
        gui.drawTexturedModalRect(xPosition, posY + 4, 0, (256 - currentHeight) + 4, 4, currentHeight - 4);
        gui.drawTexturedModalRect(xPosition + 4, posY, (256 - currentWidth) + 4, 0, currentWidth - 4, 4);
        gui.drawTexturedModalRect(xPosition, posY, 0, 0, 4, 4);
        gui.drawTexturedModalRect(xPosition + 4, posY + 4, (256 - currentWidth) + 4, (256 - currentHeight) + 4, currentWidth - 4, currentHeight - 4);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void drawBackground(int mouseX, int mouseY, float gameTicks)
    {
        mouseX -= posX();
        mouseY -= posY;
        GlStateManager.pushMatrix();
        drawBackground();
        GlStateManager.translate(posX(), posY, 0.0F);
        for(int i = 0; i < elements.size(); i++)
        {
            ElementBase element = (ElementBase)elements.get(i);
            if(element.isVisible())
                element.drawBackground(mouseX, mouseY, gameTicks);
        }

        GlStateManager.popMatrix();
    }

    public void drawForeground(int mouseX, int mouseY)
    {
        mouseX -= posX();
        mouseY -= posY;
        GlStateManager.pushMatrix();
        drawForeground();
        GlStateManager.translate(posX(), posY, 0.0F);
        for(int i = 0; i < elements.size(); i++)
        {
            ElementBase element = (ElementBase)elements.get(i);
            if(element.isVisible())
                element.drawForeground(mouseX, mouseY);
        }

        GlStateManager.popMatrix();
    }

    public void update(int mouseX, int mouseY)
    {
        super.update(mouseX, mouseY);
        mouseX -= posX();
        mouseY -= posY;
        int i = elements.size();
        do
        {
            if(i-- <= 0)
                break;
            ElementBase c = (ElementBase)elements.get(i);
            if(c.isVisible() && c.isEnabled())
                c.update(mouseX, mouseY);
        } while(true);
    }

    public void update()
    {
        if(open && currentWidth < maxWidth)
            currentWidth += tabExpandSpeed;
        else
        if(!open && currentWidth > minWidth)
            currentWidth -= tabExpandSpeed;
        if(currentWidth > maxWidth)
            currentWidth = maxWidth;
        else
        if(currentWidth < minWidth)
            currentWidth = minWidth;
        if(open && currentHeight < maxHeight)
            currentHeight += tabExpandSpeed;
        else
        if(!open && currentHeight > minHeight)
            currentHeight -= tabExpandSpeed;
        if(currentHeight > maxHeight)
            currentHeight = maxHeight;
        else
        if(currentHeight < minHeight)
            currentHeight = minHeight;
        if(!fullyOpen && open && currentWidth == maxWidth && currentHeight == maxHeight)
            setFullyOpen();
    }

    protected void drawTabIcon(TextureAtlasSprite iconName)
    {
        gui.drawIcon(iconName, posXOffset(), posY + 3);
    }

    protected int posX()
    {
        if(side == 0)
            return posX - currentWidth;
        else
            return posX;
    }

    protected int posXOffset()
    {
        return posX() + sideOffset();
    }

    protected int sideOffset()
    {
        return side != 0 ? 2 : 4;
    }

    public boolean intersectsWith(int mouseX, int mouseY, int shiftX, int shiftY)
    {
        shiftX += offsetX;
        shiftY += offsetY;
        if(side == 0)
        {
            if(mouseX <= shiftX && mouseX >= shiftX - currentWidth && mouseY >= shiftY && mouseY <= shiftY + currentHeight)
                return true;
        } else
        if(mouseX >= shiftX && mouseX <= shiftX + currentWidth && mouseY >= shiftY && mouseY <= shiftY + currentHeight)
            return true;
        return false;
    }

    public boolean isFullyOpened()
    {
        return fullyOpen;
    }

    public void setCurrentShift(int x, int y)
    {
        updateElements();
        currentShiftX = x + offsetX;
        currentShiftY = y + offsetY;
    }

    public void setFullyOpen()
    {
        open = true;
        currentWidth = maxWidth;
        currentHeight = maxHeight;
        fullyOpen = true;
        updateElements();
    }

    public void toggleOpen()
    {
        /*if(open)
        {
            open = false;
            if(side == 0)
                TabTracker.setOpenedLeftTab(null);
            else
                TabTracker.setOpenedRightTab(null);
            fullyOpen = false;
        } else
        {
            open = true;
            if(side == 0)
                TabTracker.setOpenedLeftTab(getClass());
            else
                TabTracker.setOpenedRightTab(getClass());
        }*/
        updateElements();
    }

    public Rectangle4i getBounds()
    {
        if(isVisible())
            return new Rectangle4i(posX() + gui.getGuiLeft(), posY + gui.getGuiTop(), currentWidth, currentHeight);
        else
            return new Rectangle4i(posX() + gui.getGuiLeft(), posY + gui.getGuiTop(), 0, 0);
    }

    public ElementBase addElement(ElementBase element)
    {
        elements.add(element);
        return element;
    }

    protected ElementBase getElementAtPosition(int mX, int mY)
    {
        for(int i = elements.size(); i-- > 0;)
        {
            ElementBase element = (ElementBase)elements.get(i);
            if(element.intersectsWith(mX, mY))
                return element;
        }

        return null;
    }

    public boolean onMouseWheel(int mouseX, int mouseY, int movement)
    {
label0:
        {
            int wheelMovement = Mouse.getEventDWheel();
            mouseX -= posX();
            mouseY -= posY;
            if(wheelMovement == 0)
                break label0;
            int i = elements.size();
            ElementBase c;
            do
            {
                if(i-- <= 0)
                    break label0;
                c = (ElementBase)elements.get(i);
            } while(!c.isVisible() || !c.isEnabled() || !c.intersectsWith(mouseX, mouseY) || !c.onMouseWheel(mouseX, mouseY, wheelMovement));
            return true;
        }
        return true;
    }

    public void addTooltip(List list)
    {
        for(int i = 0; i < elements.size(); i++)
        {
            ElementBase c = (ElementBase)elements.get(i);
            if(c.isVisible() && c.isEnabled() && c.intersectsWith(gui.getXSize(), gui.getYSize()))
                c.addTooltip(list);
        }

    }

    public boolean onKeyTyped(char characterTyped, int keyPressed)
    {
        for(int i = elements.size(); i-- > 0;)
        {
            ElementBase c = (ElementBase)elements.get(i);
            if(c.isVisible() && c.isEnabled() && c.onKeyTyped(characterTyped, keyPressed))
                return true;
        }

        return super.onKeyTyped(characterTyped, keyPressed);
    }

    public boolean onMousePressed(int mouseX, int mouseY, int mouseButton)
        throws IOException
    {
        mouseX -= posX();
        mouseY -= posY;
        boolean shouldStayOpen = false;
        for(int i = 0; i < elements.size(); i++)
        {
            ElementBase c = (ElementBase)elements.get(i);
            if(!c.isVisible() || !c.isEnabled() || !c.intersectsWith(mouseX, mouseY))
                continue;
            shouldStayOpen = true;
            if(c.onMousePressed(mouseX, mouseY, mouseButton))
                return true;
        }

        return shouldStayOpen;
    }

    public void onMouseReleased(int mouseX, int mouseY)
    {
        mouseX -= posX();
        mouseY -= posY;
        int i = elements.size();
        do
        {
            if(i-- <= 0)
                break;
            ElementBase c = (ElementBase)elements.get(i);
            if(c.isVisible() && c.isEnabled())
                c.onMouseReleased(mouseX, mouseY);
        } while(true);
    }

    protected void updateElements()
    {
        ElementBase element;
        for(Iterator iterator = elements.iterator(); iterator.hasNext(); element.setVisible(isFullyOpened()))
            element = (ElementBase)iterator.next();

    }

    public ElementBase setPosition(int i, int j)
    {
        return setPosition(i, j);
    }

    public static int tabExpandSpeed = 8;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    protected int offsetX;
    protected int offsetY;
    public boolean open;
    public boolean fullyOpen;
    public int side;
    public int headerColor;
    public int subheaderColor;
    public int textColor;
    public int backgroundColor;
    protected int currentShiftX;
    protected int currentShiftY;
    public int minWidth;
    public int maxWidth;
    public int currentWidth;
    public int minHeight;
    public int maxHeight;
    public int currentHeight;
    protected ArrayList elements;
    public static final ResourceLocation DEFAULT_TEXTURE_LEFT = new ResourceLocation("techreborn:textures/gui/elements/tab_left.png");
    public static final ResourceLocation DEFAULT_TEXTURE_RIGHT = new ResourceLocation("techreborn:textures/gui/elements/tab_right.png");

}
