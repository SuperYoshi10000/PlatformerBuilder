package local.ytk.g.platformer1.data.tag;

public class ListTag extends TypedListTag<Tag> {
    @Override
    public byte getId() {
        return -1;
    }

    @Override
    public String toTagString() {
        return "[" + combineEntries() + "]";
    }
    private String combineEntries() {
        String entries = stream()
            .map(t -> ", " + t.toTagString())
            .reduce("", (a, b) -> a + b);
        return entries.substring(2);
    }
}
