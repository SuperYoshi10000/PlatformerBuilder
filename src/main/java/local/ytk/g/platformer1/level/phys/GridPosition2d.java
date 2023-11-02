package local.ytk.g.platformer1.level.phys;

import org.joml.Vector2d;

import local.ytk.g.platformer1.level.layout.Grid2d;
import local.ytk.g.platformer1.level.tile.GridTile;

public class GridPosition2d {
    public int x;
    public int y;
    public Vector2d getCorner() {
        return new Position2d(0).add(x, y);
    }
    public Vector2d getCenter() {
        return new Position2d(0).add(x + 0.5, y + 0.5);
    }
    public GridTile getFor(Grid2d grid) {
        return grid.getAt(this);
    }
}
