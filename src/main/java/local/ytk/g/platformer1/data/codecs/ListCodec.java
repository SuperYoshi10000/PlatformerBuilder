package local.ytk.g.platformer1.data.codecs;

import java.util.Collection;

public class ListCodec<T> extends AbstractCodec<Collection<T>> {
    public ListCodec() {
        super(Encoder.of(Ops::ofList), Ops::getList);
    }
}
