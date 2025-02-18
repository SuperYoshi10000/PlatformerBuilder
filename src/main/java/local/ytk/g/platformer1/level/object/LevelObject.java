package local.ytk.g.platformer1.level.object;

import com.jme3.scene.Node;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.time.Tickable;

public interface LevelObject extends Tickable {
    LevelInstance getLevelInstance();
    
    Node node();
    
    default <V> void setProperty(ObjectProperty.Value<?, V> propertyValue) {
        setProperty(propertyValue.property(), propertyValue.value());
    }
    <V> void setProperty(ObjectProperty<?, V> property, V value);
    
    default ObjectID getId() {
        return getLevelInstance().getObjects().inverse().get(this);
    }
}
