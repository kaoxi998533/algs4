/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Tabulate {
    public static String addSpace(String x, int spaceSize) {
        for (int i = x.length(); i < spaceSize; i++) {
            x += " ";
        }
        return x;
    }

    public static void tabulate() {
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            String number1 = StdIn.readString();
            String number2 = StdIn.readString();
            String avg = Integer.toString((Integer.parseInt(number1) +
                    Integer.parseInt(number2)) / 2);
            StdOut.println("|" + addSpace(name, 30) + "|" +
                                   addSpace(number1, 6) + "|" + addSpace(number2, 6) +
                                   "|" + addSpace(avg, 6) + "|");

        }
    }

    public static void main(String[] args) {
        tabulate();
    }
}
