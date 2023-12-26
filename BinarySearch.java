/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] arr) {
        return rank(key, arr, 0, arr.length, 0);
    }

    public static int rank(int key, int[] arr, int lo, int hi, int depth) {
        int mid = (lo + hi) / 2;
        if (lo > hi)
            return -1;
        else if (arr[mid] < key) {
            StdOut.println(depth);
            return rank(key, arr, mid + 1, hi, depth + 1);
        }
        else if (arr[mid] > key) {
            StdOut.println(depth);
            return rank(key, arr, lo, mid - 1, depth + 1);
        }
        else {
            StdOut.println(depth);
            return mid;
        }

    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts("whitelist.txt");
        Arrays.sort(whitelist);
        int len = whitelist.length;
        for (int i = 0; i < len; i++) {
            if (whitelist[i] == whitelist[i + 1]) {
                for (int j = i + 1; j < len - 1; j++) {
                    whitelist[j] = whitelist[j + 1];
                }
                len -= 1;
            }
        }
        if (args[1].equals("+")) {
            while (!StdIn.isEmpty()) {
                int key = StdIn.readInt();
                if (rank(key, whitelist) == -1)
                    StdOut.println(key);
            }
        }
        else {
            while (!StdIn.isEmpty()) {
                int key = StdIn.readInt();
                if (rank(key, whitelist) != -1)
                    StdOut.println(key);
            }
        }
    }


}


