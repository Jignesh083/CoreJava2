package DetectingandPreventingDeadlocksEx;


//Lock Ordering
public class LockOrderingDeadlockPreventionEx {
    private static final Object LockA = new Object();
    private static final Object LockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           synchronized (LockA){
               System.out.println("Thread 1: Acquired LockA");
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (LockB){
                    System.out.println("Thread 1: Acquired LockB");
                }
           }
        });


        Thread thread2 = new Thread(()->{
           synchronized (LockA){
               System.out.println("Thread 2: Acquired LockA");
               try{
                   Thread.sleep(1000);
               }
               catch (InterruptedException e){
                   e.printStackTrace();
               }

               synchronized (LockB){
                   System.out.println("Thread 2: Acquired LockB");
               }
           }

        });


        thread1.start();
        thread2.start();
    }
}
