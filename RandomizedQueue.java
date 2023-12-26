import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr = (Item[]) new Object[1];
    private int size = 1;
    private int n = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    private void resize(int sz) {
        Item[] newArr = (Item[]) new Object[sz];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        size = sz;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        else {
            if (n >= size)
                resize(size * 2);
            arr[n++] = item;
        }
    }

    private void swap(int i1, int i2, Item[] a) {
        Item tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException("");
        }
        else {
            if (n < size / 4) {
                resize(size / 2);
            }
            int randIndex = StdRandom.uniformInt(0, n);
            swap(randIndex, n - 1, arr);
            Item res = arr[--n];
            arr[n] = null;
            return res;
        }
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (n == 0)
            throw new NoSuchElementException("");
        int randIndex = StdRandom.uniformInt(0, n);
        return arr[randIndex];
    }


    private class Iter implements Iterator<Item> {
        private Item[] arrIter;
        int i = n;

        public Iter() {
            arrIter = (Item[]) new Object[n];
            for (int j = 0; j < n; j++) {
                arrIter[j] = arr[j];
            }
            StdRandom.shuffle(arrIter);
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            Item res = arrIter[--i];
            arrIter[i] = null;
            return res;
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iter();

    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(114514);
        queue.enqueue(1919810);
        queue.enqueue(132);


        Iterator<Integer> iter = queue.iterator();
        while (iter.hasNext()) {
            StdOut.println(iter.next());
        }
    }

}
