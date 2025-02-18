package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public interface SequenceTag<V, T extends Tag, S extends SequenceTag<V, T, S>> extends List<V>, ObjectTag<T, S> {
    byte ARRAY_TYPE_OFFSET = 16;
    Object[] EMPTY_ARRAY = new Object[0];
    
    @SuppressWarnings("unchecked")
    static <V, T extends Tag<V, T>, S extends Empty<T, S>> Empty<T, S> empty() {
        return (Empty<T, S>) Empty.INSTANCE;
    }
    
    byte getId();
    byte getItemId();
    String toTagString();
    List<T> toTagList();
    
    void addTag(T tag);
    
    @Override
    default boolean serialize(ByteBuf buffer) {
        buffer.writeByte(getId());
        buffer.writeInt(size());
        for (V item : this) if (!(item instanceof Tag tag && tag.serialize(buffer))) return false;
        return true;
    }
    
    abstract class Empty<T extends Tag<?, ? extends T>, S extends Empty<T, S>> extends AbstractList<Object> implements SequenceTag<Object, T, S>, RandomAccess {
        public static final Empty<?, ?> INSTANCE = new Empty() {};
        
        public byte getId() {
            return ARRAY_TYPE_OFFSET;
        }
        
        @Override
        public Object[] objectValue() {
            return EMPTY_ARRAY;
        }
        
        @Override
        public boolean serialize(ByteBuf buffer) {
            buffer.writeByte(getId());
            buffer.writeInt(0);
            return true;
        }
        
        public byte getItemId() {
            return 0;
        }
        
        @Override
        public String toTagString() {
            return "[]";
        }
        
        @Override
        public List<T> toTagList() {
            return List.of();
        }
        
        @Override
        public Tag<?, T> get(int index) {
            return null;
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public void addTag(T tag) {
            throw new UnsupportedOperationException("Cannot modify empty sequence");
        }
    }
}
