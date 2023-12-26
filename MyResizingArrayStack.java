/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Iterator;

public class MyResizingArrayStack<T> implements Iterable<T> {
    private T[] items;
    private int n;

    private void resize(int max) {
        T[] arr = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            arr[i] = items[i];
        }
        items = arr;
    }

    public MyResizingArrayStack(int capacity) {
        n = capacity;
        items = (T[]) new Object[1];
    }

    public void push(T item) {
        if (n == items.length)
            resize(2 * n);
        items[n++] = item;
    }

    public T pop() {
        T result = items[--n];
        items[n] = null;
        if (n == items.length / 4 && n > 0)
            resize(n / 2);
        return result;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        int i = n - 1;

        public void remove() {
            throw new UnsupportedOperationException("");
        }

        public T next() {
            return items[i--];
        }

        public boolean hasNext() {
            return i >= 0;
        }
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    public static void main(String[] args) {

    }
}
