package concurrency;

public class ThreadingExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 10; i++)
                System.out.println(Thread.currentThread().getName() + " prints value " + i);
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 10; i++)
                System.out.println(Thread.currentThread().getName() + " prints value " + i);
        });

        thread1.start();
        thread2.start();
    }
}
