package local.ytk.g.platformer1.level.tile;

import local.ytk.g.platformer1.client.render.model.Model;
import local.ytk.g.platformer1.data.ResourceName;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.TileLevel;
import local.ytk.g.platformer1.level.phys.Position3d;

public class FloatingTile extends Position3d implements Tile<FloatingTileState> {
    public LevelInstance level;
    public Model model;
    public final ResourceName id;
    public LevelInstance getLevel() {
        return level;
    }
    
    public FloatingTile(ResourceName id) {
        super(0);
        this.id = id;
    }

    public FloatingTile(String id) {
        this(new ResourceName(id));
    }

    @Override
    public void tick() {
        super.tick();
    }
    @Override
    public void setModel(Model model) {
        this.model = model;
    }
    @Override
    public Model getModel() {
        return model;
    }
    @Override
    public FloatingTileState newState() {
        return new FloatingTileState(this);
    }

    @Override
    public TileLevel getTileLevel() {
        return null;
    }
}
