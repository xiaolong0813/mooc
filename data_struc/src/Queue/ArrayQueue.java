package Queue;

import Array.Array;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayQueue() {
        array = new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) throws IllegalArgumentException {
        array.addLast(e);
    }

    @Override
    public E dequeue() throws IllegalArgumentException {
        return array.removeFirst();
    }

    @Override
    public E getFront() throws IllegalArgumentException {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();  // 注意这里的toString是StringBuilder类里面的，这里override的是String类里面的
    }

    public static void main(String[] args) throws IllegalArgumentException {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }

}
