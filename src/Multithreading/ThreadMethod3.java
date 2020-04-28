package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadMethod3 {
    public static void main(String[] args) {
        Callable<String> oneCallable = new Tickets<>();
        FutureTask<String> oneTask = new FutureTask<>(oneCallable);
        Thread thread = new Thread(oneTask);
        Thread thread1= new Thread(new FutureTask<Object>(new Tickets<>()));
        thread.start();
//        thread1.start();
        System.out.println(oneTask);
        System.out.println(Thread.currentThread().getName());
    }
}

class Tickets<Object> implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
        return (Object) "111" ;
    }
}