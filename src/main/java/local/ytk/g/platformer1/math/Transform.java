package local.ytk.g.platformer1.math;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import local.ytk.g.platformer1.level.entity.HasTransform;
import org.joml.Quaterniond;
import org.joml.Vector3d;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Transform implements HasTransform {
    public final Vector3d position;
    public final Vector3d velocity;
    public final Vector3d velocityMod = new Vector3d(1);
    public final Vector3d angle;
    public final Vector3d angularVelocity;
    public final Vector3d angularVelocityMod = new Vector3d(1);
    public final Vector3d scale;

    private static final double TICKS_PER_SECOND = 32;
    private static final double SECONDS_PER_TICK = 1/TICKS_PER_SECOND;
    
    public static Vector3d angleToVector(Vector3d angle) {
        return new Vector3d(cos(angle.z) * cos(angle.y), sin(angle.z) * cos(angle.y), sin(angle.y));
    }
    public static Vector3d vectorToAngle(Vector3d vector) {
        // needs to be tested
        Vector3d normalized = new Vector3d(vector).normalize();
        return new Vector3d(0, Math.asin(-normalized.y), Math.atan2(normalized.x, normalized.z));
    }
    
    public Vector3d position() {
        return position;
    }
    public Vector3d velocity() {
        return velocity;
    }
    public Vector3d rotation() {
        return angle;
    }
    public Vector3d angularVelocity() {
        return angularVelocity;
    }
    public Vector3d scale() {
        return scale;
    }

    public void tick() {
        tick(SECONDS_PER_TICK);
    }
    public void tick(double deltaTime) {
        position.add(velocity.mul(velocityMod.mul(deltaTime)));
        angle.add(angularVelocity.mul(velocityMod.mul(deltaTime)));
    }

    public Transform() {
        this(0, 0, 0); // center
    }
    public Transform(double x, double y, double z) {
        this(x, y, z, 0);
    }
    public Transform(double x, double y, double z, double yaw) {
        this(x, y, z, yaw, 0);
    }
    public Transform(double x, double y, double z, double yaw, double pitch) {
        this(x, y, z, yaw, pitch, 0);
    }
    public Transform(double x, double y, double z, double yaw, double pitch, double roll) {
        this(new Vector3d(x, y, z), new Vector3d(pitch, yaw, roll)); // I hope this is correct
    }
    public Transform(double x, double y, double z, double yaw, double pitch, double roll, double scale) {
        this(new Vector3d(x, y, z), new Vector3d(pitch, yaw, roll), new Vector3d(scale)); // I hope this is correct
    }
    public Transform(double x, double y, double z, double yaw, double pitch, double roll, double scaleX, double scaleY, double scaleZ) {
        this(new Vector3d(x, y, z), new Vector3d(pitch, yaw, roll), new Vector3d(scaleX, scaleY, scaleZ)); // I hope this is correct
    }

    public Transform(Vector3d position) {
        this(position, new Vector3d());
    }

    public Transform(Vector3d position, Vector3d angle) {
        this(position, angle, new Vector3d(1));
    }

    public Transform(Vector3d position, Vector3d angle, Vector3d scale) {
        this(position, new Vector3d(), angle, new Vector3d(), scale);
    }
    public Transform(Vector3d position, Quaternion angle, Vector3d scale) {
        this(position, new Vector3d(), angle, new Vector3d(), scale);
    }

    public Transform(Vector3d position, Vector3d velocity, Vector3d angle, Vector3d angularVelocity, Vector3d scale) {
        this.position = position;
        this.velocity = velocity;
        this.angle = angle;
        this.angularVelocity = angularVelocity;
        this.scale = scale;
    }

    public Transform(Vector3d position, Vector3d velocity, Quaternion angle, Vector3d angularVelocity, Vector3d scale) {
        this(position, velocity, new Vector3d(angle.toAngles(null)), angularVelocity, scale);
    }


    public Transform position(double x, double y, double z) {
        position.set(x, y, z);
        return this;
    }
    public Transform move(double x, double y, double z) {
        position.add(x, y, z);
        return this;
    }
    
    public Transform velocity(double x, double y, double z) {
        velocity.set(x, y, z);
        return this;
    }
    public Transform velocityMod(double x, double y, double z) {
        velocityMod.set(x, y, z);
        return this;
    }
    public Transform accelerate(double x, double y, double z) {
        velocity.add(x, y, z);
        return this;
    }
    public Transform decelerate(double x, double y, double z) {
        velocity.sub(x, y, z);
        return this;
    }
    
    public Transform angle(double x, double y, double z) {
        angle.set(x, y, z);
        return this;
    }
    public Transform rotate(double x, double y, double z) {
        angle.add(x, y, z);
        return this;
    }
    public Transform angularVelocity(double x, double y, double z) {
        angularVelocity.set(x, y, z);
        return this;
    }
    public Transform angularVelocityMod(double x, double y, double z) {
        angularVelocityMod.set(x, y, z);
        return this;
    }
    public Transform spin(double x, double y, double z) {
        angularVelocity.add(x, y, z);
        return this;
    }
    
    public Transform scale(double x, double y, double z) {
        scale.set(x, y, z);
        return this;
    }
    public Transform expand(double x, double y, double z) {
        scale.add(x, y, z);
        return this;
    }
    public Transform contract(double x, double y, double z) {
        scale.sub(x, y, z);
        return this;
    }

    public Transform position(Vector3d vector) {
        position.set(vector);
        return this;
    }
    public Transform move(Vector3d vector) {
        position.add(vector);
        return this;
    }

    public Transform velocity(Vector3d vector) {
        velocity.set(vector);
        return this;
    }
    public Transform velocityMod(Vector3d vector) {
        velocityMod.set(vector);
        return this;
    }
    public Transform accelerate(Vector3d vector) {
        velocity.add(vector);
        return this;
    }
    public Transform decelerate(Vector3d vector) {
        velocity.sub(vector);
        return this;
    }

    public Transform angle(Vector3d vector) {
        angle.set(vector);
        return this;
    }
    public Transform rotate(Vector3d vector) {
        angle.add(vector);
        return this;
    }
    public Transform angularVelocity(Vector3d vector) {
        angularVelocity.set(vector);
        return this;
    }
    public Transform angularVelocityMod(Vector3d vector) {
        angularVelocityMod.set(vector);
        return this;
    }
    public Transform spin(Vector3d vector) {
        angularVelocity.add(vector);
        return this;
    }

    public Transform scale(Vector3d vector) {
        scale.set(vector);
        return this;
    }
    public Transform expand(Vector3d vector) {
        scale.add(vector);
        return this;
    }
    public Transform contract(Vector3d vector) {
        scale.sub(vector);
        return this;
    }

    public Transform multiplyVelocity(double size) {
        position.mul(size, size, size);
        return this;
    }
    public Transform divideVelocity(double size) {
        position.div(size, size, size);
        return this;
    }

    public Transform multiplyAngularVelocity(double size) {
        angularVelocity.mul(size, size, size);
        return this;
    }
    public Transform divideAngularVelocity(double size) {
        angularVelocity.div(size, size, size);
        return this;
    }

    public Transform multiplyScale(double size) {
        scale.mul(size, size, size);
        return this;
    }
    public Transform divideScale(double size) {
        scale.div(size, size, size);
        return this;
    }

    public Transform scale(double size) {
        scale.set(size);
        return this;
    }
    public Transform expand(double size) {
        scale.add(size, size, size);
        return this;
    }
    public Transform contract(double size) {
        scale.sub(size, size, size);
        return this;
    }

    public Transform stop() {
        stopMovement();
        stopSpinning();
        return this;
    }
    public Transform resetPosition() {
        angle.set(0);
        return this;
    }
    public Transform stopMovement() {
        velocity.set(0);
        return this;
    }
    public Transform resetAngle() {
        angle.set(0);
        return this;
    }
    public Transform resetRoll() {
        angle.mul(1, 1, 0); // I hope this is correct
        return this;
    }
    public Transform resetPitchAndRoll() {
        angle.mul(0, 1, 0); // I hope this is correct
        return this;
    }
    public Transform stopSpinning() {
        angularVelocity.set(0);
        return this;
    }
    public Transform resetScale() {
        scale.set(1);
        return this;
    }
    
    public Quaterniond angleToQuaternionD() {
        return angleToQuaternionD(angle);
    }
    public Quaternion angleToQuaternion() {
        return angleToQuaternion(angle);
    }
    
    public static Quaterniond angleToQuaternionD(Vector3d angle) {
        Quaternion q = angleToQuaternion(angle);
        return new Quaterniond(q.getX(), q.getY(), q.getZ(), q.getW());
    }
    public static Quaternion angleToQuaternion(Vector3d angle) {
        return new Quaternion().fromAngles((float) angle.x, (float) angle.y, (float) angle.z);
    }
    
    public Transform angleFromQuaternion(Quaterniond q) {
        return angleFromQuaternion(new Quaternion((float) q.x, (float) q.y, (float) q.z, (float) q.w));
    }
    public Transform angleFromQuaternion(Quaternion quaternion) {
        angle.set(quaternion.toAngles(null));
        return this;
    }

    public static Transform fromJmeTransform(com.jme3.math.Transform transform) {
        Vector3f translation = transform.getTranslation();
        Vector3f scale = transform.getScale();
        return new Transform(translation.x, translation.y, translation.z)
            .angleFromQuaternion(transform.getRotation())
            .scale(scale.x, scale.y, scale.z);
    }
    public com.jme3.math.Transform toJmeTransform() {
        return new com.jme3.math.Transform()
            .setTranslation((float) position.x, (float) position.y, (float) position.z)
            .setRotation(angleToQuaternion())
            .setScale((float) scale.x, (float) scale.y, (float) scale.z);
    }
    
    public static Transform of(double m) {
        return null;
    }
    public static Transform of(double x, double y, double z) {
        return null;
    }
    public static Transform of(double x, double y, double z, double pitch, double yaw) {
        return null;
    }
    public static Transform of(double x, double y, double z, double roll, double pitch, double yaw) {
        return null;
    }
    
    @Override
    public Transform transform() {
        return this;
    }
    
    @Override
    public byte forwardVal() {
        return 1;
    }
}
