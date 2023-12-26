/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class MergeSort {
    private static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void merge(Comparable[] arr, Comparable[] aux,
                             int start, int mid, int end) {
        // we merge arr with two sides sorted into aux
        int i = start;
        int j = mid + 1;
        int auxI = start;
        while (auxI <= end) {
            if (i > mid) aux[auxI++] = arr[j++];
            else if (j > end) aux[auxI++] = arr[i++];
            else if (less(arr[i], arr[j])) aux[auxI++] = arr[i++];
            else aux[auxI++] = arr[j++];
        }
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo,
                             int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(aux, arr, lo, mid);
        sort(aux, arr, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
        }
        sort(aux, arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 1, 4, 5, 1, 4, 1, 9, 1, 9, 8, 1, 0 };
        BinarySort.sort(arr);
        for (int i : arr) {
            StdOut.print(i);
        }
        StdOut.println();
    }
}
