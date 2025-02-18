package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.util.List;

public class DoubleArrayTag extends NumericArrayTag<Double, DoubleTag> {
    public static DoubleArrayTag of(double... array) {
        DoubleArrayTag tag = new DoubleArrayTag();
        for (double item : array) tag.add(item);
        return tag;
    }
    
    public double[] toPrimitiveArray() {
        double[] array = new double[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
    
    @Override
    public byte getItemId() {
        return DoubleTag.TYPE;
    }
    
    @Override
    public double[] objectValue() {
        return toPrimitiveArray();
    }
    @Override
    public List<DoubleTag> toTagList() {
        return stream().map(DoubleTag::of).toList();
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        for (double item : this) buffer.writeDouble(item);
        return true;
    }
    
    public static DoubleArrayTag deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        DoubleArrayTag tag = new DoubleArrayTag();
        for (int i = 0; i < size; i++) tag.add(buffer.readDouble());
        return tag;
    }
    
    @Override
    public void addTag(DoubleTag tag) {
        add(tag.getValue());
    }
}
