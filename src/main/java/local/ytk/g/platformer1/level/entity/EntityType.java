package local.ytk.g.platformer1.level.entity;

import java.util.function.Function;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;

import local.ytk.g.platformer1.client.render.model.ModelData;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.object.ObjectData;
import local.ytk.g.platformer1.level.object.ObjectPlacer;
import local.ytk.g.platformer1.math.Transform;
import local.ytk.g.platformer1.level.object.ObjectType;

public abstract class EntityType<E extends GameEntity> implements ObjectType<E> {
    protected final Function<LevelInstance, E> getter;
    public ModelData.ModelLoader model;

    public EntityType(Function<LevelInstance, E> getter) {
        this.getter = getter;
    }
    public E create(LevelInstance level, Transform transform, AssetManager assetManager) {
        E entity = getter.apply(level);
        entity.model = model.loadTo(assetManager, level.rootNode());
        return entity;
    }
    public static ObjectPlacer<GameEntity, EntityType<GameEntity>> placer(LevelInstance instance, Node rootNode) {
        return new ObjectPlacer<>(instance, ObjectData::createObject);
    }
    
}
