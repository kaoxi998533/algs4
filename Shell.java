/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Shell {

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    static void sort(Comparable[] arr) {
        int len = arr.length;
        int h = 1;
        while (h < len)
            h += 3;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j - h >= 0 && less(arr[j], arr[j - h]); j -= h) {
                    exch(arr, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 1, 4, 5, 1, 4, 1, 9, 1, 9, 8, 1, 0 };
        Shell.sort(arr);
        for (int i : arr) {
            StdOut.print(i);
        }
    }
}
