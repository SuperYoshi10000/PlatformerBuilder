package local.ytk.g.platformer1.client.render.model;

import local.ytk.g.platformer1.client.render.Renderable;
import local.ytk.g.platformer1.client.render.Screen;
import local.ytk.g.platformer1.level.phys.Position3d;
import local.ytk.g.platformer1.level.time.Tickable;

public interface ModelInstance extends Tickable, Renderable {
    public void render(Screen screen, Position3d position);
    public default void tick() {}
}
