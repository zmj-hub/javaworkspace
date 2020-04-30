public class Test {

    public static void main(String[] args) {
//        System.out.println(test());
//        String ss="00201221201212";
//        System.out.println(ss.length());
        test();
    }

    public static void test() {
        for (int i = 1; i < 1000; i++) {
            if (String.valueOf(i).contains("7")) {
                System.out.print("过"+" ");
            } else if (i % 7 == 0) {
                System.out.print("过"+" ");
            } else
                System.out.print(i+" ");
        }
    }


}
