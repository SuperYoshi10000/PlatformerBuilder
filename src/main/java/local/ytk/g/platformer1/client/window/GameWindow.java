package local.ytk.g.platformer1.client.window;

import local.ytk.g.platformer1.client.render.Screen;
import local.ytk.g.platformer1.client.render.model.StaticModel;
import local.ytk.g.platformer1.level.entity.player.LocalPlayer;
import local.ytk.g.platformer1.level.phys.Position3d;
import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GameWindow {
    public static final int DEFAULT_WIDTH_144P = 256;
    public static final int DEFAULT_HEIGHT_144P = 144;
    public static final int DEFAULT_WIDTH_360P = 640;
    public static final int DEFAULT_HEIGHT_360P = 360;
    public static final int DEFAULT_WIDTH_720P = 1280;
    public static final int DEFAULT_HEIGHT_720P = 720;
    public static final int DEFAULT_WIDTH_1080P = 1920;
    public static final int DEFAULT_HEIGHT_1080P = 1080;
    public static final int DEFAULT_WIDTH_2K = 1920;
    public static final int DEFAULT_HEIGHT_2K = 1080;
    public static final int DEFAULT_WIDTH_4K = 1920;
    public static final int DEFAULT_HEIGHT_4K = 1080;
    public static final int DEFAULT_WIDTH_8K = 1920;
    public static final int DEFAULT_HEIGHT_8K = 1080;
    
    public static final String DEFAULT_NAME = "";
    public static final long SHARE = NULL;
    public long monitor;
    public long id;

    public GLFWVidMode videoMode;
    public int width;
    public int height;
    public int refresh;

    public static GameWindow WINDOW;
    protected LocalPlayer player;

    public boolean fullscreen;

    public static void open() {
        WINDOW = new GameWindow();
    }

    protected GameWindow() {
        super();
        openWindow();
    }
    public void openWindow() {
        // monitor = glfwGetPrimaryMonitor();
        // videoMode = glfwGetVideoMode(monitor);
        // width = videoMode.width();
        // height = videoMode.height();
        // refresh = videoMode.refreshRate();
        
        // id = glfwCreateWindow(width, height, DEFAULT_NAME, monitor, SHARE);
        // if (id == NULL) terminate(Platformer1.GLFW_WINDOW_CREATION_FAILED);
        // glfwMakeContextCurrent(id);
        // IntReference w = new IntReference();
        // IntReference h = new IntReference();
        // glfwGetFramebufferSize(id, w.intBuffer(), h.intBuffer());
        // glViewport();

        GameRenderer.init();
    }

    public void toggleFullscreen(int v) {
        if (!fullscreen) {
            glfwSetWindowMonitor(id, monitor, 0, 0, width, height, GLFW_DONT_CARE);
            fullscreen = true;
        } else {
            glfwSetWindowMonitor(id, NULL, 0, 0, width, height, GLFW_DONT_CARE);
            fullscreen = false;
        }
    }

    public void render(StaticModel model, Screen screen, Position3d position) {
        model.hashCode();
        
        
    }

    public LocalPlayer player() {
        return player;
    }
}
