package local.ytk.g.platformer1.data.tag;

import java.util.TreeMap;

public class FloatTag extends NumericTag {
    private float value;
    public FloatTag(float value) {
        this.value = value;
    }
    public float getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

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

    private static final TreeMap<Float, FloatTag> cache = new TreeMap<>();

    public byte getId() {
        return 5;
    }
}
