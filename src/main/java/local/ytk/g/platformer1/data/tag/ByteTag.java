package local.ytk.g.platformer1.data.tag;

public class ByteTag extends NumericTag {
    private byte value;
    public ByteTag(byte value) {
        this.value = value;
    }
    public byte getValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    public static ByteTag of(byte value) {
        return cache[value % 256];
    }

    private static final ByteTag[] cache = new ByteTag[256];

    public static void init() {
        if (cache[0] != null) return;
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new ByteTag((byte) i);
        }
    }

    public byte getId() {
        return 1;
    }
}
