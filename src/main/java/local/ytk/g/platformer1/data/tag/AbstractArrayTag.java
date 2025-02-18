package local.ytk.g.platformer1.data.tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractArrayTag<V, T extends Tag<V, T>, S extends AbstractArrayTag<V, T, S>> extends ArrayList<V> implements SequenceTag<V, T, S> {
    public AbstractArrayTag() {}
    @SafeVarargs
    public AbstractArrayTag(V... tags) {
        this(List.of(tags));
    }
    public AbstractArrayTag(Collection<V> tags) {
        super(tags);
    }
    
    @Override
    public String toTagString() {
        return "[:" + toString().substring(1);
    }
}
