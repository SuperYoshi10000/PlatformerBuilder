package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.util.List;

public class LongArrayTag extends NumericArrayTag<Long, LongTag> {
    public static LongArrayTag of(long... array) {
        LongArrayTag tag = new LongArrayTag();
        for (long item : array) tag.add(item);
        return tag;
    }
    
    public long[] toPrimitiveArray() {
        long[] array = new long[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
    
    @Override
    public byte getItemId() {
        return LongTag.TYPE;
    }
    
    @Override
    public long[] objectValue() {
        return toPrimitiveArray();
    }
    @Override
    public List<LongTag> toTagList() {
        return stream().map(LongTag::of).toList();
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        for (long item : this) buffer.writeLong(item);
        return true;
    }
    
    public static LongArrayTag deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        LongArrayTag tag = new LongArrayTag();
        for (int i = 0; i < size; i++) tag.add(buffer.readLong());
        return tag;
    }
    
    @Override
    public void addTag(LongTag tag) {
        add(tag.getValue());
    }
}
