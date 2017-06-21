package codechicken.lib.render.state;

import java.util.ArrayList;
import java.util.LinkedList;

import org.lwjgl.opengl.GL11;

import com.google.common.base.MoreObjects;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by covers1624 on 10/10/2016.
 * Dumps specific GL states from GlStateManager
 * Ability to push and pop most of the GL state.
 * TODO Ability to auto compare between different saved states. So basically a GlLeak analyser.
 * TODO Support both Raw GL and GLStateManager, would be useful for detecting GLLeaks that occur due to raw GL calls.
 * TODO Support all the things.
 */
public class GlStateTracker {
	
	private static final GlStateTracker.AlphaState alphaState = new GlStateTracker.AlphaState();
    private static final GlStateTracker.BooleanState lightingState = new GlStateTracker.BooleanState(2896);
    private static GlStateTracker.BlendState blendState;
    private static GlStateTracker.DepthState depthState;
    private static GlStateTracker.CullState cullState;
    private static GlStateTracker.BooleanState rescaleNormalState;
    public static enum State {
    	
        GL_ALPHA_TEST {
            @Override
            public String getState() {
                AlphaState alphaState = GlStateTracker.alphaState;
                return MoreObjects.toStringHelper(name()).add("Func", alphaState.func).add("Ref", alphaState.ref).add("Enabled", String.valueOf(alphaState.alphaTest.currentState).toUpperCase()).toString();
            }

            @Override
            public void pushState(SavedState state) {
                state.alphaTest = GlStateTracker.alphaState.alphaTest.currentState;
                state.alphaFunc = GlStateTracker.alphaState.func;
                state.alphaRef = GlStateTracker.alphaState.ref;
            }

            @Override
            public void popState(SavedState pre, SavedState post) {
                if (pre.alphaTest) {
                    GlStateManager.enableAlpha();
                } else {
                    GlStateManager.disableAlpha();
                }
                GlStateManager.alphaFunc(pre.alphaFunc, pre.alphaRef);
            }
        },
        GL_LIGHTING {
            @Override
            public String getState() {
                return MoreObjects.toStringHelper(name()).add("Enabled", parseBoolState(GlStateTracker.lightingState)).toString();
            }

            @Override
            public void pushState(SavedState state) {
                state.lighting = GlStateTracker.lightingState.currentState;
            }

            @Override
            public void popState(SavedState pre, SavedState post) {
                if (pre.lighting) {
                    GlStateManager.enableLighting();
                } else {
                    GlStateManager.disableLighting();
                }
            }
        },
        GL_BLEND {
            @Override
            public String getState() {
                BlendState blendState = GlStateTracker.blendState;
                //@formatter:off
                return MoreObjects.toStringHelper(name())
                        .add("SrcFactor", parseFactor(blendState.srcFactor))          .add("DstFactor", parseFactor(blendState.dstFactor))
                        .add("SrcFactorAlpha", parseFactor(blendState.srcFactorAlpha)).add("DstFactorAlpha", parseFactor(blendState.dstFactorAlpha))
                        .add("Enabled", parseBoolState(blendState.blend)).toString();
                //@formatter:on
            }

            @Override
            public void pushState(SavedState state) {
                state.blend = GlStateTracker.blendState.blend.currentState;
                state.blendSrcFactor = GlStateTracker.blendState.srcFactor;
                state.blendDstFactor = GlStateTracker.blendState.dstFactor;
                state.blendSrcFactorAlpha = GlStateTracker.blendState.srcFactorAlpha;
                state.blendDstFactorAlpha = GlStateTracker.blendState.dstFactorAlpha;
            }

            @Override
            public void popState(SavedState pre, SavedState post) {
                if (pre.blend) {
                    GlStateManager.enableBlend();
                } else {
                    GlStateManager.disableBlend();
                }
                if (pre.blendSrcFactorAlpha != post.blendSrcFactorAlpha || pre.blendDstFactorAlpha != post.blendDstFactorAlpha) {
                    GlStateManager.tryBlendFuncSeparate(pre.blendSrcFactor, pre.blendDstFactor, pre.blendSrcFactorAlpha, pre.blendDstFactorAlpha);
                } else {
                    GlStateManager.blendFunc(pre.blendSrcFactor, post.blendDstFactor);
                }
            }

            private String parseFactor(int factor) {
                switch (factor) {
                    case 32771:
                        return "CONSTANT_ALPHA";
                    case 32769:
                        return "CONSTANT_COLOR";
                    case 772:
                        return "DST_ALPHA";
                    case 774:
                        return "DST_COLOR";
                    case 1:
                        return "ONE";
                    case 32772:
                        return "ONE_MINUS_CONSTANT_ALPHA";
                    case 32770:
                        return "ONE_MINUS_CONSTANT_COLOR";
                    case 773:
                        return "ONE_MINUS_DST_ALPHA";
                    case 775:
                        return "ONE_MINUS_DST_COLOR";
                    case 771:
                        return "ONE_MINUS_SRC_ALPHA";
                    case 769:
                        return "ONE_MINUS_SRC_COLOR";
                    case 770:
                        return "SRC_ALPHA";
                    case 776:
                        return "SRC_ALPHA_SATURATE";
                    case 768:
                        return "SRC_COLOR";
                    case 0:
                        return "ZERO";
                    default:
                        return "UNKNOWN:" + factor;

                }
            }

        },
        GL_DEPTH_TEST {
            @Override
            public String getState() {
                DepthState depthState = GlStateTracker.depthState;
                return MoreObjects.toStringHelper(name()).add("Func", parseFunc(depthState.depthFunc)).add("Mask", String.valueOf(depthState.maskEnabled).toUpperCase()).add("Enabled", parseBoolState(depthState.depthTest)).toString();
            }

            @Override
            public void pushState(SavedState state) {
                state.depthTest = GlStateTracker.depthState.depthTest.currentState;
                state.depthMaskEnabled = GlStateTracker.depthState.maskEnabled;
                state.depthFunc = GlStateTracker.depthState.depthFunc;
            }

            @Override
            public void popState(SavedState pre, SavedState post) {
                if (pre.depthTest) {
                    GlStateManager.enableDepth();
                } else {
                    GlStateManager.disableDepth();
                }
                GlStateManager.depthMask(pre.depthMaskEnabled);
                GlStateManager.depthFunc(pre.depthFunc);
            }

            private String parseFunc(int func) {
                switch (func) {
                    case 0x200:
                        return "GL_NEVER";
                    case 0x201:
                        return "GL_LESS";
                    case 0x202:
                        return "GL_EQUAL";
                    case 0x203:
                        return "GL_LEQUAL";
                    case 0x204:
                        return "GL_GREATER";
                    case 0x205:
                        return "GL_NOTEQUAL";
                    case 0x206:
                        return "GL_GEQUAL";
                    case 0x207:
                        return "GL_ALWAYS";
                    default:
                        return "UNKNOWN:" + func;

                }
            }
        },
        GL_CULL_FACE {
            @Override
            public String getState() {
                CullState cullState = GlStateTracker.cullState;
                return MoreObjects.toStringHelper(name()).add("Mode", parseMode(cullState.mode)).add("Enabled", parseBoolState(cullState.cullFace)).toString();
            }

            @Override
            public void pushState(SavedState state) {
                state.cull = GlStateTracker.cullState.cullFace.currentState;
                state.cullMode = GlStateTracker.cullState.mode;
            }

            @Override
            public void popState(SavedState pre, SavedState post) {

                if (pre.cull) {
                    GlStateManager.enableCull();
                } else {
                    GlStateManager.disableCull();
                }
                GlStateManager.glDisableClientState(pre.cullMode);
            }

            private String parseMode(int mode) {
                switch (mode) {
                    case 1028:
                        return "FRONT";
                    case 1029:
                        return "BACK";
                    case 1032:
                        return "FRONT_AND_BACK";
                    default:
                        return "UNKNOWN:" + mode;

                }
            }

        },
        GL_RESCALE_NORMAL {
            @Override
            public String getState() {
                return MoreObjects.toStringHelper(name()).add("Enabled", parseBoolState(GlStateTracker.rescaleNormalState)).toString();
            }

            @Override
            public void pushState(SavedState state) {
                state.rescaleNormal = GlStateTracker.rescaleNormalState.currentState;
            }

            @Override
            public void popState(SavedState pre, SavedState post) {
                if (pre.rescaleNormal) {
                    GlStateManager.enableRescaleNormal();
                } else {
                    GlStateManager.disableRescaleNormal();
                }
            }

        };

