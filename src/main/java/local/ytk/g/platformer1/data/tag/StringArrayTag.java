package local.ytk.g.platformer1.data.tag;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StringArrayTag extends AbstractArrayTag<String, StringTag, StringArrayTag> {
    public String @NotNull [] toArray() {
        return this.toArray(String[]::new);
    }
    
    @Override
    public byte getId() {
        return StringTag.TYPE + ARRAY_TYPE_OFFSET;
    }
    
    @Override
    public String[] objectValue() {
        return toArray();
    }
    
    @Override
    public byte getItemId() {
        return StringTag.TYPE;
    }
    
    @Override
    public List<StringTag> toTagList() {
        return List.of();
    }
    
    @Override
    public void addTag(StringTag tag) {
    
    }
}
