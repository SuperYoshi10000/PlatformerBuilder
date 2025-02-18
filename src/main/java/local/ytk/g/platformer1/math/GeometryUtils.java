package local.ytk.g.platformer1.math;

import java.util.stream.Stream;

public class GeometryUtils {
    public static interface Shape {
        public boolean contains(double x, double y);
        public boolean intersects(Rectangle other);
        public boolean intersects(Circle other);
        public boolean intersects(Triangle other);
        public boolean intersects(Polygon other) ;

        public static Shape create(double[] x, double[] y) {
            return new Polygon(x, y);
        }
        public static Shape create(double[]... points) {
            if (points.length == 3) {
                return new Triangle(points[0][0], points[0][1], points[1][0], points[1][1], points[2][0], points[2][1]);
            }
            return new Polygon(points);
        }
    }
    public static class Rectangle implements Shape {
        public final double x1, y1, x2, y2;
        public Rectangle(double x, double y, double size) {
            this(x, y, size, size);
        }
        public Rectangle(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        public static Rectangle size(double x, double y, double w, double h) {
            return new Rectangle(x, y, x + w, y + h);
        }
        public boolean intersects(Rectangle other) {
            return intersects(other.x1, other.y1, other.x2, other.y2);
        }
        public boolean intersects(double x1, double y1, double x2, double y2) {
            return this.x1 <= x2 && this.x2 >= x1 && this.y1 <= y2 && this.y2 >= y1;
        }
        public boolean intersects(Triangle other) {
            return intersects(other.x1, other.y1, other.x2, other.y2, other.x3, other.y3);
        }
        public boolean intersects(double x1, double y1, double x2, double y2, double x3, double y3) {
            return false; // TODO look this up
        }
        public boolean intersects(Circle other) {
            return intersects(other.x, other.y, other.w, other.h, other.a);
        }
        public boolean intersects(double x, double y, double w, double h, double a) {
            return false; // TODO look this up
        }

        public boolean contains(double x, double y) {
            return x1 <= x && x2 >= x && y1 <= y && y2 >= y;
        }
        public boolean contains(Rectangle other) {
            return contains(other.x1, other.y1) && contains(other.x2, other.y2);
        }
        @Override
        public boolean intersects(Polygon other) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'intersects'");
        }
    }
    public static class Circle implements Shape {
        public final double x, y, w, h, a;
        public Circle(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.w = this.h = r;
            this.a = 0;
        }
        public Circle(double x, double y, double w, double h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.a = 0;
        }
        public Circle(double x, double y, double w, double h, double a) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.a = a;
        }
        
        public boolean intersects(Rectangle other) {
            return intersects(other.x1, other.y1, other.x2, other.y2);
        }
        public boolean intersects(double x1, double y1, double x2, double y2) {
            return false; // TODO look this up
        }
        public boolean intersects(Triangle other) {
            return intersects(other.x1, other.y1, other.x2, other.y2, other.x3, other.y3);
        }
        public boolean intersects(double x1, double y1, double x2, double y2, double x3, double y3) {
            return false; // TODO look this up
        }

        public boolean intersects(Circle other) {
            return intersects(other.x, other.y, other.w, other.h, other.a);
        }
        public boolean intersects(double x, double y, double r) {
            return intersects(x, y, r, r, 0);
        }
        public boolean intersects(double x, double y, double w, double h, double a) {
            return false; // TODO look this up
        }

        public boolean contains(double x, double y) {
            return false; // TODO look this up
        }
        @Override
        public boolean intersects(Polygon other) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'intersects'");
        }
    }
    public static class Triangle implements Shape {
        public final double x1, y1, x2, y2, x3, y3;
        public Triangle(double x, double y, double w, double h) {
            x1 = x;
            y1 = y;
            x2 = x + w;
            y2 = y;
            x3 = x + w / 2;
            y3 = y + h;
        }
        public Triangle(double x, double y, double x2, double y2, double x3, double y3) {
            this.x1 = x;
            this.y1 = y;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public boolean intersects(Triangle other) {
            // TODO look this up
            return intersects(other.x1, other.y1, other.x2, other.y2, other.x3, other.y3);
        }
        public boolean intersects(double x1, double y1, double x2, double y2, double x3, double y3) {
            return intersects(new Triangle(x1, y1, x2, y2, x3, y3));
        }

        public boolean intersects(Rectangle other) {
            // TODO look this up
            return false;
        }
        public boolean intersects(double x1, double y1, double x2, double y2) {
            return false; // TODO look this up
        }

        public boolean intersects(Circle other) {
            return false; // TODO look this up
        }
        public boolean intersects(double x, double y, double w, double h, double a) {
            return false; // TODO look this up
        }
        @Override
        public boolean contains(double x, double y) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'contains'");
        }
        @Override
        public boolean intersects(Polygon other) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'intersects'");
        }
    }

    public static class RightTriangle extends Triangle {
        public RightTriangle(double x1, double y1, double x2, double y2, Corner corner) {
            super(
                x1, corner.value == 3 ? y2 : y1,
                corner.value > 1 ? x2 : x1, y2,
                x2, corner.value == 1 ? y2 : y1
            );
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.corner = corner;
        }
        public final double x1, y1, x2, y2;
        public final Corner corner;
        public enum Corner {
            TOP_LEFT(1), // 1,1 1,2 2,2
            TOP_RIGHT(3), // 1,2 2,2 2,1
            BOTTOM_LEFT(0), // 1,1 1,2 2,1
            BOTTOM_RIGHT(2), // 1,1 2,2 2,1
            ;
            final int value;
            private Corner(int pos) {
                this.value = pos;
            }
        }
    }

    public static class Polygon implements Shape {
        public final double[] x, y;
        public Polygon(double[] x, double[] y) {
            this.x = x;
            this.y = y;
        }
        public Polygon(double[]... points) {
            this.x = Stream.of(points).mapToDouble(d -> d[0]).toArray();
            this.y = Stream.of(points).mapToDouble(d -> d[1]).toArray();
        }

        public boolean intersects(Rectangle other) {
            return false; // TODO look this up
        }
        public boolean intersects(Circle other) {
            return false; // TODO look this up
        }
        public boolean intersects(Triangle other) {
            return false; // TODO look this up
        }
        public boolean intersects(Polygon other) {
            return false; // TODO look this up
        }
        @Override
        public boolean contains(double x, double y) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'contains'");
        }
    }
}
