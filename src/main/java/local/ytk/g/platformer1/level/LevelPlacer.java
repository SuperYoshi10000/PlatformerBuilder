package local.ytk.g.platformer1.level;

import local.ytk.g.platformer1.level.entity.PlaceableObject;
import local.ytk.g.platformer1.level.phys.Position3d;

public class LevelPlacer<O extends LevelObject, P extends PlaceableObject<O>> {
    public final LevelInstance level;
    public LevelPlacer(LevelInstance level) {
        this.level = level;
    }
    public void place(PlaceableObject<O> object, Position3d position) {
        level.place(object, position);
    }
}