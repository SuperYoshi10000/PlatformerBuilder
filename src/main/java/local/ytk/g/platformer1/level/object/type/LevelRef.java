package local.ytk.g.platformer1.level.object.type;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.jme3.asset.AssetManager;
import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.level.Level;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.math.Transform;
import local.ytk.g.platformer1.level.object.LevelObject;
import local.ytk.g.platformer1.level.object.ObjectType;

public class LevelRef implements ObjectType<LevelObject> {
    protected final Level level;
    
    public LevelRef(Level level) {
        this.level = level;
    }
    
    @Override
    public LevelObject create(LevelInstance instance, Transform transform, AssetManager assetManager) {
        try (LevelInstance newInstance = this.level.instance()) {
            return instance.placeAll(newInstance.getObjects());
        } catch (Exception e) {
            return new LevelObjectContainer(instance, ImmutableBiMap.of());
        }
    }
    
    @Override
    public Identifier getName() {
        return Identifier.ofDefault("reference");
    }
}
