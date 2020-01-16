package Test;

public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("2222222222222222");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTwo());
        thread.start();
    }
}
