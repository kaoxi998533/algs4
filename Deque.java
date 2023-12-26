import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node last;
    private Node first;
    private int size = 0;

    private class Node {
        Item entry;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        if (isEmpty()) {
            first = new Node();
            first.entry = item;
            last = first;
        }
        else {
            Node newHead = new Node();
            newHead.entry = item;
            newHead.next = first;
            first = newHead;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        if (isEmpty()) {
            last = new Node();
            last.entry = item;
            first = last;
        }
        else {
            Node newLast = new Node();
            newLast.entry = item;
            newLast.prev = last;
            last = newLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        else {
            size--;
            Item firstEntry = first.entry;
            first = first.next;
            return firstEntry;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        else {
            size--;
            Item lastEntry = last.entry;
            last = last.prev;
            return lastEntry;
        }
    }


    private class Iter implements Iterator<Item> {
        Node iter = first;

        public Item next() {
            if (iter == null) {
                throw new NoSuchElementException("");
            }
            Item ret = iter.entry;
            iter = iter.next;
            return ret;
        }

        public boolean hasNext() {
            return iter != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iter();
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        StdOut.println(deque.removeFirst());
        deque.addLast(2);
        StdOut.println(deque.removeLast());
        deque.addLast(3);
        StdOut.println(deque.size());
        StdOut.println(deque.isEmpty());
        Iterator<Integer> iter = deque.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());


    }

}
