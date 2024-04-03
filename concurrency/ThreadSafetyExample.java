package concurrency;

public class ThreadSafetyExample {

    private int count = 0;

    // synchronized ensure that only one thread can execute the synchronized block at a time.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyExample example = new ThreadSafetyExample();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Count: " + example.getCount());
    }
}
