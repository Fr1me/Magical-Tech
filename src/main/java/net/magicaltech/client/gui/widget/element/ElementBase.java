package net.magicaltech.client.gui.widget.element;

import java.io.IOException;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.magicaltech.Reference;
import net.magicaltech.client.gui.GuiBase;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public abstract class ElementBase
{

    public ElementBase(GuiBase gui, int posX, int posY)
    {
        texW = 256;
        texH = 256;
        visible = true;
        enabled = true;
        this.gui = gui;
        this.posX = posX;
        this.posY = posY;
    }

    public ElementBase(GuiBase gui, int posX, int posY, int width, int height)
    {
        texW = 256;
        texH = 256;
        visible = true;
        enabled = true;
        this.gui = gui;
        this.posX = posX;
        this.posY = posY;
        sizeX = width;
        sizeY = height;
    }

    public ElementBase setName(String name)
    {
        this.name = name;
        return this;
    }

    public ElementBase setPosition(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        return this;
    }

    public ElementBase setSize(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        return this;
    }

    public ElementBase setTexture(String texture, int texW, int texH)
    {
        this.texture = new ResourceLocation(texture);
        this.texW = texW;
        this.texH = texH;
        return this;
    }

    public final ElementBase setVisible(boolean visible)
    {
        this.visible = visible;
        return this;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public final ElementBase setEnabled(boolean enabled)
    {
        this.enabled = enabled;
        return this;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void update(int mouseX, int mouseY)
    {
        update();
    }

    public void update()
    {
    }

    public abstract void drawBackground(int i, int j, float f);

    public abstract void drawForeground(int i, int j);

    public void addTooltip(List list1)
    {
    }

    public void drawModalRect(int x, int y, int width, int height, int color)
    {
        gui.drawSizedModalRect(x, y, width, height, color);
    }

    public void drawStencil(int xStart, int yStart, int xEnd, int yEnd, int flag)
    {
        GlStateManager.disableTexture2D();
        GL11.glStencilFunc(519, flag, flag);
        GL11.glStencilOp(0, 0, 7681);
        GL11.glStencilMask(flag);
        GlStateManager.colorMask(false, false, false, false);
        GlStateManager.depthMask(false);
        GL11.glClearStencil(0);
        GlStateManager.clear(1024);
        VertexBuffer buffer = Tessellator.getInstance().getBuffer();
        buffer.begin(7, DefaultVertexFormats.POSITION);
        buffer.pos(xStart, yEnd, 0.0D).endVertex();
        buffer.pos(xEnd, yEnd, 0.0D).endVertex();
        buffer.pos(xEnd, yStart, 0.0D).endVertex();
        buffer.pos(xStart, yStart, 0.0D).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableTexture2D();
        GL11.glStencilFunc(514, flag, flag);
        GL11.glStencilMask(0);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.depthMask(true);
    }

    public void drawTexturedModalRect(int x, int y, int u, int v, int width, int height)
    {
        gui.drawSizedTexturedModalRect(x, y, u, v, width, height, texW, texH);
    }

    public void drawCenteredString(FontRenderer fontRenderer, String text, int x, int y, int color)
    {
        fontRenderer.drawStringWithShadow(text, x - fontRenderer.getStringWidth(text) / 2, y, color);
    }

    public boolean onMousePressed(int mouseX, int mouseY, int mouseButton)
        throws IOException
    {
        return false;
    }

    public void onMouseReleased(int i, int j)
    {
    }

    public boolean onMouseWheel(int mouseX, int mouseY, int movement)
    {
        return false;
    }

    public boolean onKeyTyped(char characterTyped, int keyPressed)
    {
        return false;
    }

    public boolean intersectsWith(int mouseX, int mouseY)
    {
        return mouseX >= posX && mouseX <= posX + sizeX && mouseY >= posY && mouseY <= posY + sizeY;
    }

    public FontRenderer getFontRenderer()
    {
        return fontRenderer != null ? fontRenderer : gui.getfontRendererObj();
    }

    public ElementBase setFontRenderer(FontRenderer renderer)
    {
        fontRenderer = renderer;
        return this;
    }

    public final String getName()
    {
        return name;
    }

    public final GuiBase getContainerScreen()
    {
        return gui;
    }

    public final int getPosY()
    {
        return posY;
    }

    public final int getPosX()
    {
        return posX;
    }

    public final int getHeight()
    {
        return sizeY;
    }

    public final int getWidth()
    {
        return sizeX;
    }

    protected GuiBase gui;
    protected ResourceLocation texture;
    public static ResourceLocation button_disabled = new ResourceLocation(Reference.MODID + "textures/gui/button_disabled");
    public static ResourceLocation button_hovered = new ResourceLocation(Reference.MODID + "textures/gui/button_hovered");
    public static ResourceLocation button_enabeled = new ResourceLocation(Reference.MODID + "textures/gui/button_enabeled");
    public static ResourceLocation buttons = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation coolant = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation energy = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation fluid_tank = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation fluid_tank_short = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation fluid_tank_thin = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_angel = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_distant = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_duration = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_force = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_input = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_output = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    public static ResourceLocation info_signal = new ResourceLocation(Reference.MODID + "textures/gui/buttons");
    private FontRenderer fontRenderer;
    protected int posX;
    protected int posY;
    protected int sizeX;
    protected int sizeY;
    protected int texW;
    protected int texH;
    protected String name;
    private boolean visible;
    private boolean enabled;
}