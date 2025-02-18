package local.ytk.g.platformer1.data.codecs;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import local.ytk.util.Result;

public interface Codec<T> extends Encoder<T>, Decoder<T> {
    static <T> Codec<T> of(Encoder<T> encoder, Decoder<T> decoder) {
        return new Codec<>() {
            @Override
            public <O> Result<O> encode(Ops<O> ops, T t, O n) {
                return encoder.encode(ops, t, n);
            }
            
            @Override
            public <O> T decode(Ops<O> ops, O o) {
                return decoder.decode(ops, o);
            }
        };
    }
    
    
    default boolean valid(T value) {
        return true;
    }
    
    default CodecField<T> field(String name) {
        return new CodecField<>() {
            @Override
            public Codec<T> codec() {
                return Codec.this;
            }
            
            @Override
            public String name() {
                return null;
                
            }
        };
    }
    
    static void of() {}
    
    static <A, B> BothCodec<A, B> both(Codec<A> a, Codec<B> b) {
        return new BothCodec<>(a, b);
    }
    static <A, B> EitherCodec<A, B> either(Codec<A> a, Codec<B> b) {
        return new EitherCodec<>(a, b);
    }
    static <A, B> XorCodec<A, B> oneOf(Codec<A> a, Codec<B> b) {
        return new XorCodec<>(a, b);
    }
    
    static <A, B> Codec<Pair<A, B>> and(Codec<A> a, Codec<B> b) {
        return both(a, b);
    }
    static <A, B> Codec<Either<A, B>> or(Codec<A> a, Codec<B> b) {
        return either(a, b);
    }
    static <A, B> Codec<Either<A, B>> xor(Codec<A> a, Codec<B> b) {
        return oneOf(a, b);
    }
    
}
