/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {
    public static void main(String[] args) {
        int tosses = Integer.parseInt(args[0]);
        Counter head = new Counter("head");
        Counter tail = new Counter("tail");
        for (int i = 0; i < tosses; i++) {
            if (StdRandom.bernoulli(0.5))
                head.increment();
            else
                tail.increment();
        }
        System.out.println("head: " + head.tally());
        StdOut.println("tail: " + tail.tally());
        StdOut.println("del: " + Math.abs(head.tally() - tail.tally()));
    }
}
