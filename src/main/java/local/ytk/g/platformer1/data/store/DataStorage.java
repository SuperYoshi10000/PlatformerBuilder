package local.ytk.g.platformer1.data.store;

import java.nio.ByteBuffer;
import java.util.function.Function;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
    @Override
    public ByteBuffer readRange(int start, int end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readRange'");
    }
    
    @Override
    public boolean readBoolean(int index, byte bitOffset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBoolean'");
    }
    @Override
    public byte readByte(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByte'");
    }
    @Override
    public short readShort(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readShort'");
    }
    @Override
    public int readInt(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readInt'");
    }
    @Override
    public long readLong(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readLong'");
    }
    @Override
    public float readFloat(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFloat'");
    }
    @Override
    public double readDouble(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readDouble'");
    }

    @Override
    public boolean[] readBooleans(int index, int count, byte bitOffset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBooleans'");
    }
    @Override
    public byte[] readBytes(int index, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBytes'");
    }
    @Override
    public short[] readShorts(int index, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readShorts'");
    }
    @Override
    public int[] readInts(int index, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readInts'");
    }
    @Override
    public long[] readLongs(int index, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readLongs'");
    }
    @Override
    public float[] readFloats(int index, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFloats'");
    }
    @Override
    public double[] readDoubles(int index, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readDoubles'");
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
