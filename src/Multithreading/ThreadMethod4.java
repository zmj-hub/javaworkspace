package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMethod4 {
    private static int POOL_NUM = 10;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <POOL_NUM ; i++) {
//        RunnableThread runnableThread = new RunnableThread();
        executorService.execute(new RunnableThread());
        }
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

