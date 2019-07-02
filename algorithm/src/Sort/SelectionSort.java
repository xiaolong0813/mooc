package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 寻找[i, n) 里面的最小值
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            // 和这n-i个里面的第一个，也就是元素i进行交换
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }


    public static void main(String[] args) {

        SelectionSort sort = new SelectionSort();

        int[] nums = {4,7,2,9,8,1,10,0};

        sort.selectionSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
