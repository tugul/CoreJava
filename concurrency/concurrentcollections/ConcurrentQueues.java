package concurrency.concurrentcollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * - ConcurrentLinkedQueue/Deque
 * Non-blocking queue intended for scenarios where
 * many threads will share access to a common collection. 
 * 
 * - Blocking queue/deque
 * They are regular queues except for additional methods that 
 * wait for specified amount of time to complete read/write to collection.
 * Waiting means blocking access (using lock) to data which comes at performance cost.
 *
 * - LinkedBlockingQueue methods:
 * offer(E e, long timeout, TimeUnit) - add item waiting for specified time, returns false if timeout elapsed
 * poll(long timeout, TimeUnit) - take/remove element waiting for specified time if necessary until the element 
 * 								becomes available, returns null if time elapsed
 *
 * - LinkedBlockingDeque methods
 * offerFirst(E e, long timeout, TimeUnit)
 * offerLast(E e, long timeout, TimeUnit)
 * pollFirst(long timeout, TimeUnit)
 * pollLast(long timeout, TimeUnit)
 *
 * Note: They throw InterruptedException if the thread is interrupted while waiting
 */
public class ConcurrentQueues {
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(10);
            
            // It will wait for 5 seconds if queue is full. If queue is still full, returns false
            // If queue is not full, operation will be performed immediately 
            // If there new space becomes available within 5 seconds, it will add new element
            // and returns true
            blockingQueue.offer(20, 5, TimeUnit.SECONDS);
            System.out.println(blockingQueue);

            System.out.println(blockingQueue.poll());
            
            // Removes head of queue immediately if there is any.
            // If not, it will wait for specified time and attempt to remove again
            System.out.println(blockingQueue.poll(20, TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            System.out.println("Operation is interrupted");
        }
    }
}
