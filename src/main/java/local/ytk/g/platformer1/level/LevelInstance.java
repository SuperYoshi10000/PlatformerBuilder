package local.ytk.g.platformer1.level;

import com.google.common.collect.HashBiMap;
import com.jme3.input.ChaseCamera;
import com.jme3.scene.Node;
import local.ytk.g.platformer1.Platformer1;
import local.ytk.g.platformer1.client.window.GameLevelWindow;
import local.ytk.g.platformer1.math.Transform;
import local.ytk.g.platformer1.level.object.*;
import local.ytk.g.platformer1.level.object.type.LevelObjectContainer;
import local.ytk.util.FlaggedCloseable;
import local.ytk.util.collection.CollectionUtils;
import local.ytk.util.collection.Mapper;

import java.util.Collection;
import java.util.Map;

import static local.ytk.g.platformer1.Assets.assetManager;

public class LevelInstance implements FlaggedCloseable {
    protected final HashBiMap<ObjectID, LevelObject> levelObjects = HashBiMap.create(64);
    protected final Node rootNode = new Node();
    public final Level level;
    public LevelInstance(Level level) {
        this.level = level;
    }
    
    public Node rootNode() {
        return rootNode;
    }
    
    public void place(LevelObject object, Transform transform) {
        levelObjects.put(new ObjectID(object), object);
        
    }
    public void place(ObjectData<?, ?> object, Transform transform) {
        place(object.createObject(), transform);
    }
    public void place(ObjectType<?> object, Transform transform) {
        levelObjects.put(new ObjectID(object.getName()), object.create(this, transform, assetManager()));
    }
    
    public LevelObject placeAll(Collection<LevelObject> objects) {
        Map<ObjectID, LevelObject> map = CollectionUtils.asMapValues(objects, ObjectID::new);
        levelObjects.putAll(map);
        return new LevelObjectContainer(this, map);
    }
    public LevelObject placeAll(Map<ObjectID, LevelObject> objects) {
        levelObjects.putAll(objects);
        return new LevelObjectContainer(this, objects);
    }
    
    public HashBiMap<ObjectID, LevelObject> getObjects() {
        return levelObjects;
    }
    public HashBiMap<ObjectID, LevelObject> getObjectCopies() {
        return Mapper.mapMap(levelObjects, ObjectID::new, o -> o, HashBiMap::create);
    }
    
    public Node node(String name) {
        Node node = new Node(name);
        rootNode.attachChild(node);
        return node;
    }
    public GameLevelWindow createWindow(Platformer1 app) {
        return new GameLevelWindow(this, app.getCamera(), app.getFlyByCamera(), new ChaseCamera(app.getCamera()));
    }

    public <O extends LevelObject, P extends ObjectType<O>> ObjectPlacer<O, P> objectPlacer() {
        return new ObjectPlacer<>(this, null);
    }
    public <O extends LevelObject, P extends ObjectType<O>> ObjectPlacer<O, P> objectPlacer(ObjectBuilder<O, P> objectBuilder) {
        return new ObjectPlacer<>(this, objectBuilder);
    }
    
    @Override
    public String toString() {
        return "LevelInstance{level=%s%s}".formatted(level, closed ? ";closed" : "");
    }
    
    protected boolean closed;
    @Override
    public void close() {
        closed = true;
    }
    @Override
    public boolean isClosed() {
        return closed;
    }
}
