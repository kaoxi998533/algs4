/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingTest {
    public static double timeTrial(int n) {
        int MAX = 1000000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        StdDraw.setPenRadius(0.007);
        for (int n = 250; true; n *= 2) {
            double time = timeTrial(n);
            double xmax = 0.4;
            double ymax = 0.05;
            if (n / 10000.0 > xmax)
                xmax *= 2;
            if (time / 100 > ymax)
                ymax *= 2;
            StdDraw.setXscale(-0.1, xmax);
            StdDraw.setYscale(-0.1, ymax);
            StdDraw.point(n / 10000.0, time / 100);

            StdOut.printf("%7d %7.1f\n", n, time);
        }
    }
}
