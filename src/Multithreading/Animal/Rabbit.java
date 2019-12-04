package Multithreading.Animal;

public class Rabbit extends Animal {
    public Rabbit() {
        setName("兔子");
    }

    @Override
    public void running() throws Exception {
        length -= 5;
        if (length <= 0) {
            System.out.println("兔子WIN!");
            calltoback.win();
//            Animal.interrupted();
//            throw new Exception("兔子WIN!");
        } else {
            System.out.println("兔子跳了5米，还剩" + length + ",米到达终点");
        }
        if ((2000 - length) % 20 == 0) {    // 每20米休息一次,休息时间是1秒
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {                //没0.1秒跑5米
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
