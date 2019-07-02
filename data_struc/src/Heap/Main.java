package Heap;

import java.util.Random;

public class Main {

    // 返回运行时间，如果isHeapify为true，则用heapify的方式构造对象，否则就一个个往里面add
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> heap;

        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        }
        else {
            heap = new MaxHeap<Integer>();
            for (int i = 0; i < testData.length; i++) {
                heap.add(testData[i]);
            }
        }

        // 测试是否成功，堆中元素一次extractMax，放入数组，并
        // 检查是否为降序排列，若是则成功
        int[] res = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            res[i] = heap.extractMin();
        }
        for (int i = 1; i < testData.length; i ++) {
            if (res[i] <= res[i - 1])
                throw new IllegalArgumentException("Error");
        }
        System.out.println("Test Maxheap completed!");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        int n = 10000;

        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i ++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        // 这里其实不一定哪个更好，如果颠倒这两个顺序，可能结果会不一样。这个和JVM性能，
        // 编译器等都有关
//        double time_add = testHeap(testData, false);
//        System.out.println("time of add is : " + time_add);

        double time_heap = testHeap(testData, true);
        System.out.println("time of heapify is : " + time_heap);


    }
}
