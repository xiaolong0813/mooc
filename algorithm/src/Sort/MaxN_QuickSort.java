package Sort;

// 用quick sort的思想求数组中第n大的元素
// 思路：递归的求数组中第x大的元素。比如原来是求第5大的，如果在partition遍历后v(可以取第一个)元素
// 在第9个位置，可以再继续取前8个里面第5个大的，如果v在第3个位置，可以取后面数组的第2大的元素。
// 逐步递归缩小范围

public class MaxN_QuickSort {

    private MaxN_QuickSort(){}

    public static Comparable maxN(Comparable[] arr, int n) {
        Comparable val = __maxN(arr, 0, arr.length - 1, n);
        return val;
    }

    // 在arr[l,r]区间里寻找arr数组第n小的值。这里是在arr[l,r]局部寻找整个数组第n小的值
    // 这里要找的是在整个数组中的位置为n的元素，而partition返回的j也是在整个数组中的位置，而不是
    // 相对于[l,r]这个子数组而言。所以要定位整个数组位置为n的元素，递归的时候n不能变
    private static Comparable __maxN(Comparable[] arr, int l, int r, int n) {

        n = n > arr.length ? arr.length : n;
        int j = __partition(arr, l, r);
        // 如果此时正好是v所在位置，返回此值
        if (j == n - 1) {
            return arr[j];
        }
        else if (j > n - 1)
            // 如果j在n-1右边，说明所找值在左边，对左边进行递归
            return __maxN(arr, l, j - 1, n);
        else
            // 如果j在n-1左边，说明所找值在右边，对右边递归，注意这里，传入的仍为arr，不是arr[j+1,r]
            // 所以不能传入n-(j-l+1)，还应该传入n。
            return __maxN(arr, j + 1, r, n);
    }

    private static int __partition(Comparable[] arr, int l, int r) {
        Comparable first = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(first) < 0) {
                SortTestHelper.swap(arr, i, j + 1);
                j++;
            }
        }
//        int i = l + 1, j = r;
//        while (true) {
//            while (i <= r && arr[i].compareTo(first) <= 0) i++;
//            while (j >= l + 1 && arr[j].compareTo(first) >= 0) j--;
//            // 如果中间有相同元素，有可能i>j
//            if (i > j) break;
//            SortTestHelper.swap(arr, i, j);
//            i++;
//            j--;
//        }

        SortTestHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] nums = {53,17,2,9,8,1,10,33};
        for (int i = 1; i <= nums.length; i++)
            System.out.println(MaxN_QuickSort.maxN(nums, i));
    }


}
