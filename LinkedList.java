/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> last;

    private static class Node<T1> {
        T1 entry;
        Node<T1> next;

        public Node(T1 x) {
            entry = x;
            next = null;
        }


    }

    public void insertEnd(T key) {
        if (Objects.isNull(head)) {
            insertBegin(key);
            last = head;
        }
        else {
            last.next = new Node<>(key);
            last = last.next;
        }
    }

    public void insertBegin(T key) {
        Node<T> oldHead = head;
        Node<T> newHead = new Node<>(key);
        newHead.next = oldHead;
        head = newHead;
    }

    public void removeBegin() {
        head = head.next;
    }

    public void removeKey(T key) {
        if (key == head.entry) {
            head = head.next;
        }
        else {
            Node<T> currNode = head;
            while (currNode.next.entry != key
                    && !Objects.isNull(currNode.next.next)) {
                currNode = currNode.next;
            }
            if (currNode.next.entry == key) {
                if (currNode.next == last)
                    last = currNode;
                currNode.next = currNode.next.next;
            }
            else {
                System.out.println("removed element not exist");
            }
        }
    }

    public String toString() {
        Node<T> marker = head;
        String str = "";
        while (!Objects.isNull(marker.next)) {
            str += marker.entry + " ";
            marker = marker.next;
        }
        str += marker.entry;
        return str;
    }


    public static void main(String[] args) {
        LinkedList<Integer> xs = new LinkedList<>();
        xs.insertBegin(5);
        xs.insertEnd(1);
        xs.insertEnd(3);

        System.out.println(xs);
    }
}
