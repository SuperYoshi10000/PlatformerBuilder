package local.ytk.g.platformer1.data.tag;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class TypedMapTag<V, T extends Tag<V, T>, M extends TypedMapTag<V, T, M>> extends MapTag<T, M> {
    public static final byte MAP_TYPE_OFFSET = 32;
    @Override
    public byte getId() {
        return (byte)(MAP_TYPE_OFFSET + getItemId());
    }
    public byte getItemId() {
        return size() > 0 ? firstEntry().getValue().getId() : 0;
    }
    
    @Override
    public String toTagString() {
        StringBuilder sb = new StringBuilder().append("{");
        List<String> tagNames = List.copyOf(keySet());
        for (int i = 0; i < tagNames.size(); i++) {
            String tagName = tagNames.get(i);
            if (i > 0) sb.append(", ");
            sb.append(tagName.matches("[^\\w$+\\-]") ? tagName.replace("\\", "\\\\").replace("\"", "\\\"") : tagName).append(": ").append(get(tagName));
        }
        return sb.append("}").toString();
    }
    
    @Override
    public TypedMapTag<V, T, M> objectValue() {
        return this;
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeByte(getItemId());
        buffer.writeInt(size());
        for (Map.Entry<String, T> entry : entrySet()) {
            buffer.writeCharSequence(entry.getKey(), StandardCharsets.UTF_8);
            if (!entry.getValue().serialize(buffer)) return false;
        }
        buffer.writeByte(END);
        return true;
    }
    
    public static <V, T extends Tag<V, T>, M extends TypedMapTag<V, T, M>> TypedMapTag<V, T, M> deserialize(ByteBuf buffer) {
        int size = buffer.readInt();
        TypedMapTag<V, T, M> tag = new TypedMapTag<>();
        try {
            for (int i = 0; i < size; i++) {
                int len = buffer.readInt();
                String key = buffer.readCharSequence(len, StandardCharsets.UTF_8).toString();
                @SuppressWarnings("unchecked")
                T value = (T) Tag.deserialize(buffer);
                tag.put(key, value);
            }
            return tag;
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }
}
