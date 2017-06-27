package net.magicaltech.network;

import net.magicaltech.Reference;
import net.thegaminghuskymc.huskylib.utils.color.Color;
import net.thegaminghuskymc.huskylib.utils.color.ColorRGBA;

public enum EnumUpgradeType {

    BLANK(0, "blank", new ColorRGBA(255, 255, 255, 255), "blank");
//    MACHINE_IO(1, "machine_io", EnumXycroniumColor.GREEN.getColor(), "machine_io"),
//    SPEED(2, "speed", EnumXycroniumColor.RED.getColor(), "speed"),
//    CAPACITY(3, "capacity", EnumXycroniumColor.LIGHT.getColor(), "capacity");

    public static final EnumUpgradeType[] VALUES = new EnumUpgradeType[]{
            BLANK
//            MACHINE_IO,
//            SPEED,
//            CAPACITY
    };
    private int index;
    private String name;
    private Color color;
    private String texture;

    EnumUpgradeType(int index, String name, Color color, String texture){
        this.index = index;
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public int getIndex(){
        return this.index;
    }

    public String getName(){
        return this.name;
    }

    public Color getColor(){
        return this.color;
    }

    public String getTexture(){
        return Reference.MODID + ":items/upgrade/upgrade_" + this.texture;
    }

    public static String[] toStringArray(){
        String[] names = new String[values().length];

        for(int i = 0; i < values().length; i++){
            names[i] = values()[i].getName();
        }

        return names;
    }

}
