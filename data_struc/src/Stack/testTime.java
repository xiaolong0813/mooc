package Stack;
import java.util.Random;

public class testTime {

    // 这里用Stack接口类而不是ArrayStack 和 LinkedListStack，利用了多态性。子类可以继承父类
    private static double testStack(Stack<Integer> stack, int opCount) throws IllegalAccessException {

        // 纳秒
        long startTime = System.nanoTime();
        // 入队随机数
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        // 出队
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        // 不是整形，需要用浮点型除法
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) throws IllegalAccessException {

        int opCount = 100000;

        ArrayStack<Integer>  arrayStack = new ArrayStack<Integer>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();

        double time1 = testStack(arrayStack, opCount);
        System.out.println("Time of arrayStack is: " + time1 + "s");

        double time2 = testStack(linkedListStack, opCount);
        System.out.println("Time of linkedListStack is: " + time2 + "s");

        // 这里时间比较复杂，其实ArrayStack和LinkedList的时间复杂度是一样的O1
        // 因为ArrayStack的push是addLast，而LinkedListStack的是addFirst。都是O1
        // 而LinkedListStack包含更多的new操作，所以在更大量的数据处理情况下会更慢

    }
}
