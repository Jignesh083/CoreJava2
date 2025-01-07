package StaticSynchronizedMethodforComparisonEx;

public class Counter {
    private static int count = 0;

   public static synchronized void increment(){ // Static synchronized method
       count++;
   }


   public static synchronized int getCount(){ // Static synchronized method
       return count;
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
