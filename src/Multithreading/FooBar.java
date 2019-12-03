package Multithreading;

public class FooBar {
    private int n;
    private boolean isTrue = false;
    Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (isTrue){
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isTrue=true;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (!isTrue){
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isTrue=false;
                lock.notifyAll();
            }
        }
    }
}

//class Foobar {
//    public void foo() {
//        for (int i = 0; i < n; i++) {
//            System.out.println("foo");
//        }
//    }
//
//    public void bar() {
//        for (int i = 0; i < n; i++) {
//            System.out.println("bar");
//        }
//    }
//}

