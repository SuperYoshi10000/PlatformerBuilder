package local.ytk.g.platformer1.data.store;

import java.nio.ByteBuffer;
import java.util.function.Function;

public interface Data {
    public ByteBuffer getData();
    public ByteBuffer getData(int index);
    public byte[] getBytes();

    public ByteBuffer read(int index, int length);
    public ByteBuffer readRange(int start, int end);
    
    public boolean readBoolean(int index, byte bitOffset);
    public byte readByte(int index);
    public short readShort(int index);
    public int readInt(int index);
    public long readLong(int index);
    public float readFloat(int index);
    public double readDouble(int index);
    
    public boolean[] readBooleans(int index, int count, byte bitOffset);
    public byte[] readBytes(int index, int count);
    public short[] readShorts(int index, int count);
    public int[] readInts(int index, int count);
    public long[] readLongs(int index, int count);
    public float[] readFloats(int index, int count);
    public double[] readDoubles(int index, int count);

    public <D extends Data> D readData(int index, int length, D data);
    public <D extends Data> D[] readData(int index, int length, D[] data);
    public <T> T readData(int index, int length, Function<byte[], T> converter);
    public <T> T[] readData(int index, int length, Function<byte[], T> converter, T[] results);

    public Data put(byte[] bytes);
}
