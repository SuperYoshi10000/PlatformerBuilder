package local.ytk.g.platformer1.client.window.input;

import static java.util.Map.*;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import local.ytk.g.platformer1.client.window.GameWindow;

public class KeyInput extends InputType {
    public final int keyID;
    public KeyInput(int keyID) {
        this.keyID = keyID;
    }

    protected int lastState;
    public boolean wasPressed() {
        return lastState < state;
    }

    public boolean wasReleased() {
        return lastState > state;
    }

    @Deprecated
    public static final Object2IntOpenHashMap<String> keyNames = keyNames();
    public static final Int2ObjectOpenHashMap<KeyInput> keyInputs = keyInputs();

    @Deprecated
    private static Object2IntOpenHashMap<String> keyNames() {
        Object2IntOpenHashMap<String> map = new Object2IntOpenHashMap<>();
        map.putAll(ofEntries(
            entry("Space", 32)
        ));
        return map;
    }
    private static Int2ObjectOpenHashMap<KeyInput> keyInputs() {
        return List.of(GLFW.class.getFields()).stream()
            .filter(f -> f.getName().matches("GLFW_KEY_\\w*")).map(f -> {
                try {
                    return f.getInt(null);
                } catch (Exception e) {
                    return 0;
                }
            }).collect(
                Int2ObjectOpenHashMap::new,
                (m, n) -> m.put(n.intValue(), new KeyInput(n)),
                Int2ObjectOpenHashMap::putAll
            );
    }
    public static void updateState() {
        keyInputs.forEach((n, i) -> {
            i.lastState = i.state;
            i.state = GLFW.glfwGetKey(GameWindow.WINDOW.id, i.keyID);
        });
    }
    // Collectors.toMap((Integer v) -> v.intValue(), (Integer v) -> new KeyInput(v), (a, b) -> a, Int2ObjectOpenHashMap::new);
}