        public abstract String getState();

        public abstract void pushState(SavedState state);

        public abstract void popState(SavedState pre, SavedState post);
        
    }
    
    @SideOnly(Side.CLIENT)
    static class AlphaState
        {
            public GlStateTracker.BooleanState alphaTest;
            public int func;
            public float ref;

            private AlphaState()
            {
                this.alphaTest = new GlStateTracker.BooleanState(3008);
                this.func = 519;
                this.ref = -1.0F;
            }
        }

    @SideOnly(Side.CLIENT)
    static class BlendState
        {
            public GlStateTracker.BooleanState blend;
            public int srcFactor;
            public int dstFactor;
            public int srcFactorAlpha;
            public int dstFactorAlpha;

            private BlendState()
            {
                this.blend = new GlStateTracker.BooleanState(3042);
                this.srcFactor = 1;
                this.dstFactor = 0;
                this.srcFactorAlpha = 1;
                this.dstFactorAlpha = 0;
            }
        }
    
    @SideOnly(Side.CLIENT)
    static class BooleanState
        {
            private final int capability;
            private boolean currentState;

            public BooleanState(int capabilityIn)
            {
                this.capability = capabilityIn;
            }

            public void setDisabled()
            {
                this.setState(false);
            }

            public void setEnabled()
            {
                this.setState(true);
            }

