package local.ytk.g.platformer1.data.tag;

public class ShortArrayTag extends AbstractArrayTag<Short> {
    private short[] data;
    public Short get(int index) {
        return data[index];
    }
}
