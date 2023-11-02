package local.ytk.g.platformer1.data.tag;

import java.util.TreeMap;

public class CompoundTag extends TreeMap<String, Tag> implements Tag {
    
    @Override
    public byte getId() {
        return 10;
    }

    @Override
    public String toTagString() {
        return "{" + combineEntries() + "}";
    }
    private String combineEntries() {
        String entries = entrySet()
            .stream()
            .map(e -> ", \"" + e.getKey() + "\": " + e.getValue().toTagString())
            .reduce("", (a, b) -> a + b);
        return entries.substring(2);
    }
}
