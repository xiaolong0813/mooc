package LinkedList;

public class LinkedList<E> {

    // 节点Node是私有类，只能在类内部访问
    // 内部变量是共有可以被LinkedList访问，不需要单独给其设置set和get
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

    // head为链表头，必须有。size为链表长度记录。设置为private，外部用户不能直接修改
    private Node head;

    // 这里引入虚拟头节点，用于指向第一个元素
    private Node dummyHead;
    private int size;

    // 链表类构造函数.初始的时候为空。也可以使用其他构造函数，比如转换array
    public LinkedList() {
//        head = null;

        // 用虚拟节点，构造的时候也是为一个节点，只是没有指向
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中元素个数
    public int getSize() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }



    // 链表中间添加新元素e,在index(0-based)位置添加
    // 这个操作不是常用，一般练习用。一般选择用链表的话，就不使用索引
    public void add(int index,  E e) {
        // 这里可以获取到size，可以在末尾添加
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        // 如果用虚拟头结点，这里就不需要讨论
//        if (index == 0) {
//            addFirst(e);
//        }
        else {
            // 从头开始，一直遍历到插入的前一个位置
//            Node prev = head;

            // 从dummyHead开始，到index前一个位置要index次
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            // 将这个变量加入prev和prev.next之间
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            // 以上三行可以用一句代替
            prev.next = new Node(e, prev.next);

            size++;
        }
    }

    // 链表头添加元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        // 以上三句可以用这一句代替
//        head = new Node(e, head);

        // 引入dummyHead之后，可以直接在0的位置添加。注意这里的0是dummyHead后一个元素
        add(0, e);

        size++;
    }

    // 末尾添加e
    public void addLast(E e) {
        add(size, e);
    }




}
