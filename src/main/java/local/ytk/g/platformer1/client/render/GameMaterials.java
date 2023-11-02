package local.ytk.g.platformer1.client.render;

import com.google.common.collect.ImmutableBiMap;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.texture.Texture;

import java.util.HashMap;

import static java.util.Map.entry;
import static local.ytk.g.platformer1.Platformer1.*;

public class GameMaterials {
    private GameMaterials() {}

    public static final HashMap<String, Material> MATERIALS = new HashMap<>();

    public static Material Transparent, Black, DarkGray, Gray, LightGray, White,
        Red, Orange, Yellow, Green, Cyan, Blue, Magenta, Brown, Pink;
    
    public static void initMaterials() {
        logC("Creating materials", 1);
        Transparent = materialColor("Transparent");
        Black = materialColor("Black");
        DarkGray = materialColor("DarkGray");
        Gray = materialColor("Gray");
        LightGray = materialColor("LightGray");
        White = materialColor("White");
        Red = materialColor("Red");
        Orange = materialColor("Orange");
        Yellow = materialColor("Yellow");
        Green = materialColor("Green");
        Cyan = materialColor("Cyan");
        Blue = materialColor("Blue");
        Magenta = materialColor("Magenta");
        Brown = materialColor("Brown");
        Pink = materialColor("Pink");
        logC("Created materials", 1);
    }

    public static ImmutableBiMap<String, ColorRGBA> colors = ImmutableBiMap.ofEntries(
        entry("Transparent", ColorRGBA.BlackNoAlpha),
        entry("Black", ColorRGBA.Black),
        entry("DarkGray", ColorRGBA.DarkGray),
        entry("Gray", ColorRGBA.Gray),
        entry("LightGray", ColorRGBA.LightGray),
        entry("White", ColorRGBA.White),
        entry("Red", ColorRGBA.Red),
        entry("Orange", ColorRGBA.Orange),
        entry("Yellow", ColorRGBA.Yellow),
        entry("Green", ColorRGBA.Green),
        entry("Cyan", ColorRGBA.Cyan),
        entry("Blue", ColorRGBA.Blue),
        entry("Magenta", ColorRGBA.Magenta),
        entry("Brown", ColorRGBA.Brown),
        entry("Pink", ColorRGBA.Pink)
    );

    protected static Builder material() {
        return material("Common/MatDefs/Misc/Unshaded.j3md");
    }
    protected static Builder material(String name) {
        logM("Creating material from \"" + name + "\"", 2);
        return new Builder(name);
    }
    protected static Material materialColor(ColorRGBA color) {
        return material().withColor(color);
    }
    protected static Material materialColor(String name) {
        return material().withColor(colors.get(name));
    }

    protected static class Builder extends Material {
        public Builder(String name) {
            super(assetManager(), name);
            logC("Created material", 2);
        }
        protected Builder withBoolean(String name, boolean value) {
            setBoolean(name, value);
            return this;
        }
        protected Builder withInt(String name, int value) {
            setInt(name, value);
            return this;
        }
        protected Builder withFloat(String name, float value) {
            setFloat(name, value);
            return this;
        }

        protected Builder withColor(ColorRGBA color) {
            logM("Set color to " + colors.inverse().getOrDefault(color, color.toString()), 3);
            return withColor("Color", color);
        }
        protected Builder withColor(String name, ColorRGBA color) {
            setColor(name, color);
            return this;
        }

        protected Builder withTexture(String name, Texture texture) {
            setTexture(name, texture);
            return this;
        }
    }
}
