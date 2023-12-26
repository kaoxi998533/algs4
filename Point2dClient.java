/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Point2dClient {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[n];
        double shortest = 1;
        StdDraw.square(0.5, 0.5, 0.5);
        int index = n;
        while (index > 0) {
            double x = StdRandom.uniformDouble();
            double y = StdRandom.uniformDouble();
            points[index - 1] = new Point2D(x, y);
            StdDraw.point(x, y);
            StdOut.println(points[index - 1]);
            index--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = points[i].distanceTo(points[j]);
                if (dist < shortest)
                    shortest = dist;
            }
        }
        StdOut.println(shortest);
    }
}
