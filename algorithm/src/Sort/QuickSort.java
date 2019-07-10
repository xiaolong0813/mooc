package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort(){}

    public static void sort(Comparable[] arr) {
        __sort(arr, 0, arr.length - 1);
    }

    // 递归实现对arr[l, r]区间快速排序
    private static void __sort(Comparable[] arr, int l, int r) {
//        if (l >= r)
//            return;
        // 优化一，调用插入排序，和归并一样。注意，测试的时候如果
        // 数据量太小，这里会直接调用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l ,r);
            return;
        }

        // 用partition找到j所在位置
        int j = __partition(arr, l, r);

        __sort(arr, l, j - 1);
        __sort(arr, j + 1, r);
    }

    // 对arr[l, r] 区间进行partition操作
    // 返回j，使得arr[l...j-1] < arr[j], arr[j+1, r] > arr[j]
    private static int __partition(Comparable[] arr, int l, int r) {


        // 优化二，不要每次用第一个的值作为比较的基准。对于近乎有序数组会退化为O(n2)级别复杂度
        // 而是选择随机一个元素作为基准。此时复杂度数学期望是O(nlogn)
//        Random random = new Random();
        int randomIndex = (int)(Math.random() * (r - l + 1) + l);
        swap(arr, l, randomIndex);

        // 将第一个和随机索引的元素交换，然后下面依然和第一个比较即可
        Comparable first = arr[l];

//        int j = l;
////      满足arr[l + 1...j] < first, arr[j+1, i) > first
//        for (int i = l + 1; i <= r; i++) {
//            if (arr[i].compareTo(first) < 0) {
//                swap(arr, i, j + 1);
//                j++;
//            }
//        }
        // 优化三：partition不再从一端开始，而是两端同时扫描。两端都可以保存等于基值的元素，
        // 避免把等于基值的元素都放在一边。
        // 注意这里不是两边同步遍历，而是两端找到需要交换的元素停止。交换后再往下遍历
        // i 和 j的取值满足初始的两个数组都是空的。这里i指的是查看的下一个元素，所以i端是开
        // 区间，i为L + 1的时候数组初始为空，满足条件
        // 满足arr[l + 1...i) <= first, arr[j+1, r] >= first
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(first) <= 0) i++;
            while (j >= l + 1 && arr[j].compareTo(first) >= 0) j--;
            // 如果中间有相同元素，有可能i>j
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static Comparable maxN(Comparable[] arr, int n) {
        if (n > arr.length || n < 1)
            throw new  IllegalArgumentException("n exceed index limit");
        QuickSort.sort(arr);
        return arr[n - 1];
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        SortTestHelper helper = new SortTestHelper();
        Integer[] nums = {53,17,2,9,8,1,10,33};
        QuickSort.sort(nums);
        System.out.println("sorted arr is : ");
        helper.printArr(nums);
//        Arrays.stream(nums).forEach(System.out::println);

    }
}
