package local.ytk.g.platformer1.client.render;

import local.ytk.g.platformer1.client.render.model.StaticModel;
import local.ytk.g.platformer1.client.window.GameWindow;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.LevelObject;
import local.ytk.g.platformer1.level.phys.Direction;
import local.ytk.g.platformer1.level.phys.Position3d;

public class Screen implements LevelObject {
    public final LevelInstance level;
    public final GameWindow window;
    public final Position3d cameraPostion = new Position3d(0);
    public final Direction cameraAngle = new Direction();
    public Screen(LevelInstance level, GameWindow window) {
        this.level = level;
        this.window = window;
    }
    
    public void render(Renderable r, Position3d position) {
        r.render(this, position);
    }
    public void renderOnWindow(StaticModel r, Position3d position) {
        window.render(r, this, position);
    }

    @Override
    public LevelInstance getLevel() {
        return level;
    }

}
