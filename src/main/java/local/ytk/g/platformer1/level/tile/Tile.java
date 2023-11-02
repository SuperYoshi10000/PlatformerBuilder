package local.ytk.g.platformer1.level.tile;

import local.ytk.g.platformer1.client.render.model.Model;
import local.ytk.g.platformer1.level.LevelObject;
import local.ytk.g.platformer1.level.TileLevel;

public interface Tile<S> extends LevelObject {
    public void setModel(Model model);
    public Model getModel();
    public S newState(); 
    public TileLevel getTileLevel();
}
