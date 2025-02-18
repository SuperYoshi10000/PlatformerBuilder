package local.ytk.g.platformer1.data.tag;

public abstract class NumericArrayTag<N extends Number, T extends NumericTag<N, T>, S extends NumericArrayTag<N, T, S>> extends AbstractArrayTag<N, T, S> {
    public abstract Object toPrimitiveArray();
    
    @Override
    public byte getId() {
        return (byte) (getItemId() + ARRAY_TYPE_OFFSET);
    }
}
