package recursion;
import Array.*;

public class ArraySum {

    public int sum(int[] array) {
        return subSum(array, 0);
//        if (array.length == 0) {
//            return 0;
//        }
//        else {
//            return array[0] + sum(popArray(array));
//        }
    }

    // 计算arr[l...n)这个区间内所有数字的和
    private int subSum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + subSum(arr, l + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};

        ArraySum arraySum = new ArraySum();
        System.out.println(arraySum.sum(nums));
    }
}
