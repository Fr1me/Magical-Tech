package keri.ninetaillib.util;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

import keri.ninetaillib.item.IGuiItem;
import net.magicaltech.util.colours.ColourRGBA;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class CommonUtils {

    public static final GameProfile DEFAULT_PROFILE = new GameProfile(UUID.fromString("8667ba71-b85a-4004-af54-457a9734eed7"), "Steve");

    public static SoundType getSoundType(Material material){
        if(material == Material.ANVIL){
            return SoundType.ANVIL;
        }
        else if(material == Material.CARPET || material == Material.CLOTH || material == Material.CAKE) {
            return SoundType.CLOTH;
        }
        else if(material == Material.GLASS || material == Material.ICE) {
            return SoundType.GLASS;
        }
        else if(material == Material.GRASS || material == Material.TNT || material == Material.PLANTS || material == Material.VINE) {
            return SoundType.PLANT;
        }
        else if(material == Material.GROUND) {
            return SoundType.GROUND;
        }
        else if(material == Material.IRON) {
            return SoundType.METAL;
        }
        else if(material == Material.SAND) {
            return SoundType.SAND;
        }
        else if(material == Material.SNOW) {
            return SoundType.SNOW;
        }
        else if(material == Material.ROCK) {
            return SoundType.STONE;
        }
        else if(material == Material.WOOD || material == Material.CACTUS) {
            return SoundType.WOOD;
        }
        else{
            return SoundType.STONE;
        }
    }

    public static boolean isShiftPressed(){
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isControllPressed(){
        return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
    }

    public static AxisAlignedBB devide(AxisAlignedBB aabb, double d){
        double minX = aabb.minX / d;
        double minY = aabb.minX / d;
        double minZ = aabb.minX / d;
        double maxX = aabb.minX / d;
        double maxY = aabb.minX / d;
        double maxZ = aabb.minX / d;
        return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
    }

   /* public static Cuboid6 devide(Cuboid6 cuboid, double d){
        double minX = cuboid.min.x / d;
        double minY = cuboid.min.y / d;
        double minZ = cuboid.min.z / d;
        double maxX = cuboid.max.x / d;
        double maxY = cuboid.max.y / d;
        double maxZ = cuboid.max.z / d;
        return new Cuboid6(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static Vector3 getWorldPosition(Entity entity, float partialTicks){
        double interpPosX = MathHelper.interpolate(entity.lastTickPosX, entity.posX, partialTicks);
        double interpPosY = MathHelper.interpolate(entity.lastTickPosY, entity.posY, partialTicks);
        double interpPosZ = MathHelper.interpolate(entity.lastTickPosZ, entity.posZ, partialTicks);
        double x = MathHelper.interpolate(entity.prevPosX, entity.posX, partialTicks) - interpPosX;
        double y = MathHelper.interpolate(entity.prevPosY, entity.posY, partialTicks) - interpPosY;
        double z = MathHelper.interpolate(entity.prevPosZ, entity.posZ, partialTicks) - interpPosZ;
        return new Vector3(x, y, z);
    }*/

    public static ColourRGBA readColorFromNBT(String name, NBTTagCompound tag){
        int[] colorData = tag.getIntArray(name);
        return new ColourRGBA(colorData[0], colorData[1], colorData[2], colorData[3]);
    }

    public static void writeColorToNBT(String name, NBTTagCompound tag, ColourRGBA color){
        int[] colorData = new int[4];
        colorData[0] = color.r;
        colorData[1] = color.g;
        colorData[2] = color.b;
        colorData[3] = color.a;
        tag.setIntArray(name, colorData);
    }

    public static List<BlockPos> readPosList(String name, NBTTagCompound tag){
        List<BlockPos> list = Lists.newArrayList();
        int[] xCoords = tag.getIntArray(name + "_x");
        int[] yCoords = tag.getIntArray(name + "_y");
        int[] zCoords = tag.getIntArray(name + "_z");

        for(int i = 0; i < xCoords.length; i++){
            list.add(new BlockPos(xCoords[i], yCoords[i], zCoords[i]));
        }

        return list;
    }

    public static void writePosList(String name, NBTTagCompound tag, List<BlockPos> list){
        int[] xCoords = new int[list.size()];
        int[] yCoords = new int[list.size()];
        int[] zCoords = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            xCoords[i] = list.get(i).getX();
            yCoords[i] = list.get(i).getY();
            zCoords[i] = list.get(i).getZ();
        }

        tag.setIntArray(name + "_x", xCoords);
        tag.setIntArray(name + "_y", yCoords);
        tag.setIntArray(name + "_z", zCoords);
    }

    public static void openItemGui(Object mod, EntityPlayer player, EntityEquipmentSlot slot){
        ItemStack stack = player.getItemStackFromSlot(slot);

        if(stack == null || !(stack.getItem() instanceof IGuiItem)){
            return;
        }

        IGuiItem iface = (IGuiItem)stack.getItem();
        player.openGui(mod, 100 * slot.ordinal() + iface.getGuiId(stack), player.world, (int)player.posX, (int)player.posY, (int)player.posZ);
    }

    public static EntityEquipmentSlot getSlotFromGuiId(int ID){
        EntityEquipmentSlot slot = EntityEquipmentSlot.values()[ID / 100];
        ID %= 100;
        return slot;
    }

    public static boolean isDevEnvironment(){
        return (Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");
    }

    public static ColourRGBA fromAWT(Color color){
        return new ColourRGBA(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public static Color toAWT(ColourRGBA color){
        return new Color(color.rgba(), true);
    }

    public static void dropInventory(TileEntity tile) {
        if (!(tile instanceof IInventory))
            return;

        IInventory inventory = (IInventory)tile;

        if (inventory != null) {
            dropInventory(tile, 0, inventory.getSizeInventory() - 1);
        }
    }

    public static void dropInventory(TileEntity tile, int min, int max) {
        if (!(tile instanceof IInventory)) {
            return;
        }

        IInventory inventory = (IInventory)tile;
        World world = tile.getWorld();
        BlockPos blockPos = tile.getPos();

        for (int i = min; i <= max; i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack != null && itemStack.getCount() > 0) {
                Random rand = new Random();

                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, blockPos.getX() + dX, blockPos.getY() + dY, blockPos.getZ() + dZ, itemStack.copy());

                if (itemStack.hasTagCompound()) {
                    entityItem.getItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntity(entityItem);
                itemStack.getCount();
                inventory.setInventorySlotContents(i, null);
            }
        }

        inventory.markDirty();
    }

    public static boolean isBaublesLoaded(){
        return Loader.isModLoaded("Baubles");
    }

    public static EnumFacing rotateAroundY(EnumFacing input, int amount){
        switch(amount){
            case 0: return input;
            case 90:
                switch(input){
                    case NORTH: return EnumFacing.WEST;
                    case EAST: return EnumFacing.NORTH;
                    case SOUTH: return EnumFacing.EAST;
                    case WEST: return EnumFacing.SOUTH;
                    default: return input;
                }
            case 180:
                switch(input){
                    case NORTH: return EnumFacing.SOUTH;
                    case EAST: return EnumFacing.WEST;
                    case SOUTH: return EnumFacing.NORTH;
                    case WEST: return EnumFacing.EAST;
                    default: return input;
                }
            case 270:
                switch(input){
                    case NORTH: return EnumFacing.EAST;
                    case EAST: return EnumFacing.SOUTH;
                    case SOUTH: return EnumFacing.WEST;
                    case WEST: return EnumFacing.NORTH;
                    default: return input;
                }
            case 360: return input;
            default: return input;
        }
    }

}