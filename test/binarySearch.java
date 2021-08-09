public class binarySearch {

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println(mid);
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {1,3,6,10,21,45,87};
        int target = 45;
        int r = binarySearch.search(nums, target);
        System.out.println(r);
    }


        
}