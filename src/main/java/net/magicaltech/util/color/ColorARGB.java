package net.magicaltech.util.color;

public class ColorARGB extends Color {

    public ColorARGB(int colour) {
        super((colour >> 16) & 0xFF, (colour >> 8) & 0xFF, colour & 0xFF, (colour >> 24) & 0xFF);
    }

    public ColorARGB(int a, int r, int g, int b) {
        super(r, g, b, a);
    }

    public ColorARGB(ColorARGB colour) {
        super(colour);
    }

    public ColorARGB copy() {
        return new ColorARGB(this);
    }

    @Override
    public Color set(int colour) {
        return set(new ColorARGB(colour));
    }

    public int pack() {
        return pack(this);
    }

    public float[] packArray() {
        return new float[] { (a & 0xFF) / 255, (r & 0xFF) / 255, (g & 0xFF) / 255, (b & 0xFF) / 255 };
    }

    public static int pack(Color colour) {
        return (colour.a & 0xFF) << 24 | (colour.r & 0xFF) << 16 | (colour.g & 0xFF) << 8 | (colour.b & 0xFF);
    }
}
