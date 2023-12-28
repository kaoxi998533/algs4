import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteCollinearPoints {
    private int n = 0;
    private Queue<LineSegment> segments = new Queue<>();

    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("");
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int m = k + 1; m < points.length; m++) {
                        if (Math.abs(points[i].slopeTo(points[j])) ==
                                Math.abs(points[j].slopeTo(points[k])) &&
                                Math.abs(points[j].slopeTo(points[k])) ==
                                        Math.abs((points[k].slopeTo(points[m])))) {
                            Point[] arr = {
                                    points[i], points[j],
                                    points[k], points[m]
                            };
                            Arrays.sort(arr);
                            checkEnqueue(new LineSegment(arr[0], arr[3]));
                        }
                    }
                }
            }
        }

    }    // finds all line segments containing 4 points

    private void checkEnqueue(LineSegment segment) {
        for (LineSegment seg : segments) {
            if (seg.toString().equals(segment.toString())) {
                return;
            }
        }
        n++;
        segments.enqueue(segment);
    }

    public int numberOfSegments() {
        return n;
    }        // the number of line segments

    public LineSegment[] segments() {
        LineSegment[] arr = new LineSegment[n];
        int index = 0;
        for (LineSegment sg : segments) {
            arr[index++] = sg;
        }
        return arr;
    }                // the line segments

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
