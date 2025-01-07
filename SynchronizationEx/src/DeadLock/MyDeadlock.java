package DeadLock;

public class MyDeadlock {
    public static Object l1 = new Object();
    public static Object l2 = new Object();

    public static void main(String[] args) {
        ThreadDemo1 obj1 = new ThreadDemo1();
        ThreadDemo2 obj2 = new ThreadDemo2();

        obj1.start();
        obj2.start();
    }

    private static class ThreadDemo1 extends Thread{
        public void run() {
            synchronized (l1) {
                System.out.println("Thread 1: Holding Lock 1");
                try{
                    Thread.sleep(400);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 1: waiting for lock 2..");
                synchronized (l2){
                    System.out.println("Thread 2: Holding lock 1 & 2");
                }
            }
        }
    }


    public static class ThreadDemo2 extends Thread{
        public void run(){
            synchronized (l1){
                System.out.println("Thread 2: Holding lock 2");
                try{
                    Thread.sleep(400);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 2: waiting for lock 2..");
                synchronized (l2){
                    System.out.println("Thread 2: Holding lock 2 & 1");
                }
            }
        }
    }
}
