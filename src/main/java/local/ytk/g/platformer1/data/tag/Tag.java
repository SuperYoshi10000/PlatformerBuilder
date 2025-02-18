package local.ytk.g.platformer1.data.tag;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import io.netty.buffer.ByteBuf;
import local.ytk.g.platformer1.data.save.Serializable;
import local.ytk.util.annotation.AutoGeneric;
import local.ytk.util.annotation.Singleton;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.Supplier;

import static local.ytk.g.platformer1.data.save.Serializer.checkReadable;

public interface Tag<V, T extends Tag<V, T>> extends TagRepresentable, Serializable {
    byte    NULL = 0,
            BYTE = 1,
            SHORT = 2,
            INT = 3,
            LONG = 4,
            FLOAT = 5,
            DOUBLE = 6,
            STRING = 8,
            LIST = 9,
            COMPOUND = 10,
            END = -1;
    
    String  NULL_CODE = "",
            BYTE_CODE = "b",
            SHORT_CODE = "s",
            INT_CODE = "i",
            LONG_CODE = "L",
            FLOAT_CODE = "f",
            DOUBLE_CODE = "d",
            STRING_CODE = "S",
            LIST_CODE = "[]",
            COMPOUND_CODE = "{}";
    
    String  NULL_NAME = "null",
            BYTE_NAME = "byte",
            SHORT_NAME = "short",
            INT_NAME = "int",
            LONG_NAME = "long",
            FLOAT_NAME = "float",
            DOUBLE_NAME = "double",
            STRING_NAME = "String",
            LIST_NAME = "List",
            COMPOUND_NAME = "Compound";
    
    String[] TAG_CODES = {
            NULL_CODE,
            BYTE_CODE,
            SHORT_CODE,
            INT_CODE,
            LONG_CODE,
            FLOAT_CODE,
            DOUBLE_CODE,
            null,
            STRING_CODE,
            LIST_CODE,
            COMPOUND_CODE
    };
    String[] TAG_NAMES = {
            NULL_NAME,
            BYTE_NAME,
            SHORT_NAME,
            INT_NAME,
            LONG_NAME,
            FLOAT_NAME,
            DOUBLE_NAME,
            null,
            STRING_NAME,
            LIST_NAME,
            COMPOUND_NAME
    };
    
    DynamicCommandExceptionType UNKNOWN_TYPE = new DynamicCommandExceptionType(s -> new LiteralMessage("Unknown type: " + s + " (Expected type)"));
    Dynamic2CommandExceptionType TYPE_MISMATCH = new Dynamic2CommandExceptionType((a, b) -> new LiteralMessage("Types mismatched: " + a + ", " + b));
    Dynamic2CommandExceptionType WRONG_TYPE = new Dynamic2CommandExceptionType((v, t) -> new LiteralMessage("Wrong type (Expected type " + t + "): " + v));
    
    default Tag<V, T> toTag() {
        return this;
    }
    String toTagString();
    byte getId();
    @SuppressWarnings("unchecked")
    default <@AutoGeneric S extends SequenceTag<V, T, S>> TagType<V, T, S> getType() {
        return (TagType<V, T, S>) TagType.of(this);
    }
    default String getTypeName() {
        return getType().name();
    }
    default String getTypeCode() {
        return getType().code();
    }
    Object objectValue();
    
    static Tag<?, ?> read(String str) {
        return switch (str) {
            case "" -> End.INSTANCE;
            case "null" -> Null.INSTANCE;
            case "false" -> ByteTag.ZERO;
            case "true" -> ByteTag.ONE;
            default -> read(new StringReader(str));
        };
        
    }
    
