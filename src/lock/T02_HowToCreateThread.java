package lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread");
        }
    }
    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }
    static class MyCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("callable");
            return "success";
        }
    }

    //启动线程的5种方法
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("lambda");
        }).start();
        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("ThreadPool");
        });
        service.shutdown();
    }
}
