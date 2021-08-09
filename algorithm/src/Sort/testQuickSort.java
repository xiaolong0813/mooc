public class testQuickSort {
    

    private void __sort(Comparable[] arr, int l, int r) {
        int j = __partition(arr, l, r);
        __sort(arr, l, j - 1);
        __sort(arr, j + 1, r);
    }

    // 对arr中l，r进行partition操作
    private int __partition(Comparable[] arr, int l, int r) {
        int randomIndex = (int)(Math.random() * (r - l +1) + l);

        swap(arr, l, randomIndex);

        Comparable first = arr[l];
        int i = l +1, j = r;
        while (true) {
            while(i <=r && arr[i].compareTo(first) <= 0) i++;
            while(j >=l+1 && arr[j].compareTo(first) >= 0) j++;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j++;
        }
        swap(arr, l, j);
        return j;
    }



    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}