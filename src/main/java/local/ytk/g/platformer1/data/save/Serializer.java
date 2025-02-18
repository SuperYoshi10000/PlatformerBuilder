package local.ytk.g.platformer1.data.save;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class Serializer {
    public static ByteBuf serialize(Serializable serializable) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(0);
        boolean success = serializable.serialize(buffer);
        if (!success) {
            buffer.release();
            return null;
        }
        return buffer;
    }
    
    public static void checkReadable(ByteBuf buffer) {
        if (!buffer.isReadable()) throw new IllegalArgumentException("Buffer is empty");
    }
    
    public static void checkReadable(ByteBuf buffer, int length) {
        if (buffer.readableBytes() < length) throw new IllegalArgumentException("Buffer is too short (must be at least " + length + " bytes, but is " + buffer.readableBytes() + " bytes)");
    }
    
    public static void checkReadable(ByteBuf buffer, String msg) {
        if (!buffer.isReadable()) throw new IllegalArgumentException(msg + " - Buffer is empty");
    }
    
    public static void checkReadable(ByteBuf buffer, int length, String msg) {
        if (buffer.readableBytes() < length) throw new IllegalArgumentException(msg + " - Buffer is too short (must be at least " + length + " bytes, but is " + buffer.readableBytes() + " bytes)");
    }
}