package local.ytk.g.platformer1.client.render.texture;

import local.ytk.g.platformer1.level.time.Tickable;

public interface Animation<T> extends Tickable {
    public T[] frames();
    public int frameCount();
    public int frame();
    public void nextFrame();

    public default T get() {
        return frames()[frame()];
    }
}
