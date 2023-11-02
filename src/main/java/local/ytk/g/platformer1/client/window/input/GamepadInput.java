package local.ytk.g.platformer1.client.window.input;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFWGamepadState;

public class GamepadInput extends InputType {
    protected int lastState;
    public final int buttonID;
    public final boolean isInverted;
    public GamepadInput(int buttonID) {
        this.buttonID = buttonID;
        this.isInverted = false;
    }
    public GamepadInput(int buttonID, boolean isInverted) {
        this.buttonID = buttonID;
        this.isInverted = isInverted;
        if (isInverted) sensitivity(500000);
    }
    
    @Override
    public GamepadInput sensitivity(int value) {
        sensitivity = value;
        return this;
    }

    public static final GamepadInput
        GAMEPAD_BUTTON_A = new GamepadInput(0),
        GAMEPAD_BUTTON_B = new GamepadInput(1),
        GAMEPAD_BUTTON_X = new GamepadInput(2),
        GAMEPAD_BUTTON_Y = new GamepadInput(3),
        GAMEPAD_BUTTON_LEFT_BUMPER = new GamepadInput(4),
        GAMEPAD_BUTTON_RIGHT_BUMPER = new GamepadInput(5),
        GAMEPAD_BUTTON_BACK = new GamepadInput(6),
        GAMEPAD_BUTTON_START = new GamepadInput(7),
        GAMEPAD_BUTTON_LEFT_THUMB = new GamepadInput(9),
        GAMEPAD_BUTTON_RIGHT_THUMB = new GamepadInput(10),
        GAMEPAD_BUTTON_DPAD_UP = new GamepadInput(11),
        GAMEPAD_BUTTON_DPAD_RIGHT = new GamepadInput(12),
        GAMEPAD_BUTTON_DPAD_DOWN = new GamepadInput(13),
        GAMEPAD_BUTTON_DPAD_LEFT = new GamepadInput(14),

        GAMEPAD_LEFT_STICK_UP = new GamepadInput(0, false),
        GAMEPAD_LEFT_STICK_RIGHT = new GamepadInput(1, false),
        GAMEPAD_LEFT_STICK_DOWN = new GamepadInput(0, true),
        GAMEPAD_LEFT_STICK_LEFT = new GamepadInput(1, true),
        GAMEPAD_RIGHT_STICK_UP = new GamepadInput(2, false),
        GAMEPAD_RIGHT_STICK_RIGHT = new GamepadInput(3, false),
        GAMEPAD_RIGHT_STICK_DOWN = new GamepadInput(2, true),
        GAMEPAD_RIGHT_STICK_LEFT = new GamepadInput(3, true),
        GAMEPAD_LEFT_TRIGGER = new GamepadInput(4, false),
        GAMEPAD_RIGHT_TRIGGER = new GamepadInput(5, false);



    public static final ArrayList<GamepadInput> gamepadInputs = gamepadInputs();
    public static final ArrayList<GamepadInput> gamepadStickInputs = gamepadStickInputs();

    private static ArrayList<GamepadInput> gamepadInputs() {
        ArrayList<GamepadInput> list = new ArrayList<>();
        list.add(GAMEPAD_BUTTON_A);
        list.add(GAMEPAD_BUTTON_B);
        list.add(GAMEPAD_BUTTON_X);
        list.add(GAMEPAD_BUTTON_Y);
        list.add(GAMEPAD_BUTTON_LEFT_BUMPER);
        list.add(GAMEPAD_BUTTON_RIGHT_BUMPER);
        list.add(GAMEPAD_BUTTON_BACK);
        list.add(GAMEPAD_BUTTON_START);
        list.add(GAMEPAD_BUTTON_LEFT_THUMB);
        list.add(GAMEPAD_BUTTON_RIGHT_THUMB);
        list.add(GAMEPAD_BUTTON_DPAD_UP);
        list.add(GAMEPAD_BUTTON_DPAD_RIGHT);
        list.add(GAMEPAD_BUTTON_DPAD_DOWN);
        list.add(GAMEPAD_BUTTON_DPAD_LEFT);
        return list;
    }
    private static ArrayList<GamepadInput> gamepadStickInputs() {
        ArrayList<GamepadInput> list = new ArrayList<>();
        list.add(GAMEPAD_LEFT_STICK_UP);
        list.add(GAMEPAD_LEFT_STICK_RIGHT);
        list.add(GAMEPAD_LEFT_STICK_DOWN);
        list.add(GAMEPAD_LEFT_STICK_LEFT);
        list.add(GAMEPAD_RIGHT_STICK_UP);
        list.add(GAMEPAD_RIGHT_STICK_RIGHT);
        list.add(GAMEPAD_RIGHT_STICK_DOWN);
        list.add(GAMEPAD_RIGHT_STICK_LEFT);
        return list;
    }

    public static void updateState() {
        GLFWGamepadState gamepadState = GLFWGamepadState.create();
        gamepadInputs.forEach(i -> {
            i.lastState = i.state;
            i.state = gamepadState.buttons(i.buttonID);
        });
        gamepadStickInputs.forEach(i -> {
            i.lastState = i.state;
            int value = (int) gamepadState.axes(i.buttonID);
            int invert = i.isInverted ? -1 : 1;
            i.state = (value * invert > 0) ? value * 1000000 : 0;
        });
    }

    public boolean wasPressed() {
        return lastState < state;
    }
    public boolean wasReleased() {
        return lastState > state;
    }
}
