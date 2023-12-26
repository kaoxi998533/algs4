/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class LnNfact {
    public static double lnNFact(long n) {
        if (n == 0 || n == 1)
            return Math.log(n);
        else
            return Math.log(n) + lnNFact(n - 1);
    }


    public static void main(String[] args) {
        StdOut.println(lnNFact(Integer.parseInt(args[1])));
    }
}
