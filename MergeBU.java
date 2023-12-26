/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class MergeBU {
    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[arr.length];
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }
        int i = lo;
        int j = mid + 1;
        int auxI = lo;
        while (auxI <= hi) {
            if (i > mid) arr[auxI++] = aux[j++];
            else if (j > hi) arr[auxI++] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0) arr[auxI++] = aux[i++];
            else arr[auxI++] = aux[j++];
        }
    }

    public static void sort(Comparable[] arr) {
        for (int sz = 1; sz < arr.length; sz *= 2) {
            for (int i = 0; i < arr.length - sz; i += sz * 2) {
                // arr.length - sz is to ensure that the interval does not surpass the end of the array
                merge(arr, i, i + sz - 1, Math.min(arr.length - 1, i + sz * 2 - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 1, 4, 5, 1, 4 };
        sort(arr);
        for (int i : arr)
            StdOut.println(i);
    }
}
