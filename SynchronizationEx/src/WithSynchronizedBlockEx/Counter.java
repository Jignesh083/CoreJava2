package WithSynchronizedBlockEx;

public class Counter {
    private int count = 0;

    public void increment(){
        synchronized (this){ // Locking on the current instance
            count++; // Critical section
        }
    }

    public int getCount(){
        return count;
    }


    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = ()->{
          for (int i=0;i<1000;i++){
              counter.increment();
          }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);


        t1.start();
        t2.start();


        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());

    }
}
