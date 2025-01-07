package DetectingandPreventingDeadlocksEx;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetection {
    public static void main(String[] args) {
        // Java provides a built-in way to detect deadlocks via the ThreadMXBean interface
        // The ThreadMXBean can check for deadlocked threads by using the findDeadlockedThreads() method.

        //ManagementFactory :->  such as thread management, memory usage, operating system details, and garbage collection statistics.
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // Check for deadlocked threads
        // findDeadLockedThreads : -> This method checks if there are any threads in a deadlock state and returns an array of thread IDs.
        long[] deadLockedTreads = threadMXBean.findDeadlockedThreads();


        if(deadLockedTreads != null){
            System.out.println("Deadlock detected!");
            for (long threadId : deadLockedTreads){
                Thread thread = findThreadById(threadId);
                System.out.println("Thread ID: " + thread.getName());

                // You can also print the stack trace of the deadlocked thread for debugging.
                // Thread Stack Trace: You can print the stack trace of deadlocked threads to investigate where exactly they are blocked.
                for (StackTraceElement elem : thread.getStackTrace()){
                    System.out.println("    " + elem);
                }
            }
        }else{
            System.out.println("No deadlock detected.");
        }
    }


    // Helper method to find the thread by ID
    private static Thread findThreadById(long threadId){
        for (Thread thread : Thread.getAllStackTraces().keySet()){
            if(thread.getId() == threadId){
                return thread;
            }
        }
        return null;
    }
}
