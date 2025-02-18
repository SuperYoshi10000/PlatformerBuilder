package local.ytk.g.platformer1.data.tag;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static local.ytk.g.platformer1.data.save.Serializer.checkReadable;

public class CompoundTag extends MapTag<Tag<?, ?>, CompoundTag> {
    private static final byte TYPE = 10;
    
    @Override
    public byte getId() {
        return TYPE;
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
    public CompoundTag objectValue() {
        return this;
    }
    
    @Override
    public boolean serialize(ByteBuf buffer) {
        buffer.writeInt(size());
        for (Map.Entry<String, Tag<?, ?>> entry : entrySet()) {
            buffer.writeByte(entry.getValue().getId());
            buffer.writeCharSequence(entry.getKey(), StandardCharsets.UTF_8);
            if (!entry.getValue().serialize(buffer)) return false;
        }
        buffer.writeByte(END);
        return true;
    }
    
    public static CompoundTag deserialize(ByteBuf buffer) {
        checkReadable(buffer, "No compound tag size");
        int size = buffer.readInt();
        CompoundTag tag = new CompoundTag();
        for (int i = 0; i < size; i++) {
            checkReadable(buffer, "Missing compound tag element");
            byte id = buffer.readByte();
            int len = buffer.readInt();
            String key = buffer.readCharSequence(len, StandardCharsets.UTF_8).toString();
            if (key.length() < len) throw new IllegalArgumentException("Invalid key length");
            Tag<?, ?> value = Tag.deserialize(id, buffer);
            tag.put(key, value);
        }
        return tag;
    }
    
    public static final CompoundTag EMPTY = new CompoundTag() {
        @Override
        public Tag<?, ?> put(String key, Tag value) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        @Override
        public void putAll(Map<? extends String, ? extends Tag<?, ?>> m) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        @Override
        public Tag<?, ?> remove(Object key) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        @Override
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        
        @Override
        public Tag<?, ?> merge(String key, Tag<?, ?> value, BiFunction<? super Tag<?, ?>, ? super Tag<?, ?>, ? extends Tag<?, ?>> remappingFunction) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        
        @Override
        public CompoundTag reversed() {
            return this;
        }
        
        @Override
        public Tag<?, ?> compute(String key, BiFunction<? super String, ? super Tag<?, ?>, ? extends Tag<?, ?>> remappingFunction) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        @Override
        public Tag<?, ?> computeIfAbsent(String key, Function<? super String, ? extends Tag<?, ?>> mappingFunction) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        @Override
        public Tag<?, ?> computeIfPresent(String key, BiFunction<? super String, ? super Tag<?, ?>, ? extends Tag<?, ?>> remappingFunction) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        
        @Override
        public Tag<?, ?> replace(String key, Tag value) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        @Override
        public void replaceAll(BiFunction<? super String, ? super Tag<?, ?>, ? extends Tag<?, ?>> function) {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
        
        @Override
        public void clear() {
            throw new UnsupportedOperationException("Cannot modify empty compound");
        }
    };
    
    static CompoundTag fromString(String str) {
        try {
            return Tag.readCompound(new StringReader(str));
        } catch (CommandSyntaxException e) {
            return null;
        }
    }
}
