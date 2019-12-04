package Multithreading.Animal;

public class Turtle extends Animal {
    public Turtle() {
        setName("乌龟");
    }

    @Override
    public void running() throws Exception {
        length -= 2;
        if (length <= 0) {
            System.out.println("乌龟WIN!");
//            Animal.interrupted();
//            throw new Exception("乌龟WIN!");
            calltoback.win();
        } else {
            System.out.println("乌龟爬了2米，还剩" + length + ",米到达终点");
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
