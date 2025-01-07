package DetectingandPreventingDeadlocksEx;
import java.lang.management.*;

public class DeadlockDetectionExample{

    // Create two shared resources (locks)
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void main(String[] args) {
        // Start two threads that will cause a deadlock
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());

        thread1.start();
        thread2.start();

        // Give threads time to acquire the locks and potentially deadlock
        try {
            Thread.sleep(1000); // Wait for 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }

        // Detect if any threads are deadlocked
        detectDeadlocks();
    }

    // Task that Thread 1 will perform: Acquire Lock1, then Lock2
    static class Task1 implements Runnable {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding Lock1, waiting for Lock2...");
                try {
                    Thread.sleep(50); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle interruption
                }
                synchronized (Lock2) {
                    System.out.println("Thread 1: Acquired Lock2!");
                }
            }
        }
    }

    // Task that Thread 2 will perform: Acquire Lock2, then Lock1
    static class Task2 implements Runnable {
        public void run() {
            synchronized (Lock2) {
                System.out.println("Thread 2: Holding Lock2, waiting for Lock1...");
                try {
                    Thread.sleep(50); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle interruption
                }
                synchronized (Lock1) {
                    System.out.println("Thread 2: Acquired Lock1!");
                }
            }
        }
    }

    // Detect deadlocks using ThreadMXBean
    public static void detectDeadlocks() {
        // Get the ThreadMXBean instance
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // Find the threads that are deadlocked
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();

        if (deadlockedThreads != null) {
            System.out.println("Deadlock detected!");
            // Print the details of the deadlocked threads
            for (long threadId : deadlockedThreads) {
                Thread thread = findThreadById(threadId);
                if (thread != null) {
                    System.out.println("Thread ID: " + thread.getName());
                    // Print the stack trace of the deadlocked thread
                    for (StackTraceElement elem : thread.getStackTrace()) {
                        System.out.println("    " + elem);
                    }
                }
            }
        } else {
            System.out.println("No deadlock detected.");
        }
    }

    // Helper method to find a thread by its ID
    private static Thread findThreadById(long threadId) {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getId() == threadId) {
                return thread;
            }
        }
        return null;
    }
}
