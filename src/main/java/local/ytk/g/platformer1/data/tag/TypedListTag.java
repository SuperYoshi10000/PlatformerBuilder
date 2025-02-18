package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.util.Collection;
import java.util.List;

public class TypedListTag<T extends Tag<T, T>, S extends TypedListTag<T, S>> extends AbstractListTag<T, S> {
    public TypedListTag() {}
    @SafeVarargs
    public TypedListTag(T... tags) {
        this(List.of(tags));
    }
    public TypedListTag(Collection<T> tags) {
        super(tags);
    }
    
    public byte getId() {
        return (byte)(getItemId() + ARRAY_TYPE_OFFSET);
    }
    
    @Override
    public TypedListTag<T, S> objectValue() {
        return this;
    }
    
    public byte getItemId() {
        return size() > 0 ? getFirst().getId() : 0;
    }
    public String toTagString() {
        if (size() < 1) return "[:]";
        return "[" + TAG_CODES[getItemId()] + ":" + toString().substring(1);
    }
    
    @Override
    public TypedListTag<T, S> toTagList() {
        return this;
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeByte(getItemId());
        buffer.writeInt(size());
        for (T tag : this) if (!tag.serialize(buffer)) return false;
        buffer.writeByte(END);
        return true;
    }
    
}
