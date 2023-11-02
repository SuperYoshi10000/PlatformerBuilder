package local.ytk.g.platformer1.data.tag;

public class StringTag implements Tag {
    private String value;

    public StringTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StringTag of(String string) {
        return new StringTag(string);
    }

    public boolean equals(Object value) {
        return value instanceof StringTag tag && value == tag.value;
    }

    public String toString() {
        return value;
    }
    public String toTagString() {
        return "\"" + value.translateEscapes() + "\"";
    }
    
    @Override
    public byte getId() {
        return -1;
    }
}
