package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadMethod3 {
    public static void main(String[] args) {
        Callable<Object> oneCallable = new Tickets<>();
        FutureTask<Object> oneTask = new FutureTask<>(oneCallable);
        Thread thread = new Thread(oneTask);
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class Tickets<Object> implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
        return null;
    }
}