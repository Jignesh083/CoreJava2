package SyncronizedMethodExample;

public class BankAccount {
    private int balance = 1000;

    // Synchronized Method
    public synchronized void withdraw(int amount){
        if (balance>=amount){
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -=amount;
            System.out.println("Remaining balance: " + balance);
        }else{
            System.out.println(Thread.currentThread().getName() + " insufficient balance.");
        }
    }


    public synchronized int getBalance(){
        return balance;
    }
}




