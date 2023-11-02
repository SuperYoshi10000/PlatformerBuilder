package local.ytk.g.platformer1.data.tag;

public abstract class NumericTag extends Number implements Tag, Comparable<NumericTag> {
    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    public int compareTo(NumericTag tag) {
        double difference = compare(this, tag);
        if (difference > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (difference < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (difference > 0 && difference < 1) return 1;
        if (difference < 0 && difference > -1) return -1;
        return (int) difference;
    }

    public static double compare(NumericTag a, NumericTag b) {
        return a.doubleValue() - b.doubleValue();
    }

    public boolean equals(Object value) {
        return value instanceof NumericTag tag && getClass() == tag.getClass() && doubleValue() == tag.doubleValue();
    }
    public String toString() {
        return Double.toString(doubleValue());
    }
    public String toTagString() {
        return TAG_CLASS_LETTERS[getId()];
    }
    
    @Override
    public byte getId() {
        return 99;
    }

}
