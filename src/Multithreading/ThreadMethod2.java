package Multithreading;

public class ThreadMethod2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->我是通过实现接口的线程实现方式！");
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new ThreadMethod2());
        thread.setName("aaaaa");
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
