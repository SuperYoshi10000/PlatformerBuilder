package local.ytk.g.platformer1.level.object;

import com.jme3.scene.Node;
import local.ytk.g.platformer1.level.LevelInstance;

public abstract class AbstractLevelObject implements LevelObject {
    public AbstractLevelObject(LevelInstance instance) {
        this.instance = instance;
        this.node = new Node();
    }
    
    protected final LevelInstance instance;
    protected final Node node;
    
    @Override
    public LevelInstance getLevelInstance() {
        return instance;
    }
    
    @Override
    public Node node() {
        return node;
    }
    
    @Override
    public <V> void setProperty(ObjectProperty<?, V> property, V value) {}
    
    @Override
    public void tick() {}
}
