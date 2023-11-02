package local.ytk.g.platformer1.data.tag;

import java.util.TreeMap;

public class DoubleTag extends NumericTag {
    private double value;
    public DoubleTag(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
    
    @Override
    public double doubleValue() {
        return value;
    }
    
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

    private static final TreeMap<Double, DoubleTag> cache = new TreeMap<>();

    @Override
    public byte getId() {
        return 6;
    }
}
