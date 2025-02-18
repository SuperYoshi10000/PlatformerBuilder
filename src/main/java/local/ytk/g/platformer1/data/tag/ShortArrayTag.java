package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import local.ytk.util.math.ArrayRange;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShortArrayTag extends NumericArrayTag<Short, ShortTag> {
    public static ShortArrayTag of(short... array) {
        ShortArrayTag tag = new ShortArrayTag();
        for (short s : array) tag.add(s);
        return tag;
    }
    public static ShortArrayTag of(@NotNull String s) {
        return of(ArrayRange.charToShort(s.toCharArray()));
    }
    
    public short[] toPrimitiveArray() {
        short[] array = new short[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
    
    @Override
    public byte getItemId() {
        return ShortTag.TYPE;
    }
    
    @Override
    public short[] objectValue() {
        return toPrimitiveArray();
    }
    @Override
    public List<ShortTag> toTagList() {
        return stream().map(ShortTag::of).toList();
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        forEach(buffer::writeShort);
        return true;
    }
    
    public static ShortArrayTag deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        ShortArrayTag tag = new ShortArrayTag();
        for (int i = 0; i < size; i++) tag.add(buffer.readShort());
        return tag;
    }
    
    @Override
    public void addTag(ShortTag tag) {
        add(tag.getValue());
    }
}
