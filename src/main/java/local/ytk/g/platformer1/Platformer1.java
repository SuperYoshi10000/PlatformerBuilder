package local.ytk.g.platformer1;

import static org.lwjgl.glfw.GLFW.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.glfw.GLFW;

import jdk.jshell.JShell;

import com.jme3.anim.AnimComposer;
import com.jme3.anim.Armature;
import com.jme3.anim.Joint;
import com.jme3.app.FlyCamAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.app.state.AppState;
import com.jme3.asset.AssetManager;
import com.jme3.light.AmbientLight;
import com.jme3.light.Light;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.TangentBinormalGenerator;

import local.ytk.g.platformer1.client.render.GameMaterials;
import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.client.window.GameWindow;
import local.ytk.g.platformer1.level.entity.player.LocalPlayer;

@SuppressWarnings("unused")
public class Platformer1 extends SimpleApplication {
    protected static Platformer1 app;
    protected static final String APP_NAME = "Platformer1";

    protected Node levelDataNode;
    public Platformer1() {
        super();
        // super(getAppStates());
        logM("called app constructor", 2);
    }

    protected static AppState[] getAppStates() {
        StatsAppState stats = new StatsAppState();
        FlyCamAppState flyCam = new FlyCamAppState();
        
        return new AppState[]{};
    }

    public static void main(String[] args) {
        logM("start main", 0);
        init();
        execute(args);
        logM("end main", 0);
    }
    public static void init() {
        logC("initializing", 0);
        logC("creating app", 1);
        app = new Platformer1();
        logC("created app", 1);
        logC("initialized", 0);

        // System.out.println(GameMaterials.Blue.toString());
    }
    public static void terminate(int exitCode) {
        System.exit(exitCode);
    }
    public static void execute(String[] args) {
        logC("executing", 0);
        logV(app, 1);
        // app.toString();
        app.start();
        logC("executed", 0);
    }

    public static void initGlfwForApp() {
        boolean success = glfwInit();
        if (!success) {
            System.err.println("GLFW failed to initialize");
            terminate(GLFW_INIT_FAILED);
        }
    }

    public static void log(String message, int level, char c) {
        System.out.println("[" + APP_NAME + "]: " + "  ".repeat(level) + c + " " + message);
    }
    public static void logM(String message, int level) {
        System.out.println("[" + APP_NAME + "]: " + "  ".repeat(level) + "* " + message);
    }
    public static void logC(String message, int level) {
        System.out.println("[" + APP_NAME + "]: " + "  ".repeat(level) + "> " + message);
    }
    public static void logV(Object value, int level) {
        System.out.println("[" + APP_NAME + "]: " + "  ".repeat(level) + "# " + value.toString());
    }

    public static Platformer1 app() {
        return app;
    }
    public static AssetManager assetManager() {
        return app.assetManager;
    }
    public Node getLevelDataNode() {
        return levelDataNode;
    }

    /** 
     * <h3>Exit Codes</h3> 
     * <ul>
     * <li>{@code 0x000000 GAME_CLOSED}: The game was closed normally.
     * <li>{@code 0x011001 GLFW_INIT_FAILED}: GLFW failed to initialize - {@link GLFW#glfwInit} returned {@code false}.
     * <li>{@code 0x011002 GLFW_WINDOW_CREATION_FAILED}: GLFW could not open a window - {@link GLFW#glfwCreateWindow} returned {@code NULL} and no window could open.
     * </ul>
    */
    public static final int
        GAME_CLOSED = 0x000000,
        GLFW_INIT_FAILED = 0x011001,
        GLFW_WINDOW_CREATION_FAILED = 0x011002;


    @Override
    public void simpleInitApp() {
        logC("simpleInitApp started", 0);

        GameMaterials.initMaterials();

        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);
        geom.setMaterial(GameMaterials.Blue);
        // rootNode.attachChild(geom);

        Material boatMaterial = assetManager.loadMaterial("Models/Boat/boat.j3m");
        Spatial boatMesh = assetManager.loadModel("Models/Boat/boat.mesh.xml");
        TangentBinormalGenerator.generate(boatMesh);
        boatMesh.setMaterial(boatMaterial);
        Node boatNode = new Node("Boat");
        boatNode.attachChild(boatMesh);
        rootNode.attachChild(boatNode);

        rootNode.addLight(new AmbientLight());

        ModelData m = LocalPlayer.MODEL_LOADER.loadTo(assetManager, rootNode);
        logV(m.model.getControl(AnimComposer.class).getAnimClips().stream().findFirst(),3);

        

        logC("done", 0);
    }

    @Override
    public void simpleUpdate(float tpf) {
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        
    }

    @Override
    public String toString() {
        return getString(
            new String[]{"AssetManager", "AudioRenderer", "Camera", "Context", "FlyCamera", "FpsText", "GuiFont", "GuiNode", "GuiViewPort", "InputEnabled", "InputManager", "JoyInput", "KeyInput", "Listener", "LostFocusBehavior", "MouseInput", "Paused", "Prof", "RenderManager", "Renderer", "Speed", "Settings", "ShowSettings", "StateManager", "Timer", "TouchInput", "ViewPort"},
            new Object[]{assetManager, audioRenderer, cam, context, flyCam, fpsText, guiFont, guiNode, guiViewPort, inputEnabled, inputManager, joyInput, keyInput, listener, lostFocusBehavior, mouseInput, paused, prof, renderManager, renderer, speed, settings, showSettings, stateManager, timer, touchInput, viewPort}
        );
    }

    public String getString(String[] keys, Object[] values){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            String v = keys[i] + ": " + getStringFor(values[i]);
            logM(v, 2);
            builder.append(v + (i < values.length - 1 ? ", " : ""));
        }
        return "{ " + builder.toString() + " }";
    }
    protected String getStringFor(Object value) {
        if (value instanceof Boolean b) return b.toString();
        if (value instanceof Byte b) return b + "b";
        if (value instanceof Short s) return s + "s";
        if (value instanceof Integer i) return i + "i";
        if (value instanceof Long l) return l + "l";
        if (value instanceof Float f) return f + "f";
        if (value instanceof Double d) return d + "d";
        if (value instanceof Character c) return c.toString();
        if (value instanceof String s) return s;
        if (value == null) return "null";
        if (value.toString().equals(value.getClass().getName() + "@" + Integer.toHexString(value.hashCode()))) return "(" + value.getClass().getSimpleName() + ") " + value;
        return value.toString();
    }

    @Override
    public void stop(boolean waitFor) {
        super.stop(waitFor);
        logM("stopped", 0);
    }
}
