package net.magicaltech;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class BlockStateUtils
{
    private static class IndexedProperty
    {

        public boolean increment()
        {
            if(counter < maxCount)
                counter++;
            else
            if(hasParent())
            {
                resetSelfAndChildren();
                return parent.increment();
            } else
            {
                return false;
            }
            return true;
        }

        public void resetSelfAndChildren()
        {
            counter = 0;
            if(hasChild())
                child.resetSelfAndChildren();
        }

        public boolean hasParent()
        {
            return parent != null;
        }

        public boolean hasChild()
        {
            return child != null;
        }

        public int getCounter()
        {
            return counter;
        }

        public int getMaxCount()
        {
            return maxCount;
        }

        public Comparable getCurrentValue()
        {
            return (Comparable)validValues.get(counter);
        }

        private ArrayList validValues;
        private int maxCount;
        private int counter;
        private IndexedProperty parent;
        private IndexedProperty child;



        private IndexedProperty(IProperty property)
        {
            validValues = new ArrayList();
            validValues.addAll(property.getAllowedValues());
            maxCount = validValues.size() - 1;
        }

    }

    private static class PropertyIndexer
    {

        public boolean increment()
        {
            return ((IndexedProperty)indexedProperties.get(finalProperty)).increment();
        }

        public IndexedProperty getIndexedProperty(IProperty property)
        {
            return (IndexedProperty)indexedProperties.get(property);
        }

        private HashMap indexedProperties;
        private IProperty finalProperty;

        private PropertyIndexer(IProperty properties[])
        {
            indexedProperties = new HashMap();
            finalProperty = properties[properties.length - 1];
            IndexedProperty previousIndexedProperty = null;
            IProperty arr$[] = properties;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                IProperty property = arr$[i$];
                IndexedProperty indexedProperty = new IndexedProperty(property);
                if(previousIndexedProperty != null)
                {
                    indexedProperty.parent = previousIndexedProperty;
                    previousIndexedProperty.child = indexedProperty;
                }
                indexedProperties.put(property, indexedProperty);
                previousIndexedProperty = indexedProperty;
            }

        }

    }


    public BlockStateUtils()
    {
    }

    public static EnumFacing getFacing(IBlockState state)
    {
        return EnumFacing.getFront(state.getBlock().getMetaFromState(state) & 7);
    }

    public static EnumFacing getFacing(int meta)
    {
        return EnumFacing.getFront(meta & 7);
    }

    public static boolean isEnabled(IBlockState state)
    {
        return (state.getBlock().getMetaFromState(state) & 8) != 8;
    }

    public static boolean isEnabled(int meta)
    {
        return (meta & 8) != 8;
    }

    public static IProperty getPropertyByName(IBlockState blockState, String propertyName)
    {
        for(Iterator i$ = blockState.getProperties().keySet().iterator(); i$.hasNext();)
        {
            IProperty property = (IProperty)i$.next();
            if(property.getName().equals(propertyName))
                return property;
        }

        return null;
    }

    public static boolean isValidPropertyName(IBlockState blockState, String propertyName)
    {
        return getPropertyByName(blockState, propertyName) != null;
    }

    public static Comparable getPropertyValueByName(IBlockState blockState, IProperty property, String valueName)
    {
        for(Iterator i$ = ((ImmutableSet)property.getAllowedValues()).iterator(); i$.hasNext();)
        {
            Comparable value = (Comparable)i$.next();
            if(value.toString().equals(valueName))
                return value;
        }

        return null;
    }

    public static ImmutableSet getValidStatesForProperties(IBlockState baseState, IProperty properties[])
    {
        if(properties == null)
            return null;
        Set validStates = Sets.newHashSet();
        PropertyIndexer propertyIndexer = new PropertyIndexer(properties);
        do
        {
            IBlockState currentState = baseState;
            IProperty arr$[] = properties;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                IProperty property = arr$[i$];
                IndexedProperty indexedProperty = propertyIndexer.getIndexedProperty(property);
                currentState = currentState.withProperty(property, indexedProperty.getCurrentValue());
            }

            validStates.add(currentState);
        } while(propertyIndexer.increment());
        return ImmutableSet.copyOf(validStates);
    }
}
