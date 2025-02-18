package local.ytk.g.platformer1.level.object;

import com.jme3.asset.AssetManager;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.math.Transform;

import java.util.LinkedList;

public class ObjectDataImpl<O extends LevelObject, P extends ObjectType<O>> implements ObjectData<O, P> {
    protected final LinkedList<ObjectProperty.Value<O, ?>> objectData = new LinkedList<>();
    protected final ObjectType<O> objectType;
    protected final LevelInstance instance;
    protected final Transform transform;
    protected final AssetManager manager;
    
    protected ObjectDataImpl(ObjectType<O> objectType, LevelInstance instance, Transform transform, AssetManager manager) {
        this.objectType = objectType;
        this.instance = instance;
        this.transform = transform;
        this.manager = manager;
    }
    
    @Override
    public <T> ObjectData<O, P> setProperty(ObjectProperty.Value<O, T> propertyValue) {
        objectData.add(propertyValue);
        return this;
    }
    @Override
    public <T> ObjectData<O, P> setProperty(ObjectProperty<O, T> property, T value) {
        objectData.add(new ObjectProperty.Value<>(property, value));
        return this;
    }
    
    @Override
    public O createObject() {
        O levelObject = objectType.create(instance, transform, manager);
        objectData.forEach(levelObject::setProperty);
        return levelObject;
    }
}
