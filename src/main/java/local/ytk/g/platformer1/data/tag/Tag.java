package local.ytk.g.platformer1.data.tag;

public interface Tag extends TagRepresentable {
    public static final String[] TAG_CLASS_LETTERS = {
        "", "b", "s", "i", "l", "f", "d", "N", "S", "A",
        "C", "TA", "L", "TL"};
    public default Tag saveToTag() {
        return this;
    }
    public String toTagString();
    public byte getId();
}
