package Multithreading;


import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private boolean isZero=false;
    private boolean isEven=false;
    private boolean isOdd=false;
    Object lock = new Object();
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for (int i = 0; i < ; i++) {
//            
//        }
//        synchronized (){
//            
//        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }
}