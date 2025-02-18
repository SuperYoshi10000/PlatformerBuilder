package local.ytk.g.platformer1.data.codecs;

import java.util.function.IntFunction;

public abstract class PrimitiveCodec<T> extends AbstractCodec<T> {
    public PrimitiveCodec(Encoder<T> encoder, Decoder<T> decoder) {
        super(encoder, decoder);
    }
    
    public static class ShortCodec extends PrimitiveCodec<Short> {
        public ShortCodec() {
            super(Encoder.of(Ops::ofShort), Ops::getShort);
        }
        
        @Override
        public boolean valid(Short s) {
            return valid(s.shortValue());
        }
        public boolean valid(short s) {
            return true;
        }
        
        public static ShortCodec range(short min, short max) {
            return rangeExclusive(min, (short)(max + 1));
        }
        public static ShortCodec rangeExclusive(short min, short max) {
            return new ShortCodec() {
                @Override
                public boolean valid(short s) {
                    return s >= min && s < max;
                }
            };
        }
    }
    
    public static class FloatCodec extends PrimitiveCodec<Float> {
        public FloatCodec() {
            super(Encoder.of(Ops::ofFloat), Ops::getFloat);
        }
        
        @Override
        public boolean valid(Float f) {
            return valid(f.floatValue());
        }
        public boolean valid(float f) {
            return true;
        }
        
        public static FloatCodec range(float min, float max) {
            return new FloatCodec() {
                @Override
                public boolean valid(float f) {
                    return f >= min && f <= max;
                }
            };
        }
        public static FloatCodec rangeExclusive(float min, float max) {
            return new FloatCodec() {
                @Override
                public boolean valid(float f) {
                    return f > min && f < max;
                }
            };
        }
    }
    
    public static class IntCodec extends PrimitiveCodec<Integer> {
        public IntCodec() {
            super(Encoder.of(Ops::ofInt), Ops::getInt);
        }
        
        @Override
        public boolean valid(Integer i) {
            return valid(i.intValue());
        }
        public boolean valid(int i) {
            return true;
        }
        
        public static IntCodec range(int min, int max) {
            return rangeExclusive(min, max + 1);
        }
        public static IntCodec rangeExclusive(int min, int max) {
            return new IntCodec() {
                @Override
                public boolean valid(int i) {
                    return i >= min && i < max;
                }
            };
        }
    }
    
    public static class LongCodec extends PrimitiveCodec<Long> {
        public LongCodec() {
            super(Encoder.of(Ops::ofLong), Ops::getLong);
        }
        
        @Override
        public boolean valid(Long l) {
            return valid(l.longValue());
        }
        public boolean valid(long l) {
            return true;
        }
        
        public static LongCodec range(long min, long max) {
            return rangeExclusive(min, max + 1L);
        }
        public static LongCodec rangeExclusive(long min, long max) {
            return new LongCodec() {
                @Override
                public boolean valid(long l) {
                    return l >= min && l < max;
                }
            };
        }
    }
    
    public static class StringCodec extends PrimitiveCodec<String> {
        public StringCodec() {
            super(Encoder.of(Ops::ofString), Ops::getString);
        }
    }
    
    public static class CharCodec extends PrimitiveCodec<Character> {
        public CharCodec() {
            super(Encoder.of(Ops::ofChar), Ops::getChar);
        }
        
        @Override
        public boolean valid(Character c) {
            return valid(c.charValue());
        }
        public boolean valid(char c) {
            return true;
        }
        
        public static CharCodec range(char min, char max) {
            return rangeExclusive(min, (char)(max + 1));
        }
        public static CharCodec rangeExclusive(char min, char max) {
            return new CharCodec() {
                @Override
                public boolean valid(char c) {
                    return c >= min && c < max;
                }
            };
        }
    }
    
    public static class ByteCodec extends PrimitiveCodec<Byte> {
        public ByteCodec() {
            super(Encoder.of(Ops::ofByte), Ops::getByte);
        }
        
        @Override
        public boolean valid(Byte b) {
            return valid(b.byteValue());
        }
        public boolean valid(byte b) {
            return true;
        }
        
        public static ByteCodec range(byte min, byte max) {
            return rangeExclusive(min, (byte)(max + 1));
        }
        public static ByteCodec rangeExclusive(byte min, byte max) {
            return new ByteCodec() {
                @Override
                public boolean valid(byte b) {
                    return b >= min && b < max;
                }
            };
        }
    }
    
    public static class BooleanCodec extends PrimitiveCodec<Boolean> {
        public BooleanCodec() {
            super(Encoder.of(Ops::ofBool), Ops::getBool);
        }
    }
    
    public static class DoubleCodec extends PrimitiveCodec<Double> {
        public DoubleCodec() {
            super(Encoder.of(Ops::ofDouble), Ops::getDouble);
        }
        
        @Override
        public boolean valid(Double d) {
            return valid(d.doubleValue());
        }
        public boolean valid(double d) {
            return true;
        }
        
        public static DoubleCodec range(double min, double max) {
            return new DoubleCodec() {
                @Override
                public boolean valid(double d) {
                    return d >= min && d <= max;
                }
            };
        }
        public static DoubleCodec rangeExclusive(double min, double max) {
            return new DoubleCodec() {
                @Override
                public boolean valid(double d) {
                    return d > min && d < max;
                }
            };
        }
    }
    
    public abstract static class ArrayCodec<T> extends PrimitiveCodec<T[]> {
        protected final IntFunction<? extends T[]> generator;
        
        public ArrayCodec(IntFunction<T[]> generator) {
            super(Encoder.of(Ops::ofArray), null /*Ops.getArrayDecoder(generator)*/);
            this.generator = generator;
        }
    }
}
