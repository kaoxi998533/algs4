import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
public class FastCollinearPoints {

    private Stack<LineSegment> segmentStack = new Stack<>();

    public FastCollinearPoints(Point[] points) {
        int len = points.length;
        Point[] pointArr = new Point[len];
        int contArrIndex = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // copy of array
                pointArr[j] = points[j];
            }
            Comparator<Point> comparator = pointArr[i].slopeOrder();
            Arrays.sort(pointArr, comparator);
            for (int j = 1; j < len; j++) {
                if (comparator.compare(pointArr[j], pointArr[j - 1]) == 0) {
                    contArrIndex++;
                }
                else {
                    if (contArrIndex >= 4) {
                        if (isSubsegment(pointArr,
                                         j - contArrIndex,
                                         pointArr[j - 1].slopeTo(pointArr[j - 2]))
                                || pointArr[j - 1].slopeTo(pointArr[j - 2]) < 0) {
                            // is subsegment is likely the cause of bug
                            contArrIndex = 1;
                            continue;
                        }
                        segmentStack.push(
                                new LineSegment(pointArr[j - 1],
                                                pointArr[j - contArrIndex]
                                ));
                        contArrIndex = 1;

                    }
                    else {
                        // compared to previous, not equal, and the array index is <4
                        contArrIndex = 1;
                    }

                }
            }
        }
    }     // finds all line segments containing 4 or more points

    private boolean isSubsegment(Point[] arr, int pointIndex, double originalSlope) {
        // we compare the point at pointIndex with the other points for slope
        // if we find the target slope then return false
        double targetSlope = -originalSlope;
        Point pointToBeCompared = arr[pointIndex];
        for (int i = 0; i < pointIndex; i++) {
            if (pointToBeCompared.slopeTo(arr[i]) == targetSlope) {
                StdOut.println(pointToBeCompared + "and " + arr[i]);
                return true;
            }
        }
        return false;
    }

    public int numberOfSegments() {
        return segmentStack.size();
    }       // the number of line segments

    public LineSegment[] segments() {
        LineSegment[] arr = new LineSegment[segmentStack.size()];
        int i = 0;
        for (LineSegment p : segmentStack)
            arr[i++] = p;
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
