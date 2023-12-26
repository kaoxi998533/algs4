/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MyDoublyLinkedList<T> implements Iterable<T> {
    private DoubleNode node;
    private int size;
    private DoubleNode first;
    private DoubleNode last;
    private class DoubleNode {
        T entry;
        DoubleNode frontNode;
        DoubleNode backNode;

        public DoubleNode(T key) {
            entry = key;
            frontNode = null;
            backNode = null;
        }

    }

    public void insertFront(T key) {

        DoubleNode inserted = new DoubleNode(key);
        if (first == null) {
            first = inserted;
            last = inserted;
        }
        else {
            first.frontNode = inserted;
            inserted.backNode = first;
            first = inserted;
        }
    }

    public void insertBack(T key) {
        DoubleNode inserted = new DoubleNode(key);
        if (first == null) {
            first = inserted;
            last = inserted;
        }
        else {
            last.backNode = inserted;
            inserted.frontNode = last;
            last = inserted;
        }
    }
    public void removeEnd() {
        if (first == null) {
            0;
        }
        else if (first == last) {
            first = null;
            last = null;
        }
        else {
            last.entry = null;
            last = last.frontNode
            last.backNode = null;
        }

    }
    public void removeFront () {
        if (first == null) {
            0;
        }
        else if (first == last) {
            first = null;
            last = null;
        }
        else {
            first.entry = null;
            first = first.backNode;
            first.frontNode = null;
        }
    }
    public void removeBefore(DoubleNode n) {

    }


    public static void main(String[] args) {

    }
}
