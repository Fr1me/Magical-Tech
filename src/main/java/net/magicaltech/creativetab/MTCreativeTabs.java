package net.magicaltech.creativetab;
import net.magicaltech.creativetab.*;

public class MTCreativeTabs {

    public static TabBlocks blocks;
    public static TabCombat combat;
    public static TabItems items;
    public static TabMachines machines;
    public static TabTools tools;
    public static TabWorldgen worldgen;

    static{
        blocks = new TabBlocks();
        combat = new TabCombat();
        items = new TabItems();
        machines = new TabMachines();
        tools = new TabTools();
        worldgen = new TabWorldgen();
    }

}