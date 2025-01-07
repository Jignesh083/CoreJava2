package SynchronisedBlockExample;

import WithoutSyncronizedEx.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount =  new BankAccount();

        Runnable task = ()->{
            for (int i = 0; i < 3; i++) {
                bankAccount.withdraw(50);
            }
        };


        Thread t1 = new Thread(task,"Thread-1");
        Thread t2 = new Thread(task,"Thread-2");


        t1.start();
        t2.start();
    }
}
