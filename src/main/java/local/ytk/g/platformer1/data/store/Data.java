package local.ytk.g.platformer1.data.store;

import java.nio.ByteBuffer;
import java.util.function.Function;

public interface Data {
    ByteBuffer getData();
    ByteBuffer getData(int index);
    byte[] getBytes();

    ByteBuffer read(int index, int length);
    default ByteBuffer slice(int index, int length) {
        return read(index, length);
    }
    
    ByteBuffer readRange(int start, int end);
    
    boolean readBoolean(int index, byte bitOffset);
    byte readByte(int index);
    short readShort(int index);
    int readInt(int index);
    long readLong(int index);
    float readFloat(int index);
    double readDouble(int index);
    char readChar(int index);
    
    boolean[] readBooleans(int index, int count, byte bitOffset);
    byte[] readBytes(int index, int count);
    short[] readShorts(int index, int count);
    int[] readInts(int index, int count);
    long[] readLongs(int index, int count);
    float[] readFloats(int index, int count);
    double[] readDoubles(int index, int count);
    char[] readChars(int index, int count);
    
    <D extends Data> D readData(int index, int length, D data);
    <D extends Data> D[] readData(int index, int length, D[] data);
    <T> T readData(int index, int length, Function<byte[], T> converter);
    <T> T[] readData(int index, int length, Function<byte[], T> converter, T[] results);

    Data put(byte[] bytes);
}
