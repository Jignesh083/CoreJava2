package InterthreadCommunicationEx;


class SharedBuffer{
    private int data;
    private boolean available = false;


    // Consumer will wait if no data is available
    public synchronized void produce(int value){
        while(available){
            try{
                wait(); // Wait if data is already available
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        notify(); // Notify the consumer that data is available
    }

    // Producer will wait if data is not available
    public synchronized int consume() {
        while (!available) {
            try {
                wait();  // Wait if no data is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        notify(); // Notify the producer that space is available
        return data;
    }
}


class Producer extends Thread{
    private SharedBuffer Buffer;


    public Producer(SharedBuffer buffer){
        this.Buffer = buffer;
    }

    public void run(){
        for (int i=1;i<=5;i++){
            Buffer.produce(i);
            System.out.println("Produced: " + i);
        }
    }
}


class Consumer extends Thread{
    private SharedBuffer buffer;


    public Consumer(SharedBuffer buffer){
        this.buffer=buffer;
    }


    public void run(){
        for (int i=1;i<=5;i++){
            int value = buffer.consume();
            System.out.println("Consumed: " + value);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);


        producer.start();
        consumer.start();
    }
}
