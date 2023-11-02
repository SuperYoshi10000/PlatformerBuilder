package local.ytk.g.platformer1.level.phys;

import org.joml.Vector2d;

import local.ytk.g.platformer1.level.time.Tickable;

public class Position2d extends Vector2d implements Tickable {
    public final PhysVal x;
    public final PhysVal y;
    public final PhysVal angle;

    public Position2d(double multiplier) {
        super();
        x = new PhysVal().multiplier(multiplier);
        y = new PhysVal().multiplier(multiplier);
        angle = new PhysVal();
    }

    public void tick() {
        x.tick();
        y.tick();
        angle.tick();
    }

    public void move(Vector2d vector) {
        x.value += vector.x;
        y.value += vector.y;
    }

    public void accelerate(Vector2d vector) {
        x.velocity += vector.x;
        y.velocity += vector.y;
    }

    public void multiply(Vector2d vector) {
        x.multiplier += vector.x;
        y.multiplier += vector.y;
    }

    @Override
    public double x() {
        return x.value;
    }
    @Override
    public double y() {
        return y.value;
    }
}
