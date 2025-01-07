package InterthreadCommunicationEx;

class SumDemo extends Thread {
    int sum = 0;
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 50; i++) {
                sum += i;
            }

            this.notify(); //passed notification in main method ki I have completed task
//            System.out.println(sum);
        }
    }
}

public class BestEx {
    public static void main(String[] args) throws InterruptedException {
        SumDemo thread = new SumDemo();
        thread.start();

        synchronized (thread){
            thread.wait(); //wait main thread
        System.out.println("Sum is: "+thread.sum);
        }
    }
}
