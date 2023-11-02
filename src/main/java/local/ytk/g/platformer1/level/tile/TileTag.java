package local.ytk.g.platformer1.level.tile;

import java.util.List;
import java.util.ArrayList;
import local.ytk.g.platformer1.data.ResourceName;

public class TileTag<T extends Tile<?>> {
    public static final TileTag<?> EMPTY = new TileTag<>(new ResourceName("%game%:empty"));
    public static final TileTag<?> SOLID = new TileTag<>(new ResourceName("%game%:solid"));

    public final ResourceName id;
    public final ArrayList<T> tiles = new ArrayList<>();
    public TileTag(ResourceName id) {
        this.id = id;
    }

    public TileTag<T> addTile(T newTile) {
        tiles.add(newTile);
        return this;
    }
    public TileTag<T> addTiles(T[] newTiles) {
        tiles.addAll(List.of(newTiles));
        return this;
    }
    public boolean isValid(Tile<?> tile) {
        return tiles.contains(tile);
    }
}
