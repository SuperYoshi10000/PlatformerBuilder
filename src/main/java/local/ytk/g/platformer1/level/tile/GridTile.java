package local.ytk.g.platformer1.level.tile;

import com.jme3.scene.Node;
import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.level.TileLevel;
import local.ytk.g.platformer1.level.object.ObjectProperty;

public class GridTile implements Tile<GridTileState> {
    public TileLevel level;
    public final Identifier id;

    public TileLevel getLevelInstance() {
        return level;
    }
    
    public GridTile(Identifier id) {
        this.id = id;
    }

    public GridTile(String id) {
        this(new Identifier(id));
    }

    public void tick() {}
    @Override
    public GridTileState newState() {
        return new GridTileState(this);
    }

    @Override
    public TileLevel getTileLevel() {
        return null;
    }

    public Node node;
    @Override
    public Node node() {
        return node;
    }
    
    @Override
    public <T> void setProperty(ObjectProperty<?, T> property, T value) {
    
    }
}
