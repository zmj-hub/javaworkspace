package Multithreading.Bank;

public class PersonB extends Thread{
    public String mode;
    public Bank bank;
    public PersonB(String mode, Bank bank){
        this.mode=mode;
        this.bank=bank;
    }

    @Override
    public void run() {
        while (Bank.money>=100){
            try {
                bank.outMoney(100,"counter");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
