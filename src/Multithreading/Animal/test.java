package Multithreading.Animal;

public class test {
    public static void main(String[] args) {
        Turtle turtle = new Turtle();
        Rabbit rabbit = new Rabbit();
        LetOneStop letOneStop1 = new LetOneStop(turtle);
        // 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
        rabbit.calltoback = letOneStop1;
        LetOneStop letOneStop2 = new LetOneStop(rabbit);
        // 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
        turtle.calltoback = letOneStop2;

        turtle.start();
        rabbit.start();
    }
}
