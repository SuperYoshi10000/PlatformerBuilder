package local.ytk.g.platformer1.level.object;

import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.math.Transform;

import javax.annotation.Nullable;

public record ObjectPlacer<O extends LevelObject, T extends ObjectType<O>>(LevelInstance level, @Nullable ObjectBuilder<O, T> objectBuilder) {
    public ObjectPlacer<O, T> place(T object, Transform transform) {
        level.place(object, transform);
        return this;
    }
    
    public ObjectPlacer<O, T> place(ObjectData<O, T> objectData, Transform transform) {
        if (objectBuilder != null) level.place(objectBuilder.apply(objectData), transform);
        return this;
    }
}
