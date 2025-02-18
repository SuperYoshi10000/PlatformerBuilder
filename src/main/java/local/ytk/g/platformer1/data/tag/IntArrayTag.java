package local.ytk.g.platformer1.data.tag;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IntArrayTag extends NumericArrayTag<Integer, IntTag> {
    public static IntArrayTag of(int... array) {
        IntArrayTag tag = new IntArrayTag();
        for (int i : array) tag.add(i);
        return tag;
    }
    public static IntArrayTag of(@NotNull String s) {
        return of(s.codePoints().toArray());
    }
    
    public int[] toPrimitiveArray() {
        int[] array = new int[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
    
    @Override
    public byte getItemId() {
        return IntTag.TYPE;
    }
    
    @Override
    public int[] objectValue() {
        return toPrimitiveArray();
    }
    @Override
    public List<IntTag> toTagList() {
        return stream().map(IntTag::of).toList();
    }
    
    @Override
    public boolean serialize(io.netty.buffer.ByteBuf buffer) {
        buffer.writeInt(size());
        forEach(buffer::writeInt);
        return true;
    }
    
    public static IntArrayTag deserialize(io.netty.buffer.ByteBuf buffer) {
        int size = buffer.readInt();
        IntArrayTag tag = new IntArrayTag();
        for (int i = 0; i < size; i++) tag.add(buffer.readInt());
        return tag;
    }
    
    @Override
    public void addTag(IntTag tag) {
        add(tag.getValue());
    }
}
