package local.ytk.g.platformer1.data.tag;

import java.util.TreeMap;

public class ShortTag extends NumericTag {
    private short value;
    public ShortTag(short value) {
        this.value = value;
    }
    public short getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

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

    private static final TreeMap<Short, ShortTag> cache = new TreeMap<>();

    public byte getId() {
        return 2;
    }
}
