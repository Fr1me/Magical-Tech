// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IBlockFacing.java

package net.magicaltech.blocks;

import com.google.common.base.Predicate;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public interface IBlockFacing
{

    public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate() {

        public boolean apply(EnumFacing facing)
        {
            return true;
        }

        public boolean apply(Object p_apply_1_)
        {
            return apply((EnumFacing)p_apply_1_);
        }

    }
);

}
