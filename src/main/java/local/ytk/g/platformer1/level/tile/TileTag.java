package local.ytk.g.platformer1.level.tile;

import java.util.List;
import java.util.ArrayList;
import local.ytk.g.platformer1.data.Identifier;

public class TileTag<T extends Tile<?>> {
    public static final TileTag<?> EMPTY = new TileTag<>(new Identifier("%game%:empty"));
    public static final TileTag<?> SOLID = new TileTag<>(new Identifier("%game%:solid"));

    public final Identifier id;
    public final ArrayList<T> tiles = new ArrayList<>();
    public TileTag(Identifier id) {
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
