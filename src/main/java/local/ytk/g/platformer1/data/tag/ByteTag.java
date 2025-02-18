package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;
import local.ytk.util.math.ArrayRange;
import org.jetbrains.annotations.NotNull;

public class ByteTag extends NumericTag<Byte, ByteTag> {
    public static final byte TYPE = 1;
    
    private final byte value;
    ByteTag(byte value) {
        this.value = value;
    }
    public byte getValue() {
        return value;
    }
    public boolean getBooleanValue() {
        return value != 0;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    public static ByteTag of(byte value) {
        return cache[value % 256];
    }
    public static ByteTag of(boolean value) {
        return value ? ONE : ZERO;
    }
    public static ByteTag of(char c) {
        return of((byte) c);
    }
    public static ByteTag of(@NotNull String s) {
        return s.equals("false") ? FALSE : s.equals("true") ? TRUE : of(Byte.parseByte(s));
    }
    public static ByteTag ofByte(@NotNull String s) {
        return of(Byte.parseByte(s));
    }
    public static ByteTag ofBoolean(@NotNull String s) {
        return of(Boolean.parseBoolean(s));
    }
    public static ByteTag ofChar(@NotNull String s) {
        return of(s.charAt(0));
    }
    public static ByteTag of(@NotNull Number n) {
        return of(n.byteValue());
    }
    public static ByteTag of(@NotNull Object o) {
        return of(Byte.parseByte(o.toString()));
    }
    public static ByteTag deserialize(@NotNull ByteBuf buffer) {
        return of(buffer.readByte());
    }
    
    static final ByteTag[] cache = ArrayRange.generate(ByteTag[]::new, 256, n -> new ByteTag((byte) n));
    public static final ByteTag ZERO = cache[0];
    public static final ByteTag ONE  = cache[1];
    public static final ByteTag NEGATIVE_ONE = cache[255];
    public static final ByteTag FALSE = ZERO;
    public static final ByteTag TRUE  = ONE;

    public byte getId() {
        return TYPE;
    }
    
    @Override
    public Byte objectValue() {
        return value;
    }
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeByte(value);
        return true;
    }
}
