package local.ytk.g.platformer1.client.window.input;

import java.util.ArrayList;
import java.util.function.IntConsumer;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import local.ytk.g.platformer1.client.window.GameWindow;

import static org.lwjgl.glfw.GLFW.*;
import static local.ytk.g.platformer1.client.window.GameWindow.WINDOW;

public abstract class UserInputHandler {
    public static final Int2ObjectOpenHashMap<KeyInput> keyInputs = KeyInput.keyInputs;
    public static final ArrayList<MouseInput> mouseInputs = MouseInput.mouseInputs;
    public static final Int2ObjectOpenHashMap<GamepadInput> gamepadInputs = new Int2ObjectOpenHashMap<>();
    protected boolean active;
    protected boolean wasPressed;
    private boolean wasReleased;
    public UserInputHandler() {}

    public boolean active() {
        return active;
    }
    public boolean wasPressed() {
        return wasPressed;
    }
    public boolean wasReleased() {
        return wasReleased;
    }

    public abstract void press();
    public abstract void repeat();
    public abstract void release();
    public abstract void hold();

    public static void createCallbacks() {
        // glfwSetKeyCallback(WINDOW.id, (w, k, c, a, m) -> inputCallback(keyInputs.get(k), a));
        glfwSetScrollCallback(WINDOW.id, (w, x, y) -> inputCallback(MouseInput.MOUSE_WHEEL_SCROLL, 1));
        glfwSetMouseButtonCallback(WINDOW.id, (w, b, a, m) -> inputCallback(mouseInputs.get(b), a));
    }
    public static void inputCallback(InputType input, int action) {
        input.state = action;
        switch (action) {
            case GLFW_PRESS:
                input.execute(b -> {
                    b.press();
                    b.active = true;
                });
                break;
            case GLFW_REPEAT:
                input.execute(b -> b.repeat());
                break;
            case GLFW_RELEASE: 
                input.execute(b -> {
                    b.release();
                    b.active = false;
                });
                break;
            default:
        }
    }

    public static void handleInput() {
        KeyInput.updateState();
        keyInputs.forEach((k, i) -> {
            i.execute(b -> {
                b.wasPressed = false;
                b.active = false;
                b.wasReleased = false;
            });
            if (i.wasPressed()) i.execute(b -> {
                b.press();
                b.wasPressed = true;
            });
            if (i.active()) i.execute(b -> {
                b.hold();
                b.active = true;
            });
            if (i.active() && !i.wasPressed()) i.execute(b -> b.repeat());
            if (i.wasReleased()) i.execute(b -> {
                b.release();
                b.wasReleased = true;
            });
        });
        GamepadInput.updateState();
        gamepadInputs.forEach((btn, i) -> {
            i.execute(b -> {
                b.wasPressed = false;
                b.active = false;
                b.wasReleased = false;
            });
            if (i.wasPressed()) i.execute(b -> {
                b.press();
                b.wasPressed = true;
            });
            if (i.active()) i.execute(b -> {
                b.hold();
                b.active = true;
            });
            if (i.active() && !i.wasPressed()) i.execute(b -> b.repeat());
            if (i.wasReleased()) i.execute(b -> {
                b.release();
                b.wasReleased = true;
            });
        });
    }

    public static UserInputHandler create(IntConsumer executor, boolean repeat){
        return new UserInputHandler() {
            private void run() {
                executor.accept(0);
            }
            @Override
            public void hold() {
                run();
            }
            @Override
            public void press() {
                run();
            }
            @Override
            public void repeat() {
                run();
            }
            @Override
            public void release() {
                run();
            }
        };
    }

    public static int[] k(int... keys) {
        return keys;
    }
    
    public static UserInputHandler
        PAUSE = create(null, false),
        JUMP = create(null, false),
        UP = create(null, false),
        DOWN = create(null, false),
        LEFT = create(null, false),
        RIGHT = create(null, false),
        CROUCH = create(null, false),
        RUN = create(null, false),
        ACTION_1 = create(null, false),
        ACTION_2 = create(null, false),
        ACTION_3 = create(null, false),
        ACTION_4 = create(null, false),
        FULLSCREEN = create(GameWindow.WINDOW::toggleFullscreen, false);

}
