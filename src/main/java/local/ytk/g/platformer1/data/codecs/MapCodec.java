package local.ytk.g.platformer1.data.codecs;

import java.util.Map;

public class MapCodec<K, V> extends AbstractCodec<Map<K, V>> {
    public MapCodec() {
        super(Encoder.of(Ops::ofMap), Ops::getMap);
    }
}
