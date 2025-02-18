package local.ytk.g.platformer1.data.store;

import org.apache.commons.lang3.ArrayUtils;

import java.nio.ByteBuffer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class DataStorage implements Data {
    public final ByteBuffer buffer;
    public DataStorage(int size) {
        super();
        buffer = ByteBuffer.wrap(new byte[size]);
    }

    @Override
    public ByteBuffer getData() {
        return buffer.asReadOnlyBuffer();
    }
    @Override
    public ByteBuffer getData(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }
    @Override
    public byte[] getBytes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBytes'");
    }
    
    @Override
    public ByteBuffer read(int index, int length) {
        return ByteBuffer.wrap(buffer.slice(index, length).array());
    }
    @Override
    public ByteBuffer slice(int index, int length) {
        return buffer.slice(index, length);
    }
    @Override
    public ByteBuffer readRange(int start, int end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readRange'");
    }
    
    @Override
    public boolean readBoolean(int index, byte offset) {
        if (offset < 0 || offset > 7) throw new IllegalArgumentException("Offset must be between 0 and 7");
        return (buffer.get(index) >> 7 - offset) % 2 == 0;
    }
    @Override
    public byte readByte(int index) {
        return buffer.get(index);
    }
    @Override
    public short readShort(int index) {
        return buffer.getShort(index);
    }
    @Override
    public int readInt(int index) {
        return buffer.getInt(index);
    }
    @Override
    public long readLong(int index) {
        return buffer.getLong(index);
    }
    @Override
    public float readFloat(int index) {
        return buffer.getFloat(index);
    }
    @Override
    public double readDouble(int index) {
        return buffer.getDouble(index);
    }
    @Override
    public char readChar(int index) {
        return buffer.getChar(index);
    }

    @Override
    public boolean[] readBooleans(int index, int count, byte bitOffset) {
        return IntStream.of(readInts(index, Math.ceilDiv(count, 32) + 1)).mapToObj(n -> {
            boolean[] booleans = new boolean[32];
            for (int i = 0; i < 32; ++i) {
                booleans[i] = (n & (1 << i)) != 0;
            }
            return booleans;
        }).reduce(new boolean[0], ArrayUtils::addAll);
    }
    @Override
    public byte[] readBytes(int index, int count) {
        byte[] dst = new byte[count];
        buffer.get(index, dst);
        return dst;
    }
    @Override
    public short[] readShorts(int index, int count) {
        short[] dst = new short[count];
        buffer.asShortBuffer().get(index, dst);
        return dst;
    }
    @Override
    public int[] readInts(int index, int count) {
        int[] dst = new int[count];
        buffer.asIntBuffer().get(index, dst);
        return dst;
    }
    @Override
    public long[] readLongs(int index, int count) {
        long[] dst = new long[count];
        buffer.asLongBuffer().get(index, dst);
        return dst;
    }
    @Override
    public float[] readFloats(int index, int count) {
        float[] dst = new float[count];
        buffer.asFloatBuffer().get(index, dst);
        return dst;
    }
    @Override
    public double[] readDoubles(int index, int count) {
        double[] dst = new double[count];
        buffer.asDoubleBuffer().get(index, dst);
        return dst;
    }
    @Override
    public char[] readChars(int index, int count) {
        char[] dst = new char[count];
        buffer.asCharBuffer().get(index, dst);
        return dst;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <D extends Data> D readData(int index, int length, D data) throws ClassCastException {
        return (D) data.put(readBytes(index, length));
    }
    @Override
    public <D extends Data> D[] readData(int index, int length, D[] data) {
        for (int i = 0; i < data.length; i++) {
            readData(index + i * length, length, data[i]);
        }
        return data;
    }
    @Override
    public <T> T readData(int index, int length, Function<byte[], T> converter) {
        return converter.apply(readBytes(index, length));
    }
    @Override
    public <T> T[] readData(int index, int length, Function<byte[], T> converter, T[] results) {
        for (int i = 0; i < results.length; i++) {
            readData(index + i * length, length, converter);
        }
        return results;
    }
    
    public DataStorage writeBit(int index, byte offset, boolean bit) {
        byte value = buffer.get(index);
        value |= (bit ? 1 : 0) << (7 - offset);
        buffer.put(index, value);
        return this;
    }
    public DataStorage writeBits(int index, byte offset, boolean bit1, boolean bit2, boolean bit3, boolean bit4, boolean bit5, boolean bit6, boolean bit7, boolean bit8) {
        short value = buffer.getShort(index);
        value |= (bit1 ? 128 : 0) << (15 - offset);
        value |= (bit2 ? 64 : 0) << (15 - offset);
        value |= (bit3 ? 32 : 0) << (15 - offset);
        value |= (bit4 ? 16 : 0) << (15 - offset);
        value |= (bit5 ? 8 : 0) << (15 - offset);
        value |= (bit6 ? 4 : 0) << (15 - offset);
        value |= (bit7 ? 2 : 0) << (15 - offset);
        value |= (bit8 ? 1 : 0) << (15 - offset);
        buffer.putShort(index, value);
        return this;
    }
    public DataStorage writeBits(int index, byte bitOffset, boolean... bits) {
        int end = Math.floorDiv(bits.length, 8);
        for (int i = 0; i < end; i++) {
            writeBits(index + i, bitOffset, bits[i], bits[i + 1], bits[i + 2], bits[i + 3], bits[i + 4], bits[i + 5], bits[i + 6], bits[i + 7]);
        }
        return this;
    }
    public DataStorage write(int index, byte... data) {
        buffer.put(index, data);
        return this;
    }
    public DataStorage write(int index, short... data) {
        for (short s : data) {
            buffer.putShort(index, s);
        }
        return this;
    }
    public DataStorage write(int index, int... data) {
        for (int i : data) {
            buffer.putInt(index, i);
        }
        return this;
    }
    public DataStorage write(int index, long... data) {
        for (long l : data) {
            buffer.putLong(index, l);
        }
        return this;
    }
    public DataStorage write(int index, float... data) {
        for (float f : data) {
            buffer.putFloat(index, f);
        }
        return this;
    }
    public DataStorage write(int index, double... data) {
        for (double d : data) {
            buffer.putDouble(index, d);
        }
        return this;
    }
    public DataStorage write(int index, Data data) {
        buffer.put(index, data.getBytes());
        return this;
    }

    @Override
    public DataStorage put(byte[] bytes) {
        buffer.put(0, bytes);
        return this;
    }
}
