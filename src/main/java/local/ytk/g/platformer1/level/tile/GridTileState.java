package local.ytk.g.platformer1.level.tile;

import local.ytk.g.platformer1.math.GridPosition3d;

public class GridTileState extends GridPosition3d implements TileState<GridTileState> {
    public final GridTile tile;

    public GridTileState(GridTile tile) {
        this.tile = tile;
    }

    @Override
    public GridTile getTile() {
        return tile;
    }
}
