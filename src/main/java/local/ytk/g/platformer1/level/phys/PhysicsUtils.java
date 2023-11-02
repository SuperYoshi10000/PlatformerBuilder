package local.ytk.g.platformer1.level.phys;

import org.joml.Vector2d;
import org.joml.Vector3d;

public class PhysicsUtils {
    public static Vector2d angle(double amount, double angle) {
        return new Vector2d(Math.sin(angle) * amount, Math.cos(angle) * amount);
    }

    public static Vector3d angleOnXY(double amount, double angle) {
        return new Vector3d(Math.sin(angle) * amount, Math.cos(angle) * amount, 0);
    }

    public static Vector3d angleOnXZ(double amount, double angle) {
        return new Vector3d(Math.sin(angle) * amount, 0, Math.cos(angle) * amount);
    }

    public static Vector3d angleOnYZ(double amount, double angle) {
        return new Vector3d(0, Math.cos(angle) * amount, Math.sin(angle) * amount);
    }

    public static Vector3d angleOnXY(Vector2d vector) {
        return new Vector3d(vector.x, vector.y, 0);
    }

    public static Vector3d angleOnXZ(Vector2d vector) {
        return new Vector3d(vector.x, 0, vector.y);
    }

    public static Vector3d angleOnYZ(Vector2d vector) {
        return new Vector3d(0, vector.y, vector.x);
    }

    public static Vector3d angleOnXYZ(double amount, double yaw, double pitch) {
        return new Vector3d(Math.sin(yaw) * Math.cos(pitch) * amount, Math.sin(pitch) * amount, Math.cos(yaw) * Math.cos(pitch) * amount);
    }

    public static Vector3d angleOnXYZ(Vector2d vector, double amount, double pitch) {
        return new Vector3d(vector.x * Math.cos(pitch), Math.sin(pitch) * amount, vector.y * Math.cos(pitch));
    }

    public static Vector3d angleOnXYZ(double amount, Direction angle) {
        return new Vector3d(Math.sin(angle.yaw) * Math.cos(angle.pitch) * amount, Math.sin(angle.pitch) * amount, Math.cos(angle.yaw) * Math.cos(angle.pitch) * amount);
    }
}
