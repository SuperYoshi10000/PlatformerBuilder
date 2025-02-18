package local.ytk.g.platformer1.data.codecs;

import java.util.stream.Stream;

public class StreamCodec<T> extends AbstractCodec<Stream<T>> {
    public StreamCodec() {
        super(Encoder.of(Ops::ofStream), Ops::getStream);
    }
}
