/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Interval1dClient {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[n];
        int index = n;
        while (index > 0) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            intervals[n - 1] = new Interval1D(x, y);
            index--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j]))
                    StdOut.println(intervals[i] + " " + intervals[j]);
            }
        }
    }
}
