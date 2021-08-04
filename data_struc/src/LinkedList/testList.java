package LinkedList;

public class testList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null)
        }

        public Node() {
            this(null, null);
        }

        public String toString() {
            return this.e.toString();
        }

        private Node head;

        private Node dummyHead;

        
    }
}