package local.ytk.g.platformer1.data.tag;

import java.util.ArrayList;

public abstract class AbstractArrayTag<T> extends ArrayList<T> implements Tag {
    public byte getId() {
        return 19;
    }
    public String toTagString() {
        return "[:" + toString().substring(1);
    }
}
