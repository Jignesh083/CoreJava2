package DetectingandPreventingDeadlocksEx.ReenTrantAllMethodEx;

import java.util.concurrent.locks.ReentrantLock;


class Counter{
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();


    public void increment(){
        lock.lock();
        try{
            count++;
        }
        finally {
            lock.unlock();
        }
    }


    public int getCount(){
        return count;
    }
}

public class LockExample {
    public static void main(String[] args) {
        Counter c = new Counter();
        Runnable task = ()->{
          for (int i=0;i<1000;i++){
              c.increment();
          }
        };


        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
