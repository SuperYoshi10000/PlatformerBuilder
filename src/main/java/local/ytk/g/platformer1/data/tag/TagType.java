// This file is a mess. I should probably clean it up.

package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.function.Function;
import java.util.function.Supplier;

public record TagType<V, T extends Tag, A extends SequenceTag<V, T>>(
        byte id,
        String name,
        String code,
        Class<V> valueClass,
        Supplier<T> emptySupplier,
        Function<Object,  T> constructor,
        Function<String,  T> stringConstructor,
        Function<ByteBuf, V> bufferConstructor,
        Function<ByteBuf, T> bufferTagConstructor,
        Supplier<A> arrayConstructor
) {
    public TagType(byte id, String name, String code, Class<V> valueClass, V value, T tag, A array) {
        this(id, name, code, valueClass, () -> tag, obj -> tag, str -> tag, buf -> value, buf -> tag, () -> array);
    }
    
    // Empty tag types
    public static final TagType<Object, Tag.Null, SequenceTag.Empty<Tag.Null>> NULL = new TagType<>(Tag.NULL, "null", "null", Object.class, null, Tag.Null.INSTANCE, SequenceTag.empty());
    public static final TagType<Object, Tag.End,  SequenceTag.Empty<Tag.End >> END  = new TagType<>(Tag.END,  "end",  "end",  Object.class, null, Tag.End.INSTANCE,  SequenceTag.empty());
    
    // Number tag types
    public static final TagType<Byte,    ByteTag,   ByteArrayTag  > BYTE   = new TagType<>(Tag.BYTE,   "byte",   "b",    Byte.class,    () -> ByteTag.ZERO,   ByteTag::of,   ByteTag::of,   ByteBuf::readByte,   ByteTag::deserialize,   ByteArrayTag::new  );
    public static final TagType<Short,   ShortTag,  ShortArrayTag > SHORT  = new TagType<>(Tag.SHORT,  "short",  "str",  Short.class,   () -> ShortTag.ZERO,  ShortTag::of,  ShortTag::of,  ByteBuf::readShort,  ShortTag::deserialize,  ShortArrayTag::new );
    public static final TagType<Integer, IntTag,    IntArrayTag   > INT    = new TagType<>(Tag.INT,    "int",    "i",    Integer.class, () -> IntTag.ZERO,    IntTag::of,    IntTag::of,    ByteBuf::readInt,    IntTag::deserialize,    IntArrayTag::new   );
    public static final TagType<Long,    LongTag,   LongArrayTag  > LONG   = new TagType<>(Tag.LONG,   "long",   "L",    Long.class,    () -> LongTag.ZERO,   LongTag::of,   LongTag::of,   ByteBuf::readLong,   LongTag::deserialize,   LongArrayTag::new  );
    public static final TagType<Float,   FloatTag,  FloatArrayTag > FLOAT  = new TagType<>(Tag.FLOAT,  "float",  "f",    Float.class,   () -> FloatTag.ZERO,  FloatTag::of,  FloatTag::of,  ByteBuf::readFloat,  FloatTag::deserialize,  FloatArrayTag::new );
    public static final TagType<Double,  DoubleTag, DoubleArrayTag> DOUBLE = new TagType<>(Tag.DOUBLE, "double", "d",    Double.class,  () -> DoubleTag.ZERO, DoubleTag::of, DoubleTag::of, ByteBuf::readDouble, DoubleTag::deserialize, DoubleArrayTag::new);
    
    // String and collection tag types
    public static final TagType<String,      StringTag,   StringArrayTag  > STRING   = new TagType<>(Tag.STRING,   "string",   "S",  String.class,      () -> StringTag.EMPTY,   StringTag::of,            StringTag::of,           StringTag::readString,    StringTag::deserialize,   StringArrayTag::new);
    public static final TagType<ListTag,     ListTag, ListListTag> LIST     = new TagType<>(Tag.LIST,     "list",     "[]", ListTag.class,     () -> ListTag.EMPTY, obj -> new ListTag(),     ListTag::fromString,     ListTag::deserialize,     ListTag::deserialize,     ListListTag::new);
    public static final TagType<CompoundTag, CompoundTag, CompoundListTag> COMPOUND = new TagType<>(Tag.COMPOUND, "compound", "{}", CompoundTag.class, () -> CompoundTag.EMPTY, obj -> new CompoundTag(), CompoundTag::fromString, CompoundTag::deserialize, CompoundTag::deserialize, CompoundListTag::new);
    
    static final Byte2ObjectOpenHashMap<TagType<?, ?, ?>> TAG_TYPES = new Byte2ObjectOpenHashMap<>(256) {{
        put(Tag.NULL,     NULL    );
        put(Tag.BYTE,     BYTE    );
        put(Tag.SHORT,    SHORT   );
        put(Tag.INT,      INT     );
        put(Tag.LONG,     LONG    );
        put(Tag.FLOAT,    FLOAT   );
        put(Tag.DOUBLE,   DOUBLE  );
        put(Tag.STRING,   STRING  );
        put(Tag.LIST,     LIST    );
        put(Tag.COMPOUND, COMPOUND);
        put(Tag.END,      END     );
    }};
    static final ObjectCollection<TagType<?, ?, ?>> VALUES = TAG_TYPES.values();
    static final TagType<?, ?, ?>[] VALUES_ARRAY = VALUES.toArray(new TagType<?, ?, ?>[256]);
    
    public static @Nullable TagType<?, ?, ?> fromName(@NotNull String name) {
        return TAG_TYPES.values().stream().filter(type -> type.name().equals(name)).findFirst().orElse(null);
    }
    public static @Nullable TagType<?, ?, ?> fromCode(@NotNull String code) {
        return TAG_TYPES.values().stream().filter(type -> type.code().equals(code)).findFirst().orElse(null);
    }
    @SuppressWarnings("unchecked")
    public static @Nullable <V> TagType<V, ?, ?> fromClass(@NotNull Class<V> valueClass) {
        return (TagType<V, ?, ?>) TAG_TYPES.values().stream().filter(type -> type.valueClass().equals(valueClass)).findFirst().orElse(null);
    }
    public static TagType<?, ?, ?> fromId(byte id) {
        return TAG_TYPES.get(id);
    }
    @SuppressWarnings("unchecked")
    public static <V, T extends Tag<V, T>> TagType<V, T, ?> of(Tag<V, T> tag) {
        return (TagType<V, T, ?>) fromId(tag.getId());
    }
    
    public V deserialize(ByteBuf buffer) {
        return bufferConstructor.apply(buffer);
    }
    
    public A deserializeArray(ByteBuf buffer) {
        int size = buffer.readInt();
        A array = arrayConstructor.get();
        for (int i = 0; i < size; i++) array.add(deserialize(buffer));
        return array;
    }
    
    public A array() {
        return arrayConstructor.get();
    }
    public A array(V value) {
        A array = array();
        array.add(value);
        return array;
    }
    @SafeVarargs
    public final A array(V... values) {
        A array = array();
        Collections.addAll(array, values);
        return array;
    }
}

