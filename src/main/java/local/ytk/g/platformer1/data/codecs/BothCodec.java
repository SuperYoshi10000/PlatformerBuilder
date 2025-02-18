package local.ytk.g.platformer1.data.codecs;

import com.mojang.datafixers.util.Pair;
import local.ytk.util.Result;

public record BothCodec<A, B>(Codec<A> aCodec, Codec<B> bCodec) implements Codec<Pair<A, B>> {
    @Override
    public <O> Pair<A, B> decode(Ops<O> ops, O o) {
        return null;
    }
    
    @Override
    public <O> Result<O> encode(Ops<O> ops, Pair<A, B> abPair, O n) {
        return bCodec.encode(ops, abPair.getSecond(), n).flatMap(x -> aCodec.encode(ops, abPair.getFirst(), x));
    }
}
