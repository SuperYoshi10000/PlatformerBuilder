package local.ytk.g.platformer1.data.codecs;

import local.ytk.util.collection.Mapper;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public interface Ops<T> {
    <U> U convert(T t, Ops<U> outOps);
    
    default Object getObject(T t) {
        return null;
    }
    
    T ofEmpty();
    T ofNumber(Number n);
    T ofString(String s);
    default T ofByte(byte b) {
        return ofNumber(b);
    }
    default T ofShort(short s) {
        return ofNumber(s);
    }
    default T ofInt(int i) {
        return ofNumber(i);
    }
    default T ofLong(long l) {
        return ofNumber(l);
    }
    default T ofFloat(float f) {
        return ofNumber(f);
    }
    default T ofDouble(double d) {
        return ofNumber(d);
    }
    T ofChar(char c);
    T ofBool(boolean b);
    
    Number getNumber(T t);
    String getString(T t);
    default byte getByte(T t) {
        return getNumber(t).byteValue();
    }
    default short getShort(T t) {
        return getNumber(t).shortValue();
    }
    default int getInt(T t) {
        return getNumber(t).intValue();
    }
    default long getLong(T t) {
        return getNumber(t).longValue();
    }
    default float getFloat(T t) {
        return getNumber(t).floatValue();
    }
    default double getDouble(T t) {
        return getNumber(t).doubleValue();
    }
    char getChar(T t);
    boolean getBool(T t);
    
    T ofStream();
    <E extends T> T ofStream(E item);
    <E extends T> T ofStream(Stream<E> s);
    <E extends T> T mergeStream(T stream, E item);
    <E extends T> T mergeStreams(T stream, Stream<E> items);
    T mergeStreams(T stream1, T stream2);
    <E> Stream<E> getStream(T t);
    
    T ofList();
    default <E extends T> T ofList(E item) {
        return ofList(List.of(item));
    }
    <E extends T> T ofList(Collection<E> l);
    <E extends T> T mergeList(T list, E item);
    <E extends T> T mergeLists(T list, List<E> items);
    T mergeLists(T list1, T list2);
    <E extends T> E add(T list);
    <E extends T> E add(T list, int index);
    <E extends T> E set(T list, int index, E value);
    <E extends T> E get(T list, int index);
    <E extends T> E remove(T list, int index);
    <E> List<E> getList(T t);
    
    default int getSize(T t) {
        Object o = getObject(t);
        return o instanceof List<?> l ? l.size() : o instanceof Map<?, ?> m ? m.size() : o instanceof Object[] a ? a.length : 0;
    }
    default Class<?> getClass(T t) {
        return getObject(t).getClass();
    }
    
    default <E extends T> T ofArray(E... items) {
        return ofList(Arrays.asList(items));
    }
    default <E extends T> E[] getArray(T array, IntFunction<E[]> generator) {
        return getList(array).toArray(generator);
    }
    /*
    static <T, E extends T> Decoder<E[]> getArrayDecoder(IntFunction<E[]> generator) {
        return (o, aCodec) -> o.getArray(aCodec, generator);
    }
    >>> todo HELP ME FIX THIS!!!!!
     */
    
    T ofMap();
    <K extends T, V extends T> T toMap(K k, V v);
    <K extends T, V extends T> T ofMap(Map<K, V> m);
    <K extends T, V extends T> T mergeMap(T map, K k, V v);
    <K extends T, V extends T> T mergeMap(T map, Map<K, V> items);
    T mergeMaps(T map1, T map2);
    <K extends T, V extends T> V set(T map, K k, V v);
    <K extends T, V extends T> V get(T map, K k);
    <K extends T, V extends T> V remove(T map, K k);
    <K, V> Map<K, V> getMap(T t);
    
    default <U> Ops<U> map() {
        return null;
    }
    
    default <U> Ops<U> map(Function<T, U> mapper) {
        return new Ops<>() {
            @Override
            public <U1> U1 convert(U u, Ops<U1> outOps) {
                return null;
            }
            @Override
            public U ofEmpty() {
                return mapper.apply(Ops.this.ofEmpty());
            }
            @Override
            public U ofNumber(Number n) {
                return mapper.apply(Ops.this.ofNumber(n));
            }
            @Override
            public U ofString(String s) {
                return mapper.apply(Ops.this.ofString(s));
            }
            @Override
            public U ofByte(byte b) {
                return mapper.apply(Ops.this.ofByte(b));
            }
            @Override
            public U ofShort(short s) {
                return mapper.apply(Ops.this.ofShort(s));
            }
            @Override
            public U ofInt(int i) {
                return mapper.apply(Ops.this.ofInt(i));
            }
            @Override
            public U ofLong(long l) {
                return mapper.apply(Ops.this.ofLong(l));
            }
            @Override
            public U ofFloat(float f) {
                return mapper.apply(Ops.this.ofFloat(f));
            }
            @Override
            public U ofDouble(double d) {
                return mapper.apply(Ops.this.ofDouble(d));
            }
            @Override
            public U ofChar(char c) {
                return mapper.apply(Ops.this.ofChar(c));
            }
            @Override
            public U ofBool(boolean b) {
                return mapper.apply(Ops.this.ofBool(b));
            }
            @Override
            public Number getNumber(U u) {
                return null;
            }
            @Override
            public String getString(U u) {
                return null;
            }
            @Override
            public byte getByte(U u) {
                return 0;
            }
            @Override
            public short getShort(U u) {
                return 0;
            }
            @Override
            public int getInt(U u) {
                return 0;
            }
            @Override
            public long getLong(U u) {
                return 0;
            }
            @Override
            public float getFloat(U u) {
                return 0;
            }
            @Override
            public double getDouble(U u) {
                return 0;
            }
            @Override
            public char getChar(U u) {
                return 0;
            }
            @Override
            public boolean getBool(U u) {
                return false;
            }
            @Override
            public U ofStream() {
                return mapper.apply(Ops.this.ofStream());
            }
            @Override
            public <E extends U> U ofStream(E item) {
                return null;
            }
            @Override
            public <E extends U> U ofStream(Stream<E> s) {
                return null;
            }
            @Override
            public <E extends U> U mergeStream(U stream, E item) {
                return null;
            }
            @Override
            public <E extends U> U mergeStreams(U stream, Stream<E> items) {
                return null;
            }
            @Override
            public U mergeStreams(U stream1, U stream2) {
                return null;
            }
            @Override
            public <E> Stream<E> getStream(U u) {
                return null;
            }
            @Override
            public U ofList() {
                return mapper.apply(Ops.this.ofList());
            }
            @Override
            public <E extends U> U ofList(E item) {
                return null;
            }
            @Override
            public <E extends U> U ofList(Collection<E> l) {
                return null;
            }
            @Override
            public <E extends U> U mergeList(U list, E item) {
                return null;
            }
            @Override
            public <E extends U> U mergeLists(U list, List<E> items) {
                return null;
            }
            @Override
            public U mergeLists(U list1, U list2) {
                return null;
            }
            @Override
            public <E extends U> E add(U list) {
                return null;
            }
            @Override
            public <E extends U> E add(U list, int index) {
                return null;
            }
            @Override
            public <E extends U> E set(U list, int index, E value) {
                return null;
            }
            @Override
            public <E extends U> E get(U list, int index) {
                return null;
            }
            @Override
            public <E extends U> E remove(U list, int index) {
                return null;
            }
            @Override
            public <E> List<E> getList(U u) {
                return null;
            }
            @Override
            public int getSize(U u) {
                return 0;
            }
            @Override
            public U ofMap() {
                return mapper.apply(Ops.this.ofMap());
            }
            @Override
            public <K extends U, V extends U> U toMap(K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U ofMap(Map<K, V> m) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U mergeMap(U map, K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U mergeMap(U map, Map<K, V> items) {
                return null;
            }
            @Override
            public U mergeMaps(U map1, U map2) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V set(U map, K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V get(U map, K k) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V remove(U map, K k) {
                return null;
            }
            @Override
            public <K, V> Map<K, V> getMap(U u) {
                return null;
            }
        };
    }
    
    default <U> Ops<U> mapReverse(Function<U, T> reverseMapper) {
        return new Ops<>() {
            @Override
            public Object getObject(U u) {
                return Ops.this.getObject(reverseMapper.apply(u));
            }
            @Override
            public <U1> U1 convert(U u, Ops<U1> outOps) {
                return Ops.this.convert(reverseMapper.apply(u), outOps);
            }
            @Override
            public U ofEmpty() {
                return null;
            }
            @Override
            public U ofNumber(Number n) {
                return null;
            }
            @Override
            public U ofString(String s) {
                return null;
            }
            @Override
            public U ofByte(byte b) {
                return null;
            }
            @Override
            public U ofShort(short s) {
                return null;
            }
            @Override
            public U ofInt(int i) {
                return null;
            }
            @Override
            public U ofLong(long l) {
                return null;
            }
            @Override
            public U ofFloat(float f) {
                return null;
            }
            @Override
            public U ofDouble(double d) {
                return null;
            }
            @Override
            public U ofChar(char c) {
                return null;
            }
            @Override
            public U ofBool(boolean b) {
                return null;
            }
            @Override
            public Number getNumber(U u) {
                return Ops.this.getNumber(reverseMapper.apply(u));
            }
            @Override
            public String getString(U u) {
                return Ops.this.getString(reverseMapper.apply(u));
            }
            @Override
            public byte getByte(U u) {
                return Ops.this.getByte(reverseMapper.apply(u));
            }
            @Override
            public short getShort(U u) {
                return Ops.this.getShort(reverseMapper.apply(u));
            }
            @Override
            public int getInt(U u) {
                return Ops.this.getInt(reverseMapper.apply(u));
            }
            @Override
            public long getLong(U u) {
                return Ops.this.getLong(reverseMapper.apply(u));
            }
            @Override
            public float getFloat(U u) {
                return Ops.this.getFloat(reverseMapper.apply(u));
            }
            @Override
            public double getDouble(U u) {
                return Ops.this.getDouble(reverseMapper.apply(u));
            }
            @Override
            public char getChar(U u) {
                return Ops.this.getChar(reverseMapper.apply(u));
            }
            @Override
            public boolean getBool(U u) {
                return Ops.this.getBool(reverseMapper.apply(u));
            }
            @Override
            public U ofStream() {
                return null;
            }
            @Override
            public <E extends U> U ofStream(E item) {
                return null;
            }
            @Override
            public <E extends U> U ofStream(Stream<E> s) {
                return null;
            }
            @Override
            public <E extends U> U mergeStream(U stream, E item) {
                return null;
            }
            @Override
            public <E extends U> U mergeStreams(U stream, Stream<E> items) {
                return null;
            }
            @Override
            public U mergeStreams(U stream1, U stream2) {
                return null;
            }
            @Override
            public <E> Stream<E> getStream(U u) {
                return Ops.this.getStream(reverseMapper.apply(u));
            }
            @Override
            public U ofList() {
                return null;
            }
            @Override
            public <E extends U> U ofList(E item) {
                return null;
            }
            @Override
            public <E extends U> U ofList(Collection<E> l) {
                return null;
            }
            @Override
            public <E extends U> U mergeList(U list, E item) {
                return null;
            }
            @Override
            public <E extends U> U mergeLists(U list, List<E> items) {
                return null;
            }
            @Override
            public U mergeLists(U list1, U list2) {
                return null;
            }
            @Override
            public <E extends U> E add(U list) {
                return null;
            }
            @Override
            public <E extends U> E add(U list, int index) {
                return null;
            }
            @Override
            public <E extends U> E set(U list, int index, E value) {
                return null;
            }
            @Override
            public <E extends U> E get(U list, int index) {
                return null;
            }
            @Override
            public <E extends U> E remove(U list, int index) {
                return null;
            }
            @Override
            public <E> List<E> getList(U u) {
                return Ops.this.getList(reverseMapper.apply(u));
            }
            @Override
            public int getSize(U u) {
                return Ops.this.getSize(reverseMapper.apply(u));
            }
            @Override
            public U ofMap() {
                return null;
            }
            @Override
            public <K extends U, V extends U> U toMap(K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U ofMap(Map<K, V> m) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U mergeMap(U map, K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U mergeMap(U map, Map<K, V> items) {
                return null;
            }
            @Override
            public U mergeMaps(U map1, U map2) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V set(U map, K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V get(U map, K k) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V remove(U map, K k) {
                return null;
            }
            @Override
            public <K, V> Map<K, V> getMap(U u) {
                return Ops.this.getMap(reverseMapper.apply(u));
            }
        };
    }
    
    default <U> Ops<U> map(Function<T, U> mapper, Function<U, T> reverseMapper) {
        return new Ops<>() {
            @Override
            public Object getObject(U u) {
                return Ops.this.getObject(reverseMapper.apply(u));
            }
            @Override
            public <U1> U1 convert(U u, Ops<U1> outOps) {
                return Ops.this.convert(reverseMapper.apply(u), outOps);
            }
            @Override
            public U ofEmpty() {
                return mapper.apply(Ops.this.ofEmpty());
            }
            @Override
            public U ofNumber(Number n) {
                return mapper.apply(Ops.this.ofNumber(n));
            }
            @Override
            public U ofString(String s) {
                return mapper.apply(Ops.this.ofString(s));
            }
            @Override
            public U ofByte(byte b) {
                return mapper.apply(Ops.this.ofByte(b));
            }
            @Override
            public U ofShort(short s) {
                return mapper.apply(Ops.this.ofShort(s));
            }
            @Override
            public U ofInt(int i) {
                return mapper.apply(Ops.this.ofInt(i));
            }
            @Override
            public U ofLong(long l) {
                return mapper.apply(Ops.this.ofLong(l));
            }
            @Override
            public U ofFloat(float f) {
                return mapper.apply(Ops.this.ofFloat(f));
            }
            @Override
            public U ofDouble(double d) {
                return mapper.apply(Ops.this.ofDouble(d));
            }
            @Override
            public U ofChar(char c) {
                return mapper.apply(Ops.this.ofChar(c));
            }
            @Override
            public U ofBool(boolean b) {
                return mapper.apply(Ops.this.ofBool(b));
            }
            @Override
            public Number getNumber(U u) {
                return Ops.this.getNumber(reverseMapper.apply(u));
            }
            @Override
            public String getString(U u) {
                return Ops.this.getString(reverseMapper.apply(u));
            }
            @Override
            public byte getByte(U u) {
                return Ops.this.getByte(reverseMapper.apply(u));
            }
            @Override
            public short getShort(U u) {
                return Ops.this.getShort(reverseMapper.apply(u));
            }
            @Override
            public int getInt(U u) {
                return Ops.this.getInt(reverseMapper.apply(u));
            }
            @Override
            public long getLong(U u) {
                return Ops.this.getLong(reverseMapper.apply(u));
            }
            @Override
            public float getFloat(U u) {
                return Ops.this.getFloat(reverseMapper.apply(u));
            }
            @Override
            public double getDouble(U u) {
                return Ops.this.getDouble(reverseMapper.apply(u));
            }
            @Override
            public char getChar(U u) {
                return Ops.this.getChar(reverseMapper.apply(u));
            }
            @Override
            public boolean getBool(U u) {
                return Ops.this.getBool(reverseMapper.apply(u));
            }
            @Override
            public U ofStream() {
                return mapper.apply(Ops.this.ofStream());
            }
            @Override
            public <E extends U> U ofStream(E item) {
                return mapper.apply(Ops.this.ofStream(reverseMapper.apply(item)));
            }
            @Override
            public <E extends U> U ofStream(Stream<E> s) {
                return mapper.apply(Ops.this.ofStream(s.map(reverseMapper)));
            }
            @Override
            public <E extends U> U mergeStream(U stream, E item) {
                return mapper.apply(Ops.this.mergeStream(reverseMapper.apply(stream), reverseMapper.apply(item)));
            }
            @Override
            public <E extends U> U mergeStreams(U stream, Stream<E> items) {
                return mapper.apply(Ops.this.mergeStreams(reverseMapper.apply(stream), items.map(reverseMapper)));
            }
            @Override
            public U mergeStreams(U stream1, U stream2) {
                return mapper.apply(Ops.this.mergeStream(reverseMapper.apply(stream1), reverseMapper.apply(stream2)));
            }
            @Override
            public <E> Stream<E> getStream(U u) {
                return Ops.this.getStream(reverseMapper.apply(u));
            }
            private List<T> mapList(Collection<? extends U> l) {
                return l.stream().map(reverseMapper).toList();
            }
            @Override
            public U ofList() {
                return mapper.apply(Ops.this.ofList());
            }
            @Override
            public <E extends U> U ofList(E item) {
                return mapper.apply(Ops.this.ofList(reverseMapper.apply(item)));
            }
            @Override
            public <E extends U> U ofList(Collection<E> l) {
                return mapper.apply(Ops.this.ofList(mapList(l)));
            }
            @Override
            public <E extends U> U mergeList(U list, E item) {
                return mapper.apply(Ops.this.mergeList(reverseMapper.apply(list), reverseMapper.apply(item)));
            }
            @Override
            public <E extends U> U mergeLists(U list, List<E> items) {
                return mapper.apply(Ops.this.mergeLists(reverseMapper.apply(list), mapList(items)));
            }
            @Override
            public U mergeLists(U list1, U list2) {
                return mapper.apply(Ops.this.mergeLists(reverseMapper.apply(list1), reverseMapper.apply(list2)));
            }
            @Override
            public <E extends U> E add(U list) {
                return null;
            }
            @Override
            public <E extends U> E add(U list, int index) {
                return null;
            }
            @Override
            public <E extends U> E set(U list, int index, E value) {
                return null;
            }
            @Override
            public <E extends U> E get(U list, int index) {
                return null;
            }
            @Override
            public <E extends U> E remove(U list, int index) {
                return null;
            }
            @Override
            public <E> List<E> getList(U u) {
                return Ops.this.getList(reverseMapper.apply(u));
            }
            @Override
            public int getSize(U u) {
                return Ops.this.getSize(reverseMapper.apply(u));
            }
            
            @Override
            public U ofMap() {
                return mapper.apply(Ops.this.ofMap());
            }
            @Override
            public <K extends U, V extends U> U toMap(K k, V v) {
                return mapper.apply(Ops.this.toMap(reverseMapper.apply(k), reverseMapper.apply(v)));
            }
            @Override
            public <K extends U, V extends U> U ofMap(Map<K, V> m) {
                // I don't know why the .compose() part is necessary, but there's an error when I don't include it, so I'll leave it here for now
                // Old code
                //return m.entrySet().stream().collect(Entries.entriesToMap(reverseMapper.compose(k->k), reverseMapper.compose(v->v)));
                return mapper.apply(Ops.this.ofMap(Mapper.mapMap(m, reverseMapper.compose(k -> k), reverseMapper.compose(v -> v), HashMap::new)));
            }
            @Override
            public <K extends U, V extends U> U mergeMap(U map, K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> U mergeMap(U map, Map<K, V> items) {
                return null;
            }
            @Override
            public U mergeMaps(U map1, U map2) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V set(U map, K k, V v) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V get(U map, K k) {
                return null;
            }
            @Override
            public <K extends U, V extends U> V remove(U map, K k) {
                return null;
            }
            @Override
            public <K, V> Map<K, V> getMap(U u) {
                return Ops.this.getMap(reverseMapper.apply(u));
            }
        };
    }
}
