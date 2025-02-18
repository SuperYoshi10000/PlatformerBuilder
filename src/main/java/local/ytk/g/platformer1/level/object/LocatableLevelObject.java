package local.ytk.g.platformer1.level.object;

import com.jme3.math.Quaternion;
import local.ytk.g.platformer1.level.entity.HasTransform;
import local.ytk.g.platformer1.math.Transform;
import org.joml.Vector3d;

public abstract class LocatableLevelObject implements LevelObject, HasTransform {
    public final Transform transform;

    protected LocatableLevelObject() {
        this.transform = new Transform();
    }
    protected LocatableLevelObject(Vector3d position) {
        this.transform = new Transform(position);
    }
    protected LocatableLevelObject(Vector3d position, Vector3d angle) {
        this.transform = new Transform(position, angle);
    }
    protected LocatableLevelObject(Vector3d position, Vector3d angle, Vector3d scale) {
        this.transform = new Transform(position, angle, scale);
    }
    protected LocatableLevelObject(Vector3d position, Quaternion angle, Vector3d scale) {
        this.transform = new Transform(position, angle, scale);
    }
    protected LocatableLevelObject(Vector3d position, Vector3d velocity, Quaternion angle, Vector3d angularVelocity, Vector3d scale) {
        this.transform = new Transform(position, velocity, angle, angularVelocity, scale);
    }
    protected LocatableLevelObject(Vector3d position, Vector3d angle, Vector3d scale, Vector3d velocityMod, Vector3d angularVelocityMod) {
        this(position, angle, scale);
        transform.velocityMod(velocityMod).angularVelocityMod(angularVelocityMod);
    }
    protected LocatableLevelObject(Vector3d position, Quaternion angle, Vector3d scale, Vector3d velocityMod, Vector3d angularVelocityMod) {
        this(position, angle, scale);
        transform.velocityMod(velocityMod).angularVelocityMod(angularVelocityMod);

    }
    protected LocatableLevelObject(Vector3d position, Vector3d velocity, Quaternion angle, Vector3d angularVelocity, Vector3d scale, Vector3d velocityMod, Vector3d angularVelocityMod) {
        this(position, velocity, angle, angularVelocity, scale);
        transform.velocityMod(velocityMod).angularVelocityMod(angularVelocityMod);
    }
    protected LocatableLevelObject(Transform transform) {
        this.transform = transform;
    }
    
    @Override
    public Transform transform() {
        return transform;
    }
}
