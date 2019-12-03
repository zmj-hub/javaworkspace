package Multithreading;

public class ThreadMethod1 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "run");
    }

    public static void main(String[] args) {
        ThreadMethod1 threadDemo01 = new ThreadMethod1();
        threadDemo01.setName("我是自定义的线程1");
        threadDemo01.start();
        System.out.println(Thread.currentThread().toString());
    }

}
