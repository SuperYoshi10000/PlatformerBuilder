package local.ytk.g.platformer1.level.tile;

import local.ytk.g.platformer1.client.render.model.Model;
import local.ytk.g.platformer1.data.ResourceName;
import local.ytk.g.platformer1.level.TileLevel;

public class GridTile implements Tile<GridTileState> {
    public TileLevel level;
    public Model model;
    public final ResourceName id;
    public TileLevel getLevel() {
        return level;
    }
    
    public GridTile(ResourceName id) {
        this.id = id;
    }

    public GridTile(String id) {
        this(new ResourceName(id));
    }

    public void tick() {}
    @Override
    public void setModel(Model model) {
        this.model = model;
    }
    @Override
    public Model getModel() {
        return model;
    }
    @Override
    public GridTileState newState() {
        return new GridTileState(this);
    }

    @Override
    public TileLevel getTileLevel() {
        return null;
    }
}
