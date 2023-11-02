package local.ytk.g.platformer1.level.layout;

import java.util.ArrayList;
import local.ytk.g.platformer1.level.phys.GridPosition2d;
import local.ytk.g.platformer1.level.phys.GridPosition3d;
import local.ytk.g.platformer1.level.tile.GridTile;

public class Grid3d extends Grid2d {
    public final int depth;
    public final ArrayList<ArrayList<ArrayList<GridTile>>> tiles;

    public Grid3d(int width, int height, int depth) {
        super(width, height);
        tiles = new ArrayList<>();
        this.depth = depth;
    }
    


    @Override
    @Deprecated
    /** @deprecated
     * Please do not use this, it may not give you the results you want...
     */
    public GridTile getAt(GridPosition2d pos) {
        return tiles.get(depth / 2).get(pos.y).get(pos.x);
    }
    public GridTile getAt(GridPosition3d pos) {
        return tiles.get(pos.z).get(pos.y).get(pos.x);
    }

    public void addTile(GridPosition3d pos, GridTile tile) {
        ArrayList<GridTile> row = getOrCreateRow(getOrCreatePlane(tiles, pos.z), pos.y);
        expandToFitTile(row, pos.x);
        row.set(pos.x, tile);
    }
}
