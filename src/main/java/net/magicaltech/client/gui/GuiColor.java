package net.magicaltech.client.gui;


public class GuiColor extends Number
{

    public GuiColor(int argb)
    {
        _color = argb;
    }

    public GuiColor(int rgba, Void dummy)
    {
        this(rgba >>> 24, rgba >> 16, rgba >> 8, rgba);
    }

    public GuiColor(byte alpha, int argb)
    {
        this(argb >> 16, argb >> 8, argb, alpha);
    }

    public GuiColor(int rgba, byte alpha)
    {
        this(rgba >>> 24, rgba >> 16, rgba >> 8, alpha);
    }

    public GuiColor(int r, int g, int b)
    {
        this(r, g, b, 255);
    }

    public GuiColor(int r, int g, int b, int a)
    {
        _color = b & 0xff | (g & 0xff) << 8 | (r & 0xff) << 16 | (a & 0xff) << 24;
    }

    public int getColor()
    {
        return _color;
    }

    public int getIntR()
    {
        return _color >> 16 & 0xff;
    }

    public int getIntG()
    {
        return _color >> 8 & 0xff;
    }

    public int getIntB()
    {
        return _color >> 0 & 0xff;
    }

    public int getIntA()
    {
        return _color >> 24 & 0xff;
    }

    public float getFloatR()
    {
        return (float)getIntR() / 255F;
    }

    public float getFloatG()
    {
        return (float)getIntG() / 255F;
    }

    public float getFloatB()
    {
        return (float)getIntB() / 255F;
    }

    public float getFloatA()
    {
        return (float)getIntA() / 255F;
    }

    public GuiColor multiply(float amount)
    {
        return multiply(amount, amount, amount, amount);
    }

    public GuiColor multiply(float rgb, float a)
    {
        return multiply(rgb, rgb, rgb, a);
    }

    public GuiColor multiply(float r, float g, float b)
    {
        return multiply(r, g, b, 1.0F);
    }

    public GuiColor multiply(float r, float g, float b, float a)
    {
        return new GuiColor(Math.min((int)((float)getIntR() * r), 255), Math.min((int)((float)getIntG() * g), 255), Math.min((int)((float)getIntB() * b), 255));
    }

    public GuiColor add(int amount)
    {
        return new GuiColor(Math.max(Math.min(getIntR() + amount, 255), 0), Math.max(Math.min(getIntG() + amount, 255), 0), Math.max(Math.min(getIntB() + amount, 255), 0), Math.max(Math.min(getIntA() + amount, 255), 0));
    }

    public GuiColor add(GuiColor color)
    {
        return new GuiColor(Math.max(Math.min(getIntR() + color.getIntR(), 255), 0), Math.max(Math.min(getIntG() + color.getIntG(), 255), 0), Math.max(Math.min(getIntB() + color.getIntB(), 255), 0), Math.max(Math.min(getIntA() + color.getIntA(), 255), 0));
    }

    public int intValue()
    {
        return getColor();
    }

    public long longValue()
    {
        return (long)getColor();
    }

    public float floatValue()
    {
        return (float)getColor();
    }

    public double doubleValue()
    {
        return (double)getColor();
    }

    private static final long serialVersionUID = 0x617d332884e09603L;
    private final int _color;
}
