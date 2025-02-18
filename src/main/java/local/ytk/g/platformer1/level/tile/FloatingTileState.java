package local.ytk.g.platformer1.level.tile;

import local.ytk.g.platformer1.math.Position3d;

public class FloatingTileState extends Position3d implements TileState<FloatingTileState> {
    public final FloatingTile tile;

    public FloatingTileState(FloatingTile tile) {
        super(0);
        this.tile = tile;
    }

    @Override
    public FloatingTile getTile() {
        return tile;
    }
}