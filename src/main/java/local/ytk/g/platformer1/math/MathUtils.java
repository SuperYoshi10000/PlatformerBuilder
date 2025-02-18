package local.ytk.g.platformer1.math;

import com.jme3.math.FastMath;
import org.joml.Quaterniond;
import org.joml.Vector3d;

import static java.lang.Math.*;

public class MathUtils {
    public static Quaterniond eulerToQuaternion(Vector3d vector) {
        return eulerToQuaternion(vector.z, vector.y, vector.x);
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static Quaterniond eulerToQuaternion(double xAngle, double yAngle, double zAngle) {
        zAngle *= 0.5;
        yAngle *= 0.5;
        xAngle *= 0.5;
        double sinZ = sin(zAngle);
        double cosZ = cos(zAngle);
        double sinY = sin(yAngle);
        double cosY = cos(yAngle);
        double sinX = sin(xAngle);
        double cosX = cos(xAngle);

        // variables used to reduce multiplication calls.
        double cosYXcosZ = cosY * cosZ;
        double sinYXsinZ = sinY * sinZ;
        double cosYXsinZ = cosY * sinZ;
        double sinYXcosZ = sinY * cosZ;

        double w = (cosYXcosZ * cosX - sinYXsinZ * sinX);
        double x = (cosYXcosZ * sinX + sinYXsinZ * cosX);
        double y = (sinYXcosZ * cosX + cosYXsinZ * sinX);
        double z = (cosYXsinZ * cosX - sinYXcosZ * sinX);
        // Create and return the quaternion
        return new Quaterniond(x, y, z, w);
    }
    public static Vector3d toEulerAngles(Quaterniond q) {
        double[] angles = new double[3];
        double w = q.w, x = q.x, y = q.y, z = q.z;
        double sqw = w * w;
        double sqx = x * x;
        double sqy = y * y;
        double sqz = z * z;
        double unit = sqx + sqy + sqz + sqw; // if normalized is one, otherwise
        // is correction factor
        double test = x * y + z * w;
        if (test > 0.499 * unit) { // singularity at north pole
            angles[1] = 2 * atan2(x, w);
            angles[2] = PI/2;
            angles[0] = 0;
        } else if (test < -0.499 * unit) { // singularity at south pole
            angles[1] = -2 * atan2(x, w);
            angles[2] = -PI/2;
            angles[0] = 0;
        } else {
            angles[1] = atan2(2 * y * w - 2 * x * z, sqx - sqy - sqz + sqw); // yaw or heading
            angles[2] = asin(2 * test / unit); // roll or bank
            angles[0] = atan2(2 * x * w - 2 * y * z, -sqx + sqy - sqz + sqw); // pitch or attitude
        }

        return new Vector3d(angles[0], angles[1], angles[2]);
    }
}
