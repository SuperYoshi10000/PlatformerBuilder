package local.ytk.g.platformer1.client.render;

import com.jme3.scene.Node;
import local.ytk.g.platformer1.client.window.GameWindow;
import local.ytk.g.platformer1.level.LevelInstance;
import local.ytk.g.platformer1.level.object.LevelObject;
import local.ytk.g.platformer1.math.Direction;
import local.ytk.g.platformer1.math.Position3d;
import local.ytk.g.platformer1.level.object.ObjectProperty;

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

    @Override
    public LevelInstance getLevelInstance() {
        return level;
    }

    @Override
    public Node node() {
        return null;
    }
    
    @Override
    public <T> void setProperty(ObjectProperty<?, T> property, T value) {
    
    }
    
    @Override
    public void tick() {
    
    }
}
