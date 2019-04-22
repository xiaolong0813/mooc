package Stack;
import LinkedList.*;

public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");

        // 这里sb将LinkedList的toString后的字符串append了
        sb.append(linkedList);

        return sb.toString();
    }
}
