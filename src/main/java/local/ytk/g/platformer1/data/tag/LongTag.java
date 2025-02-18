package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public class LongTag extends NumericTag<Long, LongTag> {
    public static final byte TYPE = 4;
    public static final LongTag ZERO = of(0);
    public static final LongTag ONE = of(1);
    public static final LongTag NEGATIVE_ONE = of(-1);
    private static final TreeMap<Long, LongTag> cache = new TreeMap<>();
    
    private final long value;
    LongTag(long value) {
        this.value = value;
    }
    public long getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
    
    @SuppressWarnings("all")
    public static LongTag of(long value) {
        if (cache.containsKey(value)) return cache.get(value);
        if (cache.size() > 4096) {
            if (value > 0) cache.remove(cache.lastKey());
            else cache.remove(cache.firstKey());
        }
        LongTag result = new LongTag(value);
        cache.put(value, result);
        return result;
    }
    public static LongTag of(@NotNull String value) {
        return of(Long.parseLong(value));
    }
    public static LongTag of(@NotNull Number n) {
        return of(n.longValue());
    }
    public static LongTag of(@NotNull Object o) {
        return of(Long.parseLong(o.toString()));
    }
    public static LongTag deserialize(@NotNull ByteBuf buffer) {
        return of(buffer.readLong());
    }

    public byte getId() {
        return TYPE;
    }
    
    @Override
    public Long objectValue() {
        return value;
    }
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeLong(value);
        return true;
    }
}
