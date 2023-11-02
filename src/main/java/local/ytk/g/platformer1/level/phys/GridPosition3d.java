package local.ytk.g.platformer1.level.phys;

import org.joml.Vector3d;

import local.ytk.g.platformer1.level.layout.Grid3d;
import local.ytk.g.platformer1.level.tile.GridTile;

public class GridPosition3d {
    public int x;
    public int y;
    public int z;
    public Vector3d getCorner() {
        return new Position3d(0).add(x, y, z);
    }
    public Vector3d getCenter() {
        return new Position3d(0).add(z + 0.5, y + 0.5, z + 0.5);
    }
    public GridTile getFor(Grid3d grid) {
        return grid.getAt(this);
    }
}
