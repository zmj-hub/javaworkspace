package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMethod4 {
    private static int POOL_NUM = 10;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);//创建固定大小的线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();//缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
//        ExecutorService executorService = Executors.newSingleThreadExecutor();//创建单个线程池。 线程池中只有一个线程
//        for (int i = 0; i <POOL_NUM ; i++) {
////        RunnableThread runnableThread = new RunnableThread();
//        executorService.execute(new RunnableThread());
//        }
        RunnableThread runnableThread = new RunnableThread();
        runnableThread.run();
        Thread thread = new Thread(runnableThread);
        thread.start();
        executorService.shutdown();
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");
    }
}

