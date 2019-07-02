package Map;

public class LinkedListMap<K, V> implements Map<K, V> {

    // 由于之前定义的链表只有一个参数，需要修改Node为两个参数K和V
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        // 如果只传入key，value设为空
        public Node(K key) {
            this(key, null, null);
        }
        // 什么都不传，key和value都为空
        public Node() {
            this(null, null, null);
        }

        // 打印方法也要改
        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    // 构造函数和链表一样
    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    // 辅助函数，基于key返回对应Node
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }


    // 映射中，key也是唯一的
    @Override
    public void add(K key, V value) {
        // 检查是否存在
        Node node = getNode(key);
        // 不存在，就直接添加。链表添加最快是addFirst，即在dummyHead后面添加
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        else {
            // 若有重复的，将之前的覆盖掉，这里也可以抛出异常，是设计思路问题
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        // 参照链表中removeElement的方法
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if (prev.next !=null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        // 如果循环结束后prev.next是null也就是不存在这个节点，返回空
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);

        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);

        // 如果不存在，抛出异常，而不是添加
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        // 如果存在，修改
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
