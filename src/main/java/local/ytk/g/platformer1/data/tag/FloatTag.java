package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public class FloatTag extends NumericTag<Float, FloatTag> {
    public static final byte TYPE = 5;
    public static final FloatTag ZERO = of(0);
    public static final FloatTag ONE = of(1);
    public static final FloatTag NEGATIVE_ONE = of(-1);
    
    private final float value;
    FloatTag(float value) {
        this.value = value;
    }
    public float getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
    
    @SuppressWarnings("all")
    public static FloatTag of(float value) {
        if (cache.containsKey(value)) return cache.get(value);
        if (cache.size() > 4096) {
            if (value > 0) cache.remove(cache.lastKey());
            else cache.remove(cache.firstKey());
        }
        FloatTag result = new FloatTag(value);
        cache.put(value, result);
        return result;
    }
    public static FloatTag of(@NotNull String value) {
        return of(Float.parseFloat(value));
    }
    public static FloatTag of(@NotNull Number n) {
        return of(n.floatValue());
    }
    public static FloatTag of(@NotNull Object o) {
        return of(Float.parseFloat(o.toString()));
    }
    public static FloatTag deserialize(@NotNull ByteBuf buffer) {
        return of(buffer.readFloat());
    }

    private static final TreeMap<Float, FloatTag> cache = new TreeMap<>();

    public byte getId() {
        return TYPE;
    }
    
    @Override
    public Float objectValue() {
        return value;
    }
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeFloat(value);
        return true;
    }
}
