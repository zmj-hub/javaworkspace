package Multithreading;

class Foo {

    private  boolean two = false;
    private  boolean three = false;
    Object object=new Object();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(object){
            printFirst.run();
            two = true;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(object){
            while(two==true){
                printSecond.run();
                two=false;
                three=true;
                object.notifyAll();
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(object){
            while(three==true){
                printThird.run();
                three=false;
            }
        }
    }
}