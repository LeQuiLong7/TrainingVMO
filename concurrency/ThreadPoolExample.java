package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // a pool of fixed number of threads to execute any number of tasks.
        // If additional tasks are submitted when all threads are active,
        // they will wait in the queue until a thread is available
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () ->
                System.out.println("Thread name: " + Thread.currentThread().getName());

        for (int i = 0; i < 30; i++) {
            executor.submit(task);
        }

        executor.shutdown();
    }
}
