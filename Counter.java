/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Counter {


    private String name;
    private int count = 0;

    public Counter(String n) {
        name = n;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }


    public static void main(String[] args) {
        Counter c = new Counter("hi");
        c.increment();
        StdOut.println(c.tally());
        int[] arr = new int[3];

    }
}
