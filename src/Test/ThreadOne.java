package Test;

public class ThreadOne extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("11111111111");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOne threadOne = new ThreadOne();
//        Thread.sleep(10000);
//        Thread.yield();
        threadOne.start();
    }
}