            public void setState(boolean state)
            {
                if (state != this.currentState)
                {
                    this.currentState = state;

                    if (state)
                    {
                        GL11.glEnable(this.capability);
                    }
                    else
                    {
                        GL11.glDisable(this.capability);
                    }
                }
            }
        }
    
    @SideOnly(Side.CLIENT)
    static class ClearState
        {
            public double depth;
            public GlStateTracker.Color color;

            private ClearState()
            {
                this.depth = 1.0D;
                this.color = new GlStateTracker.Color(0.0F, 0.0F, 0.0F, 0.0F);
            }
        }

    @SideOnly(Side.CLIENT)
    static class Color
        {
            public float red;
            public float green;
            public float blue;
            public float alpha;

            public Color()
            {
                this(1.0F, 1.0F, 1.0F, 1.0F);
            }

            public Color(float redIn, float greenIn, float blueIn, float alphaIn)
            {
                this.red = 1.0F;
                this.green = 1.0F;
                this.blue = 1.0F;
                this.alpha = 1.0F;
                this.red = redIn;
                this.green = greenIn;
                this.blue = blueIn;
                this.alpha = alphaIn;
            }
        }

    @SideOnly(Side.CLIENT)
    static class ColorLogicState
        {
            public GlStateTracker.BooleanState colorLogicOp;
            public int opcode;

            private ColorLogicState()
            {
                this.colorLogicOp = new GlStateTracker.BooleanState(3058);
                this.opcode = 5379;
            }
        }

    @SideOnly(Side.CLIENT)
    static class ColorMask
        {
            public boolean red;
            public boolean green;
            public boolean blue;
            public boolean alpha;

            private ColorMask()
            {
                this.red = true;
                this.green = true;
                this.blue = true;
                this.alpha = true;
            }
        }

    @SideOnly(Side.CLIENT)
    static class ColorMaterialState
        {
            public GlStateTracker.BooleanState colorMaterial;
            public int face;
            public int mode;

            private ColorMaterialState()
            {
                this.colorMaterial = new GlStateTracker.BooleanState(2903);
                this.face = 1032;
                this.mode = 5634;
            }
        }

    @SideOnly(Side.CLIENT)
    public static enum CullFace
    {
        FRONT(1028),
        BACK(1029),
        FRONT_AND_BACK(1032);

        public final int mode;

        private CullFace(int modeIn)
        {
            this.mode = modeIn;
        }
    }

    @SideOnly(Side.CLIENT)
    static class CullState
        {
            public GlStateTracker.BooleanState cullFace;
            public int mode;

            private CullState()
            {
                this.cullFace = new GlStateTracker.BooleanState(2884);
                this.mode = 1029;
            }
        }

    @SideOnly(Side.CLIENT)
    static class DepthState
        {
            public GlStateTracker.BooleanState depthTest;
            public boolean maskEnabled;
            public int depthFunc;

            private DepthState()
            {
                this.depthTest = new GlStateTracker.BooleanState(2929);
                this.maskEnabled = true;
                this.depthFunc = 513;
            }
        }

    @SideOnly(Side.CLIENT)
    public static enum DestFactor
    {
        CONSTANT_ALPHA(32771),
        CONSTANT_COLOR(32769),
        DST_ALPHA(772),
        DST_COLOR(774),
        ONE(1),
        ONE_MINUS_CONSTANT_ALPHA(32772),
        ONE_MINUS_CONSTANT_COLOR(32770),
        ONE_MINUS_DST_ALPHA(773),
        ONE_MINUS_DST_COLOR(775),
        ONE_MINUS_SRC_ALPHA(771),
        ONE_MINUS_SRC_COLOR(769),
        SRC_ALPHA(770),
        SRC_COLOR(768),
        ZERO(0);

