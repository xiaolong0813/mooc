package Sort;

// 归并排序
// 思路：对于N个元素的数组，每次划分为之前的一半，每次对每部分排序，再逐层向上归并，因为每次二分，一共可以分logN层。
// 每次的归并过程的复杂度可以为O(N)。需要重新开辟一块和此层同样大小的空间(空间换时间)，对两块同时进行向后遍历且放入新的空间内。

// 时间复杂度O(N*logN)

import LinkedList.LinkedList;

import javax.xml.soap.Node;
import java.util.Random;


public class MergeSort {

    private MergeSort(){}

    public static void sort(Comparable[] arr) {
        // 使用辅助函数,索引为0到n-1
        __sort(arr, 0, arr.length - 1);
    }

    // 自底向上的归并排序法。即不再划分，直接向上归并(sort bottom up)
    public static void sortBU(Comparable[] arr) {
        // 每次循环的是考虑的数组大小，每次比之前要大一倍
        for (int size = 1; size <= arr.length; size = size * 2) {
            // 每次对相邻数组进行合并，这里j是数组左边元素的位置。每次遍历
            // 两个数组的长度，将其合并
            // 注意这里的边界需要考虑下，1. 左端：左端位置需要小于数组长度。2. 右端：如果两两组合的情况下
            // 最后一个数组长度不足size，则右端需要取arr.length-1的位置，也就是右端边界需要取
            // j + size * 2 - 1 和 arr.length-1中的最小值。
            // merge的时候，数组不足size个元素也没关系，函数内已经考虑这种情况
            for (int j = 0; j + size < arr.length; j += size * 2) {
                // 对相邻的数组进行归并
                int mid = j + size - 1;
                int right = Math.min(j + size * 2 - 1, arr.length - 1);
                if (arr[mid].compareTo(arr[mid + 1]) > 0)
                    __merge(arr, j, mid, right);
            }
        }
    }



    // 递归归并。对arr[l, r] 范围内的元素进行排序,由于索引是前后闭，其实是取得
    // 第l+1到第r+1个元素，比如第一到第n个。这里范围为前后闭。用这个辅助函数
    // 比单纯用sort内部递归更清晰和简单
    private static void __sort(Comparable[] arr, int l, int r) {
        // 如果l大于r，则数据集为空，其实是不会发生的
//        if (l >= r)
//            return;
        // 上面递归的终点可以优化，当数据量小于一定程度时，可以转而使用插入排序提高性能，
        // 因为 1. 数据量较小时近乎有序的概率较大 2. 时间复杂度前面的系数，插入排序更小
        // 这里当元素少于15个时用插入
        if (r - l <= 15) {
            InsertionSort.sort(arr, l ,r);
            return;
        }

        // 找到当前中点位置
        int mid = (l + r) / 2;
        // 对两侧的元素分别进行排序
        __sort(arr, l , mid);
        __sort(arr, mid + 1, r);
        // 然后将其merge起来。注意，如果前段的最后一个元素已经比
        // 后段第一个小，就没必要再归并了。不然反而会增加没必要时间，尤其对于近乎有序数组
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            __merge(arr, l, mid, r);
    }

    // 将数组分两部分进行归并，重组为新的排好序merge好的数组，即 arr[l, mid] 和 arr[mid + 1, r]
    private static void __merge(Comparable[] arr, int l, int mid, int r) {
        // 创建临时空间存储merge后的数组
        // 注意这里是对arr范围内排序，而不是取出这个范围并排序，所以不能建立新数组存储排序
        // 后的元素，而是应该将范围内元素拷入新数组，然后作为辅助在原arr中对该范围排序
        Comparable[] aux = new Comparable[r - l + 1];
        // 这里l和r都是索引，可以被遍历到
        for (int i = l; i <= r; i++) {
            aux[i - l] =arr[i];
        }
        // i和j指向aux中的前后两个数组，k指向arr。在arr中对[l,r]的元素排序
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 判断i和j是否已经过界，如果过了，可以直接将另一组的值赋予aux
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            }
            else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // 如果都没越界，就比较两侧大小
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }
            else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

//    public static void sort(Comparable[] arr) {
//        Comparable[] arr1 = new Comparable[arr.length / 2];
//        Comparable[] arr2 = new Comparable[arr.length / 2];
//        if (arr.length > 0) {
//            for (int i = 0, j = arr.length / 2; i < arr.length / 2 && j < arr.length; i++, j++) {
//                arr1[i] = arr[i];
//                arr2[i] = arr[j];
//            }
//
//            sort(arr1);
//            sort(arr2);
//
//            merge(arr, arr1, arr2);
//        }
//    }
//
//    private static void merge(Comparable[] arr, Comparable[] sortedArr1, Comparable[] sortedArr2) {
//        if (arr1.length == 1 && arr2.length == 1)
//            return merge()
//
//    }


}
