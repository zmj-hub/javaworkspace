public class XuanZe {
    public static void main(String[] args) {
        int[] a={22,4,1,9,66,5,8,12};
        sort(a);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
