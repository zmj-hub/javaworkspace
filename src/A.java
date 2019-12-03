/**
 * 单例模式：饿汉模式
 */
public class A {

    private static A a = new A();

    private A() {

    }

    public static A getA() {
        return a;
    }
}
