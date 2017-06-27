package net.magicaltech.network;

import net.minecraft.util.IStringSerializable;

public enum EnumPlankTypes implements IStringSerializable{
	
	GREATWOOD("greatwood", 0),
	SILVERWOOD("silverwood", 1);

	private String name;
	private int ID;
	
	EnumPlankTypes(String name, int ID){
    	this.name = name;
    	this.ID = ID;
    }

    public String getName()
    {
        return this.name;
    }

    public String toString()
    {
        return getName();
    }

}
