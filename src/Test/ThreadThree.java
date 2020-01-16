package Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadThree<Object> implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("33333333333333333333333");
        return (Object) "3333333";
    }


}
class Test{
    public static void main(String[] args) {
        Callable<Object> callable = new ThreadThree<>();
        FutureTask<Object> futureTask = new FutureTask<>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();
    }
}
