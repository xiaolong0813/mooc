package Sort;

import LinkedList.LinkedList;

import javax.security.auth.callback.TextInputCallback;
import java.util.Random;

public class LinkedListMergeSort<E extends Comparable<E>>{

    // 节点Node是私有类，只能在类内部访问
    // 内部变量是共有可以被LinkedList访问，不需要单独给其设置set和get
//    private class Node implements Comparable<Node>{
    private class Node{

        public E e;
        public Node next;

        // Node构造函数中包含外部用户传入可能为以下几种情况
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

//        @Override
//        public int compareTo(Node another) {
//            if (this.e.compareTo(another.e) < 0)
//                return 1;
//            else if (this.e.compareTo(another.e) > 0)
//                return -1;
//            else
//                return 0;
//        }
    }
    private Node head;

    // 这里引入虚拟头节点，用于指向第一个元素
    private Node dummyHead;
    private int size;

    // 以下为链表构造函数
    public LinkedListMergeSort() {
//        head = null;

        // 用虚拟节点，构造的时候也是为一个节点，只是没有指向
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index,  E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        else {
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index");
        }
        else {
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            Node retNode = prev.next;
            prev.next = retNode.next;
            retNode.next = null;
            size--;
            return retNode.e;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }

        else {
            Node current = dummyHead.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.e;
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }

        else {
            Node current = dummyHead.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }
        if (prev.next !=null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        else {
            Node current = dummyHead.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.e = e;
        }
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }




    // 对链表进行sortBU的排序
    public void sortBU() {
        for (int sz = 1; sz <= size; sz = sz * 2) {
            for (int j = 0; j + sz < size; j += sz * 2) {
                int mid = j + sz -1;
                int right = Math.min(j + sz * 2 -1, size - 1);
                Node midNode = this.getNode(mid);
                if (midNode.e.compareTo(midNode.next.e) > 0)
                    __merge(j, mid, right);
            }
        }
    }

    // 将链表分两段链表进行归并
    private void __merge(int l, int mid, int r) {
//        LinkedListMergeSort aux = new LinkedListMergeSort<>();
        Node prev;
        if (l == 0)
            prev = dummyHead;
        else
            prev = this.getNode(l - 1);

        Node leftAuxDummyHead = new Node(null, null);
        Node rightAuxDummyHead = new Node(null, null);

        Node left = leftAuxDummyHead;
        Node right = rightAuxDummyHead;
        Node cur = prev;
        for (int i = l; i <= r; i++) {
            cur = cur.next;
            if (i <= mid) {
                left = left.next= new Node(cur.e);
            }
            else {
                right = right.next = new Node(cur.e);
            }
        }
        // 保存需要排序的部分的下一个节点
        Node next = cur.next;

        Node i = leftAuxDummyHead.next, j = rightAuxDummyHead.next, k;
        for (k = prev; i != null || j != null; k = k.next) {
            if (i == null) {
                k.next = j;
                j = j.next;
            }
            else if (j == null) {
                k.next = i;
                i = i.next;
            }
            else if (i.e.compareTo(j.e) < 0) {
                k.next = i;
                i = i.next;
            }
            else {
                k.next = j;
                j = j.next;
            }
        }

        k.next = next;
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        else if (i == j)
            return;
        else {
            Node iprev;
            Node jprev;
            if (i == 0)
                iprev = dummyHead;
            else
                iprev = this.getNode(i - 1);
            if (j == 0)
                jprev = dummyHead;
            else
                jprev = this.getNode(j - 1);
            Node nodei = iprev.next;
            Node nodej = jprev.next;

            Node nexti = nodei.next;
            Node nextj = nodej.next;

            nodej.next = nexti;
            iprev.next = nodej;
            nodei.next = nextj;
            jprev.next = nodei;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node current = dummyHead.next; current != null; current = current.next) {
            sb.append(current + "->");
        }
        sb.append("NULL. size is " + size);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListMergeSort list = new LinkedListMergeSort();
        Random random = new Random();

        int value = 0;
        for (int i = 0; i < 15; i++) {
            list.addFirst(random.nextInt(100));
        }

        System.out.println(list);
        list.sortBU();
        System.out.println(list);
        list.swap(8, 2);
        System.out.println(list);

    }
}
