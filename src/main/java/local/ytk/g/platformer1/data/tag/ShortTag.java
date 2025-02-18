package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public class ShortTag extends NumericTag<Short, ShortTag> {
    public static final byte TYPE = 2;
    public static final ShortTag ZERO = of((short) 0);
    public static final ShortTag ONE = of((short) 1);
    public static final ShortTag NEGATIVE_ONE = of((short) -1);
    
    private final short value;
    ShortTag(short value) {
        this.value = value;
    }
    public short getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @SuppressWarnings("all")
    public static ShortTag of(short value) {
        if (cache.containsKey(value)) return cache.get(value);
        if (cache.size() > 4096) {
            if (value > 0) cache.remove(cache.lastKey());
            else cache.remove(cache.firstKey());
        }
        ShortTag result = new ShortTag(value);
        cache.put(value, result);
        return result;
    }
    public static ShortTag of(char c) {
        return of((short) c);
    }
    public static ShortTag of(@NotNull String s) {
        return of(Short.parseShort(s));
    }
    public static ShortTag of(@NotNull Number n) {
        return of(n.shortValue());
    }
    public static ShortTag of(@NotNull Object o) {
        return of(Short.parseShort(o.toString()));
    }
    public static ShortTag ofShort(@NotNull String s) {
        return of(Short.parseShort(s));
    }
    public static ShortTag ofChar(@NotNull String s) {
        return of(s.charAt(0));
    }
    public static ShortTag deserialize(@NotNull ByteBuf buffer) {
        return of(buffer.readShort());
    }

    private static final TreeMap<Short, ShortTag> cache = new TreeMap<>();

    public byte getId() {
        return TYPE;
    }
    @Override
    public Short objectValue() {
        return value;
    }
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeShort(value);
        return true;
    }
}
