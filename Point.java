import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (this.y == that.y) {
            return Integer.compare(this.x, that.x);
        }
        return this.y < that.y ? -1 : 1;
    }     // compare two points by y-coordinates, breaking ties by x-coordinates

    public double slopeTo(Point that) {
        if (this.x == that.x && this.y == that.y) return -1 / 0.0;
        else if (this.x == that.x) return 1 / 0.0;
        else if (this.y == that.y) return 0.0;
        else return (this.y - that.y) / (double) (this.x - that.x);
    }       // the slope between this point and that point

    public Comparator<Point> slopeOrder() {
        Point p = this;
        return new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                if (o1.slopeTo(p) < o2.slopeTo(p))
                    return -1;
                else if (o1.slopeTo(p) > o2.slopeTo(p))
                    return 1;
                else
                    return 0;
            }
        };
    }              // compare two points by slopes they make with this point

    public static void main(String[] args) {
        Point pt1 = new Point(1, 0);
        Point pt2 = new Point(1, 1);
        pt1.draw();
        StdOut.println(pt1.slopeTo(pt2));

    }
}
