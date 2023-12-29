import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
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


    private Queue<LineSegment> segmentQueue = new Queue<>();

    public FastCollinearPoints(Point[] points) {
        int len = points.length;
        Point[] pointArr = new Point[len];
        for (int i = 0; i < len; i++) {
            int contArrIndex = 1;
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
                    if (contArrIndex >= 3) {
                        Point[] arr = new Point[contArrIndex + 1];
                        int arrIndex = 0;
                        for (int m = j - contArrIndex; m <= j - 1; m++) {
                            arr[arrIndex++] = pointArr[m];
                        }
                        arr[arrIndex] = pointArr[0];
                        Arrays.sort(arr);
                        checkEnqueue(new LineSegment(arr[0], arr[arr.length - 1]));
                        contArrIndex = 1;
                    }
                    else {
                        // compared to previous, not equal, and the array index is <4
                        contArrIndex = 1;
                    }

                }

            }
            if (contArrIndex >= 3) {
                Point[] arr = new Point[contArrIndex + 1];
                int arrIndex = 0;
                for (int m = len - contArrIndex; m <= len - 1; m++) {
                    arr[arrIndex++] = pointArr[m];
                }
                arr[arrIndex] = pointArr[0];
                Arrays.sort(arr);
                checkEnqueue(new LineSegment(arr[0], arr[arr.length - 1]));
            }
        }
    }     // finds all line segments containing 4 or more points

    private void checkEnqueue(LineSegment segment) {
        int len = segmentQueue.size();
        for (LineSegment seg : segmentQueue) {
            if (seg.toString().equals(segment.toString())) {
                return;
            }
        }
        segmentQueue.enqueue(segment);
    }

    public int numberOfSegments() {
        return segmentQueue.size();
    }       // the number of line segments

    public LineSegment[] segments() {
        LineSegment[] arr = new LineSegment[segmentQueue.size()];
        int i = 0;
        for (LineSegment p : segmentQueue)
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
