package local.ytk.g.platformer1.client.window.input;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class InputType {
    protected int state = 0;
    protected int sensitivity = 1;
    public final ArrayList<UserInputHandler> bindings = new ArrayList<>();
    public InputType sensitivity(int value) {
        sensitivity = value;
        return this;
    }
    public int state() {
        return state;
    }
    public boolean active() {
        return state > sensitivity;
    }
    public void execute(Consumer<UserInputHandler> action) {
        this.bindings.forEach(action);
    }
}
