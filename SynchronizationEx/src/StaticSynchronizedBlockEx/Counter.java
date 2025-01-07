package StaticSynchronizedBlockEx;

public class Counter {
    private static int count = 0;

    public static void increment(){
        synchronized (Counter.class){ // Locking on the class object
            count++; // Critical section
        }
    }


    public static int getCount() {
        synchronized (Counter.class){ // Locking on the class object
            return count;
        }
    }

    public static void main(String[] args) {
        Runnable task = ()->{
          for (int i=0;i<1000;i++){
            Counter.increment();
          }
        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + Counter.getCount());
    }
}
