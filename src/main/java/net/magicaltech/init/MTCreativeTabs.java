package net.magicaltech.init;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by TheGamingHuskyMC on 29.05.2017.
 */
public class MTCreativeTabs {

    public static CreativeTabs blocks;
    public static CreativeTabs combat;
    public static CreativeTabs items;
    public static CreativeTabs machines;
    public static CreativeTabs tools;
    public static CreativeTabs worldgen;

    public static void initTabs(){
        blocks = new CreativeTabs("blocks_mt"){
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(MTBlocks.hStone));
            }
        };
        combat = new CreativeTabs("combat_mt"){
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(MTTools.tSword);
            } 
        };
        items = new CreativeTabs("items_mt"){
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(MTItems.tIngot);
            }
        };
        machines = new CreativeTabs("machines_mt"){
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.FURNACE));
            }

        };
        tools = new CreativeTabs("tools_mt"){
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(MTTools.tPickaxe);
            }
        };
        worldgen = new CreativeTabs("worldgen_mt"){
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_ORE));
            }
        };
    }

}
