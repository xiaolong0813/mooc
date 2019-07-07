package Sort;

// 冒泡排序
// 思想：遍历数组的相邻元素，如果后面元素比前一个小，就交换两个元素。遍历结束后，最大的
// 元素就到了第n个位置。然后，再重新遍历前n-1个元素，这次第二大的元素就到了第n-1个位置
// 这样以此缩小遍历范围。剩下一个元素的时候就完成了排序。

// 时间复杂度最差为O(n2)，最好为O(n)。

public class BubbleSort {
    private BubbleSort(){}

//    public static void sort(Comparable[] arr) {
//        // 第一次整体遍历，后面每次遍历的元素个数递减。比较前i个
//        for (int i = arr.length; i > 1; i--) {
//            for (int j = 0; j < i - 1; j++) {
//                if (arr[j].compareTo(arr[j + 1]) > 0) {
//                    SortTestHelper.swap(arr, j, j + 1);
//                }
//            }
//        }
//    }
    // 改进版：每次不一定都遍历前面i个元素，因为已经排好的肯定比前面的都大，
    // 比如对于 3, 1, 4, 5, 2, 7, 9, 12, 15这个数组，其实第一次遍历后，记住最后一次
    // 交换的位置，也就是5和2，下次可以只遍历5前面的。因为最后一次交换的位置后面的肯定是
    // 已经排好顺序的数组
    public static void sort(Comparable[] arr) {
        int lastSwap;
        for (int i = arr.length; i > 1; i = lastSwap) {
            // 第一次整体遍历，记下每次遍历最后一次交换的位置。更新为下次遍历的终点
            lastSwap = 0;
            for (int j = 0; j < i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortTestHelper.swap(arr, j, j + 1);
                    // 注意这里因为j是索引号，而比较的个数为前i个，为j+1
                    lastSwap = j + 1;
                }
            }
        }
    }


}
