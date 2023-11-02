package local.ytk.g.platformer1.client.render.model;

import local.ytk.g.platformer1.client.render.Screen;
import local.ytk.g.platformer1.client.render.texture.Texture;
import local.ytk.g.platformer1.level.phys.Position3d;

public class StaticModel implements Model, ModelInstance {
    public StaticModel() {
        super();
    }

    @Override
    public void render(Screen screen, Position3d position) {
        screen.renderOnWindow(this, position);
    }

    @Override
    public void tick() {}

    @Override
    public ModelInstance instance() {
        return new TexturedModel(Texture.BLANK);
    }
    public ModelInstance instance(Texture texture) {
        return new TexturedModel(texture);
    }

    public class TexturedModel extends StaticModel {
        public final Texture texture;
        public TexturedModel(Texture texture) {
            super();
            this.texture = texture;
        }
        @Override
        public void render(Screen screen, Position3d position) {
            screen.renderOnWindow(null, position);
        }
    }
}
