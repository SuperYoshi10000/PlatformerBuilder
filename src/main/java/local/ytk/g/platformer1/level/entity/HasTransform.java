package local.ytk.g.platformer1.level.entity;

import com.jme3.math.Quaternion;
import local.ytk.g.platformer1.data.tag.Tag;
import local.ytk.g.platformer1.math.PhysVal;
import local.ytk.g.platformer1.math.Transform;
import org.joml.Quaterniond;
import org.joml.Vector3d;

import java.util.function.BiConsumer;
import java.util.function.ToDoubleFunction;

public interface HasTransform {
    Transform transform();
    
    byte forwardVal();
    
    default Vector3d backward() {
        return forward().negate();
    }
    default Vector3d forward() {
        return Transform.angleToVector(transform().angle);
    }
    default Vector3d left() {
        return right().negate();
    }
    default Vector3d right() {
        return Transform.angleToVector(transform().angle.add(0, 0, 90));
    }
    default Vector3d down() {
        return up().negate();
    }
    default Vector3d up() {
        return Transform.angleToVector(transform().angle.add(0, 90, 0));
    }
    
    default Vector3d pos() {
        return transform().position;
    }
    default Vector3d vel() {
        return transform().velocity;
    }
    default Vector3d acc() {
        return transform().velocity; //temp
    }
    default Vector3d angle() {
        return transform().angle;
    }
    default Vector3d angleVel() {
        return transform().angularVelocity;
    }
    default Vector3d angleAcc() {
        return transform().angularVelocity; //temp
    }
    default Quaternion angleQ() {
        return transform().angleToQuaternion();
    }
    default Quaterniond angleQD() {
        return transform().angleToQuaternionD();
    }
    
    default PhysVal x() {
        return physVal(Vector3d::x, (v, x) -> v.x = x);
    }
    default PhysVal y() {
        return physVal(Vector3d::y, (v, y) -> v.y = y);
    }
    default PhysVal z() {
        return physVal(Vector3d::z, (v, z) -> v.z = z);
    }
    default PhysVal roll() {
        return physValAngle(Vector3d::x, (v, x) -> v.x = x);
    }
    default PhysVal pitch() {
        return physValAngle(Vector3d::y, (v, y) -> v.y = y);
    }
    default PhysVal yaw() {
        return physValAngle(Vector3d::z, (v, z) -> v.z = z);
    }
    
    private PhysVal physVal(ToDoubleFunction<Vector3d> getter, BiConsumer<Vector3d, Double> setter) {
        return new PhysVal() {
            @Override
            public PhysVal value(double value) {
                return null;
            }
            @Override
            public PhysVal velocity(double value) {
                return null;
            }
            @Override
            public PhysVal acceleration(double value) {
                return null;
            }
            @Override
            public PhysVal multiplier(double value) {
                return null;
            }
            @Override
            public double value() {
                return getter.applyAsDouble(transform().position);
            }
            @Override
            public double velocity() {
                return getter.applyAsDouble(transform().velocity);
            }
            @Override
            public double acceleration() {
                return getter.applyAsDouble(transform().velocity); // temp (change to acceleration when possible)
            }
            @Override
            public double multiplier() {
                return getter.applyAsDouble(transform().velocityMod);
            }
            @Override
            public Tag toTag() {
                return null;
            }
            @Override
            public void tick() {}
        };
    }
    private PhysVal physValAngle(ToDoubleFunction<Vector3d> getter, BiConsumer<Vector3d, Double> setter) {
        return new PhysVal() {
            @Override
            public PhysVal value(double value) {
                return null;
            }
            @Override
            public PhysVal velocity(double value) {
                return null;
            }
            @Override
            public PhysVal acceleration(double value) {
                return null;
            }
            @Override
            public PhysVal multiplier(double value) {
                return null;
            }
            @Override
            public double value() {
                return getter.applyAsDouble(transform().angle);
            }
            @Override
            public double velocity() {
                return getter.applyAsDouble(transform().angularVelocity);
            }
            @Override
            public double acceleration() {
                return getter.applyAsDouble(transform().angularVelocity); // temp (change to acceleration when possible)
            }
            @Override
            public double multiplier() {
                return getter.applyAsDouble(transform().angularVelocityMod);
            }
            @Override
            public Tag toTag() {
                return null;
            }
            @Override
            public void tick() {}
        };
    }
}
