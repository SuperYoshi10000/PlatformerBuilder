package local.ytk.g.platformer1.math;

import com.bulletphysics.collision.shapes.BoxShape;

import javax.vecmath.Vector3f;

public class CollisionBox extends BoxShape {
    public int x1;
    public int y1;
    public int z1;
    public int x2;
    public int y2;
    public int z2;
    public int width;
    public int height;
    public int depth;
    public CollisionBox(int x, int y, int z, int width, int height, int depth) {
        super(new Vector3f(width, height, depth));
        this.x1 = x;
        this.y1 = y;
        this.z1 = z;
        this.x2 = x + width;
        this.y2 = y + height;
        this.z2 = z + depth;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public CollisionBox(int x, int y, int width, int height) {
        this(x, y, -1, width, height, 2);
    }

    public boolean colliding(CollisionBox box) {
        return x2 > box.x1 && y2 > box.y1 && z2 > box.z1 && x1 < box.x2 && y1 < box.y2 && z1 < box.z2;
    }


}
