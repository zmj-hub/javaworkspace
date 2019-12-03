import java.util.concurrent.CountDownLatch;

/**
 * 单例模式：懒汉模式
 */
public class B {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            T t = new T(countDownLatch);
            t.start();
        }
        countDownLatch.await();
    }

    private static B b;

    private B() {
        System.out.println("1");
    }

    public static B getB() {
        synchronized (B.class) {
            if (b == null) {
                b = new B();
            }
        }
        return b;
    }
}

class T extends Thread {

    private CountDownLatch countDownLatch;

    T(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        B.getB();
        countDownLatch.countDown();
    }
}
