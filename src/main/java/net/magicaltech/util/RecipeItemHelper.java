package net.magicaltech.util;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntCollection;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import java.util.BitSet;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RecipeItemHelper
{
    /** Map from {@link #pack} packed ids to counts */
    public final Int2IntMap itemToCount = new Int2IntOpenHashMap();

    public void func_194112_a(ItemStack stack)
    {
        if (!stack.isEmpty() && !stack.isItemDamaged() && !stack.isItemEnchanted() && !stack.hasDisplayName())
        {
            int i = pack(stack);
            int j = stack.getCount();
            this.increment(i, j);
        }
    }

    public static int pack(ItemStack stack)
    {
        Item item = stack.getItem();
        int i = item.getHasSubtypes() ? stack.getMetadata() : 0;
        return Item.REGISTRY.getIDForObject(item) << 16 | i & 65535;
    }

    public boolean containsItem(int p_194120_1_)
    {
        return this.itemToCount.get(p_194120_1_) > 0;
    }

    public int tryTake(int p_194122_1_, int maximum)
    {
        int i = this.itemToCount.get(p_194122_1_);

        if (i >= maximum)
        {
            this.itemToCount.put(p_194122_1_, i - maximum);
            return p_194122_1_;
        }
        else
        {
            return 0;
        }
    }

    private void increment(int p_194117_1_, int amount)
    {
        this.itemToCount.put(p_194117_1_, this.itemToCount.get(p_194117_1_) + amount);
    }

    public boolean func_194116_a(IRecipe recipe, @Nullable IntList p_194116_2_)
    {
        return this.func_194118_a(recipe, p_194116_2_, 1);
    }

    public boolean func_194118_a(IRecipe recipe, @Nullable IntList p_194118_2_, int p_194118_3_)
    {
        return (new RecipeItemHelper.RecipePicker(recipe)).func_194092_a(p_194118_3_, p_194118_2_);
    }

    public int func_194114_b(IRecipe recipe, @Nullable IntList p_194114_2_)
    {
        return this.func_194121_a(recipe, Integer.MAX_VALUE, p_194114_2_);
    }

    public int func_194121_a(IRecipe recipe, int p_194121_2_, @Nullable IntList p_194121_3_)
    {
        return (new RecipeItemHelper.RecipePicker(recipe)).func_194102_b(p_194121_2_, p_194121_3_);
    }

    public static ItemStack unpack(int p_194115_0_)
    {
        return p_194115_0_ == 0 ? ItemStack.EMPTY : new ItemStack(Item.getItemById(p_194115_0_ >> 16 & 65535), 1, p_194115_0_ & 65535);
    }

    public void clear()
    {
        this.itemToCount.clear();
    }

    @SideOnly(Side.CLIENT)
    class RecipePicker
    {
        private final IRecipe recipe;
        private final List<Ingredient> ingredients = Lists.<Ingredient>newArrayList();
        private final int ingredientCount;
        private final int[] possessedIngredientStacks;
        private final int possessedIngredientStackCount;
        private final BitSet field_194110_g;
        private IntList field_194111_h = new IntArrayList();

        public RecipePicker(IRecipe p_i47608_2_)
        {
            this.recipe = p_i47608_2_;
            this.ingredients.addAll(p_i47608_2_.getIngredients());
            this.ingredients.removeIf((p_194103_0_) ->
            {
                return p_194103_0_ == Ingredient.EMPTY;
            });
            this.ingredientCount = this.ingredients.size();
            this.possessedIngredientStacks = this.func_194097_a();
            this.possessedIngredientStackCount = this.possessedIngredientStacks.length;
            this.field_194110_g = new BitSet(this.ingredientCount + this.possessedIngredientStackCount + this.ingredientCount + this.ingredientCount * this.possessedIngredientStackCount);

            for (int i = 0; i < this.ingredients.size(); ++i)
            {
                IntList intlist = ((Ingredient)this.ingredients.get(i)).getValidItemStacksPacked();

                for (int j = 0; j < this.possessedIngredientStackCount; ++j)
                {
                    if (intlist.contains(this.possessedIngredientStacks[j]))
                    {
                        this.field_194110_g.set(this.func_194095_d(true, j, i));
                    }
                }
            }
        }

        public boolean func_194092_a(int p_194092_1_, @Nullable IntList p_194092_2_)
        {
            if (p_194092_1_ <= 0)
            {
                return true;
            }
            else
            {
                int k;

                for (k = 0; this.func_194098_a(p_194092_1_); ++k)
                {
                    RecipeItemHelper.this.tryTake(this.possessedIngredientStacks[this.field_194111_h.getInt(0)], p_194092_1_);
                    int l = this.field_194111_h.size() - 1;
                    this.func_194096_c(this.field_194111_h.getInt(l));

                    for (int i1 = 0; i1 < l; ++i1)
                    {
                        this.func_194089_c((i1 & 1) == 0, ((Integer)this.field_194111_h.get(i1)).intValue(), ((Integer)this.field_194111_h.get(i1 + 1)).intValue());
                    }

                    this.field_194111_h.clear();
                    this.field_194110_g.clear(0, this.ingredientCount + this.possessedIngredientStackCount);
                }

                boolean flag = k == this.ingredientCount;
                boolean flag1 = flag && p_194092_2_ != null;

                if (flag1)
                {
                    p_194092_2_.clear();
                }

                this.field_194110_g.clear(0, this.ingredientCount + this.possessedIngredientStackCount + this.ingredientCount);
                int j1 = 0;
                List<Ingredient> list = this.recipe.getIngredients();

                for (int k1 = 0; k1 < list.size(); ++k1)
                {
                    if (flag1 && list.get(k1) == Ingredient.EMPTY)
                    {
                        p_194092_2_.add(0);
                    }
                    else
                    {
                        for (int l1 = 0; l1 < this.possessedIngredientStackCount; ++l1)
                        {
                            if (this.func_194100_b(false, j1, l1))
                            {
                                this.func_194089_c(true, l1, j1);
                                RecipeItemHelper.this.increment(this.possessedIngredientStacks[l1], p_194092_1_);

                                if (flag1)
                                {
                                    p_194092_2_.add(this.possessedIngredientStacks[l1]);
                                }
                            }
                        }

                        ++j1;
                    }
                }

                return flag;
            }
        }

        private int[] func_194097_a()
        {
            IntCollection intcollection = new IntAVLTreeSet();

            for (Ingredient ingredient : this.ingredients)
            {
                intcollection.addAll(ingredient.getValidItemStacksPacked());
            }

            IntIterator intiterator = intcollection.iterator();

            while (intiterator.hasNext())
            {
                if (!RecipeItemHelper.this.containsItem(intiterator.nextInt()))
                {
                    intiterator.remove();
                }
            }

            return intcollection.toIntArray();
        }

        private boolean func_194098_a(int p_194098_1_)
        {
            int k = this.possessedIngredientStackCount;

            for (int l = 0; l < k; ++l)
            {
                if (RecipeItemHelper.this.itemToCount.get(this.possessedIngredientStacks[l]) >= p_194098_1_)
                {
                    this.func_194088_a(false, l);

                    while (!this.field_194111_h.isEmpty())
                    {
                        int i1 = this.field_194111_h.size();
                        boolean flag = (i1 & 1) == 1;
                        int j1 = this.field_194111_h.getInt(i1 - 1);

                        if (!flag && !this.func_194091_b(j1))
                        {
                            break;
                        }

                        int k1 = flag ? this.ingredientCount : k;

                        for (int l1 = 0; l1 < k1; ++l1)
                        {
                            if (!this.func_194101_b(flag, l1) && this.func_194093_a(flag, j1, l1) && this.func_194100_b(flag, j1, l1))
                            {
                                this.func_194088_a(flag, l1);
                                break;
                            }
                        }

                        int i2 = this.field_194111_h.size();

                        if (i2 == i1)
                        {
                            this.field_194111_h.removeInt(i2 - 1);
                        }
                    }

                    if (!this.field_194111_h.isEmpty())
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean func_194091_b(int p_194091_1_)
        {
            return this.field_194110_g.get(this.func_194094_d(p_194091_1_));
        }

        private void func_194096_c(int p_194096_1_)
        {
            this.field_194110_g.set(this.func_194094_d(p_194096_1_));
        }

        private int func_194094_d(int p_194094_1_)
        {
            return this.ingredientCount + this.possessedIngredientStackCount + p_194094_1_;
        }

        private boolean func_194093_a(boolean p_194093_1_, int p_194093_2_, int p_194093_3_)
        {
            return this.field_194110_g.get(this.func_194095_d(p_194093_1_, p_194093_2_, p_194093_3_));
        }

        private boolean func_194100_b(boolean p_194100_1_, int p_194100_2_, int p_194100_3_)
        {
            return p_194100_1_ != this.field_194110_g.get(1 + this.func_194095_d(p_194100_1_, p_194100_2_, p_194100_3_));
        }

        private void func_194089_c(boolean p_194089_1_, int p_194089_2_, int p_194089_3_)
        {
            this.field_194110_g.flip(1 + this.func_194095_d(p_194089_1_, p_194089_2_, p_194089_3_));
        }

        private int func_194095_d(boolean p_194095_1_, int p_194095_2_, int p_194095_3_)
        {
            int k = p_194095_1_ ? p_194095_2_ * this.ingredientCount + p_194095_3_ : p_194095_3_ * this.ingredientCount + p_194095_2_;
            return this.ingredientCount + this.possessedIngredientStackCount + this.ingredientCount + 2 * k;
        }

        private void func_194088_a(boolean p_194088_1_, int p_194088_2_)
        {
            this.field_194110_g.set(this.func_194099_c(p_194088_1_, p_194088_2_));
            this.field_194111_h.add(p_194088_2_);
        }

        private boolean func_194101_b(boolean p_194101_1_, int p_194101_2_)
        {
            return this.field_194110_g.get(this.func_194099_c(p_194101_1_, p_194101_2_));
        }

        private int func_194099_c(boolean p_194099_1_, int p_194099_2_)
        {
            return (p_194099_1_ ? 0 : this.ingredientCount) + p_194099_2_;
        }

        public int func_194102_b(int p_194102_1_, @Nullable IntList p_194102_2_)
        {
            int k = 0;
            int l = Math.min(p_194102_1_, this.func_194090_b()) + 1;

            while (true)
            {
                int i1 = (k + l) / 2;

                if (this.func_194092_a(i1, (IntList)null))
                {
                    if (l - k <= 1)
                    {
                        if (i1 > 0)
                        {
                            this.func_194092_a(i1, p_194102_2_);
                        }

                        return i1;
                    }

                    k = i1;
                }
                else
                {
                    l = i1;
                }
            }
        }

        private int func_194090_b()
        {
            int k = Integer.MAX_VALUE;

            for (Ingredient ingredient : this.ingredients)
            {
                int l = 0;
                int i1;

                for (IntListIterator intlistiterator = ingredient.getValidItemStacksPacked().iterator(); intlistiterator.hasNext(); l = Math.max(l, RecipeItemHelper.this.itemToCount.get(i1)))
                {
                    i1 = ((Integer)intlistiterator.next()).intValue();
                }

                if (k > 0)
                {
                    k = Math.min(k, l);
                }
            }

            return k;
        }
    }
}