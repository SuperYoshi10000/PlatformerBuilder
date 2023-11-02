package local.ytk.g.platformer1.data.tag;

public class TypedArrayTag<T extends Tag> extends AbstractArrayTag<T> {
    public byte getId() {
        return (byte) (getTypeId() + 20);
    }
    public byte getTypeId() {
        return size() > 0 ? get(1).getId() : 0;
    }
    public String toTagString() {
        if (size() < 1) return "[null:]";
        return "[" + TAG_CLASS_LETTERS[getTypeId()] + ":" + toString().substring(1);
    }
}
