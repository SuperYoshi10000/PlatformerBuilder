package local.ytk.g.platformer1.level.object;

public interface ObjectData<O extends LevelObject, T extends ObjectType<O>> {
    default <V> ObjectData<O, T> setProperty(ObjectProperty.Value<O, V> propertyValue) {
        return setProperty(propertyValue.property(), propertyValue.value());
    }
    
    <V> ObjectData<O, T> setProperty(ObjectProperty<O, V> property, V value);
    
    O createObject();
}
