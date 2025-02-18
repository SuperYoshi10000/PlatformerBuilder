package local.ytk.g.platformer1.data.save;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufConvertible;

@com.jme3.network.serializing.Serializable
public interface Serializable extends ByteBufConvertible {
    boolean serialize(ByteBuf buffer);
    
    @Override
    default ByteBuf asByteBuf() {
        return Serializer.serialize(this);
    }
}
