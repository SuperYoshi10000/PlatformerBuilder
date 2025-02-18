package local.ytk.g.platformer1.data.codecs;

import local.ytk.util.Result;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Encoder<T> {
    <O> Result<O> encode(Ops<O> ops, T t, O n);
    
    static <O1, T> Encoder<T> of(BiFunction<Ops<? super O1>, T, ? super O1> function) {
        return new Encoder<>() {
            @Override
            public <O2> Result<O2> encode(Ops<O2> ops, T t, O2 n) {
                return (Result<O2>) Result.of(function.apply((Ops<O1>) ops, t));
            }
        };
    }
}
