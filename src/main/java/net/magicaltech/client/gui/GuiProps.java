// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   java

package net.magicaltech.client.gui;

import net.minecraft.util.ResourceLocation;

public class GuiProps
{

    private GuiProps()
    {
    }

    public static final String PATH_GFX = "techreborn:textures/";
    public static final String PATH_GUI = "techreborn:textures/gui/";
    public static final String PATH_ELEMENTS = "techreborn:textures/gui/elements/";
    
    /* TEXTURES */
	public static final String PATH_ARMOR = PATH_GFX + "armor/";
	public static final String PATH_ENTITY = PATH_GFX + "entity/";
	public static final String PATH_RENDER = PATH_GFX + "blocks/";

	public static final String PATH_GUI_MACHINE = PATH_GUI + "machine/";
	
	public static final String PATH_GUI_SHEET = PATH_GUI + "gui_sheet.png";
	
	/* INFO TEXTURES */
	public static final String TEX_INFO_INPUT = PATH_ELEMENTS + "info_input.png";
	public static final String TEX_INFO_OUTPUT = PATH_ELEMENTS + "info_output.png";

	/* PROGRESS TEXTURES */
	public static final String TEX_ARROW_LEFT = PATH_ELEMENTS + "progress_arrow_left.png";
	public static final String TEX_ARROW_RIGHT = PATH_ELEMENTS + "progress_arrow_right.png";
	public static final String TEX_ARROW_FLUID_LEFT = PATH_ELEMENTS + "progress_arrow_fluid_left.png";
	public static final String TEX_ARROW_FLUID_RIGHT = PATH_ELEMENTS + "progress_arrow_fluid_right.png";
	public static final String TEX_DROP_LEFT = PATH_ELEMENTS + "progress_fluid_left.png";
	public static final String TEX_DROP_RIGHT = PATH_ELEMENTS + "progress_fluid_right.png";

	/* SPEED / INTENSITY TEXTURES */
	public static final String TEX_ALCHEMY = PATH_ELEMENTS + "scale_alchemy.png";
	public static final String TEX_BUBBLE = PATH_ELEMENTS + "scale_bubble.png";
	public static final String TEX_COMPACT = PATH_ELEMENTS + "scale_compact.png";
	public static final String TEX_CRUSH = PATH_ELEMENTS + "scale_crush.png";
	public static final String TEX_FLAME = PATH_ELEMENTS + "scale_flame.png";
	public static final String TEX_FLAME_GREEN = PATH_ELEMENTS + "scale_flame_green.png";
	public static final String TEX_FLUX = PATH_ELEMENTS + "scale_flux.png";
	public static final String TEX_SAW = PATH_ELEMENTS + "scale_saw.png";
	public static final String TEX_SUN = PATH_ELEMENTS + "scale_sun.png";
	public static final String TEX_SNOWFLAKE = PATH_ELEMENTS + "scale_snowflake.png";

	public static final String TEX_BUTTONS = PATH_ELEMENTS + "buttons.png";

	public static final ResourceLocation PATH_COMMON = new ResourceLocation(PATH_ELEMENTS + "slots.png");
	public static final ResourceLocation PATH_COMMON_CB = new ResourceLocation(PATH_ELEMENTS + "slots_cb.png");
	public static final ResourceLocation PATH_CENTRIFUGE = new ResourceLocation(PATH_ELEMENTS + "slots_centrifuge.png");
	public static final ResourceLocation PATH_CENTRIFUGE_CB = new ResourceLocation(PATH_ELEMENTS + "slots_centrifuge_cb.png");
	public static final ResourceLocation PATH_CRAFTER = new ResourceLocation(PATH_ELEMENTS + "slots_crafter.png");
	public static final ResourceLocation PATH_CRAFTER_CB = new ResourceLocation(PATH_ELEMENTS + "slots_crafter_cb.png");
	public static final String PATH_ICON = PATH_GUI + "icons/";

	public static final String TEXTURE_DEFAULT = "config_";
	public static final String TEXTURE_CB = "config_cb_";

	public static ResourceLocation textureGuiCommon = PATH_COMMON;
	public static ResourceLocation textureGuiCentrifuge = PATH_CENTRIFUGE;
	public static ResourceLocation textureGuiCrafter = PATH_CRAFTER;
	public static String textureSelection = TEXTURE_DEFAULT;
	public static boolean useAlternateStarfieldShader = false;

	/* BLOCKSTATE PROPERTIES */
//	public static final UnlistedBooleanProperty ACTIVE = new UnlistedBooleanProperty("active");
//	public static final UnlistedBooleanProperty CREATIVE = new UnlistedBooleanProperty("creative");
//	public static final UnlistedEnumFacingProperty FACING = new UnlistedEnumFacingProperty("facing");

//	public static final UnlistedIntegerProperty LEVEL = new UnlistedIntegerProperty("level");
//	public static final UnlistedIntegerProperty HOLDING = new UnlistedIntegerProperty("enchant_holding");
//	public static final UnlistedIntegerProperty SCALE = new UnlistedIntegerProperty("scale");

//	public static final UnlistedByteArrayProperty SIDE_CONFIG = new UnlistedByteArrayProperty("side_config");

//	public static final UnlistedFluidStackProperty FLUID = new UnlistedFluidStackProperty("fluid_stack");
//	public static final UnlistedResourceLocationProperty ACTIVE_SPRITE_PROPERTY = new UnlistedResourceLocationProperty("active_texture");
//	public static final UnlistedTileEntityProperty TILE = new UnlistedTileEntityProperty("tile");
}