    static Tag<?, ?> read(StringReader reader) {
        try {
            return switch (Character.toLowerCase(reader.peek())) {
                case '[' -> {
                    String next = new StringReader(reader).readStringUntil(':').substring(1);
                    if (!next.matches("[A-Z]+")) yield readList(reader);
                    yield switch (next) {
                        case Tag.BYTE_CODE,     Tag.BYTE_NAME   -> readArray(reader, ByteArrayTag::new  );
                        case Tag.SHORT_CODE,    Tag.SHORT_NAME  -> readArray(reader, ShortArrayTag::new );
                        case Tag.INT_CODE,      Tag.INT_NAME    -> readArray(reader, IntArrayTag::new   );
                        case Tag.LONG_CODE,     Tag.LONG_NAME   -> readArray(reader, LongArrayTag::new  );
                        case Tag.FLOAT_CODE,    Tag.FLOAT_NAME  -> readArray(reader, FloatArrayTag::new );
                        case Tag.DOUBLE_CODE,   Tag.DOUBLE_NAME -> readArray(reader, DoubleArrayTag::new);
                        case Tag.STRING_CODE,   Tag.STRING_NAME -> readArray(reader, StringArrayTag::new);
                        case Tag.LIST_CODE,     Tag.LIST_NAME,     "A", "Array"    -> readArray(reader, ListListTag::new    );
                        case Tag.COMPOUND_CODE, Tag.COMPOUND_NAME, "C", "M", "Map" -> readArray(reader, CompoundListTag::new);
                        default -> throw UNKNOWN_TYPE.create(next.toLowerCase());
                    };
                }
                case '{' -> readCompound(reader);
                case '\'', '\"' -> StringTag.of(reader.readQuotedString());
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '+', '-' -> switch (reader.toString().toLowerCase().charAt(reader.toString().length() - 1)) {
                    case 'b' -> readByte(reader);
                    case 's' -> readShort(reader);
                    case 'i' -> readInt(reader);
                    case 'l' -> readLong(reader);
                    case 'f' -> readFloat(reader);
                    case 'd' -> readDouble(reader);
                    case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ->
                            reader.toString().contains(".") || reader.toString().contains("e") || reader.readDouble() > Long.MAX_VALUE ? readDouble(reader)
                                    : reader.readLong() > Integer.MAX_VALUE ? readLong(reader) : readInt(reader);
                    default -> throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.readerInvalidDouble().create(reader);
                };
                default -> Null.INSTANCE;
            };
        } catch (CommandSyntaxException e) {
            return Null.INSTANCE;
        }
    }
    
    static CompoundTag readCompound(StringReader reader) throws CommandSyntaxException {
        reader.expect('{');
        reader.skipWhitespace();
        CompoundTag tag = new CompoundTag();
        while (reader.peek() != '}') {
            String key = reader.readStringUntil(':');
            reader.skipWhitespace();
            reader.expect(':');
            reader.skipWhitespace();
            tag.put(key, read(reader));
            reader.skipWhitespace();
            if (reader.peek() == '}') break;
            reader.expect(',');
            reader.skipWhitespace();
        }
        return tag;
    }
    
    static ListTag readList(StringReader reader) throws CommandSyntaxException {
        reader.expect('[');
        reader.skipWhitespace();
        ListTag list = new ListTag();
        while (reader.peek() != ']') {
            list.add(read(reader));
            reader.skipWhitespace();
            if (reader.peek() == ']') break;
            reader.expect(',');
            reader.skipWhitespace();
        }
        return list;
    }
    
    @SuppressWarnings("unchecked")
    static <E, T extends Tag<E, T>, A extends AbstractArrayTag<E, T, A>> A readArray(StringReader reader) throws CommandSyntaxException {
        reader.expect('[');
        reader.skipWhitespace();
        A array;
        try {
            String type;
            array = switch (type = reader.readStringUntil(':')) {
                case "null" -> (A) new TypedListTag<Null, A>();
                case "b" -> (A) new ByteArrayTag();
                case "s" -> (A) new ShortArrayTag();
                case "i" -> (A) new IntArrayTag();
                case "L" -> (A) new LongArrayTag();
                case "f" -> (A) new FloatArrayTag();
                case "d" -> (A) new DoubleArrayTag();
                
                case "S" -> (A) new StringArrayTag();
                case "[]" -> (A) new ListListTag();
                case "{}" -> (A) new CompoundListTag();
                default -> throw UNKNOWN_TYPE.create(type);
            };
        } catch (ClassCastException e) {
            throw WRONG_TYPE.create(reader.toString(), '?');
        }
        String type = reader.readStringUntil(':');
        if (!Objects.equals(TAG_CODES[array.getItemId()], type)) throw TYPE_MISMATCH.create(type, TAG_CODES[array.getItemId()]);
        while (reader.peek() != ']') {
            try {
                array.add((E) read(reader));
            } catch (ClassCastException e) {
                throw WRONG_TYPE.create(e.getMessage(), TAG_CODES[array.getItemId()]);
            }
            reader.skipWhitespace();
            if (reader.peek() == ']') break;
            reader.expect(',');
            reader.skipWhitespace();
        }
        return array;
    }
    
    @SuppressWarnings("unchecked")
    static <E, T extends Tag<E, T>, A extends AbstractArrayTag<E, T>> A readArray(StringReader reader, Supplier<A> supplier) throws CommandSyntaxException {
        reader.expect('[');
        reader.skipWhitespace();
        A array = supplier.get();
        String type = reader.readStringUntil(':');
        if (!Objects.equals(TAG_CODES[array.getItemId()], type)) throw TYPE_MISMATCH.create(type, TAG_CODES[array.getItemId()]);
        while (reader.peek() != ']') {
            try {
                array.add((E) read(reader));
            } catch (ClassCastException e) {
                throw WRONG_TYPE.create(e.getMessage(), TAG_CODES[array.getItemId()]);
            }
            reader.skipWhitespace();
            if (reader.peek() == ']') break;
            reader.expect(',');
            reader.skipWhitespace();
        }
        return array;
    }
    
