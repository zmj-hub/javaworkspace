package Multithreading;

public class ticketSales extends Thread {

    public ticketSales(String name) {
        super(name);
    }

    static int tick = 20;

    static Object lock = "q";

    @Override
    public void run() {
//        super.run();
        while (tick > 0) {
            synchronized (lock) {
                if (tick > 0) {
                    tick--;
                    System.out.println(Thread.currentThread().getName() + "售票成功，剩余票数：" + tick);
                } else {
                    System.out.println("已经没有余票");
                }

            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ticketSales s1 = new ticketSales("售票窗口1");
        ticketSales s2 = new ticketSales("售票窗口2");
        ticketSales s3 = new ticketSales("售票窗口3");

        s1.start();
        s2.start();
        s3.start();
    }
}
