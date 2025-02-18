package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.IntStream;

public class ByteArrayTag extends NumericArrayTag<Byte, ByteTag> {
    public static ByteArrayTag of(byte... array) {
        ByteArrayTag tag = new ByteArrayTag();
        for (byte b : array) tag.add(b);
        return tag;
    }
    public static ByteArrayTag of(@NotNull ByteBuf buffer) {
        return of(buffer.array());
    }
    public static ByteArrayTag of(@NotNull String s) {
        return of(s.getBytes());
    }
    
    public byte[] toPrimitiveArray() {
        byte[] array = new byte[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
    
    @Override
    public byte getItemId() {
        return ByteTag.TYPE;
    }
    
    @Override
    public byte[] objectValue() {
        return toPrimitiveArray();
    }
    @Override
    public List<ByteTag> toTagList() {
        return stream().map(ByteTag::of).toList();
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        buffer.writeBytes(toPrimitiveArray());
        return true;
    }
    
    public static ByteArrayTag deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        ByteArrayTag tag = new ByteArrayTag();
        IntStream.range(0, size).forEach(i -> tag.add(buffer.readByte()));
        return tag;
    }
    
    @Override
    public void addTag(ByteTag tag) {
        add(tag.getValue());
    }
}
