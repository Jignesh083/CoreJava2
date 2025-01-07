package DetectingandPreventingDeadlocksEx;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithTimeoutEx {
    private static final ReentrantLock LockA = new ReentrantLock();
    private static final ReentrantLock LockB = new ReentrantLock();


    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            try{
                if (LockA.tryLock() && LockB.tryLock()){
                    System.out.println("Thread 1: Acquired both locks");
                }
                else{
                    System.out.println("Thread 1: Could not acquire both locks");
                }
            }
            finally {
                LockA.unlock();
                LockB.unlock();
            }
        });

        Thread thread2 = new Thread(()->{
           try{
               if (LockB.tryLock() && LockA.tryLock()){
                   System.out.println("Thread 2: Acquired both locks");
               }
               else{
                   System.out.println("Thread 2: Could not acquire both locks");
               }
           }
           finally {
               LockA.unlock();
               LockB.unlock();
           }
        });


        thread1.start();
        thread2.start();
    }

}
