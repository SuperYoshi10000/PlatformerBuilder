package local.ytk.g.platformer1.level.object;

import java.util.function.Function;

@FunctionalInterface
public interface ObjectBuilder<O extends LevelObject, T extends ObjectType<O>> extends Function<ObjectData<O, T>, O> {
    @Override
    default O apply(ObjectData<O, T> objectData) {
        return build(objectData);
    }
    O build(ObjectData<O, T> objectData);
}
