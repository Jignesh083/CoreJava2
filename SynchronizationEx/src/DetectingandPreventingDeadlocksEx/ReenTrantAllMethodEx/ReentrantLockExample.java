package DetectingandPreventingDeadlocksEx.ReenTrantAllMethodEx;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();


    public void reentrantMethod(int count){
        lock.lock(); // Acquire Lock

        try{
            System.out.println(Thread.currentThread().getName() + " - Entered method with count: " + count);

            if(count > 0){
                reentrantMethod(count-1);
            }

            System.out.println(Thread.currentThread().getName() + " - Exiting method with count: " + count);

        }
        finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantMethodExample example = new ReentrantMethodExample();

        Thread thread1 = new Thread(()->example.reentrantMethod(3),"Thread-1");
        Thread thread2 = new Thread(() -> example.reentrantMethod(3), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
