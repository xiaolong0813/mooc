package Heap;

import java.util.ArrayList;
import java.util.Random;

// 用数组实现的最大堆。元素具有可比性
public class MaxHeap<E extends Comparable<E>> {

    // 成员变量就是一个Array
    private Array<E> dataArray;

    public MaxHeap(int capacity) {
        dataArray = new Array<E>(capacity);
    }

    public MaxHeap() {
        dataArray = new Array<E>();
    }

    // Heapify的构造函数,将任意数组整理成堆的形式
    // 用户传过来的是一个数组，直接构建为MaxHeap
    public MaxHeap(E[] list) {
        // 在Array类里面添加构造函数，可以传入一个数组构建为一个Array
        dataArray = new Array<E>(list);
        // 从后面数第一个非叶子节点
        int index = parent(list.length - 1);
        for (int i = index; i >=0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return dataArray.getSize();
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return dataArray.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 does not have parent");
        return (index - 1) / 2;
    }

    // 返回完全二叉树标识的数组中，一个索引对应的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树标识的数组中，一个索引对应的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 往最大堆中添加元素
    public void add(E e) {
        dataArray.addLast(e);
        siftUp(dataArray.getSize() - 1);
    }

    // 将索引为inde的元素进行siftup操作，即循环和父元素比较并交换，直到到达小于父元素的位置
    private void siftUp(int index) {
        E e = dataArray.get(index);
        if (index == 0 || e.compareTo(dataArray.get(parent(index))) < 0)
            return;
        dataArray.swap(index, parent(index));
        siftUp(parent(index));
    }

    // 和上面功能一样，只是用循环的方式
    private void siftUp_loop(int index) {
        E e = dataArray.get(index);
        while (index > 0 && dataArray.get(index).compareTo(dataArray.get(parent(index))) > 0){
            dataArray.swap(index, parent(index));
            index = parent(index);
        }
    }

    // 看堆中的最大值
    public E findMax() {
        if (dataArray.getSize() == 0)
            throw new IllegalArgumentException("Cannot find max, heap is empty");
        return dataArray.get(0);
    }

    // 从最大堆中出队，这里只能出最大的元素，这是优先队列的性质
    public E extractMax() {
        E first = findMax();
        dataArray.swap(0, dataArray.getSize() - 1);
        dataArray.removeLast();

        siftDown(0);
        return first;
    }

    // 看堆中的最小值的索引
    public int findMin() {
        if (dataArray.getSize() == 0)
            throw new IllegalArgumentException("Cannot find min, heap is empty");
        if (dataArray.getSize() == 1)
            return 0;
        // 最小值肯定出现在叶子节点，因为非叶子节点肯定大于其叶子，先找到
        // 从后往前的第一个非叶子节点的索引，也就是最后一个叶子节点的父节点
        int index = parent(dataArray.getSize() - 1);
        // 先将第一个叶子节点的值作为最小值，也就是第index+1个
        // 然后以此往后遍历
        int min = index + 1;
        for (int i = index; i < dataArray.getSize(); i++) {
            if (dataArray.get(i).compareTo(dataArray.get(min)) < 0)
                min = i;
        }
        return min;
    }

    // 取出最小值
    public E extractMin() {
        int minIndex = findMin();
        E min = dataArray.get(minIndex);
        // 如果该值为最小，直接remove掉
        if (minIndex == dataArray.getSize() - 1) {
            dataArray.removeLast();
        }
        // 如果后面还有叶子节点，先将其和最后一个叶子节点交换，然后remove掉
        // 再对交换的叶子节点进行siftUp操作
        else {
            dataArray.swap(minIndex, dataArray.getSize() - 1);
            dataArray.removeLast();
            siftUp(minIndex);
        }
        return min;
    }

    // 将index位置的元素siftdown操作，直到到达小于父元素位置
    private void siftDown(int index) {
        // 如果该节点已经到最下面，成为了叶子节点，则没有leftChild，
        // 此时leftChild(index)会大于数组的size，这时就可停止
        // 或者已经满足大于两个子节点，也停止
        if (leftChild(index) >= dataArray.getSize())
            return;

        // 如果要交换，需要找左右两个子节点中最大的值进行交换。
        // 先设定为左边，在判断是否有右边节点，如果有，并且大于左边，就
        // 将最大值索引设为右端，在进行交换和递归
        int maxIndex = leftChild(index);
        if (maxIndex + 1 < dataArray.getSize() &&
                dataArray.get(maxIndex).compareTo(dataArray.get(maxIndex + 1)) < 0)
            maxIndex = rightChild(index);

        if (dataArray.get(index).compareTo(dataArray.get(maxIndex)) > 0)
            return;

        dataArray.swap(index, maxIndex);
        siftDown(maxIndex);
    }

    // 上面的loop写法
    private void siftDown_loop(int index) {
        // 如果还有左数的话，就一直遍历(先放在左树，所以只需要比较左树)
        while (leftChild(index) < dataArray.getSize()) {
            // 找到左右两边最大的元素索引
            int maxIndex = leftChild(index);
            int left = leftChild(index);
            int right = rightChild(index);
            if (right < dataArray.getSize() &&
                    dataArray.get(right).compareTo(dataArray.get(left)) > 0)
                maxIndex = rightChild(index);

            if (dataArray.get(index).compareTo(dataArray.get(maxIndex)) > 0)
                break;

            dataArray.swap(index, maxIndex);
            index = maxIndex;
        }
    }

    // 替换元素，即取出最大元素之后，再放入一个新元素，可以先extractMax，再add，
    // 但是其实extrac是有siftDown的过程，add有siftUp的过程，是两次O(logn)级别的复杂度
    // 可以直接将最大值替换为所添加的新元素，再将新元素siftDown，这样只需要一次O(logn)
    public E replace(E e) {
        E ret = findMax();
        dataArray.set(0, e);
        siftDown(0);
        return ret;
    }


    public static void main(String[] args) {
        Random random = new Random();

        int n = 20;
        Integer[] nums = new Integer[n];

        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(100);
        }

        MaxHeap<Integer> heap = new MaxHeap<>(nums);

        System.out.println(heap.dataArray.toString());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(heap.extractMin());
        }

        System.out.println(list.toString());

    }

}
