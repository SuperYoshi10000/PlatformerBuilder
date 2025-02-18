package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public class DoubleTag extends NumericTag<Double, DoubleTag> {
    public static final byte TYPE = 6;
    public static final DoubleTag ZERO = of(0);
    public static final DoubleTag ONE = of(1);
    public static final DoubleTag NEGATIVE_ONE = of(-1);
    
    private final double value;
    DoubleTag(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
    
    @Override
    public double doubleValue() {
        return value;
    }
    
    @SuppressWarnings("all")
    public static DoubleTag of(double value) {
        if (cache.containsKey(value)) return cache.get(value);
        if (cache.size() > 4096) {
            if (value > 0) cache.remove(cache.lastKey());
            else cache.remove(cache.firstKey());
        }
        DoubleTag result = new DoubleTag(value);
        cache.put(value, result);
        return result;
    }
    public static DoubleTag of(@NotNull String value) {
        return of(Double.parseDouble(value));
    }
    public static DoubleTag of(@NotNull Number n) {
        return of(n.doubleValue());
    }
    public static DoubleTag of(@NotNull Object o) {
        return of(Double.parseDouble(o.toString()));
    }
    public static DoubleTag deserialize(@NotNull ByteBuf buffer) {
        return of(buffer.readDouble());
    }

    private static final TreeMap<Double, DoubleTag> cache = new TreeMap<>();

    @Override
    public byte getId() {
        return TYPE;
    }
    
    @Override
    public Double objectValue() {
        return value;
    }
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeDouble(value);
        return true;
    }
}
