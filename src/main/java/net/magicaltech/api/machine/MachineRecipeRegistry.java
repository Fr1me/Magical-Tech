package net.magicaltech.api.machine;

import com.google.common.collect.Iterators;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class MachineRecipeRegistry
  implements Iterable<IMachineRecipe>
{
  private final IdentityHashMap<IMachineRecipe, ModContainer> toBlameMap = new IdentityHashMap();
  private final LinkedList<IMachineRecipe> recipes = new LinkedList();
  
  public void addRecipe(IMachineRecipe recipe)
  {
    addRecipe(recipe, Loader.instance().activeModContainer());
  }
  
  public void addRecipe(IMachineRecipe recipe, ModContainer value)
  {
    this.recipes.add(recipe);
    this.toBlameMap.put(recipe, value);
  }
  
  public void addPriorityRecipe(IMachineRecipe recipe)
  {
    addPriorityRecipe(recipe, Loader.instance().activeModContainer());
  }
  
  public void addPriorityRecipe(IMachineRecipe recipe, ModContainer value)
  {
    this.recipes.addFirst(recipe);
    this.toBlameMap.put(recipe, value);
  }
  
  public boolean removeRecipe(IMachineRecipe recipe)
  {
    if (this.recipes.remove(recipe))
    {
      this.toBlameMap.remove(recipe);
      return true;
    }
    return false;
  }
  
  public ModContainer getOwner(IMachineRecipe recipe)
  {
    return (ModContainer)this.toBlameMap.get(recipe);
  }
  
  public Iterator<IMachineRecipe> iterator()
  {
    return Iterators.unmodifiableIterator(this.recipes.iterator());
  }
  
  public boolean contains(IMachineRecipe recipe)
  {
    return this.toBlameMap.containsKey(recipe);
  }
}