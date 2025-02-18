package local.ytk.g.platformer1.level.object.type;

import com.google.common.collect.HashBiMap;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.object.AbstractLevelObject;
import local.ytk.g.platformer1.level.object.LevelObject;
import local.ytk.g.platformer1.level.object.ObjectID;
import local.ytk.util.collection.Mapper;

import java.util.Map;

public class LevelObjectContainer extends AbstractLevelObject {
    protected final Map<ObjectID, LevelObject> map;
    
    public LevelObjectContainer(LevelInstance instance, Map<ObjectID, LevelObject> map) {
        super(instance);
        this.map = map;
    }
    
    public Map<ObjectID, LevelObject> getObjects() {
        return map;
    }
    public Map<ObjectID, LevelObject> getObjectCopies() {
        return Mapper.mapMapSized(map, ObjectID::new, o -> o, HashBiMap::create);
    }
    
    @Override
    public LevelInstance getLevelInstance() {
        return null;
    }
    
}
