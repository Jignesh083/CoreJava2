package DetectingandPreventingDeadlocksEx.ReenTrantAllMethodEx;

import WithoutSyncronizedEx.Main;

// Synchronized method demonstrating reentrancy
class ReentrantMethodExample{
    public synchronized void reentrantMethod(int count){
        // Print the current thread name and count
        System.out.println(Thread.currentThread().getName() + " - Entered method with count: " + count);

        // Base condition for recursion
        if (count>0){
            // Recursive call (the method calls itself)
            reentrantMethod(count-1);
        }

        // Print exit log
        System.out.println(Thread.currentThread().getName() + " - Exiting method with count: " + count);
    }
}


public class ReentrantMethodUsingSynchronizedEx {
    public static void main(String[] args) {
        ReentrantMethodExample example = new ReentrantMethodExample();

        Thread thread1 = new Thread(()->example.reentrantMethod(3),"Thread-1");
        Thread thread2 = new Thread(()->example.reentrantMethod(3),"Thread-2");


        thread1.start();
        thread2.start();
    }
}
