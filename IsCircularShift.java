/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class IsCircularShift {
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        StdOut.println(s1.concat(s1).indexOf(s2) != -1);
    }
}
