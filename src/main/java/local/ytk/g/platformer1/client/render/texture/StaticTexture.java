package local.ytk.g.platformer1.client.render.texture;

public class StaticTexture extends Texture {
    protected final Void image;
    public int id;
    public String type;

    @Override
    public StaticTexture image() {
        return this;
    }

    public StaticTexture(Void image) {
        this.image = image;
    }
}
