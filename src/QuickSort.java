public class QuickSort {
    public static void main(String[] args) {
        int[] a={22,4,1,9,66,5,8,12};
//        sort(a);
        System.out.println(max(a));
    }
    public static void sort(int[] a){

    }
    public static int max(int[] a){
        int max=-1;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }
}
