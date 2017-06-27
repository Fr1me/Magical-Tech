package net.magicaltech.blocks;

import java.util.Iterator;

import com.google.common.collect.ImmutableSet;

import net.magicaltech.BlockStateUtils;
import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class BlockTC extends Block
{

    public BlockTC(Material material)
    {
        super(material);
        states = BlockStateUtils.getValidStatesForProperties(getDefaultState(), getProperties());
        setCreativeTab(MTCreativeTabs.blocks);
        setResistance(2.0F);
        setRegistryName(getUnlocalizedName());
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if(hasProperties())
        {
            IBlockState state;
            for(Iterator<?> i$ = states.iterator(); i$.hasNext(); list.add(new ItemStack(this, 1, getMetaFromState(state))))
                state = (IBlockState)i$.next();

        } else
        {
            list.add(new ItemStack(this, 1, 0));
        }
    }

    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    public IProperty[] getProperties()
    {
        return null;
    }

    public boolean hasProperties()
    {
        return getProperties() != null;
    }

    public String getStateName(IBlockState state, boolean fullName)
    {
        String unlocalizedName = state.getBlock().getUnlocalizedName();
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public boolean defineVariantsForItemBlock()
    {
        return false;
    }

    public ImmutableSet<?> states;
}
