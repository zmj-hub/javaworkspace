package Division;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,19,21,23,29,35};
        System.out.println(binarySearch(arr,19 , 0, arr.length-1));
    }

    public static int binarySearch(int[] arr, int x, int low, int hig) {
        if (low > hig) {
            return -1;
        }
        int mid = (low + hig) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (x > arr[mid]) {
            return binarySearch(arr, x, mid + 1, hig);
        } else {
            return binarySearch(arr, x, low, mid - 1);
        }
    }
}
