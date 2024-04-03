package concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    private static final int MAX_CAPACITY = 5;
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(ProducerConsumerExample::produce);
        Thread producer2 = new Thread(ProducerConsumerExample::produce);
        Thread consumer = new Thread(ProducerConsumerExample::consume);

        producer.start();
        producer2.start();
        consumer.start();
    }

    private static void produce() {
        while (true) {
            synchronized (queue) {
                if (queue.size() == MAX_CAPACITY) {
                    System.out.println("Queue is full, wait for consuming");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int value = (int) (Math.random() * 100);
                System.out.println(Thread.currentThread().getName() + " produced: " + value);
                queue.offer(value);
                queue.notifyAll();
            }
        }
    }

    private static void consume() {
        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty, wait for producing");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int value = queue.poll();
                System.out.println(Thread.currentThread().getName() + " consumed: " + value);
                queue.notifyAll();
            }
        }
    }
}
