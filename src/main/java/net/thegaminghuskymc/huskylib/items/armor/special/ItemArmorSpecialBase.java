package net.thegaminghuskymc.huskylib.items.armor.special;

import java.util.List;

import com.google.common.collect.ImmutableMap;

import net.magicaltech.init.MTCreativeTabs;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.animation.ITimeValue;
import net.thegaminghuskymc.huskylib.utils.Names;

public class ItemArmorSpecialBase extends ItemArmor {
	
	private ArmorMaterial material;

	public ItemArmorSpecialBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.material = materialIn;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MTCreativeTabs.combat);
	}
	
	@Override
	public ArmorMaterial getArmorMaterial() {
		return material;
	}
	
	@Override
	public int getColor(ItemStack stack) {
		return super.getColor(stack);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(Names.ItemToolTips.TEST_ITEM);
	}
	
	@Override
	public String getHighlightTip(ItemStack item, String displayName) {
		return super.getHighlightTip(item, displayName);
	}
	
	@Override
	public int getItemStackLimit() {
		return 1;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return super.getIsRepairable(toRepair, repair);
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return super.getDurabilityForDisplay(stack);
	}
	
	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) {
		return super.getRGBDurabilityForDisplay(stack);
	}
	
	@Override
	public int getItemEnchantability() {
		return super.getItemEnchantability();
	}
	
	

}
