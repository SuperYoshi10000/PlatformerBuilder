package local.ytk.g.platformer1.data.tag;

import java.io.Serializable;

public interface ObjectTag<V, T extends Tag<V, T>> extends Cloneable, Serializable, Tag<V, T> {
}
