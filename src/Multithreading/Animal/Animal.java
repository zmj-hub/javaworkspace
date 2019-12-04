package Multithreading.Animal;

public abstract class Animal extends Thread {
    public int length = 200;

    public abstract void running() throws Exception;

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            try {
                running();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 在需要回调数据的地方（两个子类需要），声明一个接口
    public static interface Calltoback {
        public void win();
    }

    // 2.创建接口对象
    public Calltoback calltoback;

}
