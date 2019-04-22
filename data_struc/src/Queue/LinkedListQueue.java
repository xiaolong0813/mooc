package Queue;

// 这里由于之前原始建立的LinkedList没有tail节点，直接使用不好，这里重写带有tail节点的LinkedList

public class LinkedListQueue<E> implements Queue<E> {

    // 重写LinkedList, 需要私有节点类Node
    private class Node {
        public E e;
        public Node next;

        // Node构造函数中包含外部用户传入可能为以下几种情况
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
//            this.e = e;
//            this.next = null;
            // 这里可以直接用this指代
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        // 方便看节点
        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 头尾节点
    private Node head, tail;
    private int size;

    // 构造函数。
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) throws IllegalAccessException {
        // 如果tail为空，说明链表没有元素，则入队的这个就是tail位置元素，而head也指向这个
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }
        // 如果不为空，则将Node添加到tail的后面
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() throws IllegalAccessException {
        // 如果为空，不能出队
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }

        // 将head保存以便返回
        Node retNode = head;

        head = head.next;
        retNode.next = null;

        // 如果链表只有一个元素，出队后head指向null，而tail还指向之前仅有的一个元素
        // 需要手动将其指向空
        if (head == null) {
            tail = null;
        }

        size--;

        return retNode.e;
    }

    @Override
    public E getFront() throws IllegalAccessException {
        // 如果为空，不能出队
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front: ");

        for (Node node = head; node != null; node = node.next) {
            // 注意，这里的node + "->" 中node要转换为String，就自动调用了Node类的toString方法。
            // 这里是Node类中覆盖了父类String中的toString方法，体现了多态性
            sb.append(node + "->");
        }

        sb.append("Null tail");

        return sb.toString();
    }

}
