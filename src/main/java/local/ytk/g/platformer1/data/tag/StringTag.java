package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static local.ytk.g.platformer1.data.save.Serializer.checkReadable;

public record StringTag(String value) implements Tag<String, StringTag> {
    public static final byte TYPE = 8;
    public static final StringTag EMPTY = new StringTag("");
    
    public static StringTag of() {
        return EMPTY;
    }
    public static StringTag of(Object value) {
        return new StringTag(String.valueOf(value));
    }
    public static StringTag of(char c) {
        return new StringTag(String.valueOf(c));
    }
    public static StringTag of(char[] chars) {
        return new StringTag(new String(chars));
    }
    public static StringTag of(String string) {
        return new StringTag(string);
    }
    
    public static StringTag ofEscaped(String string) {
        // If the string is quoted, remove the quotes
        // Any characters are allowed inside a quoted string
        if (string.startsWith("\"") && string.endsWith("\"")) return new StringTag(string.substring(1, string.length() - 1));
        // An unquoted string must be an "identifier" (but with a few extra characters allowed)
        if (string.matches("[^\\w$+-]")) throw new IllegalArgumentException("Invalid string: " + string);
        return new StringTag(string.translateEscapes());
    }
    
    public boolean equals(Object value) {
        return value instanceof StringTag tag && Objects.equals(this.value, tag.value);
    }
    
    public String toString() {
        return value;
    }
    
    public String toTagString() {
        return "\"" + encodeEscapes(value) + "\"";
    }
    
    @Override
    public byte getId() {
        return TYPE;
    }
    
    @Override
    public String objectValue() {
        return value;
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(value.length());
        buffer.writeCharSequence(value, StandardCharsets.UTF_8);
        return true;
    }
    
    public static String readString(ByteBuf buffer) {
        return buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
    }
    
    public static StringTag deserialize(ByteBuf buffer) {
        checkReadable(buffer, "No string found");
        int len = buffer.readInt();
        return new StringTag(buffer.readCharSequence(len, StandardCharsets.UTF_8).toString());
    }
    
    public static String encodeEscapes(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(switch (c) {
                case '\0', '\1', '\2', '\3', '\4', '\5', '\6', '\7' -> "\\" + (char)(c + 0x30);
                case '\b' -> "\\b";
                case '\t' -> "\\t";
                case '\n' -> "\\n";
                case '\f' -> "\\f";
                case '\r' -> "\\r";
                case '\'' -> "\\'";
                case '\"' -> "\\\"";
                case '\\' -> "\\\\";
                default -> Character.toString(c);
            });
        }
        return sb.toString();
    }
    
    public boolean truthy() {
        return truthy(value);
    }
    public static boolean truthy(String s) {
        return !s.isEmpty() && !s.equals("0") && !s.equalsIgnoreCase("false");
    }
}
