package local.ytk.g.platformer1.data.tag;

import org.jetbrains.annotations.NotNull;

public class CompoundListTag extends TypedListTag<CompoundTag, CompoundListTag> {
    @Override
    public CompoundTag @NotNull [] toArray() {
        CompoundTag[] array = new CompoundTag[size()];
        for (int i = 0; i < size(); i++) array[i] = get(i);
        return array;
    }
}
