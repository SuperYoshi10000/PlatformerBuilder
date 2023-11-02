package local.ytk.g.platformer1.data.tag;

public class StringArrayTag extends AbstractArrayTag<String> {
    private String[] data;
    public String get(int index) {
        return data[index];
    }
}
