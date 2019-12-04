package Multithreading.Bank;

public class test {
    public static void main(String[] args) {
        PersonA p1=new PersonA("ATM",new Bank());
        PersonB p2=new PersonB("counter",new Bank());
        p2.start();
        p1.start();
    }
}
