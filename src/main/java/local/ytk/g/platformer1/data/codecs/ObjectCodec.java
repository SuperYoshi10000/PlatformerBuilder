package local.ytk.g.platformer1.data.codecs;

public class ObjectCodec<T> extends AbstractCodec<T> {
    public ObjectCodec(Encoder<T> encoder, Decoder<T> decoder) {
        super(encoder, decoder);
    }
}
