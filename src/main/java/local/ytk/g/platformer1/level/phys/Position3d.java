package local.ytk.g.platformer1.level.phys;

import org.joml.Vector2d;
import org.joml.Vector3d;

public class Position3d extends Vector3d {
    public final PhysVal x;
    public final PhysVal y;
    public final PhysVal z;
    public final PhysVal yaw;
    public final PhysVal pitch;
    public final PhysVal roll;

    public Position3d() {
        super();
        x = new PhysVal();
        y = new PhysVal();
        z = new PhysVal();
        yaw = new PhysVal();
        pitch = new PhysVal();
        roll = new PhysVal();
    }
    public Position3d(double multiplier) {
        super();
        x = new PhysVal().multiplier(multiplier);
        y = new PhysVal();
        z = new PhysVal().multiplier(multiplier);
        yaw = new PhysVal();
        pitch = new PhysVal();
        roll = new PhysVal();
    }

    public void tick() {
        x.tick();
        y.tick();
        z.tick();
        yaw.tick();
        pitch.tick();
        roll.tick();
    }

    @Override
    public double x() {
        return x.value;
    }
    @Override
    public double y() {
        return y.value;
    }
    @Override
    public double z() {
        return z.value;
    }

    public void moveXY(Vector2d vector) {
        x.value += vector.x;
        y.value += vector.y;
    }

    public void accelerateXY(Vector2d vector) {
        x.velocity += vector.x;
        y.velocity += vector.y;
    }

    public void multiplyXY(Vector2d vector) {
        x.multiplier += vector.x;
        y.multiplier += vector.y;
    }

    public void moveXZ(Vector2d vector) {
        x.value += vector.x;
        z.value += vector.y;
    }

    public void accelerateXZ(Vector2d vector) {
        x.velocity += vector.x;
        z.velocity += vector.y;
    }

    public void multiplyXZ(Vector2d vector) {
        x.multiplier += vector.x;
        z.multiplier += vector.y;
    }

    public void moveYZ(Vector2d vector) {
        z.value += vector.x;
        y.value += vector.y;
    }

    public void accelerateYZ(Vector2d vector) {
        z.velocity += vector.x;
        y.velocity += vector.y;
    }

    public void multiplyYZ(Vector2d vector) {
        z.multiplier += vector.x;
        y.multiplier += vector.y;
    }

    public void move(Vector3d vector) {
        x.value += vector.x;
        y.value += vector.y;
        z.value += vector.z;
    }
    public void accelerate(Vector3d vector) {
        x.velocity += vector.x;
        y.velocity += vector.y;
        z.velocity += vector.z;
    }
    public void multiply(Vector3d vector) {
        x.multiplier += vector.x;
        y.multiplier += vector.y;
        z.multiplier += vector.z;
    }

    public Position3d move(double a, double b, double c) {
        x.value += a;
        y.value += b;
        z.value += c;
        return this;
    }
    public Position3d rotate(double a, double b, double c) {
        yaw.value += a;
        pitch.value += b;
        roll.value += c;
        return this;
    }
}
