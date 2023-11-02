package local.ytk.g.platformer1.client.render.model;

import java.util.Arrays;

import local.ytk.g.platformer1.client.render.Screen;
import local.ytk.g.platformer1.client.render.texture.Animation;
import local.ytk.g.platformer1.level.phys.Position3d;

public class AnimatedModel implements Model {
    protected final StaticModel[] frames;
    protected transient final int frameCount;
    
    public AnimatedModel(StaticModel[] models) {
        super();
        frames = Arrays.copyOf(models, models.length);
        frameCount = frames.length;
    }

    @Override
    public ModelInstance instance() {
        return new Instance();
    }

    public class Instance implements Animation<StaticModel>, ModelInstance {
        public Instance() {
            frames = AnimatedModel.this.frames;
        }
        @Override
        public void render(Screen screen, Position3d position) {
            screen.render(get(), position);
        }

        protected StaticModel[] frames;
        protected int frameCount;
        protected int frame;

        @Override
        public StaticModel[] frames() {
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
    }
}
