package local.ytk.g.platformer1.level.object;

@FunctionalInterface
public interface ObjectProperty<O extends LevelObject, T> {
    O applyTo(O levelObject, T value);
    
    record Value<O extends LevelObject, T>(ObjectProperty<O, T> property, T value) {
        O applyTo(O levelObject) {
            levelObject.setProperty(property, value);
            return levelObject;
        }
        
        @Override
        public String toString() {
            return "ObjectProperty.Value(" + property + ": " + value + ')';
        }
    }
}
