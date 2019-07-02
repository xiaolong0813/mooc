package Set;

import LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E>{

    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<E>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e))
            // 在链表头添加，复杂度是O(1)级别
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
