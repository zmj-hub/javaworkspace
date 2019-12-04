package Multithreading.Bank;

public class PersonA  extends Thread{
    public String mode;
    public Bank bank;
    public PersonA(String mode,Bank bank){
        this.mode=mode;
        this.bank=bank;
    }

    @Override
    public void run() {
        while (Bank.money>=200){
            try {
                bank.outMoney(200,"ATM");
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
