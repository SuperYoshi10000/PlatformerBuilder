package local.ytk.g.platformer1.data.codecs;

public interface CodecField<T> {
    Codec<T> codec();
    String name();
}