    static ByteTag readByte(StringReader reader) throws CommandSyntaxException {
        return ByteTag.of((byte) reader.readInt());
    }
    static ShortTag readShort(StringReader reader) throws CommandSyntaxException {
        return ShortTag.of((short) reader.readInt());
    }
    static IntTag readInt(StringReader reader) throws CommandSyntaxException {
        return IntTag.of(reader.readInt());
    }
    static LongTag readLong(StringReader reader) throws CommandSyntaxException {
        return LongTag.of(reader.readLong());
    }
    static FloatTag readFloat(StringReader reader) throws CommandSyntaxException {
        return FloatTag.of(reader.readFloat());
    }
    static DoubleTag readDouble(StringReader reader) throws CommandSyntaxException {
        return DoubleTag.of(reader.readDouble());
    }
    
    static boolean serialize(Tag<?, ?> tag, ByteBuf buffer) {
        buffer.markWriterIndex(); // mark the current position to reset to if the serialization fails
        boolean success = tag.serialize(buffer); // try to serialize the tag
        if (!success) buffer.resetWriterIndex(); // reset the position if the serialization fails
        return success;
    }
    static Tag<?, ?> deserialize(byte id, ByteBuf buffer) {
        checkReadable(buffer, "No tag data found");
        return switch (id) {
            case 0 -> Null.INSTANCE;
            case 1 -> ByteTag.of(buffer.readByte());
            case 2 -> ShortTag.of(buffer.readShort());
            case 3 -> IntTag.of(buffer.readInt());
            case 4 -> LongTag.of(buffer.readLong());
            case 5 -> FloatTag.of(buffer.readFloat());
            case 6 -> DoubleTag.of(buffer.readDouble());
            case 8 -> StringTag.of(buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString());
            case 9 -> ListTag.deserialize(buffer);
            case 10 -> CompoundTag.deserialize(buffer);
            case -1 -> End.INSTANCE;
            default -> throw new IllegalArgumentException("Invalid tag id: " + id);
        };
    }
    static Tag<?, ?> deserialize(ByteBuf buffer) {
        if (buffer.readableBytes() < 1) return End.INSTANCE;
        return deserialize(buffer.readByte(), buffer);
    }
    static ListTag deserializeList(ByteBuf buffer, byte id) {
        ListTag list = new ListTag();
        while (buffer.isReadable()) list.add(deserialize(id, buffer));
        return list;
    }
    static ListTag deserializeList(ByteBuf buffer) {
        ListTag list = new ListTag();
        while (buffer.isReadable()) list.add(deserialize(buffer));
        return list;
    }
    static CompoundTag deserializeCompound(ByteBuf buffer, byte id) {
        CompoundTag tag = new CompoundTag();
        while (buffer.isReadable()) {
            String key = buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
            tag.put(key, deserialize(id, buffer));
        }
        return tag;
    }
    static CompoundTag deserializeCompound(ByteBuf buffer) {
        CompoundTag tag = new CompoundTag();
        while (buffer.isReadable()) {
            byte id = buffer.readByte();
            if (id == -1) break;
            String key = buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
            tag.put(key, deserialize(id, buffer));
        }
        return tag;
    }
    
    @Singleton(Null.class)
    class Null implements Tag<Null, Null> {
        public static final Null INSTANCE = new Null();
        
        private Null() {}
        
        public static Null getInstance() {
            return INSTANCE;
        }
        
        @Override
        public String toTagString() {
            return "null";
        }
        
        @Override
        public byte getId() {
            return 0;
        }
        
        @Override
        public Object objectValue() {
            return null;
        }
        
        @Override
        public boolean serialize(ByteBuf buffer) {
            buffer.writeByte(0);
            return true;
        }
    }
    
    @Singleton(End.class)
    class End implements Tag<End, End> {
        public static final End INSTANCE = new End();
        
        private End() {}
        
        public static End getInstance() {
            return INSTANCE;
        }
        
        @Override
        public String toTagString() {
            return "";
        }
    
        @Override
        public byte getId() {
            return -1;
        }
        
        @Override
        public Object objectValue() {
            return null;
        }
        
        @Override
        public boolean serialize(ByteBuf buffer) {
            buffer.writeByte(-1);
            return true;
        }
    }
}