        public final int factor;

        private DestFactor(int factorIn)
        {
            this.factor = factorIn;
        }
    }

    @SideOnly(Side.CLIENT)
    public static enum FogMode
    {
        LINEAR(9729),
        EXP(2048),
        EXP2(2049);

        /** The capability ID of this {@link FogMode} */
        public final int capabilityId;

        private FogMode(int capabilityIn)
        {
            this.capabilityId = capabilityIn;
        }
    }

    @SideOnly(Side.CLIENT)
    static class FogState
        {
            public GlStateTracker.BooleanState fog;
            public int mode;
            public float density;
            public float start;
            public float end;

            private FogState()
            {
                this.fog = new GlStateTracker.BooleanState(2912);
                this.mode = 2048;
                this.density = 1.0F;
                this.end = 1.0F;
            }
        }

    @SideOnly(Side.CLIENT)
    public static enum LogicOp
    {
        AND(5377),
        AND_INVERTED(5380),
        AND_REVERSE(5378),
        CLEAR(5376),
        COPY(5379),
        COPY_INVERTED(5388),
        EQUIV(5385),
        INVERT(5386),
        NAND(5390),
        NOOP(5381),
        NOR(5384),
        OR(5383),
        OR_INVERTED(5389),
        OR_REVERSE(5387),
        SET(5391),
        XOR(5382);

        public final int opcode;

        private LogicOp(int opcodeIn)
        {
            this.opcode = opcodeIn;
        }
    }

    @SideOnly(Side.CLIENT)
    static class PolygonOffsetState
        {
            public GlStateTracker.BooleanState polygonOffsetFill;
            public GlStateTracker.BooleanState polygonOffsetLine;
            public float factor;
            public float units;

            private PolygonOffsetState()
            {
                this.polygonOffsetFill = new GlStateTracker.BooleanState(32823);
                this.polygonOffsetLine = new GlStateTracker.BooleanState(10754);
            }
        }

    public static class SavedState {

        private ArrayList<State> savedStates = new ArrayList<>();

        boolean alphaTest;
        int alphaFunc;
        float alphaRef;

        boolean lighting;

        boolean blend;
        int blendSrcFactor;
        int blendDstFactor;
        int blendSrcFactorAlpha;
        int blendDstFactorAlpha;

        boolean depthTest;
        boolean depthMaskEnabled;
        int depthFunc;

        boolean cull;
        int cullMode;

        boolean rescaleNormal;

        private SavedState() {
        }

        private static SavedState createSavedState(SavedState state) {
            return createSavedState(state.savedStates.toArray(new State[state.savedStates.size()]));
        }

        private static SavedState createSavedState(State... states) {
            SavedState saveState = new SavedState();
            for (State state : states) {
                state.pushState(saveState);
                saveState.savedStates.add(state);
            }
            return saveState;
        }

        private static void applyState(SavedState pre, SavedState post) {
            for (State state : pre.savedStates) {
                state.popState(pre, post);
            }
        }

    }

    private static final LinkedList<SavedState> savedStates = new LinkedList<>();

    private static String parseBoolState(BooleanState boolState) {
        return String.valueOf(boolState.currentState).toUpperCase();
    }

    public static String dumpGLState(State... states) {
        StringBuilder builder = new StringBuilder();
        builder.append("GlStateManager { ");
        for (int i = 0; i < states.length; i++) {
            State state = states[i];
            builder.append(state.getState());
            if (i != states.length - 1) {
                builder.append(", ");
            }
        }

        builder.append(" }");
        return builder.toString();
    }

    public static void pushState() {
        SavedState state = SavedState.createSavedState(State.values());
        savedStates.addLast(state);
    }

    public static void pushStates(State... states) {
        if (states == null || states.length == 0) {
            states = State.values();
        }
        SavedState state = SavedState.createSavedState(states);
        savedStates.addLast(state);
    }

    public static void pushState(State[] states) {
        if (states == null || states.length == 0) {
            states = State.values();
        }
        SavedState state = SavedState.createSavedState(states);
        savedStates.addLast(state);
    }

    public static void popState() {
        if (savedStates.isEmpty()) {
            throw new IllegalStateException("Unable to pop the GL state as there is no saved state!");
        }
        SavedState pre = savedStates.removeLast();
        SavedState post = SavedState.createSavedState(pre);
        SavedState.applyState(pre, post);
    }

}
