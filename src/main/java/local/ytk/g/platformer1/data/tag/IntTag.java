package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public class IntTag extends NumericTag<Integer, IntTag> {
    public static final byte TYPE = 3;
    public static final IntTag ZERO = of(0);
    public static final IntTag ONE = of(1);
    public static final IntTag NEGATIVE_ONE = of(-1);
    
    private final int value;
    IntTag(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
    
    @SuppressWarnings("all")
    public static IntTag of(int value) {
        if (cache.containsKey(value)) return cache.get(value);
        if (cache.size() > 4096) {
            if (value > 0) cache.remove(cache.lastKey());
            else cache.remove(cache.firstKey());
        }
        IntTag result = new IntTag(value);
        cache.put(value, result);
        return result;
    }
    public static IntTag of(@NotNull String s) {
        return of(Integer.parseInt(s));
    }
    public static IntTag of(@NotNull Number n) {
        return of(n.intValue());
    }
    public static IntTag of(@NotNull Object o) {
        return of(Integer.parseInt(o.toString()));
    }
    public static IntTag ofCodePoint(@NotNull String s) {
        return of(s.codePointAt(0));
    }
    public static IntTag deserialize(@NotNull ByteBuf buffer) {
        return of(buffer.readInt());
    }

    private static final TreeMap<Integer, IntTag> cache = new TreeMap<>();

    public byte getId() {
        return TYPE;
    }
    
    @Override
    public Integer objectValue() {
        return value;
    }
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(value);
        return true;
    }
}
