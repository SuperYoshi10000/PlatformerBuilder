package local.ytk.g.platformer1.client.window.input;

import java.util.ArrayList;

public class MouseInput extends InputType {
    public final int buttonID;
    public MouseInput(int buttonID) {
        this.buttonID = buttonID;
    }

    public static final MouseInput
        MOUSE_BUTTON_LEFT = new MouseInput(0),
        MOUSE_BUTTON_RIGHT = new MouseInput(1),
        MOUSE_BUTTON_MIDDLE = new MouseInput(2),
        MOUSE_BUTTON_ID_3 = new MouseInput(3),
        MOUSE_BUTTON_ID_4 = new MouseInput(4),
        MOUSE_BUTTON_ID_5 = new MouseInput(5),
        MOUSE_BUTTON_ID_6 = new MouseInput(6),
        MOUSE_BUTTON_ID_7 = new MouseInput(7),
        MOUSE_WHEEL_SCROLL = new MouseInput(101),
        MOUSE_WHEEL_TILT = new MouseInput(102);

    public static final ArrayList<MouseInput> mouseInputs = mouseInputs();

    private static ArrayList<MouseInput> mouseInputs() {
        ArrayList<MouseInput> list = new ArrayList<>();
        list.add(MOUSE_BUTTON_LEFT);
        list.add(MOUSE_BUTTON_RIGHT);
        list.add(MOUSE_BUTTON_MIDDLE);
        list.add(MOUSE_BUTTON_ID_3);
        list.add(MOUSE_BUTTON_ID_4);
        list.add(MOUSE_BUTTON_ID_5);
        list.add(MOUSE_BUTTON_ID_6);
        list.add(MOUSE_BUTTON_ID_7);
        return list;
    }
}
