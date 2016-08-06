package concurrency.concurrentcollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * - Blocking queue/deque
 * LinkedBlockingDeque implements BlockingDeque interface
 * LinkedBlockingQueue implements BlockingQueue interface
 *
 * They are just like regular queues except for additional methods that wait for specified amount of time
 * to complete read/write to collection. For example:
 *
 * - BlockingQueue methods:
 * offer(E e, long timeout, TimeUnit) - add item waiting for specified time, returns false if timeout elapsed
 * poll(long timeout, TimeUnit) - take/remove element waiting for specified time if necessary until the element 
 * 								becomes available, returns null if time elapsed
 *
 * - BlockingDeque methods
 * offerFirst(E e, long timeout, TimeUnit)
 * offerLast(E e, long timeout, TimeUnit)
 * pollFirst(long timeout, TimeUnit)
 * pollLast(long timeout, TimeUnit)
 *
 * Note: They throw InterruptedException if the thread is interrupted while waiting
 *
 */
public class BlockingQueues {
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(10);
            blockingQueue.offer(20, 5, TimeUnit.SECONDS);

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(20, TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            System.out.println("Operation is interrupted");
        }
    }
}
