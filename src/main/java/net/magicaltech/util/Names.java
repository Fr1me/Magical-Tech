package net.magicaltech.util;

import net.minecraft.util.text.TextFormatting;

public class Names {

    public static class CraftingToolTips {
        public static final String CRAFT_WITH = "\u00a7a" + "Craft in Crafting Table with:";
    }
    
    public static class SmeltingToolTips {
    	public static final String SMELT_WITH = "\u00a7a" + "Smelt in Furnace with:";
    }
    
    public static class HelpToolTips {
    	public static final String WIP_BLOCK = StringHelper.getRedText("This block is Work In Progess but will be finished soon");
    	public static final String WIP_ITEM = StringHelper.getRedText("This item is Work In Progess but will be finished soon");
    	public static final String SHIFT_FOR_INFO = StringHelper.getFlavorText("Hold") + " " + StringHelper.getYellowText("Shift") + " " + StringHelper.getFlavorText("for Info.");
    }
    
    public static class GuiSpecialToolTips {
    	
    }

}
