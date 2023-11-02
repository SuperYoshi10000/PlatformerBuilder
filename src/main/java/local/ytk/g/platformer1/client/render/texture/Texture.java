package local.ytk.g.platformer1.client.render.texture;

import local.ytk.g.platformer1.level.phys.GridPosition2d;

public abstract class Texture {
    public static final Texture BLANK = new StaticTexture(null);

    public abstract StaticTexture image();

    public class Mapping {
        GridPosition2d min;
        GridPosition2d max;
    }
}
