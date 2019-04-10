package Queue;

import java.lang.Object;

public class LoopQueue<E> implements Queue<E> {

    // 实现和Array不大相同，需要从底层写起

    private E[] data;

    // 对首和队尾的索引位置。不管扩容还是减容，都指向最后一位的索引
    private int front, tail;

    // 不用这个也可以，有的话可以使逻辑更清晰
    private int size;

    public LoopQueue(int capacity) {
        // 这里需要使得tail和front的指向不同，所以需要空出一个元素
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        // 需要空出一位，所以能够承载的是长度减一
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 如果front与tail指向相同，则为空
        return front == tail;
    }

    @Override
    public void enqueue(E e) throws IllegalAccessException {
        // 队列满的标志是只剩下一个空位
        if ((tail + 1) % data.length == front ) {
            resize(this.getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        // 需要留出一个空位.放入新的数组，并将front放在第一个位置
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() throws IllegalAccessException {

        if (isEmpty()){
            throw new IllegalAccessException("Cannot dequeue from empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue: size = %d, capacity = %d\n", size, getCapacity());
        res.append("front [");
//        for (int i = front; i != tail; i = (i + 1) / data.length) {
//            res.append(data[i]);
//            if ((i + 1) / data.length != tail) {
//                res.append(", ");
//            }
//        }

        res.append("] tail");
        return res.toString();  // 注意这里的toString是StringBuilder类里面的，这里override的是String类里面的
    }


    public static void main(String[] args) throws IllegalAccessException {

        LoopQueue<Integer> arrayQueue = new LoopQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
//                System.out.println(arrayQueue);
            }
        }
    }

}
