package Stack;
import Array.*;

// 基于动态数组Array实现
public class ArrayStack<E> implements Stack<E> {

    // 动态数组
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayStack() {
        array = new Array<E>();
    }

    // 实现方法
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // 这个方法不是接口类中方法，因为与stack特性无关
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    @Override
    public E pop() throws IllegalAccessException {
        return array.removeLast();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
