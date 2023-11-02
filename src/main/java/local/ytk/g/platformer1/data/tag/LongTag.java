package local.ytk.g.platformer1.data.tag;

import java.util.TreeMap;

public class LongTag extends NumericTag {
    private long value;
    public LongTag(long value) {
        this.value = value;
    }
    public long getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
    
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

    private static final TreeMap<Long, LongTag> cache = new TreeMap<>();

    public byte getId() {
        return 4;
    }
}
