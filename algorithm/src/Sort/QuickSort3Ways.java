package Sort;

// 三路快速排序
// 对于arr[l,r]，将其分为<v, ==v, >v 三部分
// 之后递归对<v和>v两部分继续进行三路排序

import java.util.Random;

public class QuickSort3Ways {

    private QuickSort3Ways(){}

    public static void sort(Comparable[] arr) {
        __sort(arr, 0, arr.length - 1);
    }

    private static void __sort(Comparable[] arr, int l, int r) {
//        if (r - l <= 5) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
        if (l >= r)
            return;
        // partition返回两个数不好表示，这里直接写在里面
//        Random random = new Random();
        int randomIndex = (int)(Math.random() * (r - l + 1) + l);
        swap(arr, l, randomIndex);

        Comparable first = arr[l];
        // 需要保证arr[l+1, lt]的值小于v，arr[gt, r]的值大于v
        // lt = l, 保证初始数组为空，满足条件
        // gt = r + 1，保证初始数组为空，满足条件
        int i = l + 1, lt = l, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(first) == 0)
                i++;
            else if (arr[i].compareTo(first) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            }
            else if (arr[i].compareTo(first) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            }
        }
        swap(arr, l, lt);

        __sort(arr, l, lt);
        __sort(arr, gt, r);
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        SortTestHelper helper = new SortTestHelper();
        Integer[] nums = {53,17,2,9,8,1,10,33};
        QuickSort3Ways.sort(nums);
        System.out.println("sorted arr is : ");
        helper.printArr(nums);
//        Arrays.stream(nums).forEach(System.out::println);

    }



}
