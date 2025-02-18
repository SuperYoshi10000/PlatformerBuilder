package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.util.List;

public class FloatArrayTag extends NumericArrayTag<Float, FloatTag> {
    public static FloatArrayTag of(float... array) {
        FloatArrayTag tag = new FloatArrayTag();
        for (float item : array) tag.add(item);
        return tag;
    }
    
    public float[] toPrimitiveArray() {
        float[] array = new float[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
    
    @Override
    public byte getItemId() {
        return FloatTag.TYPE;
    }
    
    @Override
    public float[] objectValue() {
        return toPrimitiveArray();
    }
    @Override
    public List<FloatTag> toTagList() {
        return stream().map(FloatTag::of).toList();
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        for (float item : this) buffer.writeFloat(item);
        return true;
    }
    
    public static FloatArrayTag deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        FloatArrayTag tag = new FloatArrayTag();
        for (int i = 0; i < size; i++) tag.add(buffer.readFloat());
        return tag;
    }
    
    @Override
    public void addTag(FloatTag tag) {
        add(tag.getValue());
    }
}
