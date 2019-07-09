package Sort;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.SortedMap;

// 求数组中的逆序对
// 用merge sort的思路，将数组分而治之
// 思路：数组分成两段，如果两边都已经排好序，则两段内部的逆序对为0，在将两段归并排序的过程中，
// 在k遍历的时候，如果右边一段的索引j小于左边的i对应的值，说明此时的j肯定小于左边剩下的所有元素，
// 而j肯定大于左边所有元素的索引，所以左边剩下的元素个数就是此时逆序对的个数。
// 也就是每次归并的时候，每次遍历到j，逆序对个数增加 mid-i+1 个即可。
// 当这两段归并成一段，则此段内部的逆序对成为零，但这并不影响整段的逆序对个数计算，因为对于分成两段的数组
// 左右两段内部不管是什么顺序，都不影响其两段归并过程中计算的个数
// 由于整体采用从单一元素开始的递归排序，所以可以计算每次归并排序过程中的个数，即从单个元素计算每一段
// 逐渐扩大到整体数组
public class CastleWalls {

    private CastleWalls(){count = 0;}
    private static int count;

    public static int CastleWalls(Comparable[] arr) {
        __sort(arr, 0, arr.length - 1);
        return count;
    }

    private static void  __sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        __sort(arr, l, mid);
        __sort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            __merge(arr, l, mid, r);
    }

    private static void __merge(Comparable[] arr, int l, int mid, int r) {
        // 将两端排好序的数组merge起来，merge的过程可以计算逆序对的个数
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = l; i <= r; i++)
            aux[i - l] = arr[i];

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            }
            else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }
            else {
                arr[k] = aux[j - l];
                j++;
                count = count + (mid - i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {53,17,2,9,8,1,10,33};
        int count = CastleWalls.CastleWalls(nums);
        System.out.println(count);

        SortTestHelper helper = new SortTestHelper();
        helper.printArr(nums);
    }
}
