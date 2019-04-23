package Queue;

import java.util.Random;

public class testTime {

    // 测试使用q运行opCount个enqueue和dequeue操作需要的时间(s)
    // 这里用Queue接口类而不是ArrayQueue和LoopQueue，利用了多态性。子类可以继承父类
    private static double testQueue(Queue<Integer> q, int opCount) throws IllegalAccessException {

        // 纳秒
        long startTime = System.nanoTime();
        // 入队随机数
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        // 出队
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        // 不是整形，需要用浮点型除法
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) throws IllegalAccessException {

        int opCount = 100000;

        // 对三种队列进行事件测试
        ArrayQueue<Integer>  arrayQueue = new ArrayQueue<Integer>();
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();

        double arrayTime = testQueue(arrayQueue, opCount);
        System.out.println("Time of ArrayQueue is: " + arrayTime + "s");

        double loopTime = testQueue(loopQueue, opCount);
        System.out.println("Time of LoopQueue is: " + loopTime + "s");

        double LinkedTime = testQueue(linkedListQueue, opCount);
        System.out.println("Time of LinkedQueue is: " + LinkedTime + "s");

        // 这里ArrayQueue的时间复杂度为O(n2)，其他两个都是O(1)
//        Time of ArrayQueue is: 2.849187158s
//        Time of LoopQueue is: 0.012060834s
//        Time of LinkedQueue is: 0.006723595s
    }
}
