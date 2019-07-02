package PriorityQueue;
import Heap.MaxHeap;
import Queue.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    // 实现的底层是MaxHeap，创建私有成员变量maxHeap用于写其他方法
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
