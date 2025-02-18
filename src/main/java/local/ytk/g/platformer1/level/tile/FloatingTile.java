package local.ytk.g.platformer1.level.tile;

import com.jme3.scene.Node;
import local.ytk.g.platformer1.data.Identifier;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.TileLevel;
import local.ytk.g.platformer1.math.Position3d;
import local.ytk.g.platformer1.level.object.ObjectProperty;

public class FloatingTile extends Position3d implements Tile<FloatingTileState> {
    public LevelInstance level;
    public final Identifier id;
    public LevelInstance getLevelInstance() {
        return level;
    }
    
    public FloatingTile(Identifier id) {
        super(0);
        this.id = id;
    }

    public FloatingTile(String id) {
        this(new Identifier(id));
    }

    @Override
    public void tick() {
        super.tick();
    }
    @Override
    public FloatingTileState newState() {
        return new FloatingTileState(this);
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
