/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Interval2dClient {
    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        int intersection = 0;
        int containing = 0;
        Interval2D[] intervals = new Interval2D[n];
        for (int i = 0; i < n; i++) {
            double width = StdRandom.uniformDouble(min, max);
            double height = StdRandom.uniformDouble(min, max);
            Interval1D first = new Interval1D(StdRandom.uniformDouble(),
                                              StdRandom.uniformDouble());
            Interval1D second = new Interval1D(StdRandom.uniformDouble(),
                                               StdRandom.uniformDouble());
            intervals[i] = new Interval2D(first, second);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (intervals[i].intersects(intervals[j]))
                    intersection++;

            }
        }
        StdOut.println(intersection + " " + containing);
        double time = sw.elapsedTime();
        StdOut.println("time running: " + time);
    }
}
