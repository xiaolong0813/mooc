package Sort;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

import static java.util.Arrays.sort;


public class SortTestHelper<T extends Comparable<T>> {

    // 生成n个元素的随机数组，每个元素随即范围为rangeL到rangeR
    public Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
//        if (!(rangeL <= rangeR))
//            throw new IllegalArgumentException("RangeL must less than rangeR");
        // 不用上面的判断，直接插入断言assert [boolean 表达式] 如果后面为true，继续执行，否则
        // 抛出AssertionError，终止执行
        // java中assert是默认关闭的，需要手动开启：run -> Edit configurations -> VM options
        // 输入-ea
        assert rangeL <= rangeR;

        Integer[] nums = new Integer[n];
        Random random = new Random();
//        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < n; i++) {
//            nums[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
            // 或者用下面也可以。后面算出来的是double类型，先用(int)转换为int类型，然后由于
            // nums是Integer[]类型，前面加上new Integer建立新对象。不加也可以，因为Integer是int
            // 的包装类
             nums[i] = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return nums;
    }

    // 生成近乎排序的数组。即先生成数组，然后再对其进行swapTimes次数的随机交换
    public Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            swap(nums, x, y);
        }
        return nums;
    }

    // 生成n个元素随机链表
    public LinkedListMergeSort generateRandomLinkedList(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        LinkedListMergeSort list = new LinkedListMergeSort();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.addFirst(random.nextInt(rangeR - rangeL + 1) + rangeL);
        }
        return list;
    }

    public LinkedListMergeSort generateNearlyOrderedLinkedList(int n, int swapTimes) {
        LinkedListMergeSort list = new LinkedListMergeSort();
        for (int i = n; i > 0; i--) {
            list.addFirst(i);
        }
        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            list.swap(x, y);
        }

        return list;
    }


    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printArr(Comparable[] arr) {
//        for (int i = 0; i< arr.length; i++){
//            System.out.println(arr[i]);
//            System.out.println(" ");
//        }
        StringBuilder str = new StringBuilder();
        Arrays.stream(arr).forEach(x -> str.append(x).append(" "));
        System.out.println(str.toString());
    }


    public boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSorted(LinkedListMergeSort list) {
         Comparable t;
         while (list.getSize() != 0) {
             t = list.removeFirst();
             if (list.getFirst().compareTo(t) < 0)
                 return false;
         }
         return true;
    }

    // 用来测试sort函数，这里用的是
    public void testSort(String sortClassName, String sortMethodName, Comparable[] arr) {

        // 通过java的反射机制，通过排序类名，运行排序函数
        try {
            // 通过sortClassName获取排序函数Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数Class对象获得其中名为sortMethodName的sort方法.后面传入的是sortMethod的参数的class
            // 这里sort方法的参数是Comparable[]
            Method sortMethod = sortClass.getMethod(sortMethodName, Comparable[].class);
            // 排序参数是可比较数组arr
            Object[] params = new Object[]{arr};

            double start = System.currentTimeMillis();
            // 用sortMethod的invoke方法调用参数对象，这里只有arr数组对象
            sortMethod.invoke(null, params);
            // 不能用lambda表达式，lambda是一种行为，也就是过程，其实lambda又名匿名函数，是定义的一个函数
            // 并不用来执行
            // (T[] x) -> sortFunc.apply;
            double end = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (end - start) / 1000 + "s");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testSort(LinkedListMergeSort list) {
        try {
            double start = System.currentTimeMillis();
            list.sortBU();
            double end = System.currentTimeMillis();
            assert isSorted(list);
            System.out.println("LinkedList MergeSort" + " : " + (end - start) / 1000 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SortTestHelper helper = new SortTestHelper();

        Integer[] test = helper.generateRandomArray(20, 12, 9);
        Arrays.stream(test).forEach(e->System.out.println(e));
    }
}
