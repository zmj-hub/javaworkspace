public class Maopao {
    public static void main(String[] args) {
        int[] a={22,4,1,9,66,5,8,12};
        sort(a);
    }
    public static void sort(int[] a ){
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }

    }
}
