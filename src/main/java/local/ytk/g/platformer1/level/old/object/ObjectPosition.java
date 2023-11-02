package local.ytk.g.platformer1.level.old.object;

import local.ytk.g.platformer1.level.phys.Position3d;

public class ObjectPosition extends Position3d {
    public ObjectPosition(double multiplier) {
        super(multiplier);
    }

    @Override
    public void tick() {
        x.tick();
        y.tick();
        z.tick();
        yaw.tick();
        pitch.tick();
        roll.tick();
    }
}
