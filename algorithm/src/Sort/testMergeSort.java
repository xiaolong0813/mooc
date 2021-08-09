public class testMergeSort {
    


    private static void __sort(Comparable[] arr, int l, int r) {
        int mid = (l + r) / 2;

        __sort(arr, l, mid);
        __sort(arr, mid + 1, r);
        
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            __merge(arr, l, mid, r);
        }
    }


    private static void __merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] temp = new Comparable[r - l +1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            }
            else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            }
            else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                arr[k] = temp[i - l];
                i++;
            }
            else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }
}