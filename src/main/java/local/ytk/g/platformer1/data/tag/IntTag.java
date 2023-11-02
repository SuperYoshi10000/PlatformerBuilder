package local.ytk.g.platformer1.data.tag;

import java.util.TreeMap;

public class IntTag extends NumericTag {
    private int value;
    public IntTag(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

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

    private static final TreeMap<Integer, IntTag> cache = new TreeMap<>();

    public byte getId() {
        return 3;
    }
}
