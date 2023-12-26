/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;
    private Iterator<T> iterator;

    public void enqueue(T key) {
        if (first == null) {
            first = new Node<>(key);
            last = first;
            size++;
        }
        else {
            Node<T> oldLast = last;
            last = new Node<>(key);
            oldLast.next = last;
            size++;

        }
    }

    public T dequeue() {
        size--;
        T ret = first.entry;
        first.next = first;
        if (isEmpty()) return null;
        return ret;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        Node<T> next;
        T entry;

        public Node(T key) {
            entry = key;
            next = null;
        }
    }

    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node<T> iter = first;

        public T next() {
            T ret = iter.entry;
            iter = iter.next;
            return ret;
        }

        public boolean hasNext() {
            return iter.next != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("cannot remove");
        }
    }

    public static void main(String[] args) {

    }
}
