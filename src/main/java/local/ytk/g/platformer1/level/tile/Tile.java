package local.ytk.g.platformer1.level.tile;

import local.ytk.g.platformer1.level.object.LevelObject;
import local.ytk.g.platformer1.level.TileLevel;

public interface Tile<S> extends LevelObject {
    S newState();
    TileLevel getTileLevel();
}
