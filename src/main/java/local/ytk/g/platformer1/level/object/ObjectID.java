package local.ytk.g.platformer1.level.object;

import local.ytk.g.platformer1.data.Identifier;

import java.util.UUID;

public record ObjectID(UUID uuid, String name) {
    public ObjectID(UUID uuid) {
        this(uuid, uuid.toString());
    }
    public ObjectID(String name) {
        this(UUID.nameUUIDFromBytes(name.getBytes()), name);
    }
    public ObjectID(Object obj) {
        this(obj.toString());
    }
    public ObjectID() {
        this(UUID.randomUUID());
    }
    
    @Override
    public String toString() {
        return "ObjectID{" + uuid + "} : " + name;
    }
}
