public class testSort {

    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    
    public void bubbleSort(Comparable[] arr) {
        int lastSwap;
        for (int i = arr.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void intertionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            while (j > 0 && arr[i].compareTo(o)) {
                
            }
        }
    }

    



}