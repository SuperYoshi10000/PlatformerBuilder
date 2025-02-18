package local.ytk.g.platformer1.data.codecs;

public interface Decoder<T> {
    <O> T decode(Ops<O> ops, O o);
}
