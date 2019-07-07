package Sort;

import javax.sql.rowset.FilteredRowSet;
import java.util.Arrays;

// 插入排序
// 思想： 遍历数组，对每个元素，循环和前面元素进行比较，如果比前面一个小，就和前面交换位置
// 优化后不每次交换，而是依次和前面的比较，直到找到合适位置
// 直到比前面元素大，则插入到此处。

// 时间复杂度最差为O(n2)，最好为O(n)
// 优点： 因为插入到合适位置就不再需要往前遍历，对于近乎有序的数组，速度非常快。

public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        // 寻找元素arr[i]合适的插入位置
        // 由于当找到合适位置就终止，不像选择排序需要每次都遍历一般剩下的元素
        // 所以理论上比选择排序更快。但实际上并不是，因为插入排序需要不停的
        // 交换元素，这比单纯的比较更耗费时间
//        for (int i = 1; i < arr.length; i++) {
////            int flag = i;
////            while (flag > 0 && arr[flag].compareTo(arr[flag - 1]) < 0) {
////                SortTestHelper.swap(arr, flag, flag - 1);
////                flag--;
////            }
////        }
        // 改进版，不再循环交换，而是先复制，再找合适位置赋值
        // 这里测试改进后插入排序仍然慢于选择排序，但应该是和java8的底层优化机制有关
        // 现实中是几乎不会用到选择排序的
        for (int i = 1; i < arr.length; i++) {
            int flag = i;
            Comparable temp = arr[i];
            while (flag > 0 && temp.compareTo(arr[flag - 1]) < 0) {
                arr[flag] = arr[flag - 1];
                flag--;
            }
            arr[flag] = temp;
        }
    }

    // 对arr中l到r的元素进行排序
    public static void sort(Comparable[] arr, int l, int r) {
        // l和r都是前后闭的索引。改变范围
        for (int i = l + 1; i <= r; i++) {
            int flag = i;
            Comparable temp = arr[i];
            while (flag > l && temp.compareTo(arr[flag - 1]) < 0) {
                arr[flag] = arr[flag - 1];
                flag--;
            }
            arr[flag] = temp;
        }
    }
}
