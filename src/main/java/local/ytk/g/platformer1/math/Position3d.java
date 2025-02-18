package local.ytk.g.platformer1.math;

import org.joml.Vector2d;
import org.joml.Vector3d;

@Deprecated
public class Position3d extends Vector3d {
    public final PhysValImpl x;
    public final PhysValImpl y;
    public final PhysValImpl z;
    public final PhysValImpl yaw;
    public final PhysValImpl pitch;
    public final PhysValImpl roll;

    public Position3d() {
        super();
        x = new PhysValImpl();
        y = new PhysValImpl();
        z = new PhysValImpl();
        yaw = new PhysValImpl();
        pitch = new PhysValImpl();
        roll = new PhysValImpl();
    }
    public Position3d(double multiplier) {
        super();
        x = new PhysValImpl().multiplier(multiplier);
        y = new PhysValImpl();
        z = new PhysValImpl().multiplier(multiplier);
        yaw = new PhysValImpl();
        pitch = new PhysValImpl();
        roll = new PhysValImpl();
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
