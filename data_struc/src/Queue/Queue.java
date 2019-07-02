package Queue;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e) throws IllegalArgumentException;
    E dequeue() throws IllegalArgumentException;
    E getFront() throws IllegalArgumentException;
}
