import java.util.LinkedList;

public class BruteCollinearPoints {
    private int n = 0;
    private LinkedList<LineSegment> segments = new LinkedList<>();

    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("");
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    for (int m = 0; m < points.length; m++) {
                        if (points[i].slopeTo(points[j]) == Integer.MAX_VALUE
                                && points[j].slopeTo(points[k]) == Integer.MAX_VALUE
                                && points[k].slopeTo(points[m]) == Integer.MAX_VALUE) {
                            segments.add(new LineSegment(points[i], points[m]));
                            n++;
                        }
                    }
                }
            }
        }

    }    // finds all line segments containing 4 points

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

}
