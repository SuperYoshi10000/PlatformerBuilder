package local.ytk.g.platformer1.data.codecs;

import local.ytk.util.Result;

public abstract class AbstractCodec<T> implements Codec<T> {
    public final Encoder<T> encoder;
    public final Decoder<T> decoder;
    
    public AbstractCodec(int i) {
        this(null, null); // todo remove
    }
    public AbstractCodec(Encoder<T> encoder, Decoder<T> decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }
    
    @Override
    public <O> Result<O> encode(Ops<O> ops, T t, O n) {
        return encoder.encode(ops, t, n);
    }

    @Override
    public <O> T decode(Ops<O> ops, O o) {
        return decoder.decode(ops, o);
    }
    
    @Override
    public CodecField<T> field(String name) {
        return new CodecField<>() {
            @Override
            public AbstractCodec<T> codec() {
                return AbstractCodec.this;
            }
            
            @Override
            public String name() {
                return name;
            }
        };
    }
}
