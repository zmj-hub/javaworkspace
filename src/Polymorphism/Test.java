package Polymorphism;

public class Test {
    public static void main(String[] args) {
        func(new A());
        func(new B());
        func(new C());
    }

    public static void func(A a) {
        a.print();
        if (a instanceof B) {
            B b = (B) a;   //向下转型,通过父类实例化子类
            b.fun();    //调用B类独有的方法
        } else if (a instanceof C) {
            C c = (C) a;  //向下转型,通过父类实例化子类
            c.fun();   //调用C类独有的方法
        }
    }
}
