package local.ytk.g.platformer1.data.tag;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class ListTag extends AbstractListTag<Tag<?, ?>, ListTag> {
    public static final byte TYPE = 9;
    public static final ListTag EMPTY = new ListTag() {
        @Override
        public boolean add(Tag tag) {
            throw new UnsupportedOperationException("Cannot modify empty list");
        }
        @Override
        public void add(int index, Tag element) {
            throw new UnsupportedOperationException("Cannot modify empty list");
        }
        @Override
        public Tag<?, ?> set(int index, Tag element) {
            throw new UnsupportedOperationException("Cannot modify empty list");
        }
        @Override
        public Tag<?, ?> remove(int index) {
            throw new UnsupportedOperationException("Cannot modify empty list");
        }
        @Override
        public void clear() {
            throw new UnsupportedOperationException("Cannot modify empty list");
        }
    };
    
    public ListTag() {}
    public ListTag(Tag<?, ?>... tags) {
        this(List.of(tags));
    }
    public ListTag(List<Tag<?, ?>> tags) {
        super(tags);
    }
    
    @Override
    public byte getId() {
        return TYPE;
    }
    
    @Override
    public byte getItemId() {
        return -1;
    }
    
    @Override
    public String toTagString() {
        return "[" + stream()
                .map(Tag::toTagString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("") + "]";
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        for (Tag<?, ?> tag : this) {
            buffer.writeByte(tag.getId());
            if (!tag.serialize(buffer)) return false;
        }
        buffer.writeByte(END);
        return true;
    }
    
    static ListTag fromString(String str) {
        try {
            return Tag.readList(new StringReader(str));
        } catch (CommandSyntaxException e) {
            return null;
        }
    }
    
    public static ListTag deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        ListTag list = new ListTag();
        for (int i = 0; i < size; i++) {
            byte id = buffer.readByte();
            Tag<?, ?> tag = Tag.deserialize(id, buffer);
            if (tag == null) return null;
            list.add(tag);
        }
        return list;
    }
}
