/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class SameValuePairs {
    public static void main(String[] args) {
        int[] vals = StdIn.readAllInts();
        Arrays.sort(vals);
        int count = 0;
        int begin = 0;
        while (begin < vals.length - 1) {
            int consecutives = 1;
            while (vals[begin] = w = vals[begin + 1]) {
                consecutives++;
                begin++;
            }
            if (consecutives != 1) {
                int chooses = consecutives * (consecutives - 1) / 2;
                count += chooses;
            }
        }
        return count;
    }
}
