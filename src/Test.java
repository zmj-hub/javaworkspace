public class Test {

    public static void main(String[] args) {
//        System.out.println(test());
//        String ss="00201221201212";
//        System.out.println(ss.length());
        System.out.println(1&4);
    }

    public static Boolean test() {
        int a = 1, b = 2;
        switch (a) {
            case 1:
                if (b == 1)
                    return true;
            case 2:
                if (b == 2)
                    return true;
            default:
                return false;
        }
    }


}
