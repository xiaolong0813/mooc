package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 选择排序

// 思想：遍历数组，对于每个第i个元素，遍历找到[i, n)里面的最小值，然后和第i个进行交换，
// 也就是每次找到后面n-i个的最小值，拿到最前面来

// 时间复杂度为O(n2).
// 因为时间复杂度不会优化，效率低，一般不用

public class SelectionSort {

    // 算法不允许产生任何实例
    // 这里构造函数为空。实例为空
    private SelectionSort(){}

    public static void sort(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 寻找[i, n) 里面的最小值
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j].compareTo(nums[minIndex]) < 0)
                    minIndex = j;
            }
            // 和这n-i个里面的第一个，也就是元素i进行交换
            SortTestHelper.swap(nums, i, minIndex);
        }
    }
}
