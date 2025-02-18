package local.ytk.g.platformer1.data.tag;

import local.ytk.g.platformer1.data.codecs.Ops;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TagOps implements Ops<Tag<?, ?>> {
    @Override
    public <U> U convert(Tag<?, ?> tag, Ops<U> outOps) {
        return null;
    }
    @Override
    public Tag.Null ofEmpty() {
        return Tag.Null.INSTANCE;
    }
    @Override
    public NumericTag<?> ofNumber(Number n) {
        return null;
    }
    //todo numbers...
    public ByteTag ofByte(byte b) {
        return ByteTag.of(b);
    }
    public ShortTag ofShort(short s) {
        return ShortTag.of(s);
    }
    public IntTag ofInt(int i) {
        return IntTag.of(i);
    }
    public LongTag ofLong(long l) {
        return LongTag.of(l);
    }
    public FloatTag ofFloat(float f) {
        return FloatTag.of(f);
    }
    public DoubleTag ofDouble(double d) {
        return DoubleTag.of(d);
    }
    @Override
    public Tag<?, ?> ofString(String s) {
        return StringTag.of(s);
    }
    @Override
    public Tag<?, ?> ofChar(char c) {
        return ShortTag.of(c);
    }
    @Override
    public Tag<?, ?> ofBool(boolean b) {
        return ByteTag.of(b);
    }
    @Override
    public Number getNumber(Tag<?, ?> tag) {
        return null;
    }
    public byte getByte(Tag<?, ?> t) {
        return t instanceof NumericTag<?> n ? n.byteValue() : Byte.parseByte(t.toString());
    }
    public short getShort(Tag<?, ?> t) {
        return t instanceof NumericTag<?> n ? n.shortValue() : Short.parseShort(t.toString());
    }
    public int getInt(Tag<?, ?> t) {
        return t instanceof NumericTag<?> n ? n.intValue() : Integer.parseInt(t.toString());
    }
    public long getLong(Tag<?, ?> t) {
        return t instanceof NumericTag<?> n ? n.longValue() : Long.parseLong(t.toString());
    }
    public float getFloat(Tag<?, ?> t) {
        return t instanceof NumericTag<?> n ? n.floatValue() : Float.parseFloat(t.toString());
    }
    public double getDouble(Tag<?, ?> t) {
        return t instanceof NumericTag<?> n ? n.doubleValue() : Double.parseDouble(t.toString());
    }
    @Override
    public String getString(Tag<?, ?> tag) {
        return tag.toString();
    }
    @Override
    public char getChar(Tag<?, ?> tag) {
        return tag instanceof NumericTag<?> n ? (char)n.shortValue() : tag.toString().charAt(0);
    }
    @Override
    public boolean getBool(Tag<?, ?> tag) {
        return tag instanceof NumericTag<?> n ? !n.isZero() : !(tag instanceof StringTag s) || s.truthy();
    }
    @Override
    public Tag<?, ?> ofStream() {
        return SequenceTag.empty();
    }
    private <V, T extends Tag<V, T>> SequenceTag<V, T> toArray(Tag<V, T> item) {
        SequenceTag<V, T> sequence = item.getType().array();
        sequence.addTag((T) item);
        return sequence;
    }
    @Override
    public <E extends Tag<?, ?>> SequenceTag<?, ?> ofStream(E item) {
        return toArray((Tag<?, ?>) item);
    }
    @Override
    public <E extends Tag<?, ?>> Tag<?, ?> ofStream(Stream<E> s) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> E mergeStream(Tag<?, ?> stream, E item) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> Tag<?, ?> mergeStreams(Tag<?, ?> stream, Stream<E> items) {
        return null;
    }
    @Override
    public Tag<?, ?> mergeStreams(Tag<?, ?> stream1, Tag<?, ?> stream2) {
        return null;
    }
    @Override
    public <E> Stream<E> getStream(Tag<?, ?> tag) {
        return null;
    }
    @Override
    public ListTag ofList() {
        return new ListTag();
    }
    @Override
    public <E extends Tag<?, ?>> Tag<?, ?> ofList(Collection<E> l) {
        return new ListTag();
    }
    @Override
    public <E extends Tag<?, ?>> Tag<?, ?> mergeList(Tag<?, ?> list, E item) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> Tag<?, ?> mergeLists(Tag<?, ?> list, List<E> items) {
        return null;
    }
    @Override
    public Tag<?, ?> mergeLists(Tag<?, ?> list1, Tag<?, ?> list2) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> E add(Tag<?, ?> list) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> E add(Tag<?, ?> list, int index) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> E set(Tag<?, ?> list, int index, E value) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> E get(Tag<?, ?> list, int index) {
        return null;
    }
    @Override
    public <E extends Tag<?, ?>> E remove(Tag<?, ?> list, int index) {
        return null;
    }
    @Override
    public <E> List<E> getList(Tag<?, ?> tag) {
        return null;
    }
    @Override
    public Tag<?, ?> ofMap() {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> Tag<?, ?> toMap(K k, V v) {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> Tag<?, ?> ofMap(Map<K, V> m) {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> Tag<?, ?> mergeMap(Tag<?, ?> map, K k, V v) {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> Tag<?, ?> mergeMap(Tag<?, ?> map, Map<K, V> items) {
        return null;
    }
    @Override
    public Tag<?, ?> mergeMaps(Tag<?, ?> map1, Tag<?, ?> map2) {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> V set(Tag<?, ?> map, K k, V v) {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> V get(Tag<?, ?> map, K k) {
        return null;
    }
    @Override
    public <K extends Tag<?, ?>, V extends Tag<?, ?>> V remove(Tag<?, ?> map, K k) {
        return null;
    }
    @Override
    public <K, V> Map<K, V> getMap(Tag<?, ?> tag) {
        return null;
    }
}
