package Multithreading.Animal;

public class LetOneStop implements Animal.Calltoback {
    Animal an;

    public LetOneStop(Animal an) {
        this.an = an;
    }


    @Override
    public void win() {
        an.stop();
//        an.interrupt();
    }
}
