package local.ytk.g.platformer1.data.tag;

import java.util.LinkedHashMap;

public abstract class MapTag<T extends Tag<?, ? extends T>, M extends MapTag<T, M>> extends LinkedHashMap<String, T> implements Cloneable, ObjectTag<T, M> {
    
    @Override
    @SuppressWarnings("unchecked")
    public MapTag<T, M> clone() {
        return (MapTag<T, M>) super.clone();
    }
}
