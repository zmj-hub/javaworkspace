package AdapterPattern;

public class Test {
    public static void main(String[] args) {
        A a = new C();
        a.deal();
        B b=new B();
        A aa=new D(b);
        aa.deal();
    }
}
