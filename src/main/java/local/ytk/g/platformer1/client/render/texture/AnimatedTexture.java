package local.ytk.g.platformer1.client.render.texture;

public class AnimatedTexture extends Texture implements Animation<StaticTexture> {
    @Override
    public StaticTexture image() {
        return get();
    }

    public AnimatedTexture(StaticTexture... images) {
        frames = images;
    }

    protected StaticTexture[] frames;
    protected int frameCount;
    protected int frame;

    @Override
    public StaticTexture[] frames() {
        return frames;
    }

    @Override
    public int frameCount() {
        return frameCount;
    }

    @Override
    public int frame() {
        return frame;
    }

    @Override
    public void nextFrame() {
        frame = (frame() + 1) % frameCount();
    }

    @Override
    public void tick() {
        nextFrame();
    }
}
