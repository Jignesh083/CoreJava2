package SynchronisedBlockExample;

public class BankAccount {
    private int balance = 1000;

    public void withdraw(int amount){
        synchronized (this){ // Lock only the critical section
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient balance.");
            }
        }
    }

}


